package NicolasMaurice.Itescia.Characters;

public class Hero extends Character {
    public Hero(){
        hitPoints = 200;
        name ="Warrior Queen";
    }
    //The warrior has very little to set up.
    //The effective weapons are instantiated on the monster instead of the Hero

    @Override
    public void eventEffect() {

    }
    //This is unneeded as stated previously, the event effect is on the weapons themselves


}
