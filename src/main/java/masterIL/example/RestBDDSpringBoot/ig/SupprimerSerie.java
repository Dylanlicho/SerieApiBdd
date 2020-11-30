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
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
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
                int id = Integer.parseInt(idText.getText());
                Main.deleteSerieById(id);
            }
        });
    }



}
