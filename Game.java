package thegame;

/**
 *
 * @author Avery Reich-Norris
 */
public class Game {
    public static void playerManager(){
        
    }
    public static void gameManual(){
        System.out.println("Hello " + Library.user + " and welcome to Game Name Here.");
        System.out.println("In this game you will have many choices throughout, but the question you may have is how to make those choices.");
        System.out.println("First you ");
    }
    public static void start(){
        
    }
    public static void findStart(String where){
        if(where.equals("Start;")){
            start();
        }
    }
}
