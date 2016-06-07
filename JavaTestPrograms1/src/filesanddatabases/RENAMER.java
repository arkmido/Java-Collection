/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesanddatabases;

import java.io.*;
import java.util.Scanner;

public class RENAMER {
    public static void main(String args[]){
        String path = "C:\\Users\\L3000n100\\Desktop\\OTHERS\\CONTACTS\\";
        Scanner sc = new Scanner(System.in);
        
        File f = new File(path);
        
        int ctr = 505;
        
        // manual renaming certain files by input
        if(f.isDirectory()){
            File[] contacts = f.listFiles();
            if(contacts != null){
                for(File c : contacts){
                    String fname = c.getName();
                    if(fname.contains("("+ctr+")")){
                        System.out.println(fname+" rename to: ");
                        String newFname = sc.nextLine();
                        c.renameTo(new File(path+newFname+".vcf"));
                        System.out.println(c.getName());
                        ctr++;
                    }
                }
            }
        }
        
          // renaming filenames with certain substring
//        if(f.isDirectory()){
//            File[] contacts = f.listFiles();
//            if(contacts != null)
//                for(File c : contacts){
//                    ctr++;
//                    String s = c.getName();
//                    if(s.contains("(8)")){
//                        System.out.println(s);
//                        c.renameTo(new File(path+(s.replace("(8)", "_"))));
//                        System.out.println(c.getName());
//                    }
//                }
//        }
        System.out.println(ctr+" files found");
    }
}
