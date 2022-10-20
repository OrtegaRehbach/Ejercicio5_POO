import java.util.Random;

public class Enemy extends Character {
    
    private Random rng = new Random();

    public Enemy(String name, CharacterClass characterClass) {
        super(name, characterClass);
    }

    public Attack chooseRandomAttack() {
        return this.attackList[rng.nextInt(this.attackList.length)];
    }

    public String startingMessage() {
        return "An enemy: " + this.name + " appears!";
    }
    
    public String deathMessage() {
        return this.name + " has perished!";
    }

    public String victoryMessage() {
        return this.name + " has claimed victory!";
    }


}
