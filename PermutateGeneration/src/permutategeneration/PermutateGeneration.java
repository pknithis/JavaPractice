/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutategeneration;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nithishkp
 */
public class PermutateGeneration {

    ArrayList <ArrayList<String>> permute;
    
    PermutateGeneration()
    {
        permute = new ArrayList<ArrayList<String>>();
    }
    void permutate(char c)
    {
        ArrayList <String> at = null;
        ArrayList <String> ot = null;
        
        if(permute.size() == 0)
        {
            ot = new ArrayList<String>();
            ot.add(""+c);
            permute.add(ot);
            return;
        }
        if(permute.size()>0)
        {
            at = permute.get(permute.size()-1);      
            ot = new ArrayList<String>();
        }
        
        for(int i = 0 ; i<at.size();i++)
        {
            StringBuilder sb = new StringBuilder(at.get(i));
            
            for(int j =0;j<sb.length();j++)
            {
               ot.add(sb.substring(0, j)+c+sb.substring(j));
            }
            ot.add(sb+""+c);
        }
        
        permute.add(ot);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PermutateGeneration ob = new PermutateGeneration();
        System.out.println(("Enter the string whose permutation needs to be generated : "));
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        
        for(int i =0 ;i<st.length();i++)
        {
            ob.permutate(st.charAt(i));
        }
        
        for(ArrayList <String>a : ob.permute)
        {
            for(String s:a)
            {
                System.out.println(s);
            }
        }
    }
    
}
