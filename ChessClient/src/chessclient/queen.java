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
public class queen extends piece{
    
    queen(String color){
        super(color);
        super.type="queen";
    }
    queen(String color,Location loc,JLabel image){
        if (color=="black"){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessclient/resources/QueenBlack.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.black=true;
        }
        else if (color=="white"){
            image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chessclient/resources/QueenWhite.png"))); // NOI18N
            image.setBounds(loc.getLocationy()*57, loc.getLocationx()*57, 57, 57);
            this.white=true;
        }
        this.image=image;
        this.type="queen";
        this.loc=loc;        
    }
    public boolean validateMove(Location destinationPosition) {
        if ((destinationPosition.getLocationx()==(this.loc.getLocationx())) || (destinationPosition.getLocationy()==(this.loc.getLocationy()))){
            int dx=destinationPosition.getLocationx();
            int dy=destinationPosition.getLocationy();
            int cx=this.loc.getLocationx();
            int cy=this.loc.getLocationy();
            board cboard=board.getInstance("Chess");
            if (cx==dx){
                if (dy>cy){ //right
                    for (int i=(cy+1);i<dy;i++){
                        if (cboard.values[cx][i]!=null){
                            return false;
                        }
                    }
                }
                if (cy>dy){ //left
                    for (int i=(dy+1);i<cy;i++){
                        if (cboard.values[cx][i]!=null){
                            return false;
                        }
                    }
                }
            }
            if (cy==dy){
                if (dx>cx){ //bottom
                    for (int i=(cx+1);i<dx;i++){
                        if (cboard.values[i][cy]!=null){
                            return false;
                        }
                    }
                }
                if (cx>dx){ //top
                    for (int i=(dx+1);i<cx;i++){
                        if (cboard.values[i][cy]!=null){
                            return false;
                        }
                    }
                }
            }
            if (cboard.values[dx][dy]!=null){
                if ((cboard.values[dx][dy].isBlack() && this.isWhite())||(cboard.values[dx][dy].isWhite() && this.isBlack())){
                    return true;
                    //cboard.values[dx][dy].kill(this);                    
                }
                else{
                    return false;
                }
            }
            //super.makeMove(destinationPosition);
            return true;
        }
        else{
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
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                //super.makeMove(destinationPosition);
                return true;
            }            
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
        return black;
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
        System.out.println("kill function queen");
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
