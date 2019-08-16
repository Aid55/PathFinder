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

/**
 *
 * @author Aidan
 */
public class Board extends JFrame{
    
    private int[][] board;
    JPanel boardPanel;
    int[] startLoc;
    
    
    public Board(int[] start){
        super("PathFinder");
        this.startLoc = start;
        initBoard();
        boardPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                for(int y = 0; y < board.length; y++){
                    for(int x = 0; x < board[0].length; x++){
                        if(board[y][x] == 0){
                            g.setColor(Color.GREEN);
                        }
                        else{
                            g.setColor(Color.RED);
                        }
                        g.fillRect((x+1) * 60, (y+1) * 60, 50, 50);
                    }
                }
                g.setColor(Color.BLUE);
                g.fillRect((startLoc[0]+ 1) * 60, (startLoc[1]+1) * 60, 50, 50);
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
        board = new int[6][6];
        board[0] = new int[]{0,0,0,0,0,0};
        board[1] = new int[]{1,0,1,1,0,0};
        board[2] = new int[]{0,0,1,0,0,0};
        board[3] = new int[]{0,0,1,0,1,1};
        board[4] = new int[]{0,1,0,0,0,0};
        board[5] = new int[]{0,0,0,1,0,0};
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    
    
}


