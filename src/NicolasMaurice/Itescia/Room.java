package NicolasMaurice.Itescia;

import NicolasMaurice.Itescia.Characters.Barbarian;
import NicolasMaurice.Itescia.Characters.Character;
import NicolasMaurice.Itescia.Characters.Wizard;


public class Room {

    public Room(){
        if (Main.roomsCleared == 5){
            System.out.println("You have defeated the Dungeon!");
            System.exit(0);
        }
        else {
            Character i_monster;
            int monsterType = (int) (Math.random() * 2);

            if (monsterType == 0) {
                i_monster = new Wizard();
            } else {
                i_monster = new Barbarian();
            }
            System.out.println(i_monster.name);
            Main.roomsCleared+=1;
            System.out.println("You have cleared "+Main.roomsCleared+" rooms");
        }
    }
}
