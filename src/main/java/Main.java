import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Weapon m4 = new Weapon("M4",100);
        GameCharacter soldier = new Player("Soldier",5,m4);



        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name: ");
        String name = scanner.nextLine();

        System.out.println(name + "'s HELICOPTER GOT SHOT DOWN IN VIETNAM");
        System.out.println("you are armed with a: " + soldier.getEquippedWeapon());

        int killcount = 0;

        while (true) {

            if (killcount % 4 == 0 && killcount != 0){
                System.out.println("You have the chance to be healed with morphine.");
                System.out.println("Guess a number between 1-4");
                int res = soldier.heal();
                if (res ==1) {
                    System.out.println("You guessed wrong");
                }else{
                    System.out.println("YOU GUESSED RIGHT!!!");
                    System.out.println("Your health is now: "+soldier.getHitPoints());
                }
            }

            GameCharacter vietkong = Npc.spawnNpc();
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


                int damage = attacker.attack(defender);


                System.out.println(attacker.getName() + " hits " + defender.getName() +
                        " with a " + attacker.getEquippedWeapon() +
                        " for " + damage + " HP");


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