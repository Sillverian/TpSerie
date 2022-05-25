package fr.formation.controller;

import fr.formation.exception.SerieException;
import fr.formation.model.Serie;

import java.util.List;

public interface SerieController {

    Serie appelAjoutSerie(Serie s) throws SerieException;

    Serie appelModifSerie(Serie s) throws SerieException;

    List<Serie> appelTrouverSeries();

    List<Serie> appelTrouverSeriesAsc();

    List<Serie> appelTrouverSeriesDesc();

    List<Serie> appelTrouverSeriesAnneePremSaisonAsc();

    List<Serie> appelTrouverSeriesAnneePremSaisonDesc();

    List<Serie> appelTrouverSeriesNbEpisodesAsc();

    List<Serie> appelTrouverSeriesNbEpisodesDesc();

    List<Serie> appelTrouverSeriesRechercheReal(String real);

    List<Serie> appelTrouverSeriesRechercheAct(String act);

    List<Serie> appelTrouverSeriesRechercheTitre(String titre);


    Serie appelTrouverLaSerie(int id) throws SerieException;
}
