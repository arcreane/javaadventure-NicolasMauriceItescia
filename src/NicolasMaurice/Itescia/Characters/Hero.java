package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Weapons.Axe;
import NicolasMaurice.Itescia.Weapons.Water_Flask;
import NicolasMaurice.Itescia.Weapons.Weapon;

public class Hero extends Character {
    public Hero(){
        hitPoints = new int[1];
        hitPoints[0] = 200;
        name = new String("Warrior Queen");
        Weapon axe = new Axe();
        Weapon water_flask = new Water_Flask();
    }
}
