/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author trang
 */
public class StringToInt {
    public static void transfer () {
//        String str = "123";
//        Integer integerObj = Integer.valueOf(str);
//        int number = integerObj.intValue(); // Đối với Java 8 trở về sau, bạn có thể sử dụng phương thức intValue()

        String str = "123";
        int number = Integer.parseInt(str);

        int result = number - 3;
        System.out.println("number: " + result);

    }
    
//    public static void main(String args[]) {
//        transfer();
//    }
}
