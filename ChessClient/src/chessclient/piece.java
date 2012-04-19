/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package chessclient;

import javax.swing.JLabel;

/**
 *
 * @author Amyn
 */
public class piece implements ChessPiece{
    public piece(String color){
       if (color=="black"){
            this.black=true;
            this.white=false;
        }
        else if (color=="white"){
            this.white=true;
            this.black=false;
        }
       this.active=true;
    }
    public piece(){
        
    }
    
    public String getType(){
        return this.type;
    }
    
    Location loc;
    boolean active=false;
    boolean black=false;
    boolean white=false;
    String type;
    JLabel image;
    piece killby=null;

    @Override
    public boolean validateMove(Location destinationPosition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public boolean makeMove(Location newLocation) {
        //System.out.println("making move in client");
        image.setBounds(newLocation.getLocationy()*57, newLocation.getLocationx()*57, 57, 57);
        loc=newLocation;
        return true;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public boolean hasCheckOnOpposingKing(Location positionOfOpposingKing) {
        board cboard=board.getInstance("Chess");
        if (this.white==true){
            for (int i=0;i<cboard.blackpieces.size();i++){
                if (cboard.blackpieces.get(i).isActive() && cboard.blackpieces.get(i).validateMove(positionOfOpposingKing)){
                    return true;
                }
            }
        }
        else if (this.black==true){
            for (int i=0;i<cboard.whitepieces.size();i++){
                if (cboard.whitepieces.get(i).isActive() && cboard.whitepieces.get(i).validateMove(positionOfOpposingKing)){
                    return true;
                }
            }            
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isActive() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isWhite() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isBlack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public ChessPiece kill(ChessPiece a) {
        System.out.println("in kill function");
        this.killby=(piece)a;
        this.active=false;
        this.image.setVisible(false);
        return null;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
