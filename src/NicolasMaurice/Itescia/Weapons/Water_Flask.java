package NicolasMaurice.Itescia.Weapons;

public class Water_Flask extends Weapon {

    int damageStacks=0;

    public Water_Flask(){
        damage = 10;
        eventChance = 100;
        eventDescription = "The Wizard is already covered in water, he takes additional damage!";
        weaponName = "Water_Flask";

    }

    @Override
    public void eventEffect() {
        if (damageStacks>0){
            System.out.println(eventDescription);
        }
        damage+=(damageStacks*2);
        damageStacks+=1;
    }
}
