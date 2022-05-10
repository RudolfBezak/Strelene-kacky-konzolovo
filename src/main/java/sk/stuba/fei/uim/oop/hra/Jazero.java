package sk.stuba.fei.uim.oop.hra;

import sk.stuba.fei.uim.oop.utility.BalikFunkcie;

import javax.swing.*;
import java.awt.*;

public class Jazero {
    private int[] jazero;
    private int[] zameriavaci;
    private final ImageIcon[] obrazokKaciek;


    //vygeneruj jazero a odober tie karty z balika kaciek
    public Jazero(Kacky kacky) {
        BalikFunkcie balikFunkcie = new BalikFunkcie();
        int velkostJazera = 6;
        jazero = new int[velkostJazera];
        zameriavaci = new int[velkostJazera];
        //nastav zameriavacov na 0
        for (int i = 0; i < velkostJazera; i++){
            zameriavaci[i] = 0;

        }


        //prekopiruj vrchnych 6 kariet z baliku kaciek na jazero
        int[] balikKaciekTmp = kacky.getBalikKaciek();
        System.arraycopy(balikKaciekTmp, 0, jazero, 0, velkostJazera);
        //vymaz vrchnych 6 kariet z balika
        kacky.setBalikKaciek(balikFunkcie.balikVymazVrchnychN(balikKaciekTmp, velkostJazera));


        //najdi obrazky kaciek
        obrazokKaciek = new ImageIcon[7*2];
        obrazokKaciek[0] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka0.png");
        obrazokKaciek[1] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka0n.png");
        obrazokKaciek[2] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka1.png");
        obrazokKaciek[3] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka1n.png");
        obrazokKaciek[4] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka2.png");
        obrazokKaciek[5] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka2n.png");
        obrazokKaciek[6] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka3.png");
        obrazokKaciek[7] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka3n.png");
        obrazokKaciek[8] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka4.png");
        obrazokKaciek[9] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka4n.png");
        obrazokKaciek[10] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka5.png");
        obrazokKaciek[11] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka5n.png");
        obrazokKaciek[12] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka6.png");
        obrazokKaciek[13] =  new ImageIcon("src/main/java/sk/stuba/fei/uim/oop/obrazky/kacka6n.png");

        //zmen ich velkost
        for (int i = 0; i < obrazokKaciek.length; i++){
            obrazokKaciek[i] = zmenVelkost(obrazokKaciek[i]);
        }



    }





    public int[] getJazero() {
        return jazero;
    }
    public void setJazero(int[] jazero) {
        this.jazero = jazero;
    }
    public int[] getZameriavaci() {
        return zameriavaci;
    }
    public void setZameriavaci(int[] zameriavaci) {
        this.zameriavaci = zameriavaci;
    }
    private ImageIcon zmenVelkost(ImageIcon obrazok){
        Image obrazokImage= obrazok.getImage();
        obrazokImage = obrazokImage.getScaledInstance(10*16,10*24,Image.SCALE_DEFAULT);
        obrazok.setImage(obrazokImage);
        return obrazok;
    }

    public ImageIcon[] getObrazokKaciek() {
        return obrazokKaciek;
    }
}


