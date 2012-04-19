/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package chessserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Amyn
 */
public interface GameFunctions extends Remote{
    public void serverCalled() throws RemoteException;
}
