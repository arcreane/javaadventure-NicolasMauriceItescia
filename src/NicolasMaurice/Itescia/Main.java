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
            

        }

    }

    public void roomGeneration(){
        Room myNewRoom = new Room();
    }

    public void fight(Character monster, Character hero){

        getPlayerInput(monster.effectiveWeapon.weaponName);
        if (true){
            hero.hitPoints[0]-= monster.damage;
            monster.hitPoints[0]-=monster.effectiveWeapon.damage;
        }
        if (false){
            hero.hitPoints[0]-= monster.damage;
        }
        System.out.println(hero.hitPoints);
        System.out.println(monster.hitPoints);

    }

    public boolean getPlayerInput(String expectedString){
        Scanner sc = new Scanner(System.in);
        String userWord = sc.nextLine();
        if (userWord==expectedString){
            return true;
        }
        else{
            System.out.println("Incorrect input");
            return false;
        }
    }
}
