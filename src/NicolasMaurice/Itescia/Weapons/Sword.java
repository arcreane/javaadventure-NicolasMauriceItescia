package NicolasMaurice.Itescia.Weapons;

import NicolasMaurice.Itescia.Characters.Barbarian;
import NicolasMaurice.Itescia.Main;

public class Sword extends Weapon{
    public Sword(){
        damage = 15;
        eventChance = 20;
        eventDescription = "You have stunned your opponent ! You can strike again !";
        weaponName = "Sword";
    }

    @Override
    public void eventEffect() {
        System.out.println(eventDescription);
        Main.stunStatus = true;
    }
}
