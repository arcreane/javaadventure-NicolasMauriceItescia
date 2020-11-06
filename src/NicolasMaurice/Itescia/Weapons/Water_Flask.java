package NicolasMaurice.Itescia.Weapons;

import NicolasMaurice.Itescia.Main;

public class Water_Flask extends Weapon {

    int damageStacks=0;

    public Water_Flask(){
        damage = 10;
        eventChance = 100;
        eventDescription = "The Wizard is already covered in water, he takes additional damage!";
        weaponName = "Water_Flask";

    }
    //Specs of the Flask
    //Since the Flask will always increase it's damage each round, the event occurs everytime

    @Override
    public void eventEffect() {
        if (!Main.stunStatus) {
            //Does not apply if player is stunned
            if (damageStacks > 0) {
                System.out.println(eventDescription);
                //We make sure it's "invisible" for the player on the first attack
            }
            damage += (damageStacks * 2);
            damageStacks += 1;
        }
    }
    //Damage Scaling event on the Flask
    //The flask damage does not need to be reset each room because the weapon is instantiated on the monster instead of the Hero
}
