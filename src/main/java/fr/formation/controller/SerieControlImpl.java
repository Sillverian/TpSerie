package fr.formation.controller;

import fr.formation.exception.SerieException;
import fr.formation.model.Serie;
import fr.formation.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SerieControlImpl implements SerieController {

    @Autowired
    private SerieService sService;

    @Override
    public Serie appelAjoutSerie(Serie s) throws SerieException {
        return sService.ajouterSerie(s);
    }

    @Override
    public Serie appelModifSerie(Serie s) throws SerieException {
        return sService.modifierSerie(s);
    }

    @Override
    public List<Serie> appelTrouverSeries() {
        return sService.trouverLesSeries();
    }

    @Override
    public List<Serie> appelTrouverSeriesAsc() {
        return sService.trouverLesSeriesTriAsc();
    }

    @Override
    public List<Serie> appelTrouverSeriesDesc() {
        return sService.trouverLesSeriesTriDesc();
    }

    @Override
    public List<Serie> appelTrouverSeriesAnneePremSaisonAsc() {
        return sService.trouverLesSeriesTriAnneePremSaisonAsc();
    }

    @Override
    public List<Serie> appelTrouverSeriesAnneePremSaisonDesc() {
        return sService.trouverLesSeriesTriAnneePremSaisonDesc();
    }

    @Override
    public List<Serie> appelTrouverSeriesNbEpisodesAsc() {
        return sService.trouverLesSeriesTriNbEpisodesAsc();
    }

    @Override
    public List<Serie> appelTrouverSeriesNbEpisodesDesc() {
        return sService.trouverLesSeriesTriNbEpisodesDesc();
    }

    @Override
    public List<Serie> appelTrouverSeriesRechercheReal(String real) {
        return sService.trouverLesSeriesRechercheRealLike(real);
    }

    @Override
    public List<Serie> appelTrouverSeriesRechercheAct(String act) {
        return sService.trouverLesSeriesRechercheActLike(act);
    }

    @Override
    public List<Serie> appelTrouverSeriesRechercheTitre(String titre) {
        return sService.trouverLesSeriesRechercheTitreLike(titre);
    }

    @Override
    public Serie appelTrouverLaSerie(int id) throws SerieException {
        return sService.trouverLaSerie(id);
    }
}
