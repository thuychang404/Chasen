/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author trang
 */
public class HistoryDevices {
    private int id;
    private String device;
    private String status;
    private String readingTime;
    
    public HistoryDevices() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(String readingTime) {
        this.readingTime = readingTime;
    }
    

    public HistoryDevices(int id, String device, String status, String date, String time) {
        this.id = id;
        this.device = device;
        this.status = status;
        this.readingTime = date;
    }

    @Override
    public String toString() {
        return "HistoryDevices{" + "id=" + id + ", device=" + device + ", status=" + status + ", readingTime=" + readingTime + '}';
    }
    
    
}
