package NicolasMaurice.Itescia.Weapons;

import NicolasMaurice.Itescia.Main;

public class Sword extends Weapon{
    public Sword(){
        damage = 15;
        eventChance = 10;
        eventDescription = "You have stunned your opponent ! You can strike again ! Go get 'em !";
        weaponName = "Sword";
    }
    //Specs of the sword

    @Override
    public void eventEffect() {
        System.out.println(eventDescription);
        Main.stunStatus = true;
    }
    //Stun event effect
}
