/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

/**
 * A Node object represents a tile on the board 
 * and can be used for pathfinding algorithms
 * @author Aidan
 */
public class Node {
    
    private Node parent;
    private int[] position;
    private int g;
    private int h;
    private int f;
    
    /**
     * Zero argument constructor for new Node
     */
    public Node(){
        this.parent = null;
        this.position = null;
        this.g = 0;
        this.h = 0;
        this.f = 0;
    }
    
    /**
     * Constructor for new Node if Parent and Position is known
     * @param parent
     * @param position
     */
    public Node(Node parent, int[] position){
        this.parent = parent;
        this.position = position;
        this.g = 0;
        this.h = 0;
        this.f = 0;
    }

    /**
     * Returns the parent Node of this instance
     * @return
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Sets the parent Node of this instance
     * @param parent
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Returns the position of this instance
     * @return
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * Sets the position of this instance
     * @param position
     */
    public void setPosition(int[] position) {
        this.position = position;
    }

    /**
     * Returns the g value of this instance
     * @return
     */
    public int getG() {
        return g;
    }

    /**
     * Returns the g value of this instance
     * @param g
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * Returns the h value of this instance
     * @return
     */
    public int getH() {
        return h;
    }

    /**
     * Sets the h value of this instance
     * @param h
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * Returns the f value of this instance
     * @return
     */
    public int getF() {
        return f;
    }

    /**
     * Sets the f value of this instance
     * @param f
     */
    public void setF(int f) {
        this.f = f;
    }
}

