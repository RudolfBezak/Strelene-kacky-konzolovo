package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class ZamierKarta extends Karta {

    String meno;

    public ZamierKarta() {
        this.meno = "Zamier";
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

    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac) {
        //pozri ci exsituje miesto na ktore nebolo namierené
        if (!viemZahrat(jazero, balikKaciek)) {
            System.out.println("tato karta sa nedá zahrat :(");
            return false;
        }
        //ak viem zahrat tak karta vykona:
        this.zamier(jazero);

        return true;
    }
    private void zamier(Jazero jazero){
        boolean zamierilSom = false;
        //opytaj sa pouzivatela kde chce zamierit
        while (!zamierilSom) {
            int miestoKamChcemZamierit = ZKlavesnice.readInt("kam chces namierit (0-5)");
            //pozri ci je cislo od 0-5
            if (miestoKamChcemZamierit < 6 && miestoKamChcemZamierit >-1) {

                //zisti ci to miesto je volne
                int[] zameriavaciTmp = jazero.getZameriavaci();
                if (zameriavaciTmp[miestoKamChcemZamierit] == 0) {
                    //ak je volne tak hod zameriavaca
                    zameriavaciTmp[miestoKamChcemZamierit] = 1;
                    jazero.setZameriavaci(zameriavaciTmp);
                    zamierilSom = true;
                } else {
                    //vypis ze tam sa zamierit neda
                    System.out.println("tam uz je zamierene");

                }
            }
            else {
                System.out.println("musi to byt cislo od 0 do 5");
            }
        }
    }
}


