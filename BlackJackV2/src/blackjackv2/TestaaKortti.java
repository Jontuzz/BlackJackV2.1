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
public class TestaaKortti {
    public static void main(String[] args) {
        Kortti testaaKortti = new Kortti(1, "Pata");
        System.out.println(testaaKortti);
        
        System.out.println("Kortin arvo: " + testaaKortti.getArvo() + " maa: " + testaaKortti.getMaa());
    }
}
