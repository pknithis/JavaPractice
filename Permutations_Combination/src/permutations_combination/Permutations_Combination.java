/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutations_combination;

/**
 *
 * @author nithishkp
 */
public class Permutations_Combination {
    
    public static void generateSubsets(char set[])
    {
        int powerSet = (int)Math.pow(2, set.length);
        
        for(int i = 0;i<powerSet;i++)
        {
            int count = 0;
            int mask = 0x01;
            while(count<Integer.SIZE)
            {
                if((i & mask)>0 )
                {
                    System.out.print(set[count]+"");
                }
                
                count++;
                mask = mask<<1;
            }
            System.out.println();            
        }
    }
    public static void generateCombinations(char set[],int start,StringBuilder out)
    {
        for(int i = start;i<set.length;i++)
        {
            out.append(set[i]);
            System.out.println(out);
            if(i<set.length)
                generateCombinations(set,i+1,out);
            out.setLength(out.length()-1);
        }        
    }
    public static void generatePermutation(String prefix,String input)
    {
        if(input.length() == 0)
        {
            System.out.println(prefix);
        }
        else
        {
            for(int i=0;i<input.length();i++)
            {
                generatePermutation(prefix+input.charAt(i), input.substring(0,i)+input.substring(i+1));
            }
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char nums[]={'A','B','C'};
        System.out.println("Power Set");
        generateSubsets(nums);
        System.out.println("Combination");
        generateCombinations(nums, 0,new StringBuilder());
        System.out.println("Permutation");
        generatePermutation("", "ABC");
    }
    
}
