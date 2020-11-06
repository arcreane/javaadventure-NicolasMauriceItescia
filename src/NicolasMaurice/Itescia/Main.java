package NicolasMaurice.Itescia;

import NicolasMaurice.Itescia.Characters.Hero;
import NicolasMaurice.Itescia.Characters.Character;


import java.util.Scanner;

public class Main {
    public static int roomsCleared;
    public static boolean stunStatus;
    public static Character hero;
    //Declaration of variables we'll use throughout the game

    public static void main(String[] args) {
        startGame();
        runGame(5);
    }

    public static void startGame(){
        hero = new Hero();
        roomsCleared = 0;
        stunStatus = false;
        System.out.println("Welcome to the dungeon "+hero.name);
    }
    //This method starts the game & sets or re-sets all the static variables


    public static void runGame(int nbOfRooms){
        while (roomsCleared<=nbOfRooms){
            Room myRoom = new Room();
            fight(myRoom.i_monster,hero);
        }
    }
    //This method runs the game by creating new rooms and calling the fight method

    public static void fight(Character monster, Character hero){
        //biggest method in the project, brace yourselves
        while (monster.hitPoints>0&&hero.hitPoints>0) {
            //We keep fighting until one of the character dies !
            boolean checkInput;
            //No chainstun allowed here
            stunStatus = false;

            System.out.println("to fight the monster, type " + monster.effectiveWeapon.weaponName);
            checkInput = getPlayerInput(monster.effectiveWeapon.weaponName);
            //We use the getInput method to check if the player writes the correct weapon
            if (checkInput) {
                int monsterEventRoll = (int) (Math.random() * 100);
                if (monster.eventChance>=monsterEventRoll){
                    monster.eventEffect();
                }
                int eventRoll = (int) (Math.random() * 100);
                if (monster.effectiveWeapon.eventChance>= eventRoll){
                    monster.effectiveWeapon.eventEffect();
                }
                //We start by checking if player or monster event occurs, and apply it accordingly using the override methods
                if(!stunStatus) {
                    monster.dealDamage(monster, hero);
                    monster.effectiveWeapon.dealDamage(monster.effectiveWeapon, monster);
                }
                if (stunStatus){
                    //This is important because both the wizard and the sword can stun the opponent, making it unable to move
                    if(monster.effectiveWeapon.weaponName.equals("Sword")){
                        monster.effectiveWeapon.dealDamage(monster.effectiveWeapon,monster);
                    }
                    if(monster.effectiveWeapon.weaponName.equals("Water_Flask")){
                        monster.dealDamage(monster,hero);
                    }
                }
                //We also apply the damage that needs to be applied
            }
            if (!checkInput) {
                //Now we kinda do the same, but the player does not get to attack. Monster events can still apply
                int monsterEventRoll = (int) (Math.random() * 100);
                if (monster.eventChance>=monsterEventRoll){
                    monster.eventEffect();
                }
                monster.dealDamage(monster,hero);
            }


            if(monster.effectiveWeapon.weaponName.equals("Sword")){
                monster.damage = 15;
                //We reset the Barbarian damage between all rounds
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

            //We check if a room is over and if the game is over and call the endgame appropriately
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
    //Method to check user input

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
    //Endgame menu with the possibility to restart it
}
