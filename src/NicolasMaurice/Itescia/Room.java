package NicolasMaurice.Itescia;

import NicolasMaurice.Itescia.Characters.Barbarian;
import NicolasMaurice.Itescia.Characters.Character;
import NicolasMaurice.Itescia.Characters.Wizard;


public class Room {

    public Character i_monster;

    public Room(){

        int monsterType = (int) (Math.random() * 2);

        if (monsterType == 0) {
            i_monster = new Wizard();
        } else {
            i_monster = new Barbarian();
        }
        System.out.println("You have cleared "+Main.roomsCleared+" rooms");
        System.out.println("You enter a new room, and encounter a fierce "+i_monster.name);

        if (Main.roomsCleared == 5){
            Main.endGame();
        }





    }
}
