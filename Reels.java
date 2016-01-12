//Copyright 2016, Dustin Evans, All rights reserved.

package slotmachine;

/**
 *
 * @author dustinevans
 */
public class Reels
{
    /*
    A = Bells
    B = 7
    C = 77
    D = 777
    E = Bar
    F = 5Bar
    E = Cherry
    F = Wild
    G = QuickHit
    H = Bonus
    */
    
    //add bonus to reels. Will need to adjust all code below to reflect.
    
    private String[] reel1 = {"Cherry","Bell","Bar","5Bar","7","5Bar","Bell","Cherry","QuickHit","Bar","7","Cherry","77","Bell","Bar","777","77","5Bar","Wild","Bell","Cherry"};
    private String[] reel2 = {"Bell","7","Cherry","5Bar","Bell","Bonus","Bar","77","Cherry","QuickHit","QuickHit","5Bar","Cherry","7","Bar","Bell","5Bar","Cherry","777","Bar","Bell","Wild"};
    private String[] reel3 = {"777","Bell","Bar","7","Bell","5Bar","Cherry","QuickHit","QuickHit","QuickHit","Cherry","Bell","Bonus","Wild","Cherry","5Bar","Cherry","7","Bell","77","Cherry","Bar"};
    private String[] reel4 = {"Wild","Bar","Cherry","Bell","7","5Bar","77","Bell","Bonus","QuickHit","QuickHit","Cherry","Bell","7","5Bar","Bar","Cherry","Cherry","Bar","5Bar","777","Bell"};
    private String[] reel5 = {"Cherry","Wild","77","Bar","77","7","Cherry","5Bar","QuickHit","5Bar","Bell","Cherry","Bar","7","Bell","Bar","Cherry","Bell","777","5Bar","Bell"};
    private String[] reel = {"a","a","a","a","a"};
    private String[][] allReels = new String[3][5];
    
    private int reelIndex;
    
    public Reels()
    {
        
    }
    public void SpinReels()
    {
        for(int x=0;x<5;x++)
        {
            int number = (int)Math.round(Math.random()*10000);
            int timecode = (int)System.currentTimeMillis()%2147483647;
            int randomnumber = number*timecode;
            if(randomnumber < 0)
            {
                randomnumber*=-1;
            }
            this.reelIndex = randomnumber%21;
            
            switch(x)
            {
                case 0: this.allReels[1][x]=reel1[this.reelIndex];
                        if(this.reelIndex==0)
                        {
                            this.allReels[0][x]=reel1[reel1.length-1];
                        }
                        else
                        {
                            this.allReels[0][x]=reel1[this.reelIndex-1];
                        }
                        if(this.reelIndex==20)
                        {
                            this.allReels[2][x]=reel1[1];
                        }
                        else
                        {
                            this.allReels[2][x]=reel1[this.reelIndex+1];
                        }
                        break;
                case 1: this.allReels[1][x]=reel2[this.reelIndex];
                        if(this.reelIndex==0)
                        {
                            this.allReels[0][x]=reel2[reel2.length-1];
                        }
                        else
                        {
                            this.allReels[0][x]=reel2[this.reelIndex-1];
                        }
                        if(this.reelIndex==20)
                        {
                            this.allReels[2][x]=reel2[1];
                        }
                        else
                        {
                            this.allReels[2][x]=reel2[this.reelIndex+1];
                        }
                        break;
                case 2: this.allReels[1][x]=reel3[this.reelIndex];
                        if(this.reelIndex==0)
                        {
                            this.allReels[0][x]=reel3[reel3.length-1];
                        }
                        else
                        {
                            this.allReels[0][x]=reel3[this.reelIndex-1];
                        }
                        if(this.reelIndex==20)
                        {
                            this.allReels[2][x]=reel3[1];
                        }
                        else
                        {
                            this.allReels[2][x]=reel3[this.reelIndex+1];
                        }
                        break;
                case 3: this.allReels[1][x]=reel4[this.reelIndex];
                        if(this.reelIndex==0)
                        {
                            this.allReels[0][x]=reel4[reel4.length-1];
                        }
                        else
                        {
                            this.allReels[0][x]=reel4[this.reelIndex-1];
                        }
                        if(this.reelIndex==20)
                        {
                            this.allReels[2][x]=reel4[1];
                        }
                        else
                        {
                            this.allReels[2][x]=reel4[this.reelIndex+1];
                        }
                        break;
                case 4: this.allReels[1][x]=reel5[this.reelIndex];
                        if(this.reelIndex==0)
                        {
                            this.allReels[0][x]=reel5[reel5.length-1];
                        }
                        else
                        {
                            this.allReels[0][x]=reel5[this.reelIndex-1];
                        }
                        if(this.reelIndex==20)
                        {
                            this.allReels[2][x]=reel5[1];
                        }
                        else
                        {
                            this.allReels[2][x]=reel5[this.reelIndex+1];
                        }
                        break;
            }
            
        }
        
    }
    
    public String[][] GetReel()
    {
        return this.allReels;
    }
}
