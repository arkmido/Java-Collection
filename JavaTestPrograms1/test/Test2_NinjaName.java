/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L3000n100
 */
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.Hashtable;
import java.util.Scanner;

public class Test2_NinjaName {
    private static final Scanner sc = new Scanner(System.in);
    private static Hashtable<Character, String> ninjamap = new Hashtable();

    public static void main(String args[]){
        initchars();
        System.out.println("Your name: ");
        String name = sc.nextLine();
        System.out.println("Your ninja name is: "+ninjaName(name.toLowerCase()));
    }
    private static String ninjaName(String name){
        String ninjaname = "";
        for(int i = 0; i < name.length(); i++){
            ninjaname += ninjamap.get(name.charAt(i));
        }
        return StringUtils.capitalize(ninjaname);
    }
    private static void initchars(){
        ninjamap.put('a', "ka");    ninjamap.put('f', "lu");
        ninjamap.put('b', "zu");    ninjamap.put('g', "ji");
        ninjamap.put('c', "mi");    ninjamap.put('h', "ri");
        ninjamap.put('d', "te");    ninjamap.put('i', "ki");
        ninjamap.put('e', "ku");    ninjamap.put('j', "zu");
        
        ninjamap.put('k', "me");    ninjamap.put('p', "no");
        ninjamap.put('l', "ta");    ninjamap.put('q', "ke");
        ninjamap.put('m', "rin");   ninjamap.put('r', "shi");
        ninjamap.put('n', "to");    ninjamap.put('s', "ari");
        ninjamap.put('o', "mo");    ninjamap.put('t', "chi");
        
        ninjamap.put('u', "do");    
        ninjamap.put('v', "ru");
        ninjamap.put('w', "mei");
        ninjamap.put('x', "na");
        ninjamap.put('y', "fu");
        ninjamap.put('z', "zi");
        ninjamap.put(' ', " ");
    }
}
