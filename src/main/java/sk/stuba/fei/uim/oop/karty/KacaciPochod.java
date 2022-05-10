package sk.stuba.fei.uim.oop.karty;
import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.utility.BalikFunkcie;


public class KacaciPochod extends Karta{
//tato karta sa vzdy da zahrat

    BalikFunkcie balikFunkcie;

    String meno;


    public KacaciPochod() {
        balikFunkcie = new BalikFunkcie();
        meno = "KacaciPochod";
    }

    @Override
    public String getMeno() {
        return meno;
    }

    //zahraj kacaci pochod
    @Override
    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac){
        //potiahni si vrchnu kartu
        int[] balikKaciekTmp = balikKaciek.getBalikKaciek();
        int vrchnaKackaZBaliku = balikKaciekTmp[0];

        //vymaz ju z balika
        balikKaciekTmp = balikFunkcie.balikVymazVrchnychN(balikKaciekTmp,1);

        //zapametaj si prednu kacku na jazere
        int[] jazeroTmp = jazero.getJazero();
        int jazeroVrch = jazeroTmp[0];

        //posun jazero
        jazeroTmp = balikFunkcie.dajVrchnuNaKoniec(jazeroTmp);

        //hod potiahnutu kacku na konec jazera
        jazeroTmp[(jazeroTmp.length)-1] = vrchnaKackaZBaliku;

        //hod kacku z jazera naspet do baliku
        int[] jazeroVrchPole = new int[1];
        jazeroVrchPole[0] = jazeroVrch;
        balikKaciekTmp = balikFunkcie.dajNaSpodokNKariet(balikKaciekTmp, 1 ,jazeroVrchPole);

        //zapis tieto baliky do objektov
        jazero.setJazero(jazeroTmp);
        balikKaciek.setBalikKaciek(balikKaciekTmp);
        return true;
    }
}
