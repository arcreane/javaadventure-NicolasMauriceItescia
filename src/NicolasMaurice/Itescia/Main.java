package NicolasMaurice.Itescia;

import NicolasMaurice.Itescia.Characters.Hero;
import NicolasMaurice.Itescia.Characters.Character;
import NicolasMaurice.Itescia.Weapons.Weapon;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static int roomsCleared;
    public static boolean stunStatus;
    public static Character hero;
    //Declaration of variables we'll use throughout the game

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        hero = new Hero();
        roomsCleared = 0;
        stunStatus = false;
        System.out.println("Welcome to the dungeon "+hero.name);
        Scanner sc = new Scanner(System.in);
        int rooms = inputInt("Please choose how many rooms you wish to go through",sc);
        runGame(rooms);
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
        //Biggest method in the project, brace yourselves
        Weapon weapon = monster.effectiveWeapon;
        String weaponName = monster.effectiveWeapon.weaponName;
        //The weapon is instantiated on the monster, more details in Character class
        //These Strings are used a lot in the method, so we shorten them to make it clearer,
        //especially because they reference the monster, making the code confusing to read.
        while (monster.hitPoints>0&&hero.hitPoints>0) {
            //We keep fighting until one of the character dies !
            boolean checkInput;
            stunStatus = false;
            //No chainstun allowed here

            System.out.println("To fight the monster, type " + weaponName);
            checkInput = getPlayerInput(weaponName);
            //We use the getInput method to check if the player writes the correct weapon
            if (checkInput) {
                int monsterEventRoll = (int) (Math.random() * 100);
                if (monster.eventChance>=monsterEventRoll){
                    monster.eventEffect();
                }
                int eventRoll = (int) (Math.random() * 100);
                if (weapon.eventChance>= eventRoll){
                    weapon.eventEffect();
                }
                //We start by checking if player or monster event occurs, and apply it accordingly using the override methods
                if(!stunStatus) {
                    monster.dealDamage(monster, hero);
                    weapon.dealDamage(weapon, monster);
                }
                if (stunStatus){
                    //This is important because both the wizard and the sword can stun the opponent, making it unable to move
                    if(weaponName.equals("Sword")){
                        weapon.dealDamage(weapon,monster);
                    }
                    if(weaponName.equals("Water_Flask")){
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


            if(weaponName.equals("Sword")){
                monster.damage = 15;
                //We reset the Barbarian damage between all rounds since the critical strike doubles it.
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

            //We check if a room is over, and if the game is over, we call the endgame appropriately
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
    public static int inputInt(String prompt, Scanner keyboard) {
        System.out.print(prompt);
        try{
            return keyboard.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Input Mismatch! Please enter a positive number");
            keyboard.next();
            return inputInt(prompt, keyboard);
        }
    }
    //check user input for ints

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
