package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.hra.Obraz;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TurboKacka extends Karta{

    private final String meno;
    private final ImageIcon obrazok;

    public TurboKacka() {
        this.meno="Turbokacka";
        obrazok = new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/turboKacka.png");
        Image obrazokImage = obrazok.getImage();
        obrazokImage = obrazokImage.getScaledInstance(10*16,10*24,Image.SCALE_DEFAULT);
        this.obrazok.setImage(obrazokImage);
    }

    @Override
    public String getMeno() {
        return meno;
    }

    @Override
    public boolean viemZahrat(Jazero jazero, Kacky balikKaciek) {
        //ak je vsetko voda tak to neviem zahrat

        int[] jazeroTmp = jazero.getJazero();
        for (int j : jazeroTmp) {
            if (j != 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac, Obraz obraz){
        //zisti ci viem zahrat
        if (!this.viemZahrat(jazero, balikKaciek)){
            System.out.println("tuto kartu neviem zahrat :(");
            return false;
        }
        //viem zahrat
        //zisti na ktoru kartu
        boolean ukazujemNaKacku = false;
        int indexKamUkazujem = 0;
        int[] jazeroTmp = jazero.getJazero();

        //opytaj sa na cislo
        obraz.setVypis("ktora kacka je turbo?");
        while (!ukazujemNaKacku){
            indexKamUkazujem = obraz.getPosledneTlacitko();

            //zisti ci je dobre cislo
            if (indexKamUkazujem > 0 && indexKamUkazujem < 7){
                indexKamUkazujem--;
                if (jazeroTmp[indexKamUkazujem] != 0){
                    ukazujemNaKacku = true;
                }
                else{
                    obraz.setVypis("vodu neposunes");
                    //System.out.println("vodu neposunies");
                }
            }
            else{
                //System.out.println("musi to but cislo od 0 do 5");
                obraz.setVypis("musis kliknut na jazero");
            }
        }
        obraz.setVypis("");
        //mas dobre cislo
        //posun kacky
        int tmp;
        for (int i = indexKamUkazujem; i > 0; i--){
            //vymen kacky
            tmp = jazeroTmp[i];
            jazeroTmp[i] = jazeroTmp[i-1];
            jazeroTmp[i-1] = tmp;
        }
        return true;
    }
    public ImageIcon getObrazok() {
        return obrazok;
    }
}
