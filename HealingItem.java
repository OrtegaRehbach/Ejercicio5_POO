public class HealingItem extends Item {

    public HealingItem(String name, int effect) {
        super(name, effect);
    }

    public boolean useOn(Character target) {
        return target.heal(this.getEffect());
    }

}
