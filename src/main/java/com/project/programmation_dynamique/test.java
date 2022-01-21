package com.project.programmation_dynamique;

public class test {
    public static void main(String[] args) {
        /** sequence comprise dans un autre tableau*/
        int[] tab = {1,2,3};
        int[] tab2 = {0,1,2,3,5,6};

        int diff=0;
        for(int i=0;i<tab2.length;i++){
            if(tab2[i]==tab[0]){
                if(i+tab.length<tab2.length){
                    int compt = 1;
                    for(int j=1;j<tab.length;j++){
                        if(tab2[i+j]==tab[j]){
                            compt++;
                        }
                    }
                    if(compt==tab.length){
                        System.out.print("Oui");
                    }
                }
            }
        }
    }
    /**/
}
