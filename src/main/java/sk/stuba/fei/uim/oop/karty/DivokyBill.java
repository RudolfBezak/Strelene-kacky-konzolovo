package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.hra.Obraz;


import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class DivokyBill extends Karta {

    private final ImageIcon obrazok;
    private final String meno;


    public DivokyBill() {
        this.meno = "DivokyBill";
        obrazok = new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/divokyBill.png");
        Image obrazokImage = obrazok.getImage();
        obrazokImage = obrazokImage.getScaledInstance(10*16,10*24,Image.SCALE_DEFAULT);
        this.obrazok.setImage(obrazokImage);
    }

    @Override
    public String getMeno() {
        return meno;
    }

    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac, Obraz obraz){
        boolean zahrana = false;
        int miestoStrelby;
        //vypitaj si cislo od 0 do 5
        obraz.setVypis("kam streli divoky Bill?");
        while(!zahrana){
            miestoStrelby = obraz.getPosledneTlacitko();

            if (miestoStrelby < 7 && miestoStrelby > 0){
                //zaspis ze sme ju zahrali
                miestoStrelby--;
                zahrana = true;

                //daj tam zameriavaca
                int[] zameriavaciTmp = jazero.getZameriavaci();
                zameriavaciTmp[miestoStrelby] = 1;

                //zahraj vystrel
                Vystrel vystrel = new Vystrel();
                vystrel.zastrelKacku(jazero, balikKaciek, miestoStrelby, hrac);

            }
            else {
                obraz.setVypis("musi strelit na jazero");
                //System.out.println("musi to byt cislo od 0 do 5");
            }
        }
        obraz.setVypis("");

        return true;
    }

    public ImageIcon getObrazok() {
        return obrazok;
    }
}
