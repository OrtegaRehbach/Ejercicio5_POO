import java.util.ArrayList;

public class CharacterClass {
    private String className;
    private int maxHp;
    private int hp;
    private int atk;
    private int itemCapacity;
    private ArrayList<Item> baseItems;
    private Attack[] attackList;


    public CharacterClass(String className, int maxHp, int atk, int itemCapacity, Attack... attackList) {
        this.className = className;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.atk = atk;
        this.itemCapacity = itemCapacity;
        this.baseItems = new ArrayList<>(itemCapacity);
        this.attackList = attackList;
    }

    public String getClassName() {
        return this.className;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getItemCapacity() {
        return this.itemCapacity;
    }

    public ArrayList<Item> getBaseItems() {
        return this.baseItems;
    }

    public void setBaseItems(Item... baseItems) {
        for (Item item : baseItems) {
            if (baseItems.length <= itemCapacity)
                this.baseItems.add(item);
        }
    }

    public Attack[] getAttackList() {
        return this.attackList;
    }


    @Override
    public String toString() {
        return "{" +
            " className='" + getClassName() + "'" +
            ", hp='" + getHp() + "'" +
            ", atk='" + getAtk() + "'" +
            ", attackList='" + getAttackList() + "'" +
            "}";
    }
    
    
}
