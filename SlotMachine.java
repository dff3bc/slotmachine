//Copyright 2016, Dustin Evans, All rights reserved.


//TODO move these methods to another class and add graphics to this class
package slotmachine;

/**
 *
 * @author dustinevans
 */
public class SlotMachine
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        play();
    }
    
    public static void play()
    {
        Reels reels = new Reels();
        reels.SpinReels();
        
        String[][] symReel = reels.GetReel();
        
        for(int y=0;y<3;y++)
        {
            System.out.println("|-----------|-----------|-----------|-----------|-----------|");
            
            for(int x=0;x<5;x++)
            {
                //System.out.print("| "+symReel[y][x]);
                System.out.printf("|%-11s",symReel[y][x]);
            }
            System.out.println("|");
        }
        System.out.println("|-----------|-----------|-----------|-----------|-----------|");
        
        PayLines pl = new PayLines(symReel);
        pl.calculateQuickHits();
        
        switch(pl.getQuickHits())
        {
            case 3: System.out.println("3 quickhits");
                    break;
            case 4: System.out.println("4 quickhits");
                    break;
        }
        pl.calculateBonus();
        if(pl.getBonus())
        {
            System.out.println("Bonus round!!");
        }
        
        pl.calculateWins();
    }
    
}
