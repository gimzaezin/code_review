public class Marine extends Unit implements Attackable{

    public Marine(String name, int hp, int attackPower){
        super(name, hp, attackPower);
    }

    @Override
    public void attack (Unit unit) {
        unit.setHp(this.getHp() - unit.attackPower);
        System.out.println(this.name + "gun attack " + unit.name);
    }
}

