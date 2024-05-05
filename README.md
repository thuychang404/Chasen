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
- [Cách cài đặt](#cách-cài-đặt)
  - [Database](#)
  - [Backend](#)
  - [Frontend](#)

## Kỹ thuật 
### Frontend
- HTML
- CSS
- JS
### Backend 
- Java Servlet
### Database
- MySQL


## Cách cài đặt
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
1. Cài đặt 
