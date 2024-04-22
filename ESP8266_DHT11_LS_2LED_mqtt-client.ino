#include <DHT.h>
#include <ESP8266WiFi.h> // có người sử dụng là Wifi.h, nhưng đó thực tế là esp8266 không tồn tại thư viện đó. Idk why people keep including that library?
#include <PubSubClient.h>
#include <ArduinoJson.h>

//define Wifi
const char* ssid = "GigaChad";
const char* password = "66668888";

// define mqtt
#define MQTT_HOST "192.168.187.19" // đừng dùng host mặc định, please. Nhưng đây mới là host local thôi.
// #define MQTT_HOST "mqtts://example.com" //let try shall we?
#define MQTT_PORT 2002
#define MQTT_USER "thuychang"
#define MQTT_PASSWORD "123"

// define sensors
#define DHTPIN 4        // cắm vào chân D2 -> 4
#define DHTTYPE DHT11 
#define LUXDATA A0      // cắm vào chân A0 -> A0
#define PUB1 5          // cắm vào chân D1 -> 5
#define PUB2 0          // cắm vào chân D3 -> 0

DHT dht(DHTPIN, DHTTYPE); // khởi tạo giá trị (ấy hả?)
WiFiClient espClient;
PubSubClient client(espClient);

// define const values
const int maxAnalogValue = 1023;

// connecting to a WiFi network (private I guess)
void setup_wifi() {
  delay(500);

  Serial.println ();
  Serial.print("Connecting to ");
  Serial.println("ssid");

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);

  while(WiFi.status()!=WL_CONNECTED) {
    delay(500);
    Serial.print("Connecting to WiFi...");
  }

  randomSeed(micros()); // khởi chạy chuỗi số ngẫu nhiên với giá trị seed dựa trên thời gian hiện tại

  Serial.println();
  Serial.println("WiFi connected!");
  Serial.println("IP address:");
  Serial.println(WiFi.localIP());
}

void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");
  String msgTemp;

  for (int i = 0; i < length; i++) {
    Serial.print((char)payload[i]);
    msgTemp += (char)payload[i];
  };

  Serial.println();

  if(String(topic) == "devices/pub1/control") {
    if (msgTemp == "ON") turn_on_light(PUB1);
    else if (msgTemp == "OFF") turn_off_light(PUB1);
  } else if (String(topic) == "devices/pub2/control") {
    if (msgTemp == "ON") turn_on_light(PUB2);
    else if (msgTemp == "OFF") turn_off_light(PUB2);
  } else { // Next condition or end if else
    client.publish(String(String(topic) + "/failed").c_str(), String(msgTemp).c_str());
    Serial.println("Failed. Please try again.");
  }

  DynamicJsonDocument jsonLight(1024);
  if(String(topic) == "devices/pub1/control") {
    jsonLight["led1"] = msgTemp;
  } else {
    jsonLight["led2"] = msgTemp;
  }

  String msgLight;
  serializeJson(jsonLight, msgLight);
  client.publish("devices/response", msgLight.c_str());
}

void connect_to_broker () {
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    String clientId = "ESP32Client-";
    clientId += String(random(0xffff), HEX);
    if (/client.connect(clientId.c_str(), MQTT_USER, MQTT_PASSWORD)) {
      Serial.println("Broker connected");
      client.subscribe("devices/pub1/control");
      client.subscribe("devices/pub2/control");
    } else {
      Serial.print ("failed, rc = ");
      Serial.print(client.state());
      Serial.println(", proceed to reconnect in 2 seconds...");
      delay(2000);
    }
  }
}

void turn_on_light(int PIN) {
  int check = digitalRead(PIN);
  if (check == LOW) {
    pinMode (PIN, OUTPUT);
    digitalWrite(PIN, HIGH);
  }
}

void turn_off_light(int PIN) {
  int check = digitalRead(PIN);
  if (check == HIGH) {
    pinMode (PIN, OUTPUT);
    digitalWrite(PIN, LOW);
  }
}

int convertToLightIntensity(int analogValue) {
  // Hàm map() nhận giá trị x trong khoảng in_min đến in_max và ánh xạ nó sang khoảng out_min đến out_max.
  // analogValue là giá trị analog đọc từ cảm biến ánh sáng. 
  // 0 là giá trị analog tối thiểu có thể đọc được,
  // maxAnalogValue là giá trị analog tối đa mà cảm biến có thể đọc được. 
  // 1023 là giá trị tối đa mà giá trị analog có thể được ánh xạ.
  return map(analogValue, 0, maxAnalogValue, 0, 1023);
}

void setup_sensors() {
  dht.begin();
  pinMode(LUXDATA, INPUT);
  
  pinMode(PUB1, LOW);
  digitalWrite(PUB1, LOW);

  pinMode(PUB2, LOW);
  digitalWrite(PUB2, LOW);
}

void setup() {
  Serial.begin(9600); // khởi tạo kênh giao tiếp giữa Arduino và laptop. Baud rate (in bits per second) at which data is transmitted over the serial connection. 
  setup_sensors();
  setup_wifi();
  client.setServer(MQTT_HOST, MQTT_PORT);
  client.setCallback(callback);
  connect_to_broker();
}

void loop () {
  delay(2000);

  if(!client.connected()) {
    connect_to_broker();
  }
  client.loop();

  float tc = dht.readTemperature(); //Read temperature in C
  float hu = dht.readHumidity(); //Read Humidnity
  int analogValue = maxAnalogValue - analogRead(LUXDATA); //Read value from A0
  int li = convertToLightIntensity(analogValue); //normalize to light intensity

  if(isnan(tc) || isnan(hu) || isnan(li)) {
    Serial.println("Failed to read from DHT sensor!");
    return;
  }

  DynamicJsonDocument jsonDoc(1024);
  jsonDoc["temper"] = tc;
  jsonDoc["humid"] = hu;
  jsonDoc["light"] = li;

  String msgPub;
  serializeJson(jsonDoc, msgPub);
  client.publish("data/sensors", msgPub.c_str());

  Serial.print("Temperature: ");
  Serial.print(tc);
  Serial.print("°C, ");

  Serial.print("Humidity: ");
  Serial.print(hu);
  Serial.print("%, ");

  Serial.print("Brightness: ");
  Serial.print(li);
  Serial.println(" lux.");
}



