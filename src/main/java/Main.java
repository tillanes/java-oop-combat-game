import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Weapon m4 = new Weapon("M4",20);
        GameCharacter soldier = new Player("Soldier",100,m4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name: ");
        String name = scanner.nextLine();

        System.out.println(name + "'s HELICOPTER GOT SHOT DOWN IN VIETNAM");
        System.out.println("you are armed with a: " + soldier.getEquippedWeapon());

        int killcount = 0;

        while (true) {

            GameCharacter vietkong = new Npc("Vietkong", 50);
            String enemyName = (vietkong.getName());
            System.out.println("A "+enemyName+" SPOTTED YOU");
            System.out.println(enemyName+" is armed with: " + vietkong.getEquippedWeapon());


            GameCharacter attacker = soldier;
            GameCharacter defender = vietkong;

            while (true) {

                if (attacker == soldier) {
                    System.out.print("press f to surrender or Enter to shoot: ");
                    String inpt = scanner.nextLine();

                    if (Objects.equals(inpt, "f")) {
                        System.out.println("You surrendered");
                        System.exit(0);
                    }
                }


                attacker.attack(defender);


                if (defender.getHitPoints() <= 0) {
                    if (defender == vietkong) {
                        System.out.println(enemyName+" is dead");
                        killcount++;
                        System.out.println("Kill count: " + killcount);
                        break;
                    } else {
                        System.out.println("soldier is dead");
                        System.out.println("Vietnam wins");
                        System.out.println("Final kill count: " + killcount);
                        System.exit(0);
                    }
                }

                System.out.println(defender.getName() + " health: " + defender.getHitPoints());


                GameCharacter temp = attacker;
                attacker = defender;
                defender = temp;
            }

            System.out.println("Your health is: " + soldier.getHitPoints());
            System.out.print("Do you want to continue? (y/n): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("y")) {
                System.out.println("USA wins!");
                System.out.println("Final kill count: " + killcount);
                break;
            }
        }

        scanner.close();
    }
}