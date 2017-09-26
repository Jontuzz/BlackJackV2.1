package blackjackv2;

/**
 *
 * @author s1601378
 */
public class Kortti {
    private int arvo;
    private String maa;
    
    public Kortti(int arvo, String maa) {
        this.arvo = arvo;
        this.maa = maa;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public String getMaa() {
        return maa;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }
    
    @Override
    public String toString() {
        return this.arvo + " " + this.maa;
    }
}
