package NicolasMaurice.Itescia;

import NicolasMaurice.Itescia.Characters.Hero;
import NicolasMaurice.Itescia.Characters.Character;


import java.util.Scanner;

public class Main {
    public static int roomsCleared;
    public static boolean stunStatus;
    public static Character hero;

    public static void main(String[] args) {

        startGame();

    }

    public static void startGame(){
        hero = new Hero();
        roomsCleared = 0;
        stunStatus = false;
        while (roomsCleared<=5){
            Room myRoom = new Room();
            fight(myRoom.i_monster,hero);
        }
    }

    public static void fight(Character monster, Character hero){

        while (monster.hitPoints>0&&hero.hitPoints>0) {

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
                    monster.dealDamage(monster, hero);
                    monster.effectiveWeapon.dealDamage(monster.effectiveWeapon, monster);
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

            if(monster.hitPoints<=0){
                Main.roomsCleared+=1;
                System.out.println("The monster has been defeated, you may proceed to the next room.");
                if (roomsCleared>=5){
                    System.out.println("Congratulations "+ hero.name+"! You have vanquished the dungeon !");
                    endGame();
                }
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
            startGame();
        }
        else{
            System.out.println("Invalid entry, try again");
        }
    }
}
