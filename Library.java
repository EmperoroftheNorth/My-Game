package thegame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Avery Reich-Norris
 */
public class Library {
    public static ArrayList yesAndNo = new ArrayList(Arrays.asList("yes","no","y","n"));
    public static ArrayList illegalCharacters = new ArrayList(Arrays.asList("?",'"',"'","/"));
    public static ArrayList passwords = new ArrayList(SaveAndLoad.load("Password"));
    public static ArrayList usernames = new ArrayList(SaveAndLoad.load("Usernames"));
    public static String playerLocation = stringMaker(SaveAndLoad.load(Library.user + "PlayerLocation"));
    public static String user = null;
    public static String usernameSave = stringMaker(usernames);
    public static String passwordSave = stringMaker(passwords);
    public static ArrayList fourOptions = new ArrayList(Arrays.asList("1","2","3","4"));
    public static ArrayList fiveOptions = new ArrayList(Arrays.asList("1","2","3","4","5"));
    public static ArrayList sixOptions = new ArrayList(Arrays.asList("1","2","3","4","5","6"));
    public static ArrayList useroptions = new ArrayList(Arrays.asList("play game","manage player","change username","change password","exit"));
    public static String stringMaker(ArrayList saveItems){
        String toSave = "";
        for(int i = 0; i < saveItems.size(); i++){
            toSave = toSave + (String) saveItems.get(i) + ";";
        }
        return toSave;
    }
}
