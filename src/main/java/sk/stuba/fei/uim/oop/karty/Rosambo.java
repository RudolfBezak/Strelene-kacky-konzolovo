package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

public class Rosambo extends Karta{

    String meno;

    public Rosambo() {
        this.meno = "Rosambo";
    }

    @Override
    public String getMeno() {
        return meno;
    }

    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac){
        //shuffle jazero
        int[] jazeroTmp = jazero.getJazero();
        BalikFunkcie balikFunkcie = new BalikFunkcie();
        jazeroTmp = balikFunkcie.balikMiesaj(jazeroTmp);
        jazero.setJazero(jazeroTmp);

        return true;
    }
}
