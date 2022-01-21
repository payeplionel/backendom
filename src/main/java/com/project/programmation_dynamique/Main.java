package com.project.programmation_dynamique;

import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class Main {
    public int[] tri(int[] tab){
        for(int i=0;i<=tab.length-2;i++){
            for(int j=tab.length-1;j>=i+1;j--){
                if(tab[j]>tab[j-1]){
                    int temp = tab[j];
                    tab[j]=tab[j-1];
                    tab[j-1]=temp;
                }
            }
        }
        return tab;
    }

    public int PGNPD(int n){
        int pre = 1;
        for(int i = 1; i<=n;i++){
            int a = 0;
            for(int j=1;j<=i;j++){
                if(i%j==0){
                    a++;
                }
            }
            if(a==2){
                System.out.println(i);
                if(n%i==0){
                    pre = i;
                    //System.out.println(i);
                }
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        //RenduMonnaie renduMonnaie = new RenduMonnaie();

        //System.out.println(renduMonnaie.retraitOM(157125));
        //System.out.println(renduMonnaie.retraitMomo(30000));

        Main main = new Main();
        char[] c1 = {'a','b','c','d'};
        char[] c2 = {'d','b','c','a'};
        System.out.println(main.PGNPD(11));

    }
}

