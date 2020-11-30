package masterIL.example.RestBDDSpringBoot.ig;

import masterIL.example.RestBDDSpringBoot.model.Serie;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class RechercheSerie extends javax.swing.JFrame {

    private JButton validerButton;
    private JTextArea Infos;
    private JTextField idText;
    private JButton accueilButton;
    private JPanel mainPanel;

    public RechercheSerie(){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        initComponent();
    }

    public void initComponent() {
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.valueOf(idText.getText());
                Optional<Serie> serie = Main.getSerieById(id);
                if(serie.isPresent()) {
                    Infos.setText(serie.get().toString());
                }else{
                    erreur("Série non trouvé");
                }
            }
        });
        accueilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getRechercheSerieIG().setVisible(false);
                Main.goAccueilIG();
            }
        });
    }

    public void erreur(String aAfficher){
        Infos.setText("Erreur: \n\n"+aAfficher);
    }

    public void afficherTousSerie(List<Serie> series) {
        StringBuilder aAfficher = new StringBuilder("");
        for(Serie s : series){
            aAfficher.append(s.toString()+"\n");
        }
        Infos.setText("Toute les séries: \n\n"+aAfficher.toString());
    }
}
