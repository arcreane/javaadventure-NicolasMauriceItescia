package NicolasMaurice.Itescia.Characters;

import NicolasMaurice.Itescia.Weapons.Weapon;

public abstract class Character {
    public int hitPoints;
    public int damage;
    public int eventChance;
    public String event;
    public String name;
    public Weapon effectiveWeapon;
    public String attackLine;

    public abstract void eventEffect();
    public void dealDamage(Character monster, Character hero){
        hero.hitPoints-=monster.damage;
        System.out.println(attackLine);
        System.out.println("You have been hit for "+monster.damage+" damage, you have "+hero.hitPoints+" HP left.");
    }
}
