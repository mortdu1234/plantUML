package Western;

public class Lady extends Human {
    private String dressColor;
    private boolean captive;

    /**
     * constructeur
     * 
     * @param NAME String | nom de l'humain
     */
    public Lady(String name, String dressColor) {
        super(name);
        super.setFavoriteDrink("pink lady");
        this.dressColor = dressColor;
    }
    
    /**
     * vérifie l'égalité entre 2 femmes
     * 
     * @param other Lady | autre femme avec qui comparer
     * @return boolean | equalité ou non
     */
    public boolean equals(Lady other) {
        return super.equals(other) && this.dressColor == other.dressColor && this.captive == other.captive;
    }

    /**
     * capture en femme
     */
    public void getKidapped() {
        if (captive) {
            System.err.println("already captive");
        } else {
            super.speak("Aaahhh, heeelllp!!!");
            captive = !captive;
        }
    }

    /**
     * relache une femme
     * 
     * @param helper Cowboy | cowboy qui la libère
     */
    public void getReleased(Cowboy helper) {
        if (helper == null) {
            System.err.println("null pointer");
        } else if (!captive) {
            System.err.println("not captive");
        } else {
            super.speak("thank you " + helper.getName());
            captive = !captive;
        }
    }

    /**
     * change la couleur de la robe
     * 
     * @param newColor String | nouvelle couleur de la robe
     */
    public void changeDress(String newColor) {
        dressColor = newColor;
        super.speak("Look at my new " + dressColor + " dress!");
    }

    /**
     * getter NAME for ladies
     * 
     * @return String | nom de la femme
     */
    @Override
    public String getName() {
        return "Lady " + super.getName();
    }

    /**
     * introdution de femme
     */
    @Override
    public void selfIntroduction() {
        super.selfIntroduction();
        super.speak("look my " + dressColor + " dress");
    }

    /**
     * for testing
     */
    public String toString() {
        return super.toString() + " dressColor : " + dressColor + " captive : " + captive;
    }
}
