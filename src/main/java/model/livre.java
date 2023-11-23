package model;

import java.util.ArrayList;
import java.util.Scanner;

public class livre {
    private String titre;
    private String auteur;
    private String isbn;

    public livre(String titre, String auteur, String isbn){
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
    }
    public livre() {
    }

    public String getTitre(){
        return titre;
    }
    public String getAuteur(){
        return auteur;
    }
    public String getIsbn(){
        return isbn;
    }
    public String setTitre(String titre){
        return this.titre = titre;
    }
    public String setAuteur(String auteur){
        return this.auteur = auteur;
    }
    public String setIsbn(String isbn){
        return this.isbn = isbn;
    }

    public String toString(){
        return titre +" - " + auteur + " (ISBN : " + isbn + ")";
    }
    public static void afficherLivres(ArrayList<livre> lesLivres){

        int indice = 1;
        for (livre unLivre : lesLivres){
            System.out.println(indice + " " + unLivre.toString());
            indice++;
        }
    }
    public static void afficherMenu()
    {
        System.out.println("\n**** menu ****\n");
        System.out.println("1 - Afficher la liste des livres");
        System.out.println("2 - Ajouter un livre");
        System.out.println("3 - Modifier un livre");
        System.out.println("4 - Supprimer un livre");
        System.out.println("5 - Afficher la liste des auteurs");
        System.out.println("6 - Rechercher un livre");
        System.out.println("Q - Quitter \n");
    }

    public static void ajouterLivre(ArrayList<livre> lesLivres){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le titre du livre : ");
        String titre = sc.nextLine();
        System.out.println("Veuillez saisir l'auteur du livre : ");
        String auteur = sc.nextLine();
        System.out.println("Veuillez saisir l'ISBN du livre : ");
        String isbn = sc.nextLine();
        livre livre = new livre(titre, auteur, isbn);
        lesLivres.add(livre);
    }

    public static void supprimerLivre(ArrayList<livre> lesLivres) {
        Scanner sc = new Scanner(System.in);
        afficherLivres(lesLivres);
        System.out.println("Veuillez saisir l'indice du livre à supprimer : ");
        int indice = Integer.parseInt(sc.nextLine());

        lesLivres.remove(indice - 1);

        if(indice-1 > lesLivres.size()){
            System.out.println("L'indice saisi n'est pas valide");
        }
    }

    public static void modifierLivre(ArrayList<livre> lesLivres){
        Scanner sc = new Scanner(System.in);
        afficherLivres(lesLivres);
        System.out.println("Veuillez saisir l'indice du livre à modifier : ");
        int indice = Integer.parseInt(sc.nextLine());

        if (indice >= 1 && indice <= lesLivres.size()) {
            livre livreAModifier = lesLivres.get(indice - 1);

            System.out.println("Quel champ voulez-vous modifier ? ");
            System.out.println("1 - Titre");
            System.out.println("2 - Auteur");
            System.out.println("3 - ISBN");
            int choix = Integer.parseInt(sc.nextLine());

            switch (choix) {
                case 1:
                    System.out.println("Veuillez saisir le nouveau titre : ");
                    String nouveauTitre = sc.nextLine();
                    livreAModifier.setTitre(nouveauTitre);
                    System.out.println("Le titre a été modifié avec succès.");
                    break;
                case 2:
                    System.out.println("Veuillez saisir le nouveau nom de l'auteur : ");
                    String nouvelAuteur = sc.nextLine();
                    livreAModifier.setAuteur(nouvelAuteur);
                    System.out.println("L'auteur a été modifié avec succès.");
                    break;
                case 3:
                    System.out.println("Veuillez saisir le nouvel ISBN : ");
                    String nouvelIsbn = sc.nextLine();
                    livreAModifier.setIsbn(nouvelIsbn);
                    System.out.println("L'ISBN a été modifié avec succès.");
                    break;
                default:
                    System.out.println("Choix non valide.");
                    break;
            }
        } else {
            System.out.println("L'indice saisi n'est pas valide.");
        }
    }

    public static void afficherAuteurs(ArrayList<livre> lesLivres){
        System.out.println("Afficher la liste des auteurs");
        for( livre unLivre : lesLivres){
            System.out.println(unLivre.getAuteur());
        }
    }
    public static void rechercherLivre(ArrayList<livre> lesLivres){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir le titre du livre : ");
        String titre = sc.nextLine();
            for (livre unLivre : lesLivres){
                if (unLivre.getTitre().equals(titre)){
                    System.out.println(unLivre.toString());
                    break;
                }
            }
        }
    public static void rechercheLivreParMc(ArrayList<livre> lesLivres) {
        System.out.println("Rechercher un livre par mots-clés");
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez les mots-clés : ");
        String motsCles = sc.nextLine();
        boolean aucunResultat = true;
        for (livre livre : lesLivres) {
            if (livre.getTitre().toLowerCase().contains(motsCles.toLowerCase()) ||
                    livre.getAuteur().toLowerCase().contains(motsCles.toLowerCase())) {
                System.out.println(livre.toString());
                aucunResultat = false;
            }
        }
        if (aucunResultat) {
            System.out.println("Aucun livre trouvé pour les mots-clés donnés.");
        }
    }


}
