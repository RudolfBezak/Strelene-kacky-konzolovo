package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

public class KacaciTanec extends Karta{

    String meno;

    public KacaciTanec() {
        this.meno = "KacaciTanec";
    }

    @Override
    public String getMeno() {
        return meno;
    }

    @Override
    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac){
        //inicializuj balikfunkcie triedu
        BalikFunkcie balikFunkcie = new BalikFunkcie();

        //hod kacky do kopy
        int[] jazeroTmp = jazero.getJazero();
        int[] balikKaciekTmp = balikKaciek.getBalikKaciek();
        balikKaciekTmp = balikFunkcie.dajNaSpodokNKariet(balikKaciekTmp,jazeroTmp.length,jazeroTmp);

        //zamiesaj kopu
        balikKaciekTmp = balikFunkcie.balikMiesaj(balikKaciekTmp);

        //okopiruj 6 kariet na jazero
        System.arraycopy(balikKaciekTmp, 0, jazeroTmp, 0, jazeroTmp.length);
        //vymaz 6 kariet z baliku
        balikKaciekTmp = balikFunkcie.balikVymazVrchnychN(balikKaciekTmp,6);

        //uloz balik kaciek a jazero
        jazero.setJazero(jazeroTmp);
        balikKaciek.setBalikKaciek(balikKaciekTmp);

        return true;
    }
}
