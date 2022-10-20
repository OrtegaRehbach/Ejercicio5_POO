public class Attack {
    private String name;
    private int baseDamage;

    public Attack(String name, int baseDamage) {
        this.name = name;
        this.baseDamage = baseDamage;
    }

    public Attack() {
        this.name = "testAttack";
        this.baseDamage = 10;
    }

    public String getName() {
        return this.name;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", baseDamage='" + getBaseDamage() + "'" +
            "}";
    }

}
