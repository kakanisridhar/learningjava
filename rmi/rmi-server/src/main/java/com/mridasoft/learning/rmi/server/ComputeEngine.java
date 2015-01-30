package com.mridasoft.learning.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.mridasoft.learning.rmi.api.Compute;
import com.mridasoft.learning.rmi.api.Task;

public class ComputeEngine implements Compute {

    public ComputeEngine() {
        super();
    }

    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            
        	String name = args[0];
        	String port = args[1];
        	
            Compute engine = new ComputeEngine();
            
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            
            Registry registry = LocateRegistry.createRegistry(Integer.parseInt(port));
            
            registry.rebind(name, stub);
            
            System.out.println(String.format("ComputeEngine bound with name %s and port %s", name,port));
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}