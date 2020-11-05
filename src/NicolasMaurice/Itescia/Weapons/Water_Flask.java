package NicolasMaurice.Itescia.Weapons;

public class Water_Flask extends Weapon {

    int damageStacks[]={0};

    public Water_Flask(){
        damage = 10;
        eventChance = 100;
        eventDescription = "The Wizard is already covered in water, he takes additional damage!";
        weaponName = "Water_Flask";

    }

    @Override
    public void eventEffect() {
        System.out.println(eventDescription);
        damage+=(damageStacks[0]*2);
        damageStacks[0]+=1;
    }
}
