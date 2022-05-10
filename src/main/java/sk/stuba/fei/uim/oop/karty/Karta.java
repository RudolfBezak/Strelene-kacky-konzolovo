package sk.stuba.fei.uim.oop.karty;


import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;

public class Karta {

    String meno;

    public Karta() {
    }

    public String getMeno() {
        return meno;
    }

    public boolean viemZahrat(Jazero jazero, Kacky balikKaciek){
        return true;
    }

    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac){
        return false;

    }
}

