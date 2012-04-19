/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package chessserver;

import javax.swing.JLabel;

/**
 *
 * @author Amyn
 */
public class knight extends piece {

    knight(String color){
        super(color);
        super.type="knight";
    }
    knight(String color,Location loc,JLabel image){
        if (color=="black"){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessserver/resources/KnightBlack.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.black=true;
        }
        else if (color=="white"){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessserver/resources/KnightWhite.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.white=true;
        }
        this.image=image;
        this.type="knight";
        this.loc=loc;        
    }
    public boolean validateMove(Location destinationPosition) {
        int xdiff=Math.abs(destinationPosition.getLocationx()-this.loc.getLocationx());
        int ydiff=Math.abs(destinationPosition.getLocationy()-this.loc.getLocationy());
        if ((xdiff==2 && ydiff==1) || (xdiff==1 && ydiff==2)){
            board cboard=board.getInstance("Chess");
            int dx=destinationPosition.getLocationx();
            int dy=destinationPosition.getLocationy();
            if (cboard.values[dx][dy]!=null){
                if ((cboard.values[dx][dy].isBlack() && this.isWhite())||(cboard.values[dx][dy].isWhite() && this.isBlack())){
                    //cboard.values[dx][dy].kill(this);                    
                }
                else{
                    return false;
                }
            }
            //super.makeMove(destinationPosition);
            return true;
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public boolean makeMove(Location newLocation) {
//        this.image.setBounds(newLocation.getLocationy()*57, newLocation.getLocationx()*57, 57, 57);
        return super.makeMove(newLocation);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public boolean hasCheckOnOpposingKing(Location positionOfOpposingKing) {
        return super.hasCheckOnOpposingKing(positionOfOpposingKing);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public boolean isActive() {
        return active;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public boolean isWhite() {
        return white;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public boolean isBlack() {
        return black;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public ChessPiece kill(ChessPiece a) {
        System.out.println("kill function knight");
        this.killby=(piece)a;
        this.active=false;
        this.image.setVisible(false);
        return null;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String getType(){
        return this.type;
    }    
}
