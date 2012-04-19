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
public class bishop extends piece {

    bishop(String color){
        super(color);
        super.type="bishop";
    }
    bishop(String color,Location loc,JLabel image){
        if (color=="black"){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessclient/resources/BishopBlack.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.black=true;
        }
        else if (color=="white"){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessclient/resources/BishopWhite.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.white=true;
        }
        this.image=image;
        this.type="bishop";
        this.loc=loc;        
    }
    public boolean validateMove(Location destinationPosition) {
        int xdiff=Math.abs(destinationPosition.getLocationx()-this.loc.getLocationx());
        int ydiff=Math.abs(destinationPosition.getLocationy()-this.loc.getLocationy());
        if (xdiff==ydiff){
            int dx=destinationPosition.getLocationx();
            int dy=destinationPosition.getLocationy();
            int cx=this.loc.getLocationx();
            int cy=this.loc.getLocationy();
            board cboard=board.getInstance("Chess");
            if (dx>cx && dy>cy){ //bottom right               
                for (int i=(cx+1);i<dx;i++){
                    for (int j=(cy+1);j<dy;j++){
                        if ((i-j)==1 &&(cx-cy)==1){ 
                            if (cboard.values[i][j]!=null){
                                return false;
                            }
                        }
                    }
                }
            }
            if (dx>cx && dy<cy){ //bottom left
                for (int i=(cx+1);i<dx;i++){
                    for (int j=(dy+1);j<cy;j++){
                        if ((j+i)==(cy+cx)){
                            if (cboard.values[i][j]!=null){
                                return false;
                            }
                        }
                    }
                }
            }
            if (dx<cx && dy<cy){ //top left
                for (int i=(dx+1);i<cx;i++){
                    for (int j=(dy+1);j<cy;j++){                     
                        if ((i-j)==(cx-cy)){
                            if (cboard.values[i][j]!=null){
                                return false;
                            }
                        }
                    }
                }
            }
            if (dx<cx && dy>cy){ //top right
                for (int i=(dx-1);i<(cx+1);i++){
                    for (int j=(cy+1);j<dy;j++){
                        if ((i+j)==(cx+cy)){
                            if (cboard.values[i][j]!=null){
                                return false;
                            }
                        }
                    }
                }
            }
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

    public boolean isWhite(){ 
        return white;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isBlack() {
        return black;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public ChessPiece kill(ChessPiece a) {
        System.out.println("kill function bishop");
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
