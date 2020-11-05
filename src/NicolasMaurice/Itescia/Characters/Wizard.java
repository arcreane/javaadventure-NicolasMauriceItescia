package NicolasMaurice.Itescia.Characters;

public class Wizard extends Character {

    public Wizard(){
         hitPoints = new int[1];
         hitPoints[0] = 100;
         damage = 10;
         eventChance = 20;
         event = "Paralysis";
         name = new String("Wizard");
         effectiveWeapon = "Water_Flask";
    }



}
