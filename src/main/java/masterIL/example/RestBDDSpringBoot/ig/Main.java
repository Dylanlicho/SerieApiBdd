package masterIL.example.RestBDDSpringBoot.ig;

import masterIL.example.RestBDDSpringBoot.model.Serie;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class Main {

    private static String REST_SERVICE_URI = "http://localhost:8081/";

    private static App accueilIG;
    private static RechercheSerie rechercheSerieIG;
    private static AjouterSerie ajouterSerieIG;

    public static void main(String[] args){

        accueilIG = new App();
        rechercheSerieIG = new RechercheSerie();
        ajouterSerieIG = new AjouterSerie();

        accueilIG.setVisible(true);
    }

    // ---------------------------------  IG  ----------------------------------

    public static void goAccueilIG(){
        accueilIG.setVisible(true);
    }

    public static void goRechercheSerieIG(){
        accueilIG.setVisible(false);
        Optional<List<Serie>> series = listAllSeries();
        if(series.isPresent()) {
            rechercheSerieIG.afficherTousSerie(series.get());
        }else{
            rechercheSerieIG.erreur("Aucune série");
        }
        rechercheSerieIG.setVisible(true);
    }

    public static void goAjouterSerieIG(){
        accueilIG.setVisible(false);
        ajouterSerieIG.setVisible(true);
    }

    public static RechercheSerie getRechercheSerieIG() {
        return rechercheSerieIG;
    }

    public static AjouterSerie getAjouterSerieIG() {
        return ajouterSerieIG;
    }

    // ---------------------------------  Méthode  ----------------------------------

    private static Optional<List<Serie>> listAllSeries(){
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> mapList = restTemplate.getForObject(REST_SERVICE_URI+"/Series", List.class);

        if(mapList!=null){
            List<Serie>  listSeries = new ArrayList<>();
            Serie serie;
            int id;
            String nom, auteur, resume;
            for(LinkedHashMap<String, Object> map : mapList){
                id = (Integer) map.get("id");
                nom = (String) map.get("nom");
                auteur = (String) map.get("auteur");
                resume = (String) map.get("resume");

                serie = new Serie(id,nom,auteur,resume);
                listSeries.add(serie);
            }
            return Optional.of(listSeries);
        }
        return Optional.of(null);
    }

    public static Optional<Serie> getSerieById(int id){
        RestTemplate restTemplate = new RestTemplate();
        Serie serie = restTemplate.getForObject(REST_SERVICE_URI+"Serie/"+id, Serie.class);

        if(serie!=null){
            return Optional.of(serie);
        }
        return Optional.of(null);
    }

    public static void addSerie(Serie serie) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(REST_SERVICE_URI+"addSerie",serie, Serie.class);
    }
}