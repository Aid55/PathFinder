/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class for finding a path from a locations to a target location using various different
 * pathfinding algorithms.
 * @author Aidan
 */

public class PathFinder {
    
    private static int[] startLoc;
    private static int[] targetLoc;
    private static int[][] board;
    private static Node startNode;
    private static Node targetNode;
    private static Node currentNode;
    private static List<Node> openList;
    private static List<Node> closedList;
    private static int currentIndex;
    private static List<int[]> path = new ArrayList<>();
    
    /**
     *
     */
    public PathFinder(){
    }
    
    /**
     * Takes the board 2D int array and the start and target tiles
     * Uses the A* pathfinding algorithm to find and return a path to the target
     * @param boardGrid
     * @param start
     * @param target
     * @return
     */
    public static List<int[]> aStar(int[][] boardGrid, int[] start, int[] target){
        board = boardGrid;
        startLoc = start;
        targetLoc = target;
        
        startNode = new Node(null, startLoc);
        startNode.setG(0);
        startNode.setH(0);
        startNode.setF(0);
        targetNode = new Node(null, targetLoc);
        targetNode.setG(0);
        targetNode.setH(0);
        targetNode.setF(0);
        
        openList = new ArrayList<>();
        closedList = new ArrayList<>();
        
        openList.add(startNode);
        
        while(openList.size() > 0){
            currentNode = openList.get(0);
            currentIndex = 0;
            for(int index = 0; index < openList.size(); index++){
                if(openList.get(index).getF() < currentNode.getF()){
                    currentNode = openList.get(index);
                    currentIndex = index;
                }
            }
            openList.remove(currentIndex);
            closedList.add(currentNode);
            
            // Create a list of tiles if the currentNode position is the same as the targets position and then return the path list.
            if (currentNode.getPosition()[0] == targetNode.getPosition()[0] && currentNode.getPosition()[1] == targetNode.getPosition()[1]){
                path = new ArrayList<>();
                Node current = currentNode;
                while(current != null){
                    path.add(current.getPosition());
                    current = current.getParent();
                }
                Collections.reverse(path);
                return path;
            }
            
            // New possible positions
            List<Node> children = new ArrayList<>();
            List<int []> newPositions = new ArrayList<>();
            newPositions.add(new int[]{0,-1});
            newPositions.add(new int[]{0,1});
            newPositions.add(new int[]{-1,0});
            newPositions.add(new int[]{1,0});
            //UNCOMMENT THE BELOW TO INCLUDE DIAGONAL MOVEMENTS
//            newPositions.add(new int[]{-1,-1});
//            newPositions.add(new int[]{1,1});
//            newPositions.add(new int[]{-1,1});
//            newPositions.add(new int[]{1,-1});
            
            // Create a new child node for each position if on the board and a valid tile
            for(int[] newPosition: newPositions){
                int[] nodePosition = new int[]{currentNode.getPosition()[0] + newPosition[0], currentNode.getPosition()[1] + newPosition[1]};
                if(nodePosition[0] < 0 || nodePosition[0] > board[0].length - 1 || nodePosition[1] < 0 || nodePosition[1] > board.length - 1){
                    continue;
                }
                if(board[nodePosition[1]][nodePosition[0]] > 10){
                    continue;
                }
                Node newNode = new Node(currentNode, nodePosition);
                children.add(newNode);
            }
            
            // Add child node to children list if not already a closed node
            for(Node child: children){
                boolean a = false;
                for(Node closedNode: closedList){
                    if(closedNode.getPosition()[0] == child.getPosition()[0] && closedNode.getPosition()[1] == child.getPosition()[1]){
                        a = true;
                        break;
                    }
                }
                if(a){
                    continue;
                }
                child.setG(currentNode.getG() + 1);
                child.setH((int)Math.sqrt((Math.pow((double)child.getPosition()[0] - targetNode.getPosition()[0], 2) + Math.pow((double)child.getPosition()[1] - targetNode.getPosition()[1], 2))));
                child.setF(child.getG() + child.getH());
                
                // If child node position matches a node in open list, compares the G value to see if it is more efficient and replaces if so
                boolean b = false;
                for(Node openNode: openList){
                    if(Arrays.equals(child.getPosition(), openNode.getPosition())){
                        if(child.getG() > openNode.getG()){
                            b = true;
                            break;
                        }
                    }
                    
                }
                if (b){
                    continue;
                }
                openList.add(child);
                          
            }
//            printLists();
            
        }
        return new ArrayList<int[]>();
    }
    
    /**
     * Returns the last path found
     * @return
     */
    public List<int[]> getPath() {
        return path;
    }

    

    
//    private void printLists(){
//        System.out.println();
//        if(openList.size() > 0){
//            System.out.printf("Open List = ");
//            for(Node i: openList){
//                System.out.printf(Arrays.toString(i.getPosition()));
////                System.out.printf(""+i.getF());
//            }
//        }
//        else{
//            System.out.printf("Open List is empty");
//        }
//            System.out.println();
//        if(closedList.size() > 0){
//            System.out.printf("Closed List = ");
//            for(Node i: closedList){
//                System.out.printf(Arrays.toString(i.getPosition()));
////                System.out.printf(""+i.getF());
//            }
//        }
//        else{
//            System.out.printf("Closed List is empty");
//        }
//        System.out.println();
//        System.out.println();
//    }

}