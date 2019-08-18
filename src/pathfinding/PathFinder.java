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
 *
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
    
    public PathFinder(){
        
        
//        for(int[] i: aStar()){
//            System.out.println(Arrays.toString(i));
//        }
    }
    
    public static List<int[]> aStar(int[][] board, int[] start, int[] target){
        board = board;
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
            
            
            if (currentNode.getPosition()[0] == targetNode.getPosition()[0] && currentNode.getPosition()[1] == targetNode.getPosition()[1]){
                path = new ArrayList<>();
                Node current = currentNode;
                while(current != null){
                    path.add(current.getPosition());
                    current = current.getParent();
                }
                Collections.reverse(path);
                return path;
//                System.out.println("path found");
            }
            
            List<Node> children = new ArrayList<>();
            int[][] newPositions = new int[4][];
            newPositions[0] = new int[]{0,-1};
            newPositions[1] = new int[]{0,1};
            newPositions[2] = new int[]{-1,0};
            newPositions[3] = new int[]{1,0};
            
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
//            System.out.println("Current Node: " + Arrays.toString(currentNode.getPosition()));
//            System.out.printf("Children Nodes:");
            
            for(Node child: children){
//                System.out.printf("" + Arrays.toString(child.getPosition()));
                boolean a = false;
                for(Node closedNode: closedList){
                    if(closedNode.getPosition()[0] == child.getPosition()[0] && closedNode.getPosition()[1] == child.getPosition()[1]){
//                        System.out.println();
//                        System.out.println("" + Arrays.toString(closedNode.getPosition()) + "is the same as" + Arrays.toString(child.getPosition()));
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

    public List<int[]> getPath() {
        return path;
    }
}
