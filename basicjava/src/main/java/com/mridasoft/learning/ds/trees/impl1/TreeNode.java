package com.mridasoft.learning.ds.trees.impl1;

import java.util.Iterator;

/**
 * 
 * @author skakani
 *
 * @param <K> - id of the node 
 * 
 * A tree is a TreeNode, no additional interfaces created
 * 
 */
public interface TreeNode<K> {
	
	K getId();
	
	Iterator<K> getChildren();
	
	TreeNode<?> getChild(K child);
	
	TreeNode<?> getParent();
    
    boolean	isLeaf();
    
    public String toString(int depth);
      
}
