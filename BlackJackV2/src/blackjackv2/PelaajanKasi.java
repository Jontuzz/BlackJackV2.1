/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackv2;

/**
 *
 * @author s1601378
 */
import java.util.ArrayList;

public class PelaajanKasi {

    private ArrayList<Kortti> kortit = new ArrayList<>();

    public void otaKortti(Kortti saatukorKortti) {
        this.kortit.add(saatukorKortti);
    }

    public int selvitaSumma() {
        int korttienSumma = 0;

        for (Kortti selvitaKortinSumma : this.kortit) {
            if (selvitaKortinSumma.getArvo() >= 2 && selvitaKortinSumma.getArvo() <= 10) {
                korttienSumma += selvitaKortinSumma.getArvo();
            }

            if (selvitaKortinSumma.getArvo() >= 11 && selvitaKortinSumma.getArvo() <= 13) {
                korttienSumma += 10;
            }

            if (selvitaKortinSumma.getArvo() == 1) {
                korttienSumma += 11;
            }

            if (korttienSumma > 21) {
                korttienSumma -= 10;
            }
        }

        return korttienSumma;
    }

    public boolean onkoPelaajallaBlackJack() {
        if (this.kortit.size() == 2) {
            if (this.kortit.get(0).getArvo() == 1) {
                if (this.kortit.get(1).getArvo() >= 10 && this.kortit.get(1).getArvo() <= 13) {
                    System.out.println("Joo");
                    return true;
                }
            } else if (this.kortit.get(0).getArvo() >= 10 && this.kortit.get(0).getArvo() <= 13) {
                if (this.kortit.get(1).getArvo() == 1) {
                    System.out.println("Joo");
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
