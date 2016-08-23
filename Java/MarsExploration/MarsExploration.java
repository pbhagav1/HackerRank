
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
public class MarsExploration {
    public static void main(String args[]){
        String inpString, subStr;
        int i, j, numOfCorruptedChars;
        Scanner in = new Scanner(System.in);
        inpString = in.next();
        numOfCorruptedChars = 0;
        for(i=0; i < inpString.length(); i = i + 3){
            subStr = inpString.substring(i, i + 3);
            for (j = 0; j < 3; j++){
                switch(j){
                    case 0:
                    case 2:
                        if (subStr.charAt(j) != 'S')
                           numOfCorruptedChars++;
                        break;
                    case 1:
                        if (subStr.charAt(j) != 'O')
                            numOfCorruptedChars++;
                        break;
                }
            }
        }
        System.out.println(numOfCorruptedChars);
    }
}
