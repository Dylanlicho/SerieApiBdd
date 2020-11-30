package masterIL.example.RestBDDSpringBoot.ig;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Divers extends JFrame {

    private JPanel mainPanel;
    private JButton accueilButton;
    private JButton nombreDeSerieButton;
    private JTextArea Infos;
    private JButton verifierButton;
    private JTextField idText;

    public Divers(){
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        initComponent();
    }

    private void initComponent() {
        accueilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getDiversIG().setVisible(false);
                Main.goAccueilIG();
            }
        });
        nombreDeSerieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nb = Main.getNbSerie();
                affiche("Il y a "+nb+" séries dans la base de données");
            }
        });
        verifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idText.getText());
                if(Main.existById(id)){
                    affiche("La série existe");
                }else{
                    affiche("La série n'existe pas");
                }
            }
        });
    }

    private void affiche(String aAfficher){
        Infos.setText(aAfficher);
    }

}
