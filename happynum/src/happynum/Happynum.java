/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package happynum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author nithishkp
 */
public class Happynum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            // TODO code application logic here
            Scanner fsc = new Scanner(System.in);
            String filename = fsc.nextLine();
            File f = new File(filename);
            
            FileInputStream fin = new FileInputStream(f);
            Scanner sc = new Scanner(fin);
            
            ArrayList <Integer>ip = new ArrayList<Integer>();
            ArrayList n = new ArrayList(ip);
            while(sc.hasNextLine())
            {
                String input = sc.nextLine();
                ip.add(Integer.parseInt(input));                
            }
            
            Integer  num = 0;
            Integer total = 0;
            
            ArrayList <Integer>tempSeq=new ArrayList<Integer>();
            Integer startNo=0;
            
         for(int i =0;i<ip.size();i++)
         {
             num = startNo = ip.get(i);
             
         while(num != 1 )   
        {
            while(num > 0 )
            {
                Integer temp = num%10;
                total += (temp*temp);
                num=num/10;
            }
            
            num = total;
            total=0;
            
            if(tempSeq.contains((Integer)num))
            {
                System.out.println("unhappy "+(tempSeq.size()+1));
                break;
            }
            tempSeq.add(num);     
        }
         if(num == 1)
         {
             System.out.println("happy "+tempSeq.size());
             
         }
         
         tempSeq = new ArrayList<Integer>();                               
         
         }
         
        } catch (FileNotFoundException ex) {
                    System.out.println("Invalid Inputs");
        }
    }
    
}
