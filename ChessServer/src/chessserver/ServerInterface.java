//package chessserver;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package chessclient;
import java.rmi.*;
/**
 *
 * @author Amyn
 */
public interface ServerInterface extends Remote{
    public void startingServer() throws RemoteException;
    public void serverMove(Location ol,Location nl) throws RemoteException;
}
