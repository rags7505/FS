/*

Write Java code to print system date & time in format like 
2021-10-02 10:30:00 AM

Sample Output: 2025-06-04 11:35:27 AM

*/
import java.util.Date;
import java.text.SimpleDateFormat;
class Solution6{
    public static void main (String[] args) {
        Date currentDate=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String formattedDate=formatter.format(currentDate);
        System.out.println(formattedDate);
    }
}