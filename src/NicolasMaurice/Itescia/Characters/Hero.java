package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Weapons.Sword;
import NicolasMaurice.Itescia.Weapons.Water_Flask;
import NicolasMaurice.Itescia.Weapons.Weapon;

public class Hero extends Character {
    public Hero(){

        hitPoints = 200;
        name = new String("Warrior Queen");
        Weapon axe = new Sword();
        Weapon water_flask = new Water_Flask();
    }

    @Override
    public void eventEffect() {

    }

}
