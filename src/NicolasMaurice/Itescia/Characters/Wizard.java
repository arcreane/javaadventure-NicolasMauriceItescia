package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Main;
import NicolasMaurice.Itescia.Weapons.Water_Flask;

public class Wizard extends Character {

    public Wizard(){

         hitPoints = 20;
         damage = 10;
         eventChance = 10;
         event = "You have been paralyzed by the wizard, you cannot move this turn! Yikes!";
         name = "Wizard";
         effectiveWeapon = new Water_Flask();
         attackLine = "The Wizard shoots a lightning bolt your way with his staff! Zap!";
    }
    @Override
    public void eventEffect() {
        System.out.println(event);
        Main.stunStatus = true;
    }




}
