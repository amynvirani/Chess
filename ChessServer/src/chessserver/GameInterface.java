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
public interface GameInterface extends Remote{
    public int add(int a,int b) throws RemoteException;
}
