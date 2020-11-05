package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Weapons.Sword;

public class Barbarian extends Character {

    public Barbarian(){
        hitPoints = 30;
        damage = 15;
        int initialDamage = damage;
        eventChance = 100;
        event = "Critical Strike";
        name = new String("Barbarian");
        effectiveWeapon = new Sword();
    }


    @Override
    public void eventEffect() {
        System.out.println(event);
        damage*=2;
    }



}
