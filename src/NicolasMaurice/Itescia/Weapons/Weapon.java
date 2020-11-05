package NicolasMaurice.Itescia.Weapons;
import NicolasMaurice.Itescia.Characters.Character;

public abstract  class Weapon {
    public int damage;
    public int eventChance;
    public String eventDescription;
    public String weaponName;

    public abstract void eventEffect();

    public void dealDamage(Weapon i_weaponType, Character i_monster){
        int eventRoll = (int) (Math.random() * 100);
        if (i_weaponType.eventChance>= eventRoll){
            eventEffect();
        }
        i_monster.hitPoints[0]-=i_weaponType.damage;
    }
}
