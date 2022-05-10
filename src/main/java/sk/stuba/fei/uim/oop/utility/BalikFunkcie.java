package sk.stuba.fei.uim.oop.utility;

import sk.stuba.fei.uim.oop.karty.Karta;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;


public class BalikFunkcie {

    //shuffluje to balik - zobral som to zo stackoverflow
    public int[] balikMiesaj (int[] balik){
        Random rnd = ThreadLocalRandom.current();
        for (int i = balik.length - 1; i > 0; i--) {

            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = balik[index];
            balik[index] = balik[i];
            balik[i] = a;
        }
        return balik;
    }

    //shuffle balik classy karta
    public Karta[] balikMiesaj (Karta[] balik) {
        //pomocne pole
        int[] indexy = new int[balik.length];
        for (int i = 0; i < balik.length; i++) {
            indexy[i] = i;
        }
        //to pole zamiesaj
        indexy = balikMiesaj(indexy);

        //podla toho pola vytvor zamiesane pole
        Karta[] balikTmp = new Karta[balik.length];
        for (int i = 0; i < balik.length; i++) {
            balikTmp[i] = balik[indexy[i]];
        }
        return balikTmp;
    }




    public int[] balikVymazVrchnychN(int[] balik, int n){
        int velkost = balik.length;
        int[] balik2 = new int[velkost-n];
        if (velkost - n >= 0) System.arraycopy(balik, n, balik2, 0, velkost - n);
        return balik2;
    }

    public Karta[] balikVymazVrchnychN(Karta[] balik, int n){
        int velkost = balik.length;
        Karta[] balik2 = new Karta[velkost-n];
        if (velkost - n >= 0) System.arraycopy(balik, n, balik2, 0, velkost - n);
        return balik2;
    }

    public int[] dajNaSpodokNKariet(int[] balik, int n, int[] x){
        int velkost = balik.length;
        int[] balik2 = new int[velkost+n];
        System.arraycopy(balik, 0, balik2, 0, velkost);
        int velkost2 = x.length;
        System.arraycopy(x, 0, balik2, velkost, velkost2);
        return balik2;
    }

    public Karta[] dajNaSpodokNKariet(Karta[] balik, int n, Karta[] x){
        int velkost = balik.length;
        Karta[] balik2 = new Karta[velkost+n];
        System.arraycopy(balik, 0, balik2, 0, velkost);
        int velkost2 = x.length;
        System.arraycopy(x, 0, balik2, velkost, velkost2);
        return balik2;
    }

    public int[] dajVrchnuNaKoniec(int[] balik){
        int velkost = balik.length;
        int[] balik2 = new int[velkost];
        if (velkost - 1 >= 0) System.arraycopy(balik, 1, balik2, 0, velkost - 1);
        balik2[velkost - 1] = balik[1];
        return  balik2;
    }
}
