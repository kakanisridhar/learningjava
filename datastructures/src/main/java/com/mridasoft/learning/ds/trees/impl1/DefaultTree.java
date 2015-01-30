package com.mridasoft.learning.ds.trees.impl1;

import java.util.Iterator;


public class DefaultTree extends OrderedTreeNode {
	
	final static String DEFUALT_SEPERATOR = "/";
	
	String pathSeperator;
	
	public DefaultTree(String name) {
		this(name,DEFUALT_SEPERATOR);
	}
	
	public DefaultTree(String name,String sep) {
		super(new StringTreeNodeId(name),0,null);
		this.pathSeperator = sep;
	}
	
	public void putIfAbsent(int value, String treePath){
		
		if(treePath == null || treePath.isEmpty()) return;
		
		String[] keys = treePath.split(pathSeperator);
		
		OrderedTreeNode node  = this;
		int depth = 0;
		
		for(String key : keys) {
			
			depth++;
			
			StringTreeNodeId childKey = new StringTreeNodeId(key);
			
			final OrderedTreeNode childValue = new OrderedTreeNode(childKey , depth == keys.length ? value : UNSET_ORDER,  node);
			
			//get the child node create if not present
			node = node.children.putIfAbsent(childKey, childValue);
			
			if(node==null)
				node = childValue;
			else if(depth == keys.length) {
				node.setOrder(value);
			}
		}
	}
	
	void setConstructionCompleted() {
		//ensure ordering in children
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[\n");
		
		Iterator<StringTreeNodeId> children = getChildren();
		
		while(children.hasNext()) {
			TreeNode<?> child = getChild(children.next());
			sb.append(child.toString(1));
		}
		
		sb.append("]");
		return sb.toString();
	}	
}
