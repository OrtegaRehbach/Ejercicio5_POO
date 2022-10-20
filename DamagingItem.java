public class DamagingItem extends Item {

    public DamagingItem(String name, int effect) {
        super(name, effect);
    }

    public boolean useOn(Character target) {
        return target.takeDamage(this.getEffect());
    }
}
