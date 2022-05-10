package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class DivokyBill extends Karta {

    String meno;
    public DivokyBill() {
        meno = "DivokyBill";
    }

    @Override
    public String getMeno() {
        return meno;
    }

    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac){
        boolean zahrana = false;
        int miestoStrelby;
        //vypitaj si cislo od 0 do 5
        while(!zahrana){
            miestoStrelby = ZKlavesnice.readInt("kam streli divoky Bill? (0-5)");
            if (miestoStrelby < 6 && miestoStrelby > -1){
                //zaspis ze sme ju zahrali
                zahrana = true;

                //daj tam zameriavaca
                int[] zameriavaciTmp = jazero.getZameriavaci();
                zameriavaciTmp[miestoStrelby] = 1;

                //zahraj vystrel
                Vystrel vystrel = new Vystrel();
                vystrel.zastrelKacku(jazero, balikKaciek, miestoStrelby, hrac);

            }
            else {
                System.out.println("musi to byt cislo od 0 do 5");
            }
        }

        return true;
    }
}
