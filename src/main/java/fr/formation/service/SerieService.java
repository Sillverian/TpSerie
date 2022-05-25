package fr.formation.service;

import fr.formation.exception.SerieException;
import fr.formation.model.Serie;

import java.util.List;

public interface SerieService {

    Serie ajouterSerie(Serie s) throws SerieException;

    Serie modifierSerie(Serie s) throws SerieException;

    List<Serie> trouverLesSeries();

    List<Serie> trouverLesSeriesTriAsc();

    List<Serie> trouverLesSeriesTriDesc();

    List<Serie> trouverLesSeriesTriAnneePremSaisonAsc();

    List<Serie> trouverLesSeriesTriAnneePremSaisonDesc();

    List<Serie> trouverLesSeriesTriNbEpisodesAsc();

    List<Serie> trouverLesSeriesTriNbEpisodesDesc();

    List<Serie> trouverLesSeriesRechercheRealLike(String real);

    List<Serie> trouverLesSeriesRechercheActLike(String act);

    List<Serie> trouverLesSeriesRechercheTitreLike(String titre);

    Serie trouverLaSerie(int id) throws SerieException;
}
