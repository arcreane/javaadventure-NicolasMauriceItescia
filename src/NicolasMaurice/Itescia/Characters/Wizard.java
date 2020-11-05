package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Weapons.Water_Flask;
import NicolasMaurice.Itescia.Weapons.Weapon;

public class Wizard extends Character {

    public Wizard(){
         hitPoints = new int[1];
         hitPoints[0] = 20;
         damage = 10;
         eventChance = 20;
         event = "Paralysis";
         name = new String("Wizard");
         effectiveWeapon = new Water_Flask();
    }



}
