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
public class TestaaPelaajanKasi {
    public static void main(String[] args) {
        
        //kortin arvo 2-10:käden summaan lisätään kortin numeroa vastaava arvo(2 lisätään 2, 3 lisätään 3.)
        PelaajanKasi pelaaja2TO10 = new PelaajanKasi();        
        pelaaja2TO10.otaKortti(new Kortti(4, "Pata"));
        pelaaja2TO10.otaKortti(new Kortti(6, "Risti"));        
        System.out.println("Pelaajan2TO10 summa: " + pelaaja2TO10.selvitaSumma()); //TOIMII: 4 + 6 = 10
        
        System.out.println("--------------------------");
        
        //kortin arvo 11-13: käden summaan lisätään 10
        PelaajanKasi pelaaja11TO13 = new PelaajanKasi();        
        pelaaja11TO13.otaKortti(new Kortti(11, "Hertta"));
        pelaaja11TO13.otaKortti(new Kortti(13, "Ruutu"));
        System.out.println("Pelaajan11TO13 summa: " + pelaaja11TO13.selvitaSumma());//TOIMII 11 = 10, 13 = 10; 10 + 10 = 20
        
        //kortin arvo 1 (ässä):	käden summaan lisätään 11
        System.out.println("--------------------------");
        PelaajanKasi assa = new PelaajanKasi();
        assa.otaKortti(new Kortti(1, "Pata"));
        System.out.println("Assä summa: " + assa.selvitaSumma()); //TOIMII 1 = 11; = 11
        
        //Blackjackiksi kutsutaan tilannetta, jolla pelaajalla on kaksi korttia, joista toinen on arvoltaan 10-13 ja toinen ässä.
        //Toteuta luokkaan PelaajanKasi, metodi joka tutkii onko kätenä blackjack.
        System.out.println("--------------------------");
        PelaajanKasi onkoBlackJack = new PelaajanKasi();
        onkoBlackJack.otaKortti(new Kortti(10, "Pata"));
        onkoBlackJack.otaKortti(new Kortti(1, "Hertta"));
        System.out.println("Onko blackjack? : " + onkoBlackJack.onkoPelaajallaBlackJack()); //Pelaajall blackJack; TOIMII
        
        System.out.println("--------------------------");
        
        PelaajanKasi yli21 = new PelaajanKasi();
        //yli21.otaKortti(new Kortti(1, "Ruutu"));
        yli21.otaKortti(new Kortti(13, "Pata"));
        yli21.otaKortti(new Kortti(14, "Pata"));
        System.out.println("Yli21 : " + yli21.selvitaSumma()); //1 = 11 13 = 10; TOIMII 11 + 10 + 5 = 26; 26 - 10 = 16
        
    }
}
