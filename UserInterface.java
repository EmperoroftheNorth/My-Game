package thegame;
import java.util.Scanner;
/**
 *
 * @author Avery Reich-Norris
 */
public class UserInterface {
    public static void username(){
        Scanner input = new Scanner(System.in);
        String username;
        String check;
        String response;
        boolean stay;
        while(true){
            SaveAndLoad.save("Username", "");
            System.out.print("Please Enter your New Username: ");
            username = input.nextLine();
            System.out.print("\nPlease Re-Enter your New Username: ");
            check = input.nextLine();
            if(username.equals(check)){
                if(Library.illegalCharacters.contains(check)){
                    System.out.println("System Error 3 Contains illegal characters.");
                    System.out.println("Cannot contain the following: " + Library.illegalCharacters.toArray().toString());
                }
                else{
                    stay = true;
                    while(stay){
                        System.out.println("Your Username is " + username);
                        System.out.print("Would you like to keep it: ");
                        response = input.nextLine().toLowerCase();
                        if(Library.yesAndNo.contains(response)){
                            stay = false;
                            if(response.equals("yes") || response.equals("y")){
                                Library.user = username;
                                Library.usernames.add(username);
                                SaveAndLoad.save("Username", Library.usernameSave);
                            }
                            else{
                                System.out.println("Please try again.\n");
                            }
                        }
                        else{
                            System.out.println("\nSystem Error 1 Incorrect Input Please enter 'yes, no, y, or n'");
                        }
                    }
                }
            }
            else{
                System.out.println("\nSystem Error 1 Incorrect Inputs Username inputs did not match.\nPlease try again\n");
            }
        }
    }
    public static void password(){
        SaveAndLoad.save("Username", "");
        Scanner input = new Scanner(System.in);
        String password;
        String check;
        String response;
        boolean stay = true;
        while(true){
            System.out.print("Please Enter your New Password: ");
            password = input.nextLine();
            System.out.print("\nPlease Re-Enter your New Password: ");
            check = input.nextLine();
            if(password.equals(check)){
                if(Library.illegalCharacters.contains(check)){
                    System.out.println("System Error 3 Contains illegal characters.");
                    System.out.println("Cannot contain the following: " + Library.illegalCharacters.toArray().toString());
                }
                else{
                    while(stay){
                        System.out.println("Your Password is " + password);
                        System.out.print("Would you like to keep it: ");
                        response = input.nextLine().toLowerCase();
                        if(Library.yesAndNo.contains(response)){
                            stay = false;
                            if(response.equals("yes") || response.equals("y")){
                                Library.passwords.add(password);
                                SaveAndLoad.save("Password", Library.passwordSave);
                            }
                            else{
                                System.out.println("Please try again.\n");
                            }
                        }
                        else{
                            System.out.println("\nSystem Error 1 Incorrect Input Please enter 'yes, no, y, or n'\nPlease try again");
                        }
                    }
                }
            }
            else{
                System.out.println("\nSystem Error 1 Incorrect Input Password inputs did not match.\nPlease try again\n");
            }
        }
    }
    public static void login(){
        Scanner input = new Scanner(System.in);
        int attempts = 5;
        String username;
        String password;
        int userNum;
        int passNum;
        while(true){
            System.out.print("Username: ");
            username = input.nextLine();
            userNum = Library.usernames.indexOf(username);
            System.out.print("\nPassword: ");
            password = input.nextLine();
            passNum = Library.passwords.indexOf(password);
            if(userNum == passNum && userNum != -1){
                Library.user = username;
            }
            else{
                System.out.println("System Error 2 Incorrect Username and Password combination");
                System.out.println("You have " + attempts + "attempts left");
                if(attempts == 0){
                    Exit.exit(2);
                }
            }
            attempts = attempts - 1;
        }
    }
    public static void options(){
        boolean stay = true;
        Scanner input = new Scanner(System.in);
        String response;
        while(stay){
            System.out.println(">Play Game(1)\n>Manage Player(2)\n>Manual(3)\n>Change Username(4)\n>Change Password(5)\n>Exit(6)");
            response = input.nextLine();
            response = response.toLowerCase();
            if(Library.sixOptions.contains(response)|| Library.useroptions.contains(response)){
                if(response.equals("1") || response.equals("play game")){
                    if(SaveAndLoad.exist(Library.user + "PlayerLocation")){
                        Game.findStart(Library.playerLocation);
                    }
                    else{
                        Game.playerManager();
                        Game.start();
                    }
                }
                else if(response.equals("2") || response.equals("manage player")){
                    if(SaveAndLoad.exist(Library.user + "Player")){
                        Game.playerManager();
                    }
                    else{
                        System.out.println("Sorry there is not a Player for this User on this system.");
                    }
                }
                else if(response.equals("3") || response.equals("manual")){
                    Game.gameManual();
                }
                else if(response.equals("4") || response.equals("change username")){
                    changeUsername();
                }
                else if(response.equals("5") || response.equals("change password")){
                    changePassword();
                }
                else{
                    
                }
            }
        }
    }
    public static void changeUsername(){
        Scanner input = new Scanner(System.in);
        String currentUser;
        String username;
        String check;
        String response;
        boolean stay;
        while(true){
            System.out.print("Please Enter your Current Username: ");
            currentUser = input.nextLine();
            System.out.print("Please Enter your New Username: ");
            username = input.nextLine();
            System.out.print("\nPlease Re-Enter your New Username: ");
            check = input.nextLine();
            if(Library.user.equals(currentUser)){
                if(username.equals(check)){
                    if(Library.illegalCharacters.contains(check)){
                        System.out.println("System Error 3 Contains illegal characters.");
                        System.out.println("Cannot contain the following: " + Library.illegalCharacters.toArray().toString());
                    }
                    else{
                       stay = true;
                       while(stay){
                           System.out.println("Your Username is " + username);
                           System.out.print("Would you like to keep it: ");
                           response = input.nextLine().toLowerCase();
                           if(Library.yesAndNo.contains(response)){
                               stay = false;
                               if(response.equals("yes") || response.equals("y")){
                                   Library.user = username;
                                   Library.usernames.set(Library.usernames.indexOf(currentUser), check);
                                   SaveAndLoad.save("Username", Library.usernameSave);
                               }
                               else{
                                   System.out.println("Please try again.\n");
                               }
                           }
                           else{
                               System.out.println("\nSystem Error 1 Incorrect Input Please enter 'yes, no, y, or n'");
                           }
                       }
                    }
                }
                else{
                    System.out.println("\nSystem Error 1 Incorrect Username inputs did not match.\nPlease try again\n");
                }
            }
            else{
                System.out.println("\nSystem Error 4 Incorrect Current Username input is incorrect.\nPlease try again\n");
            }
        }
    }
    public static void changePassword(){
        Scanner input = new Scanner(System.in);
        String currentPass;
        String password;
        String check;
        String response;
        boolean stay;
        while(true){
            System.out.print("Please Enter your Current Password: ");
            currentPass = input.nextLine();
            System.out.print("Please Enter your New Password: ");
            password = input.nextLine();
            System.out.print("\nPlease Re-Enter your New Password: ");
            check = input.nextLine();
            if(Library.passwords.contains(currentPass)){
                if(password.equals(check)){
                    if(Library.illegalCharacters.contains(check)){
                        System.out.println("System Error 3 Contains illegal characters.");
                        System.out.println("Cannot contain the following: " + Library.illegalCharacters.toArray().toString());
                    }
                    else{
                       stay = true;
                       while(stay){
                           System.out.println("Your Password is " + password);
                           System.out.print("Would you like to keep it: ");
                           response = input.nextLine().toLowerCase();
                           if(Library.yesAndNo.contains(response)){
                               stay = false;
                               if(response.equals("yes") || response.equals("y")){
                                   Library.passwords.set(Library.passwords.indexOf(currentPass), check);
                                   SaveAndLoad.save("Password", Library.passwordSave);
                               }
                               else{
                                   System.out.println("Please try again.\n");
                               }
                           }
                           else{
                               System.out.println("\nSystem Error 1 Incorrect Input Please enter 'yes, no, y, or n'");
                           }
                       }
                    }
                }
                else{
                    System.out.println("\nSystem Error 1 Incorrect Password inputs did not match.\nPlease try again\n");
                }
            }
            else{
                System.out.println("\nSystem Error 4 Incorrect Current Password input is incorrect.\nPlease try again\n");
            }
        }
    }
}
