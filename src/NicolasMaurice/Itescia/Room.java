package NicolasMaurice.Itescia;

import NicolasMaurice.Itescia.Characters.Barbarian;
import NicolasMaurice.Itescia.Characters.Character;
import NicolasMaurice.Itescia.Characters.Wizard;
import NicolasMaurice.Itescia.Weapons.Water_Flask;
import NicolasMaurice.Itescia.Weapons.Weapon;


public class Room {

    public Room(){
        Character i_monster;

        int monsterType = (int) (Math.random() * 2);

        if (monsterType == 0) {
            i_monster = new Wizard();
        } else {
            i_monster = new Barbarian();
        }

        if (Main.roomsCleared == 5){
            System.out.println("You have defeated the Dungeon!");
            System.exit(0);
        }
        else {

            Main.roomsCleared+=1;
            System.out.println("You have cleared "+Main.roomsCleared+" rooms");
        }





    }
}
