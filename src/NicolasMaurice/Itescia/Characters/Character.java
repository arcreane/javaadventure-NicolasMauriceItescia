package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Weapons.Weapon;

public abstract class Character {
    //Generic Character class, used to build the Hero, Wizard and Barbarian using a lot of shared variables
    public int hitPoints;
    public int damage;
    public int eventChance;
    public String event;
    public String name;
    public Weapon effectiveWeapon;
    public String attackLine;

    public abstract void eventEffect();
    //Abstract method to apply events that all have different effects

    public void dealDamage(Character monster, Character hero){
        hero.hitPoints-=monster.damage;
        System.out.println(attackLine);
        System.out.println("You have been hit for "+monster.damage+" damage, you have "+hero.hitPoints+" HP left.");
    }
    //The monster deal damage method

    //To be fair, I could have made a child of character called monster because the hero did not need to inherit some of this stuff
}
