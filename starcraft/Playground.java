public class Playground {
    public static void main(String[] args) {
        Marine marine1 = new Marine("Marine 1", 20, 3);
        Marine marine2 = new Marine("Marine 2", 20, 3);
        Zealot zealot1 = new Zealot("Zealot1", 50, 5);
        Zergling zergling1 = new Zergling("zergling1", 15, 2);
        Zergling zergling2 = new Zergling("zergling2", 15, 2);
        Zergling zergling3 = new Zergling("zergling3", 15, 2);
        Hydra hydra1 = new Hydra("hydra1", 40  , 4);
        Hydra hydra2 = new Hydra("hydra2", 40  , 4);
        Dragoon dragoon1 = new Dragoon("Dragoon1", 100, 10);
        marine1.attack(marine2);
        marine2.attack(marine1);
        marine1.attack(zealot1);
        zealot1.attack(hydra2);
        zergling2.attack(marine1);
        dragoon1.attack(zergling3);
        hydra2.attack(hydra1);
        marine2.attack(zergling1);

    }
}
