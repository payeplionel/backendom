package com.project.programmation_dynamique;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
public class RestController {

    @RequestMapping(value = "/retrait/{option}", method = RequestMethod.GET)
    public String retrait(@PathVariable(name = "option") String option,
                          @RequestParam(value = "montant") int montant) {
        if (option.equals("om")) {
            float fraitInitial=0;
            List<Objet> objets = new ArrayList<Objet>();
            for (int i = 50; i <= 500000; i = i + 25) {
                Objet objet = new Objet(i, 0);
                if (i < 6501) {
                    objet.setValeur((float)(i * 3) / 100);
                }
                if ((i >= 6501) && (i < 10001)) {
                    double v = (180) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 10001) && (i < 13501)) {
                    double v = (300) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 13501) && (i < 25001)) {
                    double v = (350) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 25001) && (i < 50001)) {
                    double v = (700) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 50001) && (i < 80001)) {
                    double v = (1350) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 80001) && (i < 100001)) {
                    double v = (1800) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 100001) && (i < 200001)) {
                    double v = (2150) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 200001) && (i < 300001)) {
                    double v = (2600) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 300001) && (i < 400001)) {
                    double v = (3100) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if (i >= 400001) {
                    double v = (3600) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                objets.add(objet);
            }

            float[] cache = new float[montant + 1];
            int[] prise = new int[montant + 1];

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
            System.out.println("pour " + montant + " vous devez retirer :");


            System.out.println("les frais minimums pour la somme : " + montant + " est : " + cache[montant]);
            String a  = "";
            if(fraitInitial==0){
                a = "{\"initial\":\""+cache[montant]+"\",\"montant\":\""+montant+"\",\"frais\":\""+cache[montant]+"\",";
            }else{
                a = "{\"initial\":\""+fraitInitial+"\",\"montant\":\""+montant+"\",\"frais\":\""+cache[montant]+"\",";
            }
            a=a+"\"sommes\": [";

            while (retirer > 0) {
                System.out.print(objets.get(prise[(int) retirer]).getPoids() + "xaf\t");
                a=a+"{\"retrait\":\""+objets.get(prise[(int) retirer]).getPoids()+"\"}";
                retirer = retirer - objets.get(prise[(int) retirer]).getPoids();
                if(retirer!=0){
                    a=a+",";
                }
            }
            a=a+"]}";
            System.out.println(a);

            return a;

        }
        else{
            float fraitInitial=0;
            List<Objet> objets = new ArrayList<Objet>();
            for (int i = 100; i <= 500000; i = i + 25) {
                Objet objet = new Objet(i, 0);
                if (i < 6000) {
                    objet.setValeur((float) (i * 3) / 100);
                }
                if ((i >= 6000) && (i < 10051)) {
                    double v = (175) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 10051) && (i < 13551)) {
                    double v = (300) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 13551) && (i < 25051)) {
                    double v = (350) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 25051) && (i < 50051)) {
                    double v = (700) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 50051) && (i < 75101)) {
                    double v = (1350) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 75101) && (i < 100101)) {
                    double v = (1800) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 100101) && (i < 200501)) {
                    double v = (2150) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 200501) && (i < 300501)) {
                    double v = (2600) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if ((i >= 300501) && (i < 400501)) {
                    double v = (3100) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                if (i >= 400501) {
                    double v = (3500) + ((i * 0.2) / 100);
                    objet.setValeur((float) v);
                    if(i>=montant && fraitInitial==0){
                        fraitInitial=(float) v;
                    }
                }
                objets.add(objet);
            }

            float[] cache = new float[montant + 1];
            int[] prise = new int[montant + 1];

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
            System.out.println("pour " + montant + " vous devez retirer :");

            String a = "";
            if(fraitInitial==0){
                a = "{\"initial\":\""+cache[montant]+"\",\"montant\":\""+montant+"\",\"frais\":\""+cache[montant]+"\",";
            }else{
                a = "{\"initial\":\""+fraitInitial+"\",\"montant\":\""+montant+"\",\"frais\":\""+cache[montant]+"\",";
            }

            System.out.println("les frais minimums pour la somme : " + montant + " est : " + cache[montant]);

            a=a+"\"sommes\": [";

            while (retirer > 0) {
                System.out.print(objets.get(prise[(int) retirer]).getPoids() + "xaf\t");
                a=a+"{\"retrait\":\""+objets.get(prise[(int) retirer]).getPoids()+"\"}";
                retirer = retirer - objets.get(prise[(int) retirer]).getPoids();
                if(retirer!=0){
                    a=a+",";
                }
            }
            a=a+"]}";

            return a;

        }
    }
}

