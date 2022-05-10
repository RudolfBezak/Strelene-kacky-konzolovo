package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.hra.Obraz;
import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

import javax.swing.*;
import java.awt.*;

public class Rosambo extends Karta{

    private final String meno;
    private final ImageIcon obrazok;

    public Rosambo() {
        this.meno = "Rosambo";
        obrazok = new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/rosambo.png");
        Image obrazokImage = obrazok.getImage();
        obrazokImage = obrazokImage.getScaledInstance(10*16,10*24,Image.SCALE_DEFAULT);
        this.obrazok.setImage(obrazokImage);
    }

    @Override
    public String getMeno() {
        return meno;
    }

    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac, Obraz obraz){
        //shuffle jazero
        int[] jazeroTmp = jazero.getJazero();
        BalikFunkcie balikFunkcie = new BalikFunkcie();
        jazeroTmp = balikFunkcie.balikMiesaj(jazeroTmp);
        jazero.setJazero(jazeroTmp);

        return true;
    }
    public ImageIcon getObrazok() {
        return obrazok;
    }
}
