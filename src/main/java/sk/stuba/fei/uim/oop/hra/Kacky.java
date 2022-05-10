package sk.stuba.fei.uim.oop.hra;


import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

public class Kacky {

    private int[] balikKaciek;

    //vygeneruj balik kaciek a pomiesaj ho
    public Kacky(int pocetHracov) {
       //generovanie baliku kaciek
        balikKaciek = new int[(pocetHracov*5) + 5];
        for (int i = 0; i < pocetHracov+1; i++){
            for (int ii = 0; ii < 5; ii++){
                this.balikKaciek[(i*5) + ii] = i;
            }
        }
        //shuffle
        BalikFunkcie balikFunkcie = new BalikFunkcie();
        balikKaciek = balikFunkcie.balikMiesaj(balikKaciek);
    }

    public int[] getBalikKaciek() {
        return balikKaciek;
    }

    public void setBalikKaciek(int[] balikKaciek) {
        this.balikKaciek = balikKaciek;
    }
}

