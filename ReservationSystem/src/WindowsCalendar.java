import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JComboBox;


public class WindowsCalendar {

    private JComboBox liste1;
    private JComboBox liste2;
    private JButton btnCal;
    private Date depart = new Date();
    private Date arrivee = new Date();
    private JButton cal = new JButton();

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
        JPanel validationPanel = new JPanel();
        JButton date = new JButton("Valider les dates");
        topPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new GridLayout(0, 2));
        validationPanel.setLayout(new FlowLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("Choix du type de chambre"));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Calendrier de réservation"));
        bottomLeftPanel.setBorder(BorderFactory.createTitledBorder("Date d'arrivée"));
        bottomRightPanel.setBorder(BorderFactory.createTitledBorder("Date de sortie"));
        bottomPanel.add(bottomLeftPanel);
        bottomPanel.add(bottomRightPanel);
        bottomLeftPanel.add(dateChooser);
        bottomRightPanel.add(dateChooser1);
        validationPanel.add(date);

        Object[] elements = new Object[]{Food.Menu1, Food.Menu2, Food.Menu3, Food.Menu3, Food.MenuVegan};
        Object[] elements1 = new Object[]{RoomType.Room1, RoomType.Room2, RoomType.Room3, RoomType.Room4};
        liste1 = new JComboBox(elements1);
        liste2 = new JComboBox(elements);
        topPanel.add(liste1);
        topPanel.add(liste2);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.CENTER);
        frame.add(validationPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

        date.addActionListener(e ->{
            SimpleDateFormat  sdfo = new SimpleDateFormat("yyyy-MM-dd");

            Calendar calendarArrivee = dateChooser.getCalendar();
            calendarArrivee.set(Calendar.HOUR_OF_DAY, 0);
            calendarArrivee.set(Calendar.MINUTE, 0);
            calendarArrivee.set(Calendar.SECOND, 0);
            calendarArrivee.set(Calendar.MILLISECOND, 0);

            Calendar calendarDepart = dateChooser1.getCalendar();
            calendarDepart.set(Calendar.HOUR_OF_DAY, 0);
            calendarDepart.set(Calendar.MINUTE, 0);
            calendarDepart.set(Calendar.SECOND, 0);
            calendarDepart.set(Calendar.MILLISECOND, 0);


            arrivee = calendarArrivee.getTime();
            depart = calendarDepart.getTime();

            System.out.println("Date d'arrivée : " + sdfo.format(arrivee));
            System.out.println("Date de départ : " + sdfo.format(depart));


            // Compare the dates
            if (arrivee.after(depart)) {

                // When Date d1 > Date d2
                System.out.println("Date1 is after Date2");
            }

            else if (arrivee.before(depart)) {
                try {
                    // When Date d1 < Date d2
                    System.out.println("Date1 is before Date2");
                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Date de départ antérieur à la date d'arrivée");
                }
            }

            else if (arrivee.equals(depart)) {

                // When Date d1 = Date d2
                try {
                    System.out.println("Date1 is equal to Date2");
                }
                catch(Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Date de départ égale à la date d'arrivée");
                }
            }

        });

    }

    public void dateSejour() throws ParseException {
        // Create SimpleDateFormat object


        // Get the two dates to be compared
        Date d1 = arrivee;
        Date d2 = depart;

        // Print the dates

    }

}
