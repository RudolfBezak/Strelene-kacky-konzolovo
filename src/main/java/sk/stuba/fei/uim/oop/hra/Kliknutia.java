package sk.stuba.fei.uim.oop.hra;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kliknutia extends JPanel implements ActionListener {
    int klik;
    boolean posledneKliknute;

    public Kliknutia(int klik) {
        this.klik = klik;
        this.posledneKliknute = false;
    }

    public void actionPerformed(ActionEvent e){
        this.posledneKliknute = true;

}

    public void reSet() {
        this.posledneKliknute = false;
    }
}
