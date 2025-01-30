package Western;

public class Human {
    private final String NAME;
    private String favoriteDrink;

    /**
     * constructeur
     * 
     * @param NAME String | nom de l'humain
     */
    public Human(String name) {
        this.NAME = name;
        this.favoriteDrink = "water";
    }

    /**
     * getter NAME
     * 
     * @return String | nom de l'humain
     */
    public String getName() {
        return NAME;
    }

    /**
     * getter favoriteDrink
     * 
     * @return String | nom de la boisson préférée de l'humain
     */
    public String getFavoriteDrink() {
        return favoriteDrink;
    }

    public void setFavoriteDrink(String newDrink) {
        favoriteDrink = newDrink;
    }

    /**
     * permet de démarer la parole d'un humain
     */
    private void startingSpeak() {
        System.out.print(getName() + " - ");
    }

    /**
     * permet a l'humain de parler
     * 
     * @param message String | texte dit par l'humain
     */
    public void speak(String message) {
        startingSpeak();
        System.out.print(message);
        System.out.println();
    }

    /**
     * permet a l'humain de se présenter
     */
    public void selfIntroduction() {
        startingSpeak();
        System.out.print("Hi! I am " + getName());
        System.out.print(", and I drink " + getFavoriteDrink());
        System.out.println();
    }

    /**
     * permet a l'humain de boire
     */
    public void drink() {
        startingSpeak();
        System.out.print("Ah! A good glass of " + getFavoriteDrink() + "! GLOUPS!");
        System.out.println();
    }

    /**
     * vérifie l'égalité entre 2 humain avec le nom et la boisson préférée
     * @param other Human | autre humain avec qui comparer
     * @return boolean | egalité ou non
     */
    public boolean equals(Human other) {
        return this.NAME == other.NAME && this.favoriteDrink == other.favoriteDrink;
    }

    /**
     * for testing
     */
    public String toString() {
        return "name : " + NAME + " favoriteDrink : " + favoriteDrink;
    }
}
