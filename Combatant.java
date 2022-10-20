import java.util.ArrayList;

public class Combatant extends Character {
    private ArrayList<Item> items;

    public Combatant(String name, CharacterClass characterClass) {
        super(name, characterClass);
        this.items = characterClass.getBaseItems();
    }

    public boolean useItemOn(Item item, Character target) {
        return item.useOn(target);
    }

    public boolean removeItem(Item item) {
        return this.items.remove(item);
    }

    public String getClassName() {
        return this.characterClass.getClassName();
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Item getItemAtIndex(int index) {
        return (index < this.items.size() && index >= 0) ? this.items.get(index) : null;
    }

    public String startingMessage() {
        return "The " + this.characterClass.getClassName() + " " + this.name + " enters the battle!";
    }

    public String deathMessage() {
        return this.name + " has died!";
    }

    public String victoryMessage() {
        return "The " + this.characterClass.getClassName() + ": " + this.name + " wins the battle!";
    }
}