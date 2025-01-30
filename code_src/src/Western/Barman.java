package Western;

public class Barman extends Human {
    private String barName;

    /**
     * constructeur
     * 
     * @param name String | nom de l'humain
     */
    public Barman(String name) {
        super(name);
        super.setFavoriteDrink("gin tonic");
        this.barName = name;
    }
    
    /**
     * constructeur
     * 
     * @param name String | nom de l'humain
     * @param barName String | nom du bar
     */
    public Barman(String name, String barName) {
        super(name);
        super.setFavoriteDrink("gin tonic");
        this.barName = barName;
    }

    public String getBarName() {
        return barName + "'s saloon";
    }

    /**
     * permet a l'humain de parler
     * 
     * @param message String | texte dit par l'humain
     */
    @Override
    public void speak(String message) {
        super.speak(message + " Boss!");
    }
    
    /**
     * introdution du barman
     */
    @Override
    public void selfIntroduction() {
        super.selfIntroduction();
        super.speak("My saloon is " + getBarName());
    }

    /**
     * for testing
     */
    @Override
    public String toString() {
        return super.toString() + " barName : " + barName;
    }


}
