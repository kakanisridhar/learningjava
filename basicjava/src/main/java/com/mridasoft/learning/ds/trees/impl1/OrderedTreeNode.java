package com.mridasoft.learning.ds.trees.impl1;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class OrderedTreeNode implements TreeNode<StringTreeNodeId> {
	
	public static String ROOT   = "ROOT";
	public static int UNSET_ORDER = -999;  
	
	private StringTreeNodeId id;
	private OrderedTreeNode parent;
	private int order; //order of this node in parents list
	
	public OrderedTreeNode(StringTreeNodeId id, int order, OrderedTreeNode parent) {
		this.id = id;
		this.parent = parent;
		this.order = order;
	}
	
	
	protected ConcurrentHashMap<StringTreeNodeId,OrderedTreeNode> children = new ConcurrentHashMap<>();
	  
	@Override
	public StringTreeNodeId getId() {
		return id;
	}
	
	public int getOrder() {
		return order;
	}
	
	void setOrder(int order) {
		this.order = order;
	}

	@Override
	public Iterator<StringTreeNodeId> getChildren() {
		//TODO - ordering has to be taken care 
		return children.keySet().iterator();
	}

	@Override
	public TreeNode<?> getChild(StringTreeNodeId child) {
		return children.get(child);
	}
	
	/*void ensureChildOrder(StringTreeNodeId child, int order) {
		
		if(!children.containsKey(child)) return;
		
		for(StringTreeNodeId childId : children.keySet()) {
			OrderedTreeNode childNode = children.get(childId);
			childOrder.putIfAbsent(childId, childNode.getOrder());
		}
		
	}*/

	@Override
	public TreeNode<?> getParent() {
		return parent;
	}

	@Override
	public boolean isLeaf() {
		return children.size() == 0;
	}

	public String toString(int depth) {
		StringBuilder sb = new StringBuilder();
		
		StringBuilder indent = new StringBuilder();
		
		for(int d = 0; d < depth; d++) 
			indent.append("\t");
			
		sb.append(indent).append(id).append("[").append("]--->\n");
		
		Iterator<StringTreeNodeId> children = getChildren();
		
		while(children.hasNext()) {
			TreeNode<?> child = getChild(children.next());
			sb.append(indent).append(child.toString(depth+1));
		}
		
		return sb.toString();
		
	}
	
	@Override
	public String toString() {
		return "OrderedTreeNode [id=" + id + " parentid= "+ getParentIdAsString() + ", children size=" + children.size() + "]";
	}
	
	private String getParentIdAsString() {
		if(parent!=null)
			return parent.getId().toString();
		else
			return ROOT;
	}
	

}
