package NicolasMaurice.Itescia.Weapons;

public class Axe extends Weapon{
    public Axe(){
        damage = 15;
        eventChance = 20;
        eventDescription = "You've stunned your opponent ! You can strike again !";
        weaponName = "Axe";
    }

    @Override
    public void eventEffect() {

    }
}
