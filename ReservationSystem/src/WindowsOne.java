import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

public class WindowsOne implements ActionListener {

    private BufferedImage image;
    private JButton welcomeButton;
    private JFrame frame;

    public WindowsOne() {
        JFrame frame = new JFrame("Reservation Hotel");
        frame.setMinimumSize(new Dimension(640,480));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(100, 100);
        frame.setVisible(true);

        JLabel label = new JLabel(new ImageIcon("./src/chambre-triple-pre-mium.jpg"));
        JPanel panel = new JPanel(); // on crée un panel
        panel.setLayout(new OverlayLayout(panel)); // on lui affecte le layout OverLayLayout

        JPanel form = new JPanel(); // on crée un JPanel pour les composants

        this.welcomeButton = new JButton("Accéder à la réservation");
        form.add(welcomeButton); // on ajoute le bouton
        welcomeButton.addActionListener( this);

        //Il faut rendre le panel du formulaire transparent, pour voir l'image à travers
        form.setOpaque(false);

        panel.add(form); // on ajoute le formulaire
        panel.add(label); // on ajoute après le composant avec l'image (après pour qu'il soit affiché en dessus)

        frame.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        new WindowsCalendar();
    }
}
