/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotuspeli.laivanupotuspeli;

/**
 *
 * @author Anniina
 */
public class Laiva {
    
    private int pituus;
    private boolean osuma;
    private int[][] koordinaatit;
    private int osumat;
    
    public Laiva(int pituus){
        osumat=0;
        
    }
    
    public void osuma(){
        osumat++;
    }
    
    public int getPituus(){
        return pituus;
    }
    
    public boolean osuuko(int x, int y){
       // for(int i=0; i<pituus; i++){
         //   if(koordinaatit[0])
        //}
        return false;
    }
    
    public boolean onTuhottu(){
        if(osumat>=pituus){
            return true;
        }
        return false;
    }
}
