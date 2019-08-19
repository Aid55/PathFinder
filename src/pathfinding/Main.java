/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

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
        int[] targetLoc = new int[]{11,13};
        Board board = new Board(startLoc, targetLoc);
        board.setLocs(PathFinder.aStar(board.getBoard(), startLoc, targetLoc));
        board.repaint();
    }
    
}
