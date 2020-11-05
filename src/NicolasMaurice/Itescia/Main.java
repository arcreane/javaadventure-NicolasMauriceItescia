package NicolasMaurice.Itescia;



import NicolasMaurice.Itescia.Characters.Hero;
import NicolasMaurice.Itescia.Characters.Character;
import NicolasMaurice.Itescia.Weapons.Weapon;
import NicolasMaurice.Itescia.Room;


import java.util.Scanner;

public class Main {
    public static int roomsCleared = 0;

    public static void main(String[] args) {
        Character hero = new Hero();
        while (roomsCleared<=5){
            Room myRoom = new Room();
            fight(myRoom.i_monster,hero);
        }

    }

    public static void fight(Character monster, Character hero){
        while (monster.hitPoints[0]>0&&hero.hitPoints[0]>0) {
            boolean check;
            System.out.println("to fight the monster, type " + monster.effectiveWeapon.weaponName);
            check = getPlayerInput(monster.effectiveWeapon.weaponName);
            if (check) {
                hero.hitPoints[0] -= monster.damage;
                monster.hitPoints[0] -= monster.effectiveWeapon.damage;
            }
            if (!check) {
                hero.hitPoints[0] -= monster.damage;
            }
            System.out.println(hero.hitPoints[0]);
            System.out.println(monster.hitPoints[0]);
        }
    }

    public static boolean getPlayerInput(String expectedString){
        Scanner sc = new Scanner(System.in);
        String userWord = sc.nextLine();
        if (userWord.equals(expectedString)){
            System.out.println("Correct Input");
            return true;
        }
        else{
            System.out.println("Incorrect input");
            return false;
        }
    }
}
