# Chasen - IOT Dashboard 
Website đưa các dữ liệu từ chip ESP8266 vào database, thông qua backend để hiển thị lên frontend.
> <a href="https://vi.wikipedia.org/wiki/ESP8266"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/84/ESP-01.jpg/220px-ESP-01.jpg" alt="ESP8266" align="left" style="margin-right: 25px" height=150></a>
> Chip [ESP8266](https://vi.wikipedia.org/wiki/ESP8266) là vi mạch Wi-Fi giá rẻ với khả năng điều khiển đầy đủ và stack TCP/IP do Espressif Systems có trụ sở tại Thượng Hải sản xuất.
> <br/><br/><br/><br/><br/>

## Nội dung
- [Kỹ thuật](#kỹ-thuật)
  - [Frontend](#)
  - [Backend](#)
  - [Database](#)
  - [Nền tảng](#nền-tảng)
- [Cách cài đặt](#cách-cài-đặt)
  - [ESP8266](#esp8266)
  - [Database](#)
  - [Backend](#)
  - [Frontend](#)
- [Hỗ trợ](#hỗ-trợ)
## Kỹ thuật 
### Frontend
- HTML
- CSS
- JS
### Backend 
- Java Servlet
### Database
- MySQL
### Nền tảng
Phần mềm được chạy trên cấu hình như sau:
- Processor:	Intel(R) Core(TM) i7-6500U CPU @ 2.50GHz   2.60 GHz
- Installed RAM:	8.00 GB (7.71 GB usable)
- System type:	64-bit operating system, x64-based processor
- Edition:	Windows 10 Pro
- Version:	22H2

Với các dòng máy khác, kết quả được kỳ vọng không thay đổi nhiều.

## Cách cài đặt
### ESP8266
1. Chuẩn bị các thiết bị sau:
- ESP8266
- DHT11/DHT22
- Cảm biến ánh sáng
- Breadboard
- Dây điện
- 2 đèn led 3V/5V
2. Lắp thiết vào breadboard.
3. Tải Arduino về [tại đây]().
4. Kết nối mạch ESP8266 vào laptop qua cổng USB, nạp vào mạch  [```ESP8266_DHT11_LS_2LED_mqtt-client.ino```](https://github.com/thuychang404/Chasen/blob/5e98a207ad028a9fd8b2538ba403b9337bca8cd6/ESP8266_DHT11_LS_2LED_mqtt-client.ino).
5. Chọn Compile & Upload.
6. Kiểm tra kết quả.
  
### Database
1. Cài đặt MySQL Workbrench và các dịch vụ đi kèm [tại đây](https://dev.mysql.com/doc/refman/8.0/en/windows-installation.html).
2. Mở Workbrench, nhập các queries trong thư mục SQL.
3. Chạy.

**Nếu quá trình cài đặt thành công, màn hình sẽ xuất hiện một database tên iot với hai bảng như hình dưới.**
> ![image](https://github.com/thuychang404/Chasen/assets/130899126/415a29a1-484b-4256-8796-8d64cd1944f7)


### Backend
1. Cài đặt Netbeans [tại đây](https://netbeans.apache.org/front/main/download/).
2. Mở project.
3. Thêm các thư viện hỗ trợ trong thư mục [add libs]. Cách thêm thư viện trong Netbeans [tại đây](https://www.digi.com/resources/documentation/Digidocs/90001456-13/tasks/t_wk_link_libraries.htm).
4. Click chuột phải vào project > Run.

**Nếu quá trình thành công, màn hình hiển thị giao diện như hình dưới**
> ![image](https://github.com/thuychang404/Chasen/assets/130899126/b733fec1-0d0a-434f-ae1a-ece22b517dc8)

### Frontend
1. Cài đặt Visual Studio Code [tại đây](https://code.visualstudio.com/download).
2. Cài đặt extension Live Server.
3. Click chuột phải > Open with Live Server.

**Nếu quá trình thành công, màn hình hiển thị giao diện như hình dưới**
> ![image](https://github.com/thuychang404/Chasen/assets/130899126/c95410eb-9651-4fc3-8139-05e08829be91)

## Hỗ trợ
During using the application, if you encounter any problems, feel free to get in touch me through Facebook or Gmail. I always welcome questions. Otherwise you can rise issues through [Issues]() channel if needed. I will leave my Facebook links below.
[Facebook](https://facebook.com/thuychang404) and 
[Gmail](mailto:tttt.tranthithuytrang@gmail.com)
