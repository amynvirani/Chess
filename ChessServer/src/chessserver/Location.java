
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package chessserver;

/**
 *
 * @author Amyn
 */
class Location implements Serializable{
    int x;
    int y;
    public Location(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Location setLocation(int x, int y){
        this.x=x;
        this.y=y;
        return this;
    }
    public int getLocationx(){
        return x;
    }
    public int getLocationy(){
        return y;
    }
}
