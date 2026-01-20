public class Main {
    public static void main(String[] args) {


        GameCharacter dude = new GameCharacter("dude",100);
        GameCharacter ghoul = new GameCharacter("Ghoul",75);

        System.out.println("A scary-looking Ghoul runs towards you. You decide to attack.");

        while (true){

            ghoul.takeDamage(20);
            if (ghoul.getHitPoints() < 0 ){
                System.out.println("Ghoul is dead");
                System.out.println("Dude wins ");
                break;
            }
            dude.takeDamage(20);
            if(dude.getHitPoints() < 0 ) {
                System.out.println("Dude is dead");
                System.out.println("Ghoul wins");
                break;
            }

            System.out.println("Dude hits ghoul for 20 HP. Ghoul has " + ghoul.getHitPoints() + " left");
            System.out.println("Ghoul hits dude for 20 HP. Dude has " + dude.getHitPoints() + " left");


        }


    }
}
