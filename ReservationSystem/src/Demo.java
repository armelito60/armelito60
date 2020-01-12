import java.awt.EventQueue;
import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

public class Demo {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Demo window = new Demo();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Demo() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(40, 40, 200, 20);
        frame.getContentPane().add(dateChooser);
        System.out.println();
    }
}
