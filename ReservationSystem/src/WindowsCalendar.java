import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;


public class WindowsCalendar {

    private JComboBox liste1;
    private JComboBox liste2;
    private JButton btnCal;

    public WindowsCalendar() {
        JFrame frame = new JFrame();
        JCalendar cal = new JCalendar();
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(1000, 1000, 1000, 1000);
        frame.getContentPane().add(dateChooser);

        JDateChooser dateChooser1 = new JDateChooser();
        dateChooser.setBounds(1000, 1000, 1000, 1000);
        frame.getContentPane().add(dateChooser1);

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel bottomLeftPanel = new JPanel();
        JPanel bottomRightPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new GridLayout(0, 2));
        topPanel.setBorder(BorderFactory.createTitledBorder("Choix du type de chambre"));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Calendrier de réservation"));
        bottomLeftPanel.setBorder(BorderFactory.createTitledBorder("Date d'arrivée"));
        bottomRightPanel.setBorder(BorderFactory.createTitledBorder("Date de sortie"));
        bottomPanel.add(bottomLeftPanel);
        bottomPanel.add(bottomRightPanel);
        bottomLeftPanel.add(dateChooser);
        bottomRightPanel.add(dateChooser1);

        Object[] elements = new Object[]{Food.Menu1, Food.Menu2, Food.Menu3, Food.Menu3, Food.MenuVegan};
        Object[] elements1 = new Object[]{RoomType.Room1, RoomType.Room2, RoomType.Room3, RoomType.Room4};
        liste1 = new JComboBox(elements1);
        liste2 = new JComboBox(elements);
        topPanel.add(liste1);
        topPanel.add(liste2);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel);
        frame.pack();
        frame.setVisible(true);

        cal.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                System.out.println(cal.getDate().toString());
            }
        });
    }

    public void dateSejour() throws ParseException {
        // Create SimpleDateFormat object
        SimpleDateFormat
                sdfo
                = new SimpleDateFormat("yyyy-MM-dd");

        // Get the two dates to be compared
        Date d1 = sdfo.parse("2018-03-31");
        Date d2 = sdfo.parse("2012-03-31");

        // Print the dates
        System.out.println("Date1 : " + sdfo.format(d1));
        System.out.println("Date2 : " + sdfo.format(d2));

        // Compare the dates
        if (d1.after(d2)) {

            // When Date d1 > Date d2
            System.out.println("Date1 is after Date2");
        }

        else if (d1.before(d2)) {

            // When Date d1 < Date d2
            System.out.println("Date1 is before Date2");
        }

        else if (d1.equals(d2)) {

            // When Date d1 = Date d2
            System.out.println("Date1 is equal to Date2");
        }
    }

}
