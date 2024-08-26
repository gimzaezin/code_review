public class Dragoon extends Unit implements Attackable{
    private String name;
    private int hp;
    private int attackPower;

    public Dragoon(String name, int hp, int attackPower){
        super(name, hp, attackPower);
    }

    @Override
    public void attack (Unit unit) {
        unit.setHp(this.getHp() - unit.attackPower);
        System.out.println(this.name + " attack " + unit.name);
    }
}
