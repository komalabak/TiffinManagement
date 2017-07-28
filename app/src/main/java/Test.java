import com.example.pandadesktop4.loginscreen.Util;

import java.util.Date;

/**
 * Created by pandadesktop4 on 27/7/17.
 */

public class Test {

    public static void main(String[] args) {
        Date today = new Date();
        Integer currentMonth = today.getMonth() + 1;
        Integer currentYear = today.getYear() +1900;




        System.out.println(currentMonth);
        System.out.println(currentYear);

        System.out.println(Util.getDatesForMonth(today.getMonth(), today.getYear()));



    }

}
