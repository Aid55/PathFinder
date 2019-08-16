/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Aidan
 */
public class Main {

    public static PathFinder pathFinder;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] startLoc = new int[]{1,1};
        int[] targetLoc = new int[]{29,26};
        Board board = new Board(startLoc, targetLoc);
        List<int[]> x = PathFinder.aStar(board.getBoard(), startLoc, targetLoc);
        for(int[] i: x){
            System.out.printf(Arrays.toString(i));
            board.setLocs(x);
            board.repaint();
        }
//        for(int[] i: pathFinder.getPath()){
//            System.out.printf(Arrays.toString(i));
//        }
    }
    
}
