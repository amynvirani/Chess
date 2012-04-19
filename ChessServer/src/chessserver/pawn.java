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
public class pawn extends piece{
    
    boolean isFirst=true;
    int max=2;
    pawn(String color){
        super(color);
        this.type="pawn";
    }
    pawn(String color,Location loc,JLabel image){
        if ("black".equals(color)){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessserver/resources/PawnBlack.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.black=true;
        }
        else if ("white".equals(color)){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessserver/resources/PawnWhite.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.white=true;
        }
        this.image=image;
        this.type="pawn";
        this.loc=loc;
    }

    public boolean validateMove(Location destinationPosition) {
        int dx=destinationPosition.getLocationx();
        int dy=destinationPosition.getLocationy();
        int cx=this.loc.getLocationx();
        int cy=this.loc.getLocationy();
        board cboard=board.getInstance("Chess");
        if (Math.abs(dx-cx)<=this.max){
            if (cy==dy){ //not trying to kill
                if (this.isWhite()){
                    if (cx>dx){
                        if ((cx-dx)==2){
                            if (cboard.values[cx-1][cy]==null && cboard.values[dx][dy]==null){
                                this.max=1;
                                return true;
                            }
                        }
                        else if ((cx-dx)==1){
                            if (cboard.values[dx][dy]==null){
                                this.max=1;
                                return true;
                            }
                        }
                    }
                }
                else if (this.isBlack()){
                    if (dx>cx){
                        if ((dx-cx)==2){
                            if (cboard.values[cx+1][cy]==null && cboard.values[dx][dy]==null){
                                this.max=1;
                                return true;
                            }
                        }
                        else if ((dx-cx)==1){
                            if (cboard.values[dx][dy]==null){
                                this.max=1;
                                return true;
                            }
                        }
                    }                    
                }
            }
            else if (Math.abs(cy-dy)==1){ //trying to kill
                if (this.isWhite()){
                    if (cx>dx){
                        if (cboard.values[dx][dy]!=null){
                            if (cboard.values[dx][dy].isBlack()){
                                this.max=1;
                                //cboard.values[dx][dy].kill(this);
                                return true;
                            }
                        }
                    }
                }
                else if (this.isBlack()){
                    if (dx>cx){
                        if (cboard.values[dx][dy]!=null){
                            if (cboard.values[dx][dy].isWhite()){
                                this.max=1;
                                //cboard.values[dx][dy].kill(this);
                                return true;
                            }
                        }
                    }                    
                }
            }
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean makeMove(Location newLocation) {
        return super.makeMove(newLocation);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean hasCheckOnOpposingKing(Location positionOfOpposingKing) {
        return super.hasCheckOnOpposingKing(positionOfOpposingKing);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isActive() {
        return this.active;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isWhite() {
        if (this.white==true){
            return true;
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isBlack() {
        if (this.black==true){
            return true;
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public ChessPiece kill(ChessPiece a) {
        //System.out.println("kill function pawn");
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
