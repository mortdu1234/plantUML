package Western;

public class Cowboy extends Human {
    private int fame;
    private String quality;

    /**
     * constructeur
     * 
     * @param NAME String | nom de l'humain
     */
    public Cowboy(String name) {
        super(name);
        super.setFavoriteDrink("manhattan");
        fame = 0;
        quality = "brave";
    }

    /**
     * setter de quality
     * 
     * @param newQuality String | nouvelle qualité
     */
    public void setQuality(String newQuality) {
        quality = newQuality;
    }

    /**
     * setter fame
     * 
     * @param newFame | int
     */
    public void setFame(int newFame) {
        fame = newFame;
    }

    /**
     * getter fame
     * 
     * @return int | fame
     */
    public int getFame() {
        return fame;
    }

    /**
     * tire sur un birgant 
     * 
     * @param ruffian Ruffian | brigant sur qui le cowboy tire
     */
    public void shoot(Ruffian ruffian) {
        if (ruffian == null) {
            System.err.println("Cowboy shoot : null pointer");
        } else {
            System.out.print("The " + quality + " " + super.getName());
            System.out.print(" shoots " + ruffian.getName() + ". PAN!");
            System.out.println();
            super.speak("take this rascal!");
        }
    }

    /** 
     * libère une femme
     * 
     * @param lady Lady | femme qu'il libère
     * @param ruffian Ruffian | bandit chez qui est la femme
     */
    public void release(Lady lady, Ruffian ruffian) {
        super.speak("You are safe now, beautiful " + lady.getName());
        ruffian.removeLady(lady);
        lady.getReleased(this);
        fame++;
    }
    // ############################################
    // A TESTERRRRR

    /**
     * introdution de cowboy
     */
    @Override
    public void selfIntroduction() {
        super.selfIntroduction();
        super.speak("people says that I am "+ quality + " and I have a fame of " + fame);
    }

    /**
     * arrete un brigant et le donne au sheriff
     * 
     * @param sheriff Sheriff | sherif qui arrete le brigant
     * @param ruffian Ruffian | brigant qui est arreter
     */
    public void handOver(Sheriff sheriff, Ruffian ruffian) {
        sheriff.arrest(ruffian);
        super.speak("I earn " + ruffian.getReward() + " gold coins.");
    }

    /**
     * for testing
     */
    public String toString() {
        return super.toString() + "fame : " + fame + " quality : " + quality;
    }
}
