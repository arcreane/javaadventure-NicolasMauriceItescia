package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Weapons.Axe;
import NicolasMaurice.Itescia.Weapons.Weapon;

public class Barbarian extends Character {

    public Barbarian(){
        hitPoints = new int[1];
        hitPoints[0] = 30;
        damage = 15;
        eventChance = 30;
        event = "Critical Strike";
        name = new String("Barbarian");
        effectiveWeapon = new Axe();
    }


}
