package masterIL.example.RestBDDSpringBoot.ig;

import masterIL.example.RestBDDSpringBoot.model.Serie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupprimerSerie extends JFrame {

    private JButton accueilButton;
    private JPanel mainPanel;
    private JTextField idText;
    private JButton supprimerButton;

    public SupprimerSerie(){
        this.getContentPane().add(mainPanel);
        initComponent();
    }

    public void initComponent() {
        accueilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getSupprimerSerieIG().setVisible(false);
                Main.goAccueilIG();
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.supprimeSerieById();
            }
        });
    }



}
