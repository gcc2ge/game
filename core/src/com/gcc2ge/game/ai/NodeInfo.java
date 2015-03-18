package com.gcc2ge.game.ai;

public class NodeInfo implements Comparable{
	private final Object node;
	private double costFromStart;
	private NodeInfo parentNodeInfo;
	private double totalCost;
	public NodeInfo(Object node){
		this.node=node;
	}
	//getter setter ignore
	public double getCostFromStart(){
		return costFromStart;
	}
	public Object getNode(){
		return this.node;
	}
	public NodeInfo getParentNodeInfo(){
		return this.parentNodeInfo;
	}
	public double getTotalCost(){
		return this.totalCost;
	}
	public void setCostFromStart(double costFromStart){
		this.costFromStart=costFromStart;
	}
	public void setParentNodeInof(NodeInfo parentNodeInfo){
		this.parentNodeInfo=parentNodeInfo;
	}
	public void setTotalCost(double totalCost){
		this.totalCost=totalCost;
	}
	
	
	@Override
	public int compareTo(Object o) {
		NodeInfo nodeInfo=(NodeInfo)o;
		if(totalCost>nodeInfo.totalCost){
			return 1;
		}else if(totalCost<nodeInfo.totalCost){
			return -1;
		}
		return 0;
	}
	

}
