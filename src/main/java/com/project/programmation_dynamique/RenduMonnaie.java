package com.project.programmation_dynamique;

import java.util.ArrayList;
import java.util.List;

public class RenduMonnaie {

    public float retraitOM(int montant){
        List<Objet2> objets = new ArrayList<Objet2>();
        for (int i = 50; i <= 500000; i = i + 25) {
            Objet2 objet = new Objet2(i, 0);
            if (i < 6501) {
                objet.setValeur((float) (i * 3) / 100);
            }
            if ((i >= 6501) && (i < 10001)) {
                objet.setValeur(180);
            }
            if ((i >= 10001) && (i < 13501)) {
                objet.setValeur(300);
            }
            if ((i >= 13501) && (i < 25001)) {
                objet.setValeur(350);
            }
            if ((i >= 25001) && (i < 50001)) {
                objet.setValeur(700);
            }
            if ((i >= 50001) && (i < 80001)) {
                objet.setValeur(1350);
            }
            if ((i >= 80001) && (i < 100001)) {
                objet.setValeur(1800);
            }
            if ((i >= 100001) && (i < 200001)) {
                objet.setValeur(2150);
            }
            if ((i >= 200001) && (i < 300001)) {
                objet.setValeur(2600);
            }
            if ((i >= 300001) && (i < 400001)) {
                objet.setValeur(3100);
            }
            if ((i >= 400001) && (i <= 500000)) {
                objet.setValeur(3600);
            }
            objets.add(objet);
        }

//        for (Objet2 objet : objets){
//            System.out.println("montant: "+ objet.getPoids() +" valeur: "+objet.getValeur());
//        }

        float[] cache = new float[montant+1];
        int[] prise = new int[montant+1];

        float min = 0;
        for (int x = 25; x <= montant; x = x + 25) {
            min = x;
            int piece = 0;
            for (int i = 0; i < objets.size(); i++) {
                if ((objets.get(i).getPoids() <= x) && ((objets.get(i).getValeur() + cache[(int) (x - objets.get(i).getPoids())]) <= min)) {
                    min = objets.get(i).getValeur() + cache[(int) (x - objets.get(i).getPoids())];
                    piece = i;

                }

                cache[x] = min;
                prise[x] = piece;
            }
        }


        float retirer = montant;
        System.out.println("pour "+ montant + " vous devez retirer :");
        while (retirer>0){
            System.out.print(objets.get(prise[(int) retirer]).getPoids()+"xaf\t");
            retirer=  retirer-objets.get(prise[(int) retirer]).getPoids();
        }
        System.out.println();
        System.out.println("les frais minimums pour la somme : "+montant+" est : "+cache[montant]);
        return cache[montant];

    }


//    public int retraitMomo(int montant){
//        List<Objet> objets = new ArrayList<Objet>();
//        for (int i = 100; i <= 500000; i = i + 100) {
//            Objet objet = new Objet(i, 0);
//            if (i < 6000) {
//                objet.setValeur((i * 3) / 100);
//            }
//            if ((i >= 6000) && (i < 10051)) {
//                objet.setValeur(175);
//            }
//            if ((i >= 10051) && (i < 13551)) {
//                objet.setValeur(300);
//            }
//            if ((i >= 13551) && (i < 25051)) {
//                objet.setValeur(350);
//            }
//            if ((i >= 25051) && (i < 50051)) {
//                objet.setValeur(700);
//            }
//            if ((i >= 50051) && (i < 75101)) {
//                objet.setValeur(1350);
//            }
//            if ((i >= 75101) && (i < 100101)) {
//                objet.setValeur(1800);
//            }
//            if ((i >= 100101) && (i < 200501)) {
//                objet.setValeur(2150);
//            }
//            if ((i >= 200501) && (i < 300501)) {
//                objet.setValeur(2600);
//            }
//            if ((i >= 300501) && (i < 400501)) {
//                objet.setValeur(3100);
//            }
//            if ((i >= 400501) && (i <= 500000)) {
//                objet.setValeur(3500);
//            }
//            objets.add(objet);
//        }
//
//        int[] cache = new int[montant+1];
//        int[] prise = new int[montant+1];
//
//        int min = 0;
//        for (int x = 100; x <= montant; x = x + 25) {
//            min = x;
//            int piece = 0;
//            for (int i = 0; i < objets.size(); i++) {
//                if ((objets.get(i).getPoids() <= x) && ((objets.get(i).getValeur() + cache[x - objets.get(i).getPoids()]) <= min)) {
//                    min = objets.get(i).getValeur() + cache[x - objets.get(i).getPoids()];
//                    piece = i;
//
//                }
//
//                cache[x] = min;
//                prise[x] = piece;
//            }
//        }
//
//
//        int retirer = montant;
//        System.out.println("pour "+ montant + " vous devez retirer :");
//        while (retirer>0){
//            System.out.print(objets.get(prise[retirer]).getPoids()+"xaf\t");
//            retirer=retirer-objets.get(prise[retirer]).getPoids();
//        }
//        System.out.println();
//        System.out.println("les frais minimums pour la somme : "+montant+" est : "+cache[montant]);
//        return cache[montant];
//
//    }

}
