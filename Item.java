public abstract class Item {
    protected String name;
    protected int effect;

    public Item(String name, int effect) {
        this.name = name;
        this.effect = effect;
    }

    public Item() {
        this.name = "testItem";
        this.effect = 10;
    }

    public abstract boolean useOn(Character target);

    public String getName() {
        return this.name;
    }

    public int getEffect() {
        return this.effect;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", effect='" + getEffect() + "'" +
            "}";
    }
}
