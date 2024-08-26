public class Hydra extends Unit implements Attackable{

    public Hydra(String name, int hp, int attackPower){
        super(name, hp, attackPower);
    }

    public void attack (Unit unit) {
        unit.setHp(this.getHp() - unit.attackPower);
        System.out.println(this.name + " attack " + unit.name);
    }
}
