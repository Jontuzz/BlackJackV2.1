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
public class TestaaKasi {
    public static void main(String[] args) {
        
        //kortin arvo 2-10:käden summaan lisätään kortin numeroa vastaava arvo(2 lisätään 2, 3 lisätään 3.)
        PelaajanKasi kasi2TO10 = new PelaajanKasi();
        kasi2TO10.otaKortti(new Kortti(5, "Ruutu"));
        kasi2TO10.otaKortti(new Kortti(9, "Pata"));
        System.out.println("2 to 10: summa on " + kasi2TO10.selvitaSumma()); // 5 + 9 = 14 TOIMII
        
        System.out.println("-------------------------------");
        
        //kortin arvo 11-13:	käden summaan lisätään 10
        PelaajanKasi kasi11TO13 = new PelaajanKasi();
        kasi11TO13.otaKortti(new Kortti(11, "Hertta"));
        kasi11TO13.otaKortti(new Kortti(12, "Hertta"));
        kasi11TO13.otaKortti(new Kortti(13, "Pata"));
        
        System.out.println("11 to 13: summa on " + kasi11TO13.selvitaSumma()); // 11=10, 12=10, 13=10; 10 + 10 + 10 = 30 TOIMII
        
        System.out.println("-------------------------------");
        
        //kortin arvo 1 (ässä):	käden summaan lisätään 11
        PelaajanKasi assa = new PelaajanKasi();
        assa.otaKortti(new Kortti(1, "Hertta")); // 1 = 11 TOIMII
        System.out.println("Ässä summa: " + assa.selvitaSumma());
        
        System.out.println("-------------------------------");
        
        //Mikäli kortteja on kaksi ja korttein yhteissummaksi tuli yli 21, niin vähennetään summasta 10.
        //Tässä tilanteessa on saatu kaksi ässää, jolloin toisen ässän tulkitaan olevan arvoltaan 1.     
        PelaajanKasi kaksiAssaa = new PelaajanKasi();
        kaksiAssaa.otaKortti(new Kortti(1, "Ruutu"));
        kaksiAssaa.otaKortti(new Kortti(1, "Risti"));
        System.out.println("Kaksi ässää summa: " + kaksiAssaa.selvitaSumma()); // 11 + 11 = 22 - 10 = 12 //TOIMII
        
    }
}
