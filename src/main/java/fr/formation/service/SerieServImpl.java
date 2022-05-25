package fr.formation.service;

import fr.formation.exception.SerieException;
import fr.formation.model.Serie;
import fr.formation.repository.SerieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SerieServImpl implements SerieService {

    @Autowired
    private SerieDAO sDao;

    @Override
    public Serie ajouterSerie(Serie s) throws SerieException {
        verifSerie(s);
        return sDao.save(s);
    }

    @Override
    public Serie modifierSerie(Serie s) throws SerieException {
        verifSerie(s);
        return sDao.save(s);
    }

    private void verifSerie(Serie s) throws SerieException {
        if (s == null) {
            throw new SerieException("La serie ne peut pas être nulle");
        }
        if (s.getTitre() == null && s.getTitre().isBlank()) {
            throw new SerieException("Le titre de la série ne peut pas être nul");
        }
        if (s.getSaisons() == null && s.getSaisons().isEmpty()) {
            throw new SerieException("Une série doit comporter au moins une saison");
        }
    }

    @Override
    public List<Serie> trouverLesSeries() {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.findAll();
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesTriAsc() {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.findByOrderByTitreAsc();
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesTriDesc() {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.findByOrderByTitreDesc();
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesTriAnneePremSaisonAsc() {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.findDistinctByOrderBySaisonsAnneeAsc();
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesTriAnneePremSaisonDesc() {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.findDistinctByOrderBySaisonsAnneeDesc();
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesTriNbEpisodesAsc() {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.trouverTousTriParTotalEpisodesAsc();
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesTriNbEpisodesDesc() {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.trouverTousTriParTotalEpisodesDesc();
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesRechercheRealLike(String real) {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.findDistinctBySaisonsRealisateurNomContaining(real);
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesRechercheActLike(String act) {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.findDistinctBySaisonsActeursNomContaining(act);
        return lSerie;
    }

    @Override
    public List<Serie> trouverLesSeriesRechercheTitreLike(String titre) {
        List<Serie> lSerie = new ArrayList<>();
        lSerie = sDao.findDistinctByTitreContaining(titre);
        return lSerie;
    }

    @Override
    public Serie trouverLaSerie(int id) throws SerieException {
        if (id <= 0) {
            throw new SerieException("L'identifiant de la serie doit être positif");
        }

        return null;
    }
}
