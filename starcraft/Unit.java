public abstract class Unit {
    protected String name;
    protected int hp;
    protected int attackPower;

    public Unit(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    // public void attack (Unit unit) {
    //     unit.setHp(this.getHp() - unit.attackPower);
    //     System.out.println(this.name + " attack " + unit.name);
    public int getHp() {
        return this.hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }
}
