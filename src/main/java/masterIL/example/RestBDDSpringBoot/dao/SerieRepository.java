package masterIL.example.RestBDDSpringBoot.dao;

import masterIL.example.RestBDDSpringBoot.model.Serie;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SerieRepository implements ISerieRepository {


    //private List<Serie> listSeries = new ArrayList<Serie>(Arrays.asList(new Serie("Dylan in the round", "Dylan", "Bla bla"), new Serie("First", "David", "Bal bla 2")));
    private List<Serie> listSeries = new ArrayList<Serie>();

    @Override
    public <S extends Serie> S save(S s) {
        listSeries.add(s);
        return s;
    }

    @Override
    public <S extends Serie> Iterable<S> saveAll(Iterable<S> iterable) {
        Serie s = null;
        while(iterable.iterator().hasNext()){
            s = iterable.iterator().next();
            listSeries.add(s);
        }
        return new Iterable<S>() {
            @Override
            public Iterator<S> iterator() {
                return (Iterator<S>) listSeries.iterator();
            }
        };
    }

    @Override
    public Optional<Serie> findById(Integer integer) {
        Serie serie = null;
        Iterator<Serie> iterator = listSeries.iterator();
        boolean trouve = false;
        while(iterator.hasNext() && !trouve){
            serie = iterator.next();
            if(serie.getId().equals(integer)){
                trouve = true;
            }
        }
        return Optional.of(serie);
    }

    @Override
    public boolean existsById(Integer integer) {
        Serie serie;
        Iterator<Serie> iterator = listSeries.iterator();
        boolean trouve = false;
        while(iterator.hasNext() && !trouve){
            serie = iterator.next();
            if(serie.getId().equals(integer)){
                trouve = true;
            }
        }
        return trouve;
    }

    @Override
    public List<Serie> findAll() {
        return listSeries;
    }

    @Override
    public Iterable<Serie> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return listSeries.size();
    }

    @Override
    public void deleteById(Integer integer) {
        Serie serie;
        Iterator<Serie> iterator = listSeries.iterator();
        boolean trouve = false;
        while(iterator.hasNext() && !trouve){
            serie = iterator.next();
            if(serie.getId().equals(integer)){
                iterator.remove();
                trouve = true;
            }
        }
    }

    @Override
    public void delete(Serie aSupprimer) {
        Serie serie;
        Iterator<Serie> iterator = listSeries.iterator();
        boolean trouve = false;
        while(iterator.hasNext() && !trouve){
            serie = iterator.next();
            if(serie.getId().equals(aSupprimer.getId())){
                iterator.remove();
                trouve = true;
            }
        }
    }

    @Override
    public void deleteAll(Iterable<? extends Serie> iterable) {

    }

    @Override
    public void deleteAll() {
        listSeries = new ArrayList<>();
    }













/*



    @Override
    public Serie findByName(String name) {
        Serie res = null;
        Serie serie;
        Iterator<Serie> iterator = listSeries.iterator();
        boolean trouve = false;
        while(iterator.hasNext() && !trouve){
            serie = iterator.next();
            if(serie.getNom().equals(name)){
                res = serie;
                trouve = true;
            }
        }
        return res;
    }

    @Override
    public void addSerie(Serie serie) {
        listSeries.add(serie);
    }

    @Override
    public void modifySerieByName(String name, Serie nouvelleSerie) {
        this.deleteSerieByName(name);
        listSeries.add(nouvelleSerie);
    }

    @Override
    public void deleteSerieByName(String name) {
        Serie serie;
        Iterator<Serie> iterator = listSeries.iterator();
        boolean trouve = false;
        while(iterator.hasNext() && !trouve){
            serie = iterator.next();
            if(serie.getNom().equals(name)){
                iterator.remove();
                trouve = true;
            }
        }
    }*/
}
