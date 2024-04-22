/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author trang
 */
public class DataSensors {
    private int id;
    private float temperature;
    private float humid;
    private float intensity;
    private String readingTime;
    
    public DataSensors() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumid() {
        return humid;
    }

    public void setHumid(float humid) {
        this.humid = humid;
    }

    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(float intensity) {
        this.intensity = intensity;
    }

    public String getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(String readingTime) {
        this.readingTime = readingTime;
    }

    public DataSensors(int id, float temperature, float humid, float intensity, String readingTime) {
        this.id = id;
        this.temperature = temperature;
        this.humid = humid;
        this.intensity = intensity;
        this.readingTime = readingTime;
    }

    public DataSensors(float temperature, float humid, float intensity) {
        this.temperature = temperature;
        this.humid = humid;
        this.intensity = intensity;
    }
    
    

    @Override
    public String toString() {
        return "DataSensors{" + "id=" + id + ", temperature=" + temperature + ", humid=" + humid + ", intensity=" + intensity + ", readingTime=" + readingTime + '}';
    }
    
    
    
    
}
