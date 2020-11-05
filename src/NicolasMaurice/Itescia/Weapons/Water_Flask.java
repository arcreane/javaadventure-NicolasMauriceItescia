package NicolasMaurice.Itescia.Weapons;

public class Water_Flask extends Weapon {
    public Water_Flask(){
        damage = 10;
        eventChance = 100;
        eventDescription = "The Wizard is already covered in water, he takes additional damage!";
        weaponName = "Water_Flask";
    }

    @Override
    public void eventEffect() {

    }
}
