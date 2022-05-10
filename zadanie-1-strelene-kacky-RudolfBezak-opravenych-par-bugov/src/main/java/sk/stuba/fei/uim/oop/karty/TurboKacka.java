package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class TurboKacka extends Karta{

    String meno;

    public TurboKacka() {
        this.meno="Turbokacka";
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
    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac){
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
        while (!ukazujemNaKacku){
            indexKamUkazujem = ZKlavesnice.readInt("ktora kacka je turbo? (0-5)");
            //zisti ci je dobre cislo
            if (indexKamUkazujem > -1 && indexKamUkazujem < 6){
                if (jazeroTmp[indexKamUkazujem] != 0){
                    ukazujemNaKacku = true;
                }
                else{
                    System.out.println("vodu neposunies");
                }
            }
            else{
                System.out.println("musi to but cislo od 0 do 5");
            }
        }
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
}
