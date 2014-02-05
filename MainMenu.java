package thegame;
import java.util.Scanner;
/**
 *
 * @author Avery Reich-Norris
 */
public class MainMenu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String gameName = "Game Name Here";
        System.out.println("Welocome to " + gameName);
        if(SaveAndLoad.exist("Username")){
            System.out.print("Are you currently a User on this System: ");
            String response = input.nextLine().toLowerCase();
            if(Library.yesAndNo.contains(response)){
                if(response.equals("yes") || response.equals("y")){
                    UserInterface.login();
                }
                else{
                    UserInterface.username();
                    UserInterface.password();
                }
            }
        }
        else{
            UserInterface.username();
            UserInterface.password();
        }
        System.out.println("Welcome " + Library.user);
    }
    
}
