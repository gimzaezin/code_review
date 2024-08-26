public class Zealot extends Unit implements Attackable{
    private String name;
    private int hp;
    private int attackPower;

    public Zealot(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    public void attack (Unit unit) {
        unit.setHp(this.getHp() - unit.attackPower);
        System.out.println(this.name + " attack " + unit.name);
    }

}
