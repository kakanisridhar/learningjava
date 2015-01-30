package com.mridasoft.learning.rmi.client;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.mridasoft.learning.rmi.api.Compute;

public class ComputePi {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
        	
            String name = "Compute";
            
            Registry registry = LocateRegistry.getRegistry("gqavkenvi114.france.effix.fr",7001);
            Compute comp = (Compute) registry.lookup(name);
            
            Pi task = new Pi(Integer.parseInt(args[0]));
            
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
            
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}