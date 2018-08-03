import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateToDay{

    public static String getDay(String day, String mon, String year){

        int y = Integer.valueOf(year);
        int m = Integer.valueOf(mon) - 1;
        int d = Integer.valueOf(day);

        Calendar cal = new GregorianCalendar(y, m, d);
        int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
        String str = "";
        switch(dayOfWeek){
            case 1:
                str = "SUNDAY";
                break;
            case 2:
                str = "MONDAY";
                break;
            case 3:
                str = "TUESDAY";
                break;
            case 4:
                str = "WEDNESDAY";
                break;
            case 5:
                str = "THURSDAY";
                break;
            case 6:
                str = "FRIDAY";
                break;
            case 7:
                str = "SATURDAY";
                break;
            default:
                str = "";
                break;            
        }
        return str;
    }
    public static void main(String[] args) {

        String month = "08";
        String day = "05";
        String year = "2999";
        
        System.out.println(getDay(day, month, year));
    }
}