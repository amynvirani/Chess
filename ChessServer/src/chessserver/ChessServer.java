/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package chessserver;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

/**
 *
 * @author Amyn
 */
public class ChessServer implements GameFunctions{

    /**
     * @param args the command line arguments
     */
/*    public static void main(String[] args) {
        // TODO code application logic here
        try{
            GameFunctions game=new ChessServer();
            GameFunctions stub=(GameFunctions)UnicastRemoteObject.exportObject(game,0);
            String name="GameStub";
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("Waiting for client to join");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
*/
    @Override
    public void serverCalled() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
