package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Main;
import NicolasMaurice.Itescia.Weapons.Water_Flask;
import NicolasMaurice.Itescia.Weapons.Weapon;

public class Wizard extends Character {

    public Wizard(){

         hitPoints = 20;
         damage = 10;
         eventChance = 20;
         event = "Paralysis";
         name = new String("Wizard");
         effectiveWeapon = new Water_Flask();
    }
    @Override
    public void eventEffect() {
        System.out.println(event);
        Main.stunStatus = true;
    }




}
