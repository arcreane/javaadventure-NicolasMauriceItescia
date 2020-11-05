package NicolasMaurice.Itescia.Weapons;
import NicolasMaurice.Itescia.Characters.Character;

public abstract  class Weapon {
    public int damage;
    public int eventChance;
    public String eventDescription;
    public String weaponName;

    public abstract void eventEffect();

    public void dealDamage(Weapon i_weaponType, Character i_monster){

        i_monster.hitPoints-=i_weaponType.damage;
    }
}
