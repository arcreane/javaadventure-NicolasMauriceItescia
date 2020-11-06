package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Weapons.Sword;

public class Barbarian extends Character {

    public Barbarian(){
        hitPoints = 30;
        damage = 15;
        eventChance = 20;
        event = "The Barbarian lands a vicious hit against you, that's a lot of damage!";
        name = "Barbarian";
        effectiveWeapon = new Sword();
        //As explained in Hero class, the weapon is instantiated here
        attackLine = "The Barbarian whoops you with his axe! K-Pow!";
    }
    //Giving specific values to the Barbarian


    @Override
    public void eventEffect() {
        System.out.println(event);
        damage*=2;
    }
    //This is the critical strike effect


}
