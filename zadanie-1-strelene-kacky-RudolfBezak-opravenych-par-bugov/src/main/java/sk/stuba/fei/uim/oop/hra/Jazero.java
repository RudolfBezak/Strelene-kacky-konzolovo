package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

public class Jazero {
    int[] jazero;
    int velkostJazera;
    int[] zameriavaci;
    BalikFunkcie balikFunkcie;


    //vygeneruj jazero a odober tie karty z balika kaciek
    public Jazero(Kacky kacky) {
        balikFunkcie = new BalikFunkcie();
        velkostJazera = 6;
        jazero = new int[velkostJazera];
        zameriavaci = new int[velkostJazera];
        //nastav zameriavacov na 0
        for (int i = 0; i < velkostJazera; i++){
            zameriavaci[i] = 0;
        }

        //prekopiruj vrchnych 6 kariet z baliku kaciek na jazero
        System.arraycopy(kacky.balikKaciek, 0, jazero, 0, velkostJazera);
        //vymaz vrchnych 6 kariet z balika
        kacky.balikKaciek = balikFunkcie.balikVymazVrchnychN(kacky.balikKaciek, velkostJazera);
        }


    //odober zivot hracovi


    public int[] getJazero() {
        return jazero;
    }

    public void setJazero(int[] jazero) {
        this.jazero = jazero;
    }

    public int[] getZameriavaci() {
        return zameriavaci;
    }
    public void setZameriavaci(int[] zameriavaci) {
        this.zameriavaci = zameriavaci;
    }
}


