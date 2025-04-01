package _2023_14;

import java.util.Calendar;
import java.util.Date;

public class A_Date {
    public static void main(String[] args) {
        Calendar calendar =  Calendar.getInstance();
        calendar.set(2000,0,1);
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH)+1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        long count = 0;
        while(yy<2000000){
            if(yy % mm == 0&&yy%dd == 0) count++;
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            yy = calendar.get(Calendar.YEAR);
            mm = calendar.get(Calendar.MONTH)+1;
            dd = calendar.get(Calendar.DAY_OF_MONTH);
        }
        count++;
        System.out.println(count);

    }
}
