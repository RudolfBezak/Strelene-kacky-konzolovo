package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.hra.Obraz;
import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

import javax.swing.*;
import java.awt.*;

public class KacaciTanec extends Karta{

    private final String meno;
    private final ImageIcon obrazok;

    public KacaciTanec() {
        this.meno = "KacaciTanec";
        obrazok = new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacaciTanec.png");
        Image obrazokImage = obrazok.getImage();
        obrazokImage = obrazokImage.getScaledInstance(10*16,10*24,Image.SCALE_DEFAULT);
        this.obrazok.setImage(obrazokImage);
    }

    @Override
    public String getMeno() {
        return meno;
    }

    @Override
    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac, Obraz obraz){
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
    public ImageIcon getObrazok() {
        return obrazok;
    }
}
