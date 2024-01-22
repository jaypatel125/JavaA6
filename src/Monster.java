//My name: Sujan Rokad, 000882948
//My partner's name: Jay Patel, 000881881
//NUmber of total hours I worked: Around 17
//I think we did same effort in almost everything. (50%-50%)

package JavaAssignment6;

import java.util.ArrayList;

public abstract class Monster {
        private String clanAffiliation; // The clan affiliation of the monster.
        private int ferocity; // The ferocity score of the monster.
        private int defense; // The defense score of the monster.
        private int magic; // The magic score of the monster.
        private int treasure; // The amount of treasure the monster has.
        private int health; // The health score of the monster.

    // Constructor for creating a Monster object with specified attribute values.
    public Monster(String clanAffiliation, int ferocity, int defense, int magic, int treasure, int health) {
        this.clanAffiliation = clanAffiliation;
        this.ferocity = ferocity;
        this.defense = defense;
        this.magic = magic;
        this.treasure = treasure;
        this.health = health;
    }

    //  Constructor for creating a Monster object with random attribute values.
    public Monster(String clanAffiliation) {
        this.clanAffiliation = clanAffiliation;
        this.ferocity = (int) (Math.random() * 21);
        this.defense = (int) (Math.random() * 21);
        this.magic = (int) (Math.random() * 21);
        this.treasure = 0;
        this.health = 10 + (int) (Math.random() * 11);
    }

    // Getter for the clan affiliation of the monster.
    public String getClanAffiliation() {
        return clanAffiliation;
    }

    // Getter for the ferocity score of the monster.
    public int getFerocity() {
        return ferocity;
    }

    // Setter for the ferocity score of the monster.
    public void setFerocity(int ferocity) {
        if (ferocity >= 0 && ferocity <= 20) {
            this.ferocity = ferocity;
        } else {
            System.out.println("Ferocity must be between 0 & 20.");
        }
    }

    // Getter for the defense score of the monster.
    public int getDefense() {
        return defense;
    }

    // Setter for the defense score of the monster
    public void setDefense(int defense) {
        if (defense < 0 || defense > 20) {
            System.out.println("Invalid defense value");
            return;
        }
        this.defense = defense;
    }

    // Getter for the magic score of the monster.
    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        if (magic < 0 || magic > 20) { //checks if the magic value is outside the valid range or not
            System.out.println("Invalid magic value");
            return;
        }
        this.magic = magic;
    }

    //Returns the value of the treasure
    public int getTreasure() {
        return treasure;
    }

    public void setTreasure(int treasure) {
        if (treasure < 0) { //check if input treasure is negative
            System.out.println("Invalid treasure value");
            return;
        }
        this.treasure = treasure; //set the treasure value to the instance variable
    }

    // Returns the value of the health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) { //check if input health is negative
            System.out.println("Invalid health value");
            return;
        }
        this.health = health; //set the health value to the instance variable
    }

    public void attack(Monster other) {
        // Calculate the attack & defense score
        double attackScore = calculateAttackScore();
        double defenseScore = other.calculateDefenseScore();
        // Calculate damage based on the defense and attack scores
        int damage = Math.max((int) Math.round((attackScore - defenseScore) / 2.0), 1);
        other.setHealth(other.getHealth() - damage);
        // If other monster has defeated, sets its health to 0 and add its treasure to this monster
        if (other.getHealth() <= 0) {
            other.setHealth(0);
            setTreasure(getTreasure() + other.getTreasure());
        }
    }

    public double calculateAttackScore() {
        return ferocity + magic; //Calculates attack score and returns the score to the monster
    }

    public abstract void rest(); // An abstract method that defines the rest behavior of the monster

    protected abstract String getName(); // An abstract method that get the name of the monster

    public double calculateDefenseScore(){
        return defense + magic; //Calculates the defense score and returns score of the monster
    }

    public  boolean isDefeated(){
        return health <=0; //Returns a boolean value for whether the monster is defeated or not
    }
    @Override
    public String toString() { //String representation of the monster
        String status = (health > 0) ? "alive" : "dead"; //Determines the status of the monster based on its health
        // value
        return getClass().getSimpleName() + "From clan" + clanAffiliation + ", " +
                " \nferocity=" + ferocity +
                ", \ndefense=" + defense +
                ", \nmagic=" + magic +
                ", \ntreasure=" + treasure +
                ", \nhealth=" + health;
    }
}





