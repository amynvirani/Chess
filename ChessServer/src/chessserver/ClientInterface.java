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
public interface ClientInterface extends Remote{
    public void startingClient() throws RemoteException;
}
