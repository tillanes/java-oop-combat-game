import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Weapon m4 = new Weapon("M4",50);

        Weapon knife = new Weapon("knife",10);

        GameCharacter soldier = new Player("Soldier",80,m4);

        soldier.setWeapons(knife);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println(name + "'s HELICOPTER GOT SHOT DOWN IN VIETNAM");
        System.out.println("You are armed with a: " + soldier.getEquippedWeapon());

        int killcount = 0;
        Weapon vapen = null;
        while (true) {

            if (killcount % 4 == 0 && killcount != 0) {
                System.out.println("You have the chance to be healed with morphine.");
                System.out.println("Guess a number between 1-4");
                int res = soldier.heal();
                if (res == 1) {
                    System.out.println("You guessed wrong.");
                } else {
                    System.out.println("YOU GUESSED RIGHT!!! Your health is now: " + soldier.getHitPoints());
                }
            }

            GameCharacter vietkong = Npc.spawnNpc();
            String enemyName = vietkong.getName();

            System.out.println("A " + enemyName + " SPOTTED YOU");
            System.out.println(enemyName + " is armed with: " + vietkong.getEquippedWeapon());

            GameCharacter attacker = soldier;
            GameCharacter defender = vietkong;


            while (defender.getHitPoints() > 0) {

                int damage = 0;

                if (attacker == soldier) {
                    System.out.println(soldier.getWeapons());
                    System.out.print("Choose weapon to attack with. Enter 99 to surrender: ");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 99) {
                        System.out.println("You surrendered.");
                        System.exit(0);
                    }

                    Weapon weapon = soldier.chooseGun(choice);
                    vapen = weapon;
                    damage = attacker.attack(defender, weapon);
                } else {

                    damage = attacker.attack(defender, vietkong.GetGun());
                }

                if (defender == vietkong) {
                    System.out.println(attacker.getName() + " hits " + defender.getName() +
                            " with a " + vapen.getName() +
                            " for " + damage + " HP");
                } else{
                    System.out.println(attacker.getName() + " hits " + defender.getName() +
                            " with a " + attacker.getEquippedWeapon() +
                            " for " + damage + " HP");
                }
                if (defender.getHitPoints() <= 0) {
                    if (defender == vietkong) {
                        System.out.println(enemyName + " is dead.");
                        System.out.println(enemyName+" dropped their "+vietkong.getEquippedWeapon());
                        System.out.println("press (a) to add  "+vietkong.getEquippedWeapon() +" to inventory, (q) for no.");
                        String inpt = scanner.nextLine();
                        if (inpt.equalsIgnoreCase("a")){
                            soldier.setWeapons(vietkong.GetGun());
                        }
                        killcount++;
                        System.out.println("Kill count: " + killcount);
                        break;
                    } else {
                        System.out.println("Soldier is dead.");
                        System.out.println("Vietnam wins");
                        System.out.println("Final kill count: " + killcount);
                        System.exit(0);
                    }
                }

                System.out.println(defender.getName() + " health: " + defender.getHitPoints());

                // Swap
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