package fr.formation.main;

import fr.formation.config.ApplicationConfig;
import fr.formation.controller.SerieController;
import fr.formation.model.Acteur;
import fr.formation.model.Realisateur;
import fr.formation.model.Saison;
import fr.formation.model.Serie;
import fr.formation.repository.SerieDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainSerie {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        SerieDAO sDao = ac.getBean(SerieDAO.class);
        SerieController sControl = ac.getBean(SerieController.class);

        // SERIE 1

        Realisateur real1 = new Realisateur("Laer", "Bob");

        Acteur act1 = new Acteur("Lefort", "Michel", "la brute");
        Acteur act2 = new Acteur("Lafaible", "Sophie", "l'assassine");
        Acteur act3 = new Acteur("Lefort", "Michel", "la brute");
        Acteur act4 = new Acteur("Lafaible", "Sophie", "l'assassine");


        List<Acteur> listeActeurs = new ArrayList<>();
        listeActeurs.add(act1);
        listeActeurs.add(act2);

        List<Acteur> listeActeurs2 = new ArrayList<>();
        listeActeurs2.add(act3);
        listeActeurs2.add(act4);

        Saison s1 = new Saison(1, 2000, 5, real1, listeActeurs);
        Saison s2 = new Saison(2, 2003, 10, real1, listeActeurs2);

        List<Saison> listeSaisons = new ArrayList<>();
        listeSaisons.add(s1);
        listeSaisons.add(s2);

        Serie ser1 = new Serie("Brutassin", listeSaisons);

        sDao.save(ser1);

        // SERIE 2

        Realisateur real2 = new Realisateur("Movier", "Phillibert");

        Acteur act5 = new Acteur("Bastion", "Lance", "le chevalier");
        Acteur act6 = new Acteur("Crown", "Louis", "le roi");
        Acteur act7 = new Acteur("Scale", "Bernardette", "la dragonne");

        Acteur act8 = new Acteur("Bastion", "Lance", "le chevalier");
        Acteur act9 = new Acteur("Crown", "Louis", "le roi");
        Acteur act10 = new Acteur("Scale", "Bernardette", "la dragonne");
        Acteur act11 = new Acteur("Staff", "Kevin", "le mage noir");


        List<Acteur> listeActeurs3 = new ArrayList<>();
        listeActeurs3.add(act5);
        listeActeurs3.add(act6);
        listeActeurs3.add(act7);

        List<Acteur> listeActeurs4 = new ArrayList<>();
        listeActeurs4.add(act8);
        listeActeurs4.add(act9);
        listeActeurs4.add(act10);
        listeActeurs4.add(act11);

        Saison ss1 = new Saison(1, 1999, 10, real2, listeActeurs3);
        Saison ss2 = new Saison(2, 2005, 12, real2, listeActeurs4);

        List<Saison> listeSaisons2 = new ArrayList<>();
        listeSaisons2.add(ss1);
        listeSaisons2.add(ss2);

        Serie ser2 = new Serie("Spear of dragons", listeSaisons2);

        sDao.save(ser2);

        // SERIE 3

        Realisateur real3 = new Realisateur("Fablo", "Jean");

        Acteur act12 = new Acteur("Fox", "Pablo", "le renard");
        Acteur act13= new Acteur("Crow", "Bart", "le corbeau");

        List<Acteur> listeActeurs5 = new ArrayList<>();
        listeActeurs5.add(act12);
        listeActeurs5.add(act13);

        Saison sss1 = new Saison(1, 2011, 6, real3, listeActeurs5);

        List<Saison> listeSaisons3 = new ArrayList<>();
        listeSaisons3.add(sss1);

        Serie ser3 = new Serie("Maître renard et le corbeau : Live action", listeSaisons3);

        sDao.save(ser3);

        // AFFICHAGE

        System.out.println("\nListe des séries : ");
        List<Serie> lSerie = sControl.appelTrouverSeries();
        lSerie.forEach(System.out::println);

        System.out.println("\nListe des séries triée par titre croissant : ");
        lSerie = sControl.appelTrouverSeriesAsc();
        lSerie.forEach(System.out::println);

        System.out.println("\nListe des séries triée par titre décroissant : ");
        lSerie = sControl.appelTrouverSeriesDesc();
        lSerie.forEach(System.out::println);

        System.out.println("\nListe des séries triée par ordre chrono premiere saison croissant : ");
        lSerie = sControl.appelTrouverSeriesAnneePremSaisonAsc();
        lSerie.forEach(System.out::println);

        System.out.println("\nListe des séries triée par ordre chrono premiere saison décroissant : ");
        lSerie = sControl.appelTrouverSeriesAnneePremSaisonDesc();
        lSerie.forEach(System.out::println);

        System.out.println("\nListe des séries triée par total épisodes croissant : ");
        lSerie = sControl.appelTrouverSeriesNbEpisodesAsc();
        lSerie.forEach(System.out::println);

        System.out.println("\nListe des séries triée par total episodes décroissant : ");
        lSerie = sControl.appelTrouverSeriesNbEpisodesDesc();
        lSerie.forEach(System.out::println);

        System.out.println("\nListe des séries réalisées par Laer : ");
        lSerie = sControl.appelTrouverSeriesRechercheReal("Laer");
        lSerie.forEach(System.out::println);

        System.out.println("\nListe des acteurs contenant Cr : ");
        lSerie = sControl.appelTrouverSeriesRechercheAct("Cr");
        lSerie.forEach(System.out::println);
    }
}
