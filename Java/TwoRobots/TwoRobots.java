import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//public class Solution{
public class TwoRobots {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int i, j, numOfTestCases;
        int[] numOfContainers, numOfQueries;
        int[][] fromContainer, toContainer;
        int r1CurMove, r1NextMove, r2CurMove, r2NextMove, curMoveCost, nextMoveCost, totalDistanceTravelled;
        String inputString;
        
        numOfContainers = new int[50];
        numOfQueries = new int[50];
        fromContainer = new int[50][1000];
        toContainer = new int[50][1000];

        Scanner in = new Scanner(System.in);
        numOfTestCases = in.nextInt();
        for (i=0; i<numOfTestCases; i++){
            numOfContainers [i]= in.nextInt();
            numOfQueries [i] = in.nextInt();
            for (j=0; j< numOfQueries [i]; j++){
                fromContainer [i][j] = in.nextInt();
                toContainer [i][j] = in.nextInt();
            }
        }
        
        Robot r1 = new Robot(1);
        Robot r2 = new Robot(2);
        
        for (i=0; i<numOfTestCases; i++){
            totalDistanceTravelled = 0;
            r1.setCurPosition(0);
            r2.setCurPosition(0);
            for(j=0; j<numOfQueries [i]; j++){
                if (r1.getCurPosition() == 0){

                    //System.out.println("R1 goes from " + r1.getCurPosition() + " container to " + fromContainer[i][j] + " container to " + toContainer[i][j]);

                    r1.setCurPosition(toContainer [i][j]);
                    totalDistanceTravelled += Math.abs(toContainer [i][j] - fromContainer [i][j]);
                    
                    //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);
                }else{
                    if (r2.getCurPosition() == 0){
                        if (j == (numOfQueries [i] - 1)){

                            //System.out.println("R2 goes from " + r2.getCurPosition() + " container to " + fromContainer[i][j] + " container to " + toContainer[i][j]);

                            r2.setCurPosition(toContainer [i][j]);
                            totalDistanceTravelled += Math.abs(toContainer [i][j] - fromContainer [i][j]);
                            
                            //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);
                        }else{
                            if ((j + 1) <= (numOfQueries [i] - 1)){
                                curMoveCost  = Math.abs(toContainer [i][j] - fromContainer [i][j]);
                                nextMoveCost = Math.abs(toContainer [i][j+1] - fromContainer [i][j+1]);
                                r1CurMove  = Math.abs(r1.getCurPosition() - fromContainer [i][j]) + curMoveCost;
                                r2NextMove = nextMoveCost;
                                r2CurMove  = curMoveCost;
                                r1NextMove = Math.abs(r1.getCurPosition() - fromContainer [i][j+1]) + nextMoveCost;
                                
                                if ((r1CurMove + r2NextMove) < (r1NextMove + r2CurMove)){

                                    //System.out.println("R1 goes from " + r1.getCurPosition() + " container to " + fromContainer[i][j] + " container to " + toContainer[i][j]);
                                    totalDistanceTravelled += r1CurMove;
                                    //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);

                                    //System.out.println("R2 goes from " + r2.getCurPosition() + " container to " + fromContainer[i][j+1] + " container to " + toContainer[i][j+1]);
                                    totalDistanceTravelled += r2NextMove;
                                    //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);

                                    r1.setCurPosition(toContainer [i][j]);
                                    r2.setCurPosition(toContainer [i][j+1]);
                                    //totalDistanceTravelled +=  (r1CurMove + r2NextMove);
                                }else{

                                    //System.out.println("R2 goes from " + r2.getCurPosition() + " container to " + fromContainer[i][j] + " container to " + toContainer[i][j]);
                                    totalDistanceTravelled += r2CurMove;
                                    //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);

                                    //System.out.println("R1 goes from " + r1.getCurPosition() + " container to " + fromContainer[i][j+1] + " container to " + toContainer[i][j+1]);
                                    totalDistanceTravelled += r1NextMove;
                                    //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);

                                    r1.setCurPosition(toContainer [i][j+1]);
                                    r2.setCurPosition(toContainer [i][j]);
                                    //totalDistanceTravelled +=  (r1NextMove + r2CurMove);
                                }
                                j++;
                            }else{
                                //System.out.println("This line should never be printed");
                            }
                        }
                    }else{
                        if ((j + 1) <= (numOfQueries [i] - 1)){
                            curMoveCost  = Math.abs(toContainer [i][j] - fromContainer [i][j]);
                            nextMoveCost = Math.abs(toContainer [i][j+1] - fromContainer [i][j+1]);
                            r1CurMove  = Math.abs(r1.getCurPosition() - fromContainer [i][j]) + curMoveCost;
                            r2NextMove = Math.abs(r2.getCurPosition() - fromContainer [i][j+1]) + nextMoveCost;
                            r2CurMove  = Math.abs(r2.getCurPosition() - fromContainer [i][j]) + curMoveCost;
                            r1NextMove = Math.abs(r1.getCurPosition() - fromContainer [i][j+1]) + nextMoveCost;
                            if ((r1CurMove + r2NextMove) < (r1NextMove + r2CurMove)){

                                    //System.out.println("R1 goes from " + r1.getCurPosition() + " container to " + fromContainer[i][j] + " container to " + toContainer[i][j]);
                                    //System.out.println("R2 goes from " + r2.getCurPosition() + " container to " + fromContainer[i][j+1] + " container to " + toContainer[i][j+1]);

                                r1.setCurPosition(toContainer [i][j]);
                                r2.setCurPosition(toContainer [i][j+1]);
                                //totalDistanceTravelled +=  (r1CurMove + r2NextMove);

                                totalDistanceTravelled += r1CurMove;
                                //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);
                                totalDistanceTravelled += r2NextMove;
                                //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);

                            }else{
                                    //System.out.println("R2 goes from " + r2.getCurPosition() + " container to " + fromContainer[i][j] + " container to " + toContainer[i][j]);
                                    //System.out.println("R1 goes from " + r1.getCurPosition() + " container to " + fromContainer[i][j+1] + " container to " + toContainer[i][j+1]);

                                r1.setCurPosition(toContainer [i][j+1]);
                                r2.setCurPosition(toContainer [i][j]);
                                //totalDistanceTravelled +=  (r1NextMove + r2CurMove);
                                
                                totalDistanceTravelled += r2CurMove;
                                //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);
                                totalDistanceTravelled += r1NextMove;
                                //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);

                            }
                            j++;
                        }else{
                            if (j == (numOfQueries [i] - 1)){
                                curMoveCost  = Math.abs(toContainer [i][j] - fromContainer [i][j]);
                                r1CurMove  = Math.abs(r1.getCurPosition() - fromContainer [i][j]) + curMoveCost;
                                r2CurMove  = Math.abs(r2.getCurPosition() - fromContainer [i][j]) + curMoveCost;
                                if (r1CurMove < r2CurMove){

                                    //System.out.println("R1 goes from " + r1.getCurPosition() + " container to " + fromContainer[i][j] + " container to " + toContainer[i][j]);

                                    r1.setCurPosition(toContainer [i][j]);
                                    totalDistanceTravelled +=  r1CurMove;
                                    
                                    //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);
                                }else{

                                    //System.out.println("R2 goes from " + r2.getCurPosition() + " container to " + fromContainer[i][j] + " container to " + toContainer[i][j]);

                                    r2.setCurPosition(toContainer [i][j]);
                                    totalDistanceTravelled +=  r2CurMove;
                                    
                                    //System.out.println("The Total Distance Travelled : " + totalDistanceTravelled);
                                }
                            }
                        }
                    }
                }
            }
            
            System.out.println(totalDistanceTravelled);
        }
    }
}

class Robot{
    private int Id;
    private int curPosition;

    Robot(int inpId){
        this.Id = inpId;
    }

    void setCurPosition(int toPosition){
        this.curPosition = toPosition;
    }
    
    int getCurPosition(){
        return this.curPosition;
    }
}
