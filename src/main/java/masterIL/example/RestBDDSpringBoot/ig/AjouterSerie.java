package masterIL.example.RestBDDSpringBoot.ig;

import masterIL.example.RestBDDSpringBoot.model.Serie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class AjouterSerie extends JFrame{
    private JPanel mainPanel;
    private JButton accueilButton;
    private JTextField idText;
    private JTextField nomText;
    private JTextField auteurText;
    private JTextArea resumeText;
    private JButton validerButton;

    public AjouterSerie(){
        this.setContentPane(mainPanel);
        initComponent();
    }

    public void initComponent() {
        accueilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getAjouterSerieIG().setVisible(false);
                Main.goAccueilIG();
            }
        });
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = nomText.getText();
                String auteur = auteurText.getText();
                String resume = resumeText.getText();
                Serie serie = new Serie(nom, auteur, resume);
                Main.addSerie(serie);
            }
        });
    }

}
