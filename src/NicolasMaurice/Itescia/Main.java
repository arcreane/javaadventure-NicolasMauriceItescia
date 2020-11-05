package NicolasMaurice.Itescia;

import NicolasMaurice.Itescia.Characters.Hero;
import NicolasMaurice.Itescia.Characters.Character;


import java.util.Scanner;

public class Main {
    public static int roomsCleared = 0;
    public static boolean stunStatus;

    public static Character hero = new Hero();

    public static void main(String[] args) {

        while (roomsCleared<=5){
            Room myRoom = new Room();
            fight(myRoom.i_monster,hero);

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
                if(!stunStatus) {
                    monster.effectiveWeapon.dealDamage(monster.effectiveWeapon, monster);
                    monster.dealDamage(monster, hero);
                }
                if (stunStatus){
                    if(monster.effectiveWeapon.weaponName.equals("Sword")){
                        monster.effectiveWeapon.dealDamage(monster.effectiveWeapon,monster);
                    }
                    if(monster.effectiveWeapon.weaponName.equals("Water_Flask")){
                        monster.dealDamage(monster,hero);
                    }
                }



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

            if(monster.hitPoints<=0){
                Main.roomsCleared+=1;
                System.out.println("The monster has been defeated, you may proceed to the next room.");
                break;
            }
            if(hero.hitPoints<=0){
                System.out.println("You are dead. The game is now over.");
                endGame();
                break;
            }
        }

    }

    public static boolean getPlayerInput(String expectedString){
        Scanner sc = new Scanner(System.in);
        String userWord = sc.nextLine();
        if (userWord.equals(expectedString)){
            //System.out.println("Your attack lands!");
            return true;
        }
        else{
            System.out.println("You've fumbled your attack, and are now opened and exposed. Brace for impact !");
            return false;
        }
    }

    public static void endGame(){
        System.out.println("Do you wanna play again ?");
        System.out.println("press c to continue playing, or q to quit");
        Scanner sc = new Scanner(System.in);
        String userWord = sc.nextLine();
        if (userWord.equals("q")){
            System.out.println("Thank you for playing !");
            System.exit(0);
        }
        if (userWord.equals("c")){
            System.out.println("Let's go again");
            roomsCleared=0;
            hero.hitPoints=200;
        }
        else{
            System.out.println("Invalid entry, try again");
        }
    }
}
