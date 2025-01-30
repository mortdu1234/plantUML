package Western;

public class Sheriff extends Cowboy {
    /**
     * constructeur
     * 
     * @param NAME String | nom de l'humain
     */
    public Sheriff(String name) {
        super(name);
        super.setFavoriteDrink("moscow mule");
        super.setQuality("honest");
    }

    /**
     * arrete un bandit 
     * 
     * @param ruffian Rufiian | bandit a arreter
     */
    public void arrest(Ruffian ruffian) {
        super.speak("In the name of the low, you are under arrest, "+ ruffian.getName()+ "!");
        setFame(getFame()+1);
        ruffian.setJailed();
    }

    /**
     * indique des affiches
     * 
     * @param ruffian 
     */
    public void wanted(Ruffian ruffian) {
        String message = "OYEZ OYEZ BRAVE PEOPLE !!! ";
        message += ruffian.getReward() + " gold coins to the one who will catch ";
        message += ruffian.getName() + " dead or alive !!!";
        super.speak(message);
    }

    /**
     * renvois le nom du sheriff
     * 
     * @return String | nom du sheriff
     */
    @Override
    public String getName() {
        return "Sheriff " + super.getName();
    }
}
