package fr.formation.repository;

import fr.formation.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieDAO extends JpaRepository<Serie, Integer> {

    List<Serie> findByOrderByTitreAsc();

    List<Serie> findByOrderByTitreDesc();

    List<Serie> findDistinctByOrderBySaisonsAnneeAsc();

    List<Serie> findDistinctByOrderBySaisonsAnneeDesc();

    @Query(value = "SELECT * FROM serie INNER JOIN serie_saison ON serie.id = serie_saison.Serie_id INNER JOIN saison ON saison.id = serie_saison.saisons_id GROUP BY Serie_id ORDER BY SUM(saison.nbEpisodes) ASC", nativeQuery = true)
    List<Serie> trouverTousTriParTotalEpisodesAsc();

    @Query(value = "SELECT * FROM serie INNER JOIN serie_saison ON serie.id = serie_saison.Serie_id INNER JOIN saison ON saison.id = serie_saison.saisons_id GROUP BY Serie_id ORDER BY SUM(saison.nbEpisodes) DESC", nativeQuery = true)
    List<Serie> trouverTousTriParTotalEpisodesDesc();

    List<Serie> findDistinctBySaisonsRealisateurNomContaining(String nom);

    List<Serie> findDistinctBySaisonsActeursNomContaining(String nom);

    List<Serie> findDistinctByTitreContaining(String titre);
}
