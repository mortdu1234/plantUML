package Western;
import java.util.ArrayList;

public class Ruffian extends Human {
    private String look;
    private int nbLadies;
    private int reward;
    private boolean jailed;
    private ArrayList<Lady> ladies;

    
    /**
     * constructeur
     * 
     * @param NAME String | nom de l'humain
     */
    public Ruffian(String name) {
        super(name);
        super.setFavoriteDrink("bloody mary");
        look = "evil";
        nbLadies = 0;
        reward = 100;
        jailed = false;
        ladies = new ArrayList<Lady>();
    }

    /**
     * setter de jailed
     */
    public void setJailed() {
        jailed = !jailed;
    }

    /**
     * kidnappe une femme
     * 
     * @param targetLady Lady | femme qui est kidnappée
     */
    public void kidnap(Lady targetLady) {
        if (targetLady == null) {
            System.err.println("Ruffian kidnap : no target");
        } else if (jailed) {
            System.err.println("Ruffian in jail");
        } else {
            super.speak("Ha ha ! " + targetLady.getName() + ", you are mine now !");
            targetLady.getKidapped();
            reward += 50;
            nbLadies++;
            ladies.add(targetLady);
        }
    }


    /**
     * capture le bandit
     * 
     * @param cowboy Cowboy | cowboy qui le capture
     */
    public void getCaught(Cowboy cowboy) {
        if (cowboy == null) {
            System.err.println("Ruffian getCaught : no target");
        } else {
            super.speak("Argh, I am screwed ! " + cowboy.getName() + ", you got me !");
            for (Lady lady : ladies) {
                lady.getReleased(cowboy);
            }
            nbLadies = 0;
            ladies.clear();
        }
    }

    /**
     * retire une femme da la liste des femmes du bandit 
     * 
     * @param lady Lady | une femme
     */
    public void removeLady(Lady lady) {
        if (lady == null) {
            System.err.println("null pointer");
        } else {
            ladies.remove(lady);
            nbLadies--;
        }
    }

    /**
     * getter reward
     * 
     * @return int | argent donnée pour la capture
     */
    public int getReward() {
        return reward;
    }

    /**
     * getter nbLadies
     * 
     * @return int | nombre de femmes capturées
     */
    public int getNbLadies() {
        return nbLadies;
    }

    /**
     * getter NAME for ruffian
     * 
     * @return String | nom du bandit
     */
    @Override
    public String getName() {
        return super.getName() + " the " + look;
    }

    /**
     * self introdution for Rufiian
     */
    @Override
    public void selfIntroduction() {
        super.selfIntroduction();
        this.speak("I look " + look + " and I kidnapped " + nbLadies + "ladies !");
        this.speak("There is a "+ reward + "gold coins bounty on my head, HA HA HA !");
    }

    /**
     * for testing
     */
    public String toString() {
        String message = super.toString();  
        message += " look : " + look;
        message += " nbLadies : " + nbLadies;
        message += " reward : " + reward;
        message += " jailed : " + jailed;
        message += " ladies : [";
        for (Lady lady : ladies) {
            message += lady.toString(); 
        }
        return message + "]";
    }
}
