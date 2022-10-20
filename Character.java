public class Character {
    protected String name;
    protected CharacterClass characterClass;
    protected int maxHp;
    protected int hp;
    protected int atk;
    protected Attack[] attackList;


    public Character(String name, CharacterClass characterClass) {
        this.name = name;
        this.characterClass = characterClass;
        this.hp = characterClass.getHp();
        this.atk = characterClass.getAtk();
        this.attackList = characterClass.getAttackList();
    }

    public String startingMessage() {
        return "Staring message. - " + this.name;
    }
    
    public String deathMessage() {
        return this.name + " has died.";
    }

    public String victoryMessage() {
        return this.name + " has won.";
    }

    public boolean attackCharacter(int attackIndex, Character target) {
        return target.takeDamage(calculateAttackDamage(attackIndex));
    }

    private int calculateAttackDamage(int attackIndex) {
        return this.attackList[attackIndex].getBaseDamage();
    }

    public String getAttackText(Attack attack, Character target) {
        return (
            this.name + " has used " + attack.getName() + 
            " on " + target.getName() + " for " + attack.getBaseDamage() + " points of damage!"
        );
    }

    public Attack[] getAttackList() {
        return this.attackList;
    }

    public Attack getAttackAtIndex(int index) {
        return (index < this.attackList.length && index >= 0) ? this.attackList[index] : null;
    }

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    private int getAtk() {
        return this.atk;
    }

    public boolean heal(int amount) {
        if (this.hp < maxHp) {
            this.hp += amount;
            if (this.hp > maxHp) {
                this.hp = maxHp;
            }
            return true;
        } else  {
            return false;
        }
    }

    public boolean takeDamage(int amount) {
        if (this.hp != 0) {
            this.hp -= amount;
            if (this.hp < 0) {
                this.hp = 0;
            }
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", hp='" + getHp() + "'" +
            ", atk='" + getAtk() + "'" +
            ", attackList='" + getAttackList() + "'" +
            "}";
    }

}