package masterIL.example.RestBDDSpringBoot.ig;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends javax.swing.JFrame {

    /**
     * Creates new form IG
     */
    public App() {
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        initComponents();
    }

    private void initComponents() {
        rechercheSerieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.goRechercheSerieIG();
            }
        });
        ajouterUneSerieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.goAjouterSerieIG();
            }
        });
        supprimerUneSerieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.goSupprimerSerieIG();
            }
        });
        diversButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.goDiversIG();
            }
        });
    }

    private JButton rechercheSerieButton;
    private JButton supprimerUneSerieButton;
    private JButton diversButton;
    private JButton ajouterUneSerieButton;
    private JPanel mainPanel;

}
