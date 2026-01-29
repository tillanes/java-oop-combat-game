import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Weapon m4 = new Weapon("M4",20);
        GameCharacter soldier = new Player("Soldier",100,m4);


        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name: ");
        String name = scanner.nextLine();

        System.out.println( name +"'s HELICOPTER GOT SHOT DOWN IN VIETNAM");
        System.out.println("you are armed with a: "+soldier.getEquippedWeapon());



        int killcount = 0;
        while (true) {
            GameCharacter vietkong = new Npc("Vietkong", 50);
            System.out.println("\nA VIETKONG SOLDIER SPOTTED YOU");
            System.out.println("Vietkong is armed with: "+vietkong.getEquippedWeapon());


            while (true) {
                System.out.print("press f to surrender or s to shoot: ");
                String inpt = scanner.nextLine();

                if (Objects.equals(inpt, "f")) {
                    System.out.println("You surrendered");
                    System.exit(0);
                }

                soldier.attack(vietkong);

                if (vietkong.getHitPoints() <= 0) {
                    System.out.println("vietkong is dead");
                    killcount++;
                    System.out.println("Kill count: " + killcount);
                    break;
                }

                System.out.println("Vietkong health: " + vietkong.getHitPoints());
                vietkong.attack(soldier);

                if (soldier.getHitPoints() <= 0) {
                    System.out.println("soldier is dead");
                    System.out.println("Vietnam wins");
                    System.out.println("Final kill count: "+killcount);
                    System.exit(0);
                }

                System.out.println("Soldier health: " + soldier.getHitPoints());
            }


            System.out.println("Your health is: " +soldier.getHitPoints());
            System.out.print("Do you want to continue? (yes/no): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("USA wins!");
                System.out.println("Final kill count: "+killcount);
                break;
            }
        }

        scanner.close();
    }
}