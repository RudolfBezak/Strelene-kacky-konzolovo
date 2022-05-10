package sk.stuba.fei.uim.oop.karty;

import sk.stuba.fei.uim.oop.hra.Hrac;
import sk.stuba.fei.uim.oop.hra.Jazero;
import sk.stuba.fei.uim.oop.hra.Kacky;
import sk.stuba.fei.uim.oop.utility.BalikFunkcie;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Vystrel extends Karta{

    String meno;

    public Vystrel() {
        this.meno = "Vystrel";
    }

    @Override
    public String getMeno() {
        return meno;
    }

    @Override
    public boolean viemZahrat(Jazero jazero, Kacky balikKaciek){
        //zisti ci existuje zameriavac
        boolean jeMiestoNamierene = false;
        int[] zameriavaciTmp = jazero.getZameriavaci();
        for (int j : zameriavaciTmp) {
            if (j == 1) {
                jeMiestoNamierene = true;
                break;
            }
        }
        return jeMiestoNamierene;
    }

    //zastrel kacku
    @Override
    public boolean zahrajKartu(Jazero jazero, Kacky balikKaciek, Hrac[] hrac){
        if (!(viemZahrat(jazero, balikKaciek))){
            System.out.println("tato karta sa neda zahrat :(");
            return false;
        }

        //opytaj sa na miesto
        int miestoStrelby;
        boolean strielamZameriavac = false;
        //prekopiruj si zameriavacov
        int[] zameriavaciTmp = jazero.getZameriavaci();
        while (!strielamZameriavac){
            miestoStrelby = ZKlavesnice.readInt("ktory zameriavac streli? (0-5)");
            if (miestoStrelby < 6 && miestoStrelby > -1){
                //pozri ci tam je zameriavac
                if (zameriavaciTmp[miestoStrelby] == 1){
                    zastrelKacku(jazero, balikKaciek, miestoStrelby,hrac);
                    strielamZameriavac = true;
                }
                else{
                    //neni tam zameriavac
                    System.out.println("neni tam zameriavac");
                }
            }
            else{
                //musi byt od 0 do 5
                System.out.println("cislo musi byt od 0 do 5");
            }
        }



        return true;
    }

    public void zastrelKacku(Jazero jazero, Kacky balikKaciek, int miesto, Hrac[] hraci){


        int[] jazeroTmp = jazero.getJazero();
        //ak zabije kacku
        if (jazeroTmp[miesto] != 0) {

            //odober hracovi zivot
            hraci[jazeroTmp[miesto]-1].odoberZivot();


            //okopiruj si vrchnu kacku z balika
            BalikFunkcie balikFunkcie = new BalikFunkcie();
            int vrchnaKacka = balikKaciek.getBalikKaciek()[0];
            //vymaz ju z balika
            balikKaciek.setBalikKaciek(balikFunkcie.balikVymazVrchnychN(balikKaciek.getBalikKaciek(), 1));

            //posun kacky v jazere
            for (int i = 0; i < (jazeroTmp.length) - 1 - miesto; i++) {
                jazeroTmp[i + miesto] = jazeroTmp[i + miesto + 1];
            }
            //hod kartu z balika na jazero
            jazeroTmp[jazeroTmp.length - 1] = vrchnaKacka;
        }

        //prekopiruj si zameriavacov
        int[] zameriavaciTmp = jazero.getZameriavaci();

        //vymaz zameriavac
        zameriavaciTmp[miesto] = 0;
        //uloz zameriavacou
        jazero.setZameriavaci(zameriavaciTmp);

        //uloz jazero
        jazero.setJazero(jazeroTmp);




    }
}
