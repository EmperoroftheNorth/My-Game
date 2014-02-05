package thegame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
/*
 * @author Avery Reich-Norris
 */
public class SaveAndLoad {
    public static void save(String fileName, String fileData){
        PrintWriter saver = null;
        try{
            saver = new PrintWriter(fileName+".txt", "UTF-8");
        } catch (FileNotFoundException ex) {
            System.out.println("Saving Error 1 Could not save File.");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Saving Error 1 Could not save File.");
        }
        saver.append(fileData);
        saver.close();
    }
    public static ArrayList load(String fileName){
        ArrayList loadedObject = null;
        BufferedReader loader = null;
        String delim = ";";
        try{
            loader =new BufferedReader(new FileReader(fileName+".txt"));
        }
        catch(FileNotFoundException ex){
            System.out.println("Saving Error 2 Could not access File.");
        }
        try{
            loadedObject = new ArrayList(Arrays.asList(loader.readLine().split(delim)));
            loader.close();
        }
        catch(IOException ex){
            System.out.println("Saving Error 2 Could not access File.");
        }
        return loadedObject;
    }
    public static boolean exist(String fileName){
        boolean exist = new File(fileName + ".txt").isFile();
        return exist;
    }
}
