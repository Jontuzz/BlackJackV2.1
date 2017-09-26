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
import java.util.Random;

public class KorttiPakka {

    //ArrayList korteille
    private ArrayList<Kortti> pakka = new ArrayList<>();
    //ArrayList korttien maille
    private ArrayList<String> maat = new ArrayList<>();

    private int pakkojenLKM;

    public KorttiPakka(int pakkojenMaara) {
        this.pakkojenLKM = pakkojenMaara;
        this.maat.add("Hertta");
        this.maat.add("Risti");
        this.maat.add("Pata");
        this.maat.add("Ruutu");

        //korttipakkojen määrä
        for (int korttiPakkoja = 0; korttiPakkoja < pakkojenMaara; korttiPakkoja++) {
            //jokaiselle maalle kaikki kortit (jokaisella maalla kortit arvosta 2 arvoon 14
            for (int maanIndeksi = 0; maanIndeksi < this.maat.size(); maanIndeksi++) {
                //ässä on 1
                for (int kortinArvo = 1; kortinArvo <= 13; kortinArvo++) {
                    pakka.add(new Kortti(kortinArvo, this.maat.get(maanIndeksi)));
                }
            }
        }
        sekoitaPakka();
    }

    public Kortti jaaKortti() {

        Kortti jaettavaKortti = this.pakka.get(0);
        this.pakka.remove(jaettavaKortti);

        return jaettavaKortti;
    }

    public void sekoitaPakka() {

        //ArrayList apuPakalle, jonka avulla kortit sekoitetaan
        ArrayList<Kortti> apuPakka = new ArrayList<>();

        //pakkojen lukumäärä kerrottuna yhden pakan korttien määrällä
        int korttienYhteisMaara = this.pakkojenLKM * 52;
        int korttienMaaraPakassa = 0;

        //poistetaan pakasta random kortti (ja lisätään apuPakkaan), niin kauan kun korttienMaaraPakassa on pienempi kuin korttienYhteisMaara
        while (korttienMaaraPakassa < korttienYhteisMaara) {

            int min = 0;
            int max = pakka.size();
            // parametreiksi yläraja - alajara ja lopputulemaan lisätään alaraja
            // koska metodi palauttaa oletuksena 0 - yläraj
            int random = new Random().nextInt(max - min) + min;

            apuPakka.add(this.pakka.get(random));
            pakka.remove(random);

            korttienMaaraPakassa++;
        }

        //poistetaan apuPakasta random kortti (ja lisätään pakkaan), niin kauan kun korttienMaaraPakassa on pienempi kuin korttienYhteisMaara
        int korttienMaaraApuPakassa = 0;
        while (korttienMaaraApuPakassa < korttienYhteisMaara) {

            int min = 0;
            int max = apuPakka.size();
            // parametreiksi yläraja - alajara ja lopputulemaan lisätään alaraja
            // koska metodi palauttaa oletuksena 0 - yläraj
            int random = new Random().nextInt(max - min) + min;

            this.pakka.add(apuPakka.get(random));
            apuPakka.remove(random);

            korttienMaaraApuPakassa++;
        }

        //System.out.println("korttipakka " + this.pakka);
        //System.out.println("apuPakka " + apuPakka + " apupakan koko " + apuPakka.size());
    }

    @Override
    public String toString() {
        return "" + this.pakka;
    }
}
