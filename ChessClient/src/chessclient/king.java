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
public class king extends piece{

    king(String color){
        super(color);
        super.type="king";
    }
    king(String color,Location loc,JLabel image){
        if (color=="black"){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessclient/resources/KingBlack.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.black=true;
        }
        else if (color=="white"){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessclient/resources/KingWhite.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.white=true;
        }
        this.image=image;
        this.type="king";
        this.loc=loc;        
    }
    public boolean validateMove(Location destinationPosition) {
        int diffx=Math.abs(destinationPosition.getLocationx()-this.loc.getLocationx());
        int diffy=Math.abs(destinationPosition.getLocationy()-this.loc.getLocationy());
        if (diffx<=1 && diffy<=1){
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
            cboard.setKing(destinationPosition);
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
        System.out.println("kill function king");
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
