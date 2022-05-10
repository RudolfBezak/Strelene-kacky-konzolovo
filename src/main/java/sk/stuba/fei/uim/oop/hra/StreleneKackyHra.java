package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.karty.*;
import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

import java.util.concurrent.TimeUnit;

public class StreleneKackyHra {
    public StreleneKackyHra() {
        Obraz obraz = new Obraz();


        //priebeh hry

        //zisti kolko hracov
        int pocetHracov = 0;
        while (!(pocetHracov > 1 && pocetHracov < 7)) {


            pocetHracov = obraz.getPosledneTlacitko();

        }
        obraz.deleteLabely();


        //vytor balik kaciek
        Kacky balikKaciek = new Kacky(pocetHracov);

        //vytvor jazero
        Jazero jazero = new Jazero(balikKaciek);

        //vytvor pole hracov
        Hrac[] hraci = new Hrac[pocetHracov];

        //vytvor hracov / nastav im id
        for (int i = 0; i < pocetHracov; i++){
            hraci[i] = new Hrac(i+1);

        }
        obraz.legendaFariebZivot(hraci,pocetHracov);

        //vytvor balicek kariet
        BalikTahaci balikTahaci = new BalikTahaci();

        //daj karty hracom
        this.rozdajRuky(hraci,balikTahaci,pocetHracov);

        //zacni kolo
        int vitaz = 0;
        while (vitaz == 0){
            vitaz = kolo(hraci, balikTahaci, jazero, pocetHracov, balikKaciek, obraz);
        }

        obraz.setVypis("vitaz je hrac "+vitaz);
        System.out.println("Vyhral hrac "+vitaz);

    }

    private void rozdajRuky(Hrac[] hraci, BalikTahaci balikTahaci, int pocetHracov){
        Karta[] rukaTmp;
        Karta[] balikTahaciTmp = balikTahaci.getBalik();
        for (int i = 0; i < pocetHracov; i++){
            rukaTmp = hraci[i].getRuka();
            System.arraycopy(balikTahaciTmp, i * 3, rukaTmp, 0, 3);
            hraci[i].setRuka(rukaTmp);
        }
        //vamaz karty z baliku
        BalikFunkcie balikfunkcie = new BalikFunkcie();
        balikTahaciTmp = balikfunkcie.balikVymazVrchnychN(balikTahaciTmp, pocetHracov*3);
        balikTahaci.setBalik(balikTahaciTmp);

    }
    private int kolo(Hrac[] hraci, BalikTahaci balikTahaci, Jazero jazero, int pocetHracov, Kacky balikKaciek,Obraz obraz){
        boolean vieZahrat;
        boolean zahralKartu;
        Karta[] balikTahaciTmp = balikTahaci.getBalik();
        Karta[] hracRuka;

        //zacni kolo
        for (int hracNaTahu = 0; hracNaTahu < pocetHracov; hracNaTahu++){
            //hrac bez zivota nevie hrat
            if (hraci[hracNaTahu].getZivot() > 0){
                //nakresli dosku
                vykresli(hraci,jazero,balikKaciek,pocetHracov,hracNaTahu,obraz);


                zahralKartu = false;
                //zisti ci vie zahrat
                vieZahrat = false;
                hracRuka = hraci[hracNaTahu].getRuka();
                for (int o = 0; o < 3; o++){
                    if (hracRuka[o].viemZahrat(jazero,balikKaciek)){
                        vieZahrat = true;
                        break;
                    }

                }
                boolean jeOdJednaPoDva = false;
                int ktoruKartuZahra = 0;
                if (vieZahrat){
                    //vie zahrat
                    while (!zahralKartu){

                        obraz.setVypis("Ktoru kartu zahras?");
                        while (!jeOdJednaPoDva) {
                            ktoruKartuZahra = obraz.getPosledneTlacitko();


                            //zisti ci je od 0-2
                            if (ktoruKartuZahra > 6 && ktoruKartuZahra < 10){
                                jeOdJednaPoDva = true;
                                ktoruKartuZahra -= 7;
                            }
                        }
                        obraz.setVypis("");
                        if (hracRuka[ktoruKartuZahra].zahrajKartu(jazero,balikKaciek,hraci,obraz)){
                            //podarilo sa zahrat
                            zahralKartu = true;
                        }
                        else{
                            jeOdJednaPoDva = false;
                            obraz.setVypis("vyber inu");
                            while (!jeOdJednaPoDva) {
                                ktoruKartuZahra = obraz.getPosledneTlacitko();

                                if (ktoruKartuZahra > 6 && ktoruKartuZahra < 10){
                                    jeOdJednaPoDva = true;
                                    ktoruKartuZahra -= 7;
                                }
                            }
                            obraz.setVypis("");

                        }
                    }

                }
                else{
                    //nevie zahrat - musi odhodit

                    //zisti kartu
                    obraz.setVypis("zahod kartu");
                    while(!jeOdJednaPoDva){
                        ktoruKartuZahra = obraz.getPosledneTlacitko();
                        //zisti ci je od 0-2
                        if (ktoruKartuZahra > 6 && ktoruKartuZahra < 10){
                            jeOdJednaPoDva = true;
                            ktoruKartuZahra -= 7;
                        }
                    }
                    obraz.setVypis("");


                }
                //nahradime mu ju novou kartou
                BalikFunkcie balikFunkcie = new BalikFunkcie();

                //daj ju na spodok balika
                Karta[] kartaNaSpodok = new Karta[1];
                kartaNaSpodok[0] = hracRuka[ktoruKartuZahra];
                balikTahaciTmp = balikFunkcie.dajNaSpodokNKariet(balikTahaciTmp, 1, kartaNaSpodok);
                //zahod kartu
                hracRuka[ktoruKartuZahra] = balikTahaci.getBalik()[0];
                //uloz ruku
                hraci[hracNaTahu].setRuka(hracRuka);
                //vymaz ju z balika tahacieho
                balikTahaciTmp = balikFunkcie.balikVymazVrchnychN(balikTahaciTmp,1);
                //uloz baliktahaci
                balikTahaci.setBalik(balikTahaciTmp);


            }
            //kontrola ci uz karty vratil
            else if (hraci[hracNaTahu].getMaRuku() == 1){
                hraci[hracNaTahu].setMaRuku(0);
                //daj karty do kopy
                BalikFunkcie balikFunkcie = new BalikFunkcie();
                balikTahaci.setBalik(balikFunkcie.dajNaSpodokNKariet(balikTahaciTmp, hraci[hracNaTahu].getRuka().length, hraci[hracNaTahu].getRuka()));



            }
            //kontrola vitaza
            int vitaz = skontrolujVitaza(hraci);
            if (vitaz != 0){
                vykresli(hraci,jazero,balikKaciek,pocetHracov,hracNaTahu,obraz);
                return vitaz;
            }
        }


        return 0;
    }
    private int skontrolujVitaza(Hrac[] hraci){
        int zije = 0;
        int vitaz = 0;
        for (int i = 0; i < hraci.length; i++){
            if (hraci[i].getZivot() > 0){
                //hrac ma kacky zijuce
                zije++;
                vitaz = i+1;
                }
            }
        if (zije == 1){
            return vitaz;
        }
        return 0;
    }

    private void vykresli(Hrac[] hraci, Jazero jazero, Kacky balikKaciek, int pocetHracov,int naTahu,Obraz obraz){
        /*int[] zameriavaciTmp = jazero.getZameriavaci();
        int[] jazeroTmp = jazero.getJazero();


        System.out.println("suradnice   0 1 2 3 4 5");
        System.out.println("zameriavaci "+zameriavaciTmp[0]+" "+zameriavaciTmp[1]+" "+zameriavaciTmp[2]+" "+zameriavaciTmp[3]+" "+zameriavaciTmp[4]+" "+zameriavaciTmp[5]);
        System.out.println("mieritká    | | | | | |");
        System.out.println("            | | | | | |");
        System.out.println("            v v v v v v");
        System.out.println("kačky       "+jazeroTmp[0]+" "+jazeroTmp[1]+" "+jazeroTmp[2]+" "+jazeroTmp[3]+" "+jazeroTmp[4]+" "+jazeroTmp[5]);
        System.out.println("smer        <----------\n");


        //vypis karty
        for (int i = 0; i < pocetHracov; i++) {
            if (hraci[i].getZivot() > 0) {
                System.out.println("hrac " + (i + 1) + " ma kaciek " + hraci[i].getZivot() + " a ma karty:");
                for (int karta = 0; karta < 3; karta++){
                    System.out.println(hraci[i].getRuka()[karta].getMeno());
                }
            }
            else{
                System.out.println("hrac "+(i+1)+" prehral");

            }

            System.out.println();
        }
        System.out.println("na tahu je hrac "+(naTahu+1));*/

        //updatni obraz
        obraz.zmenRuku(hraci[naTahu].getRuka());
        obraz.zmenJazero(jazero);
        obraz.legendaFariebZivot(hraci,pocetHracov);
        obraz.napisHraca(hraci[naTahu]);
    }
}
