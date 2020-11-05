package NicolasMaurice.Itescia;



import java.util.Scanner;

public class Main {
    public static int roomsCleared = 0;

    public static void main(String[] args) {
        while (roomsCleared<=5){
            Room myRoom = new Room();
        }

    }

    public boolean getPlayerInput(String expectedString){
        Scanner sc = new Scanner(System.in);
        String userWord = sc.nextLine();
        if (userWord==expectedString){
            return true;
        }
        else{
            System.out.println("Incorrect input");
            return false;
        }
    }
}
