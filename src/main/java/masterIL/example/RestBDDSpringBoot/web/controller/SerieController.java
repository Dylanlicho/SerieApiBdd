package masterIL.example.RestBDDSpringBoot.web.controller;

import masterIL.example.RestBDDSpringBoot.dao.ISerieRepository;
import masterIL.example.RestBDDSpringBoot.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class SerieController {

    @Qualifier("ISerieRepository")
    @Autowired
    private ISerieRepository dao;

    @GetMapping(value = "Series")
    public List<Serie> getListeSeries(){
        return dao.findAll();
    }

    @GetMapping(value = "Serie/{id}")
    public Optional<Serie> getSerieById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "existSerie/{id}")
    public boolean existSerieById(@PathVariable Integer id){return dao.existsById(id);}

    @GetMapping(value = "count")
    public long count(){return dao.count();}


    @PostMapping(value = "addSerie")
    public void addSerie(@RequestBody Serie serie){
        dao.save(serie);
    }

    @DeleteMapping(value = "deleteSerieBySerie/{serie}")
    public void deleteSerieBySerie(@PathVariable Serie serie){ dao.delete(serie);}

    @DeleteMapping(value = "deleteSerieById/{id}")
    public void deleteSerieById(@PathVariable Integer id){ dao.deleteById(id);}

    /*
    @PostMapping(value = "addSerieHtml")
    public Serie addSerieHtml(@ModelAttribute Serie serie){
        dao.save(serie);
        return serie;
    }

    @PostMapping(value = "SerieByIdHtml/{id}")
    public Optional<Serie> getSerieByIdHtml(@PathVariable Integer id){
        return dao.findById(id);
    }

    @DeleteMapping(value = "deleteSerieHtml/{serie}")
    public void deleteSerieBySerieHtml(@PathVariable Serie serie){ dao.delete(serie);}*/

/*
    @PutMapping(value = "modifySerieByName/{name}")
    public void modifiySerie(@PathVariable String name, @RequestBody Serie serie){ dao.modifySerieByName(name, serie);}

    @DeleteMapping(value = "deleteSerieByName/{name}")
    public void deleteSerieByName(@PathVariable String name){ dao.deleteSerieByName(name);}*/


}
