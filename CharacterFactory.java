import java.util.Random;

public class CharacterFactory {

    private float legendaryChance;
    private Random rng = new Random();

    private CharacterClass[] playableClasses = {
        new CharacterClass("WARRIOR", 100, 30, 2,
            new Attack("testAttack1", 10),
            new Attack("testAttack2", 30)
        ),
        new CharacterClass("EXPLORER", 100, 30, 4, 
            new Attack("testAttack3", 5),
            new Attack("testAttack4", 15)
        ),
        new CharacterClass("HUNTER", 100, 30, 4, 
            new Attack("testAttack3", 5),
            new Attack("testAttack4", 15)
        )
    };

    private CharacterClass[] enemyClasses = {
        new CharacterClass("NORMAL", 100, 30, 0,
            new Attack("baseAttack1", 5)
        ),
        new CharacterClass("LEGENDARY", 150, 60, 0, 
            new Attack("baseAttack2", 10),
            new Attack("specialAttack", 15)
        )
    };

    private String[] enemyTypes = {
        "Goblin",
        "Zombie",
        "Ogre",
        "Knight",
        "Kobold",
        "Spirit",
        "Murlock",
        "Mosquitoe"
    };

    public CharacterFactory(float legendaryChance) {
        this.legendaryChance = legendaryChance;
        setBaseItems();
    }

    public void setBaseItems() {
        this.playableClasses[0].setBaseItems(   // WARRIOR
            new HealingItem("Healing1", 10),
            new DamagingItem("Damaging1", 10)
        );
        this.playableClasses[1].setBaseItems(   // EXPLORER
            new HealingItem("Healing2", 15),
            new HealingItem("Healing3", 20),
            new DamagingItem("Damaging2", 15),
            new DamagingItem("Damaging3", 20)
        );
        this.playableClasses[3].setBaseItems(   // HUNTER
            new HealingItem("Healing2", 15),
            new HealingItem("Healing3", 20),
            new DamagingItem("Damaging2", 15),
            new DamagingItem("Damaging3", 20)
        );
    }

    public CharacterClass[] getPlayableClasses() {
        return this.playableClasses;
    }

    public Combatant createCombatant(String name, String characterClassName) {
        for (CharacterClass characterClass : playableClasses) {
            if (characterClass.getClassName().equals(characterClassName.toUpperCase()))
                return new Combatant(name, characterClass);
        }
        return null;
    }

    public Enemy createRandomEnemy() {
        if (rng.nextFloat() <= legendaryChance ) {
            return createLegendaryEnemy(getRandomEnemyType());
        } else {
            return createNormalEnemy(getRandomEnemyType());
        }
    }

    public String getRandomEnemyType() {
        return this.enemyTypes[rng.nextInt(enemyTypes.length)];
    }

    public Enemy createNormalEnemy(String type) {
        return new Enemy(type, this.enemyClasses[0]);
    }

    public Enemy createLegendaryEnemy(String type) {
        return new Enemy(type, this.enemyClasses[1]);
    }

    public Enemy[] generateRandomEnemies(int amount) {
        Enemy[] generatedEnemies = new Enemy[amount];
        for (int i = 0; i < amount; i++) {
            generatedEnemies[i] = createRandomEnemy();
        }
        return generatedEnemies;
    }


}
