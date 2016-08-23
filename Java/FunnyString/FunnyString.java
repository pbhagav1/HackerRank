
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prasanth_B
 */
public class FunnyString {
    public static void main(String args[]){
        int i, j, diff1, diff2;
        int numOfInpStrings;
        boolean inpStringFunny;
        String[] inpStrings;
        String s, r;
        Scanner in = new Scanner(System.in);
        
        numOfInpStrings = in.nextInt();
        inpStrings = new String[numOfInpStrings];
        for (i=0; i < numOfInpStrings; i++){
            inpStrings[i] = in.next();
        }
        
        for (i=0; i < numOfInpStrings; i++){
            s = inpStrings[i];
            r = new StringBuilder(s).reverse().toString();
            inpStringFunny = true;
            for (j = 1; j < s.length(); j++){
                diff1 = Math.abs(((int) s.charAt(j)) - ((int) s.charAt(j-1)));
                diff2 = Math.abs(((int) r.charAt(j)) - ((int) r.charAt(j-1)));
                if (diff1 != diff2){
                    inpStringFunny = false;
                    break;
                }
            }
            if (inpStringFunny)
                System.out.println("Funny");
            else
                System.out.println("Not Funny");
        }
    }
}
