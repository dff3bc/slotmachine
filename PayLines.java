//Copyright 2016, Dustin Evans, All rights reserved.

package slotmachine;

/**
 *
 * @author dustinevans
 */
public class PayLines
{
    private String[][] spread;
    private int quickHits=0;
    private int bonus=0;
    private String[][] paylinex = new String[30][5];
    //payout will be ($1.5 ^ (index of the winning paychart line)) * bet
    //FIXME additional wild paychart will have to be created
    private String[][] paychart = 
    {
        {"Cherry","Cherry","Cherry","Cherry","Cherry"},
        {"Bell","Bell","Bell","Bell","Bell"},
        {"Bar","Bar","Bar","Bar","Bar"},
        {"5Bar","5Bar","5Bar","5Bar","5Bar"},
        {"7","7","7","7","7"},
        {"77","77","77","77","77"},
        {"777","777","777","777","777"},
        {"Wild","Wild","Wild","Wild","Wild"} 
    };
    
    private double[] winnings = new double[30];
    private int[] winningLines = new int[30];
    
    
    public PayLines()
    {
        //throw new Exception("Call attendant for repair.");
    }
    
    public PayLines(String[][] s)
    {
        spread=s;
    }
    
    public void calculateQuickHits()
    {
        for(int y=0;y<3;y++)
        {
            for(int x=0;x<5;x++)
            {
                if(spread[y][x].equals("QuickHit"))
                {
                    this.quickHits++;
                }
            }
        }
    }
    
    public void calculateBonus()
    {
        for(int y=0;y<3;y++)
        {
            for(int x=0;x<5;x++)
            {
                if(spread[y][x].equals("Bonus"))
                {
                    this.bonus++;
                }
            }
        }
    }
    
    public int getQuickHits()
    {
        return this.quickHits;
    }
    
    public boolean getBonus()
    {
        if(this.bonus==3)
        {
            return true;
        }
        
        return false;
    }
    
    
    //TODO add methods that total up and return the winnings
    //TODO add method that returns winning lines array
    //TODO remove all print statements from code.
    public void calculateWins()
    {
        //pupolaute the paylinex with the current symbols
        this.createPaylines();
        //compare paychart to paylinex
        int index=0;
        int winindex=0;
        int paynum=0;
        int currentPayLine=1;
        for(String[] paychartline:paychart)
        {
            currentPayLine=1;
            for(String[] payline:paylinex)
            {
                paynum=this.checkWin(paychartline, payline);
                if(paynum!=0)
                {
                    winnings[winindex]=Math.pow(1.5, index)*paynum;
                    System.out.println("Pay: "+Math.pow(1.5, index)*paynum+" Pay index: "+index + " Paynum: "+paynum);
                    winindex++;
                    System.out.print(currentPayLine+" ");
                }
                
                currentPayLine++;
            }
            index++;
        }
        System.out.print("[");
        for(double d:winnings)
        {
            if(d!=0.0)
            {
                System.out.print(d+",");
            }
        }
        System.out.println("]");
    }
    
    public int checkWin(String[] one, String[] two)
    {
        //Only 3 symbols match
        if(
                one[0].equals(two[0]) 
                && one[1].equals(two[1]) 
                && one[2].equals(two[2]) 
                && !one[3].equals(two[3])
                && !one[4].equals(two[4])
                )
        {
            return 1;
        }
        //Only 4 symbols match
        else if(
                one[0].equals(two[0]) 
                && one[1].equals(two[1]) 
                && one[2].equals(two[2]) 
                && one[3].equals(two[3])
                && !one[4].equals(two[4])
                )
        {
            return 2;
        }
        //All 5 symbols match
        else if(
                one[0].equals(two[0]) 
                && one[1].equals(two[1]) 
                && one[2].equals(two[2]) 
                && one[3].equals(two[3])
                && one[4].equals(two[4])
                )
        {
            return 3;
        }
        return 0;
    }
    
    public void reset()
    {
        this.quickHits=0;
        this.bonus=0;
    }
    
    public String[][] getPaylines()
    {
        return this.paylinex;
    }
    
    public void createPaylines()
    {
        //Line 1
        paylinex[0][0]=spread[1][0];
        paylinex[0][1]=spread[1][1];
        paylinex[0][2]=spread[1][2];
        paylinex[0][3]=spread[1][3];
        paylinex[0][4]=spread[1][4];
        
        //Line2
        paylinex[1][0]=spread[0][0];
        paylinex[1][1]=spread[0][1];
        paylinex[1][2]=spread[0][2];
        paylinex[1][3]=spread[0][3];
        paylinex[1][4]=spread[0][4];
        
        //Line 3
        paylinex[2][0]=spread[2][0];
        paylinex[2][1]=spread[2][1];
        paylinex[2][2]=spread[2][2];
        paylinex[2][3]=spread[2][3];
        paylinex[2][4]=spread[2][4];
        
        //Line 4
        paylinex[3][0]=spread[0][0];
        paylinex[3][1]=spread[1][1];
        paylinex[3][2]=spread[2][2];
        paylinex[3][3]=spread[1][3];
        paylinex[3][4]=spread[0][4];
        
        //Line 5
        paylinex[4][0]=spread[2][0];
        paylinex[4][1]=spread[1][1];
        paylinex[4][2]=spread[0][2];
        paylinex[4][3]=spread[1][3];
        paylinex[4][4]=spread[2][4];
        
        //Line 6
        paylinex[5][0]=spread[1][0];
        paylinex[5][1]=spread[0][1];
        paylinex[5][2]=spread[0][2];
        paylinex[5][3]=spread[0][3];
        paylinex[5][4]=spread[1][4];
        
        //Line 7
        paylinex[6][0]=spread[1][0];
        paylinex[6][1]=spread[2][1];
        paylinex[6][2]=spread[2][2];
        paylinex[6][3]=spread[2][3];
        paylinex[6][4]=spread[1][4];
        
        //Line 8
        paylinex[7][0]=spread[0][0];
        paylinex[7][1]=spread[0][1];
        paylinex[7][2]=spread[1][2];
        paylinex[7][3]=spread[2][3];
        paylinex[7][4]=spread[2][4];
        
        //Line 9
        paylinex[8][0]=spread[2][0];
        paylinex[8][1]=spread[2][1];
        paylinex[8][2]=spread[1][2];
        paylinex[8][3]=spread[0][3];
        paylinex[8][4]=spread[0][4];
        
        //Line 10
        paylinex[9][0]=spread[1][0];
        paylinex[9][1]=spread[0][1];
        paylinex[9][2]=spread[1][2];
        paylinex[9][3]=spread[0][3];
        paylinex[9][4]=spread[1][4];
        
        //Line 11
        paylinex[10][0]=spread[1][0];
        paylinex[10][1]=spread[2][1];
        paylinex[10][2]=spread[1][2];
        paylinex[10][3]=spread[2][3];
        paylinex[10][4]=spread[1][4];
        
        //Line 12
        paylinex[11][0]=spread[0][0];
        paylinex[11][1]=spread[1][1];
        paylinex[11][2]=spread[1][2];
        paylinex[11][3]=spread[1][3];
        paylinex[11][4]=spread[2][4];
        
        //Line 13
        paylinex[12][0]=spread[1][0];
        paylinex[12][1]=spread[2][1];
        paylinex[12][2]=spread[2][2];
        paylinex[12][3]=spread[2][3];
        paylinex[12][4]=spread[0][4];
        
        //Line 14
        paylinex[13][0]=spread[1][0];
        paylinex[13][1]=spread[1][1];
        paylinex[13][2]=spread[0][2];
        paylinex[13][3]=spread[1][3];
        paylinex[13][4]=spread[2][4];
        
        //Line 15
        paylinex[14][0]=spread[1][0];
        paylinex[14][1]=spread[1][1];
        paylinex[14][2]=spread[2][2];
        paylinex[14][3]=spread[1][3];
        paylinex[14][4]=spread[0][4];
        
        //Line 16
        paylinex[15][0]=spread[0][0];
        paylinex[15][1]=spread[1][1];
        paylinex[15][2]=spread[0][2];
        paylinex[15][3]=spread[1][3];
        paylinex[15][4]=spread[0][4];
        
        //Line 17
        paylinex[16][0]=spread[2][0];
        paylinex[16][1]=spread[1][1];
        paylinex[16][2]=spread[2][2];
        paylinex[16][3]=spread[1][3];
        paylinex[16][4]=spread[2][4];
        
        //Line 18
        paylinex[17][0]=spread[0][0];
        paylinex[17][1]=spread[0][1];
        paylinex[17][2]=spread[2][2];
        paylinex[17][3]=spread[0][3];
        paylinex[17][4]=spread[0][4];
        
        //Line 19
        paylinex[18][0]=spread[2][0];
        paylinex[18][1]=spread[2][1];
        paylinex[18][2]=spread[0][2];
        paylinex[18][3]=spread[2][3];
        paylinex[18][4]=spread[2][4];
        
        //Line 20
        paylinex[19][0]=spread[1][0];
        paylinex[19][1]=spread[0][1];
        paylinex[19][2]=spread[2][2];
        paylinex[19][3]=spread[0][3];
        paylinex[19][4]=spread[1][4];
        
        //Line 21
        paylinex[20][0]=spread[1][0];
        paylinex[20][1]=spread[2][1];
        paylinex[20][2]=spread[0][2];
        paylinex[20][3]=spread[2][3];
        paylinex[20][4]=spread[1][4];
        
        //Line 22
        paylinex[21][0]=spread[0][0];
        paylinex[21][1]=spread[2][1];
        paylinex[21][2]=spread[0][2];
        paylinex[21][3]=spread[2][3];
        paylinex[21][4]=spread[0][4];
        
        //Line 23
        paylinex[22][0]=spread[2][0];
        paylinex[22][1]=spread[0][1];
        paylinex[22][2]=spread[2][2];
        paylinex[22][3]=spread[0][3];
        paylinex[22][4]=spread[2][4];
        
        //Line 24
        paylinex[23][0]=spread[0][0];
        paylinex[23][1]=spread[2][1];
        paylinex[23][2]=spread[2][2];
        paylinex[23][3]=spread[2][3];
        paylinex[23][4]=spread[0][4];
        
        //Line 25
        paylinex[24][0]=spread[2][0];
        paylinex[24][1]=spread[0][1];
        paylinex[24][2]=spread[0][2];
        paylinex[24][3]=spread[0][3];
        paylinex[24][4]=spread[2][4];
        
        //Line 26
        paylinex[25][0]=spread[0][0];
        paylinex[25][1]=spread[2][1];
        paylinex[25][2]=spread[1][2];
        paylinex[25][3]=spread[2][3];
        paylinex[25][4]=spread[0][4];
        
        //Line 27
        paylinex[26][0]=spread[2][0];
        paylinex[26][1]=spread[0][1];
        paylinex[26][2]=spread[1][2];
        paylinex[26][3]=spread[0][3];
        paylinex[26][4]=spread[2][4];
        
        //Line 28
        paylinex[27][0]=spread[1][0];
        paylinex[27][1]=spread[1][1];
        paylinex[27][2]=spread[2][2];
        paylinex[27][3]=spread[1][3];
        paylinex[27][4]=spread[1][4];
        
        //Line 29
        paylinex[28][0]=spread[1][0];
        paylinex[28][1]=spread[1][1];
        paylinex[28][2]=spread[0][2];
        paylinex[28][3]=spread[1][3];
        paylinex[28][4]=spread[1][4];
        
        //Line 30
        paylinex[29][0]=spread[0][0];
        paylinex[29][1]=spread[2][1];
        paylinex[29][2]=spread[0][2];
        paylinex[29][3]=spread[1][3];
        paylinex[29][4]=spread[1][4];
        
    }
}