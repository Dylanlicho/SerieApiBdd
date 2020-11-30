package masterIL.example.RestBDDSpringBoot.dao;

import masterIL.example.RestBDDSpringBoot.model.Serie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISerieRepository extends CrudRepository<Serie, Integer> {

    public List<Serie> findAll();
/*
    public Serie findByName(String name);

    public void addSerie(Serie serie);

    public void modifySerieByName(String name, Serie serie);

    public void deleteSerieByName(String name);*/

}
