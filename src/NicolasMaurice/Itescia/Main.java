package NicolasMaurice.Itescia;



import NicolasMaurice.Itescia.Characters.Barbarian;
import NicolasMaurice.Itescia.Characters.Hero;
import NicolasMaurice.Itescia.Characters.Character;
import NicolasMaurice.Itescia.Weapons.Sword;
import NicolasMaurice.Itescia.Weapons.Weapon;
import NicolasMaurice.Itescia.Room;


import java.util.Scanner;

public class Main {
    public static int roomsCleared = 0;
    public static boolean stunStatus;

    public static Character hero = new Hero();

    public static void main(String[] args) {

        while (roomsCleared<=10){
            Room myRoom = new Room();
            fight(myRoom.i_monster,hero);
            Main.roomsCleared+=1;

        }

    }

    public static void fight(Character monster, Character hero){

        while (monster.hitPoints>0&&hero.hitPoints>0) {
            int tempPlayerLife = hero.hitPoints;
            int tempMonsterLife = monster.hitPoints;
            boolean checkInput;
            System.out.println("to fight the monster, type " + monster.effectiveWeapon.weaponName);
            checkInput = getPlayerInput(monster.effectiveWeapon.weaponName);
            if (checkInput) {
                int monsterEventRoll = (int) (Math.random() * 100);
                if (monster.eventChance>=monsterEventRoll){
                    monster.eventEffect();
                }
                int eventRoll = (int) (Math.random() * 100);
                if (monster.effectiveWeapon.eventChance>= eventRoll){
                    monster.effectiveWeapon.eventEffect();
                }
                if (stunStatus){
                    if(monster.effectiveWeapon.weaponName.equals("Sword")){
                        System.out.println(monster.effectiveWeapon.eventDescription);
                        monster.effectiveWeapon.dealDamage(monster.effectiveWeapon,monster);
                    }
                    if(monster.effectiveWeapon.weaponName.equals("Water_Flask")){
                        System.out.println(monster.event);
                        monster.dealDamage(monster,hero);
                    }
                }

                monster.effectiveWeapon.dealDamage(monster.effectiveWeapon,monster);
                monster.dealDamage(monster,hero);

            }
            if (!checkInput) {
                int monsterEventRoll = (int) (Math.random() * 100);
                if (monster.eventChance>=monsterEventRoll){
                    monster.eventEffect();
                }
                monster.dealDamage(monster,hero);
            }
            if(monster.effectiveWeapon.weaponName.equals("Sword")){
                monster.damage = 15;
            }
            //souts à polish
            System.out.println(hero.hitPoints);
            System.out.println(monster.hitPoints);
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
