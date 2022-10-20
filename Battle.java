import java.util.ArrayList;

public class Battle {
    private int combatantAmount;
    private int enemyAmount;
    private float legendaryChance;
    private ArrayList<Character> characterList;
    private CharacterFactory characterFactory;

    public Battle(int combatantAmount, int enemyAmount, float legendaryChance, CharacterFactory characterFactory) {
        this.combatantAmount = combatantAmount;
        this.enemyAmount = enemyAmount;
        this.legendaryChance = legendaryChance;
        this.characterFactory = new CharacterFactory(legendaryChance);
    }

    public void addCombatants(Combatant... combatants) {
        for (Combatant combatant : combatants) {
            this.characterList.add(combatant);
        }
    }

    public void generateEnemies() {
        for (Enemy enemy : this.characterFactory.generateRandomEnemies(enemyAmount)) {
            this.characterList.add(enemy);
        }
    }

    public int getCombatantAmount() {
        return this.combatantAmount;
    }

    public int getEnemyAmount() {
        return this.enemyAmount;
    }

    public float getLegendaryChance() {
        return this.legendaryChance;
    }

    public ArrayList<Character> getCharacterList() {
        return this.characterList;
    }

    public CharacterFactory getCharacterFactory() {
        return this.characterFactory;
    }

}
