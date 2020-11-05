package NicolasMaurice.Itescia.Characters;

public class Barbarian extends Character {

    public Barbarian(){
        hitPoints = new int[1];
        hitPoints[0] = 20;
        damage = 15;
        eventChance = 30;
        event = "Critical Strike";
        name = new String("Barbarian");
    }
}
