/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import java.util.Arrays;

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
        int[] startLoc = new int[]{1,2};
        Board board = new Board(startLoc);
        pathFinder = new PathFinder();
        pathFinder.aStar(board.getBoard(), startLoc, new int[]{5,5});
        for(int[] i: pathFinder.getPath()){
            System.out.printf(Arrays.toString(i));
        }
    }
    
}
