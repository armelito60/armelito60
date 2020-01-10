import com.toedter.calendar.JCalendar;
import javax.swing.*;
import java.util.Date;

public class WindowsCalendar {

    public WindowsCalendar() {
        JFrame frame = new JFrame();
        JCalendar jc = new JCalendar();
        frame.add(jc);
        frame.setVisible(true);
        Date date = jc.getCalendar().getTime();
        System.out.println(date);


        // hotelGUI

    }

}
