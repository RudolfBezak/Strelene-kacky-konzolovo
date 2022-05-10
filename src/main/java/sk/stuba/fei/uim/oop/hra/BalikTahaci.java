package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.karty.*;
import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

public class BalikTahaci {
    //pocty kariet
    // 0 zamierKarta = 10;
    // 1 vystrelKarta = 12;
    // 2 divokyBillKarta = 2;
    // 3 kacaciPochodKarta = 6;
    // 4 turboKackaKarta = 1;
    // 5 rosamboKarta = 2;
    // 6 kacaciTanecKarta = 1;

    private Karta[] balik;

    //vygeneruj balik
    public BalikTahaci() {
        //zisti kolko kariet je v baliku
        int[] pocetnostiKariet = {10,12,2,6,1,2,1};
        int sucetkariet = 0;
        for (int j : pocetnostiKariet) {
            sucetkariet += j;
        }
        //alokuj balik
        balik = new Karta[sucetkariet];


        //vytvor zamierkarty
        int zaciatok = 0;
        for (int i = 0; i < pocetnostiKariet[0]; i++){
            balik[i] = new ZamierKarta();
        }
        //vytvor vystrelkarty
        zaciatok += pocetnostiKariet[0];
        for (int i = 0; i < pocetnostiKariet[1]; i++){
            balik[zaciatok + i] = new Vystrel();
        }

        //vytvor divokybillkarty
        zaciatok += pocetnostiKariet[1];
        for (int i = 0; i < pocetnostiKariet[2]; i++){
            balik[zaciatok + i] = new DivokyBill();
        }
        //vytvor kacacipochodkarty
        zaciatok += pocetnostiKariet[2];
        for(int i = 0; i < pocetnostiKariet[3]; i++){
            balik[zaciatok + i] = new KacaciPochod();
        }
        //turbo
        zaciatok += pocetnostiKariet[3];
        for(int i = 0; i < pocetnostiKariet[4]; i++){
            balik[zaciatok + i] = new TurboKacka();
        }
        //rosambo
        zaciatok += pocetnostiKariet[4];
        for(int i = 0; i < pocetnostiKariet[5]; i++){
            balik[zaciatok + i] = new Rosambo();
        }
        //tanec
        zaciatok += pocetnostiKariet[5];
        for(int i = 0; i < pocetnostiKariet[6]; i++){
            balik[zaciatok + i] = new KacaciTanec();
        }


        //pomiesaj
        BalikFunkcie balikFunkcie = new BalikFunkcie();
        balik = balikFunkcie.balikMiesaj(balik);


    }

    public Karta[] getBalik() {
        return balik;
    }

    public void setBalik(Karta[] balik) {
        this.balik = balik;
    }
}
