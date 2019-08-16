/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aidan
 */
public class Board extends JFrame{
    
    private int[][] board;
    JPanel boardPanel;
    int[] startLoc;
    int[] targetLoc;
    List<int[]> locs = new ArrayList<>();
    
    
    public Board(int[] start, int[] target){
        super("PathFinder");
        this.startLoc = start;
        this.targetLoc = target;
        initBoard();
        boardPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                for(int x = 0; x < board[0].length; x++){
                    for(int y = 0; y < board.length; y++){
                        if(board[y][x] <= 10){
                            g.setColor(Color.GRAY);
                        }
                        else{
                            g.setColor(Color.BLACK);
                        }
                        g.fillRect((x+1) * 15, (y+1) * 15, 10, 10);
                    }
                }
                g.setColor(Color.YELLOW);
                for(int[] loc: locs){
                    g.fillRect((loc[1]+ 1) * 15, (loc[0]+1) * 15, 10, 10);
                }
                g.setColor(Color.RED);
                g.fillRect((startLoc[1]+ 1) * 15, (startLoc[0]+1) * 15, 10, 10);
                g.setColor(Color.GREEN);
                g.fillRect((targetLoc[1]+ 1) * 15, (targetLoc[0]+1) * 15, 10, 10);
                
                
            }
        };
        boardPanel.setPreferredSize(new Dimension(600, 600));
        boardPanel.setVisible(true);
        this.add(boardPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
    


    private void initBoard(){
        board = new int[31][28];
        board[0]  = new int[]{21,12,12,12,12,12,12,12,12,12,12,12,12,27,28,12,12,12,12,12,12,12,12,12,12,12,12,22};
        board[1]  = new int[]{13,01,01,01,01,01,01,01,01,01,01,01,01,32,31,01,01,01,01,01,01,01,01,01,01,01,01,14};
        board[2]  = new int[]{13,01,38,29,29,40,01,38,29,29,29,40,01,32,31,01,38,29,29,29,40,01,38,29,29,40,01,14};
        board[3]  = new int[]{13,02,32,00,00,31,01,32,00,00,00,31,01,32,31,01,32,00,00,00,31,01,32,00,00,31,02,14};
        board[4]  = new int[]{13,01,37,30,30,39,01,37,30,30,30,39,01,37,39,01,37,30,30,30,39,01,37,30,30,39,01,14};
        board[5]  = new int[]{13,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,14};
        board[6]  = new int[]{13,01,38,29,29,40,01,38,40,01,38,29,29,29,29,29,29,40,01,38,40,01,38,29,29,40,01,14};
        board[7]  = new int[]{13,01,37,30,30,39,01,32,31,01,37,30,30,36,34,30,30,39,01,32,31,01,37,30,30,39,01,14};
        board[8]  = new int[]{13,01,01,01,01,01,01,32,31,01,01,01,01,32,31,01,01,01,01,32,31,01,01,01,01,01,01,14};
        board[9]  = new int[]{20,11,11,11,11,18,01,32,33,29,29,40,00,32,31,00,38,29,29,35,31,01,17,11,11,11,11,19};
        board[10] = new int[]{00,00,00,00,00,13,01,32,34,30,30,39,00,37,39,00,37,30,30,36,31,01,14,00,00,00,00,00};
        board[11] = new int[]{00,00,00,00,00,13,01,32,31,00,00,00,00,00,00,00,00,00,00,32,31,01,14,00,00,00,00,00};
        board[12] = new int[]{00,00,00,00,00,13,01,32,31,00,17,11,11,10,10,11,11,18,00,32,31,01,14,00,00,00,00,00};
        board[13] = new int[]{12,12,12,12,12,16,01,37,39,00,14,00,00,00,00,00,00,13,00,37,39,01,15,12,12,12,12,12};
        board[14] = new int[]{00,00,00,00,00,00,01,00,00,00,14,00,00,00,00,00,00,13,00,00,00,01,00,00,00,00,00,00};
        board[15] = new int[]{11,11,11,11,11,18,01,38,40,00,14,00,00,00,00,00,00,13,00,38,40,01,17,11,11,11,11,11};
        board[16] = new int[]{00,00,00,00,00,13,01,32,31,00,15,12,12,12,12,12,12,16,00,32,31,01,14,00,00,00,00,00};
        board[17] = new int[]{00,00,00,00,00,13,01,32,31,00,00,00,00,00,00,00,00,00,00,32,31,01,14,00,00,00,00,00};
        board[18] = new int[]{00,00,00,00,00,13,01,32,31,00,38,29,29,29,29,29,29,40,00,32,31,01,14,00,00,00,00,00};
        board[19] = new int[]{21,12,12,12,12,16,01,37,39,00,37,30,30,36,34,30,30,39,00,37,39,01,15,12,12,12,12,22};
        board[20] = new int[]{13,01,01,01,01,01,01,01,01,01,01,01,01,32,31,01,01,01,01,01,01,01,01,01,01,01,01,14};
        board[21] = new int[]{13,01,38,29,29,40,01,38,29,29,29,40,01,32,31,01,38,29,29,29,40,01,38,29,29,40,01,14};
        board[22] = new int[]{13,01,37,30,36,31,01,37,30,30,30,39,01,37,39,01,37,30,30,30,39,01,32,34,30,39,01,14};
        board[23] = new int[]{13,02,01,01,32,31,01,01,01,01,01,01,01,00,00,01,01,01,01,01,01,01,32,31,01,01,02,14};
        board[24] = new int[]{23,29,40,01,32,31,01,38,40,01,38,29,29,29,29,29,29,40,01,38,40,01,32,31,01,38,29,25};
        board[25] = new int[]{24,30,39,01,37,39,01,32,31,01,37,30,30,36,34,30,30,39,01,32,31,01,37,39,01,37,30,26};
        board[26] = new int[]{13,01,01,01,01,01,01,32,31,01,01,01,01,32,31,01,01,01,01,32,31,01,01,01,01,01,01,14};
        board[27] = new int[]{13,01,38,29,29,29,29,35,33,29,29,40,01,32,31,01,38,29,29,35,33,29,29,29,29,40,01,14};
        board[28] = new int[]{13,01,37,30,30,30,30,30,30,30,30,39,01,37,39,01,37,30,30,30,30,30,30,30,30,39,01,14};
        board[29] = new int[]{13,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,14};
        board[30] = new int[]{20,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,19}; 
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    
    public void setLocs(List<int[]> locList){
        locs = locList;
    }
    
    
}


