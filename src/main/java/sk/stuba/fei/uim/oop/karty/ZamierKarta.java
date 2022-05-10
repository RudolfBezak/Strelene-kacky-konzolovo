package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.hra.Obraz;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ZamierKarta extends Karta {

    private final String meno;
    private final ImageIcon obrazok;

    public ZamierKarta() {
        this.meno = "Zamier";
        this.obrazok = new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/zamier.png");
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
        boolean jeMiestoNenamierene = false;

        //pozri ci exsituje miesto na ktore nebolo namierené
        int[] zameriavaciTmp = jazero.getZameriavaci();
        for (int j : zameriavaciTmp) {
            if (j == 0) {
                jeMiestoNenamierene = true;
                break;
            }
        }

        return jeMiestoNenamierene;
    }

    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac, Obraz obraz) {
        //pozri ci exsituje miesto na ktore nebolo namierené
        if (!viemZahrat(jazero, balikKaciek)) {
            //System.out.println("tato karta sa nedá zahrat :(");
            return false;
        }
        //ak viem zahrat tak karta vykona:
        this.zamier(jazero,obraz);

        return true;
    }
    private void zamier(Jazero jazero,Obraz obraz){
        boolean zamierilSom = false;
        //opytaj sa pouzivatela kde chce zamierit
        obraz.setVypis("kam namieris?");
        while (!zamierilSom) {
            int miestoKamChcemZamierit = obraz.getPosledneTlacitko();

            //pozri ci je cislo od 0-5
            if (miestoKamChcemZamierit < 7 && miestoKamChcemZamierit > 0) {
                miestoKamChcemZamierit--;

                //zisti ci to miesto je volne
                int[] zameriavaciTmp = jazero.getZameriavaci();
                if (zameriavaciTmp[miestoKamChcemZamierit] == 0) {
                    //ak je volne tak hod zameriavaca
                    zameriavaciTmp[miestoKamChcemZamierit] = 1;
                    jazero.setZameriavaci(zameriavaciTmp);
                    zamierilSom = true;
                } else {
                    //vypis ze tam sa zamierit neda
                    //System.out.println("tam uz je zamierene");
                    obraz.setVypis("tam uz je zamierene");

                }
            }
            else {
                //System.out.println("musi to byt cislo od 0 do 5");
                obraz.setVypis("musis kliknut na jazero");
            }
        }
        obraz.setVypis("");
    }
    public ImageIcon getObrazok() {
        return obrazok;
    }
}


