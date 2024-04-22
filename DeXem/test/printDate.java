import java.text.SimpleDateFormat;
import java.util.Date;

public class printDate {
    public static void printCurrentDate() {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(currentDate);
        System.out.println("Thời gian hiện tại: " + formattedDate);
    }
    
//    public static void main(String args[]){
//        printCurrentDate();
//    }
}
