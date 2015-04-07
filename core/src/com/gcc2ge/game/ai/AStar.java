package com.gcc2ge.game.ai;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.Gdx;

public class AStar {
	final String TAG=AStar.class.getName();
	private final Cartographer cartographer;
	private final List openNodeInfoSortedList;
	private final Map nodeToNodeInfoMap;
	
	private NodeInfo bestNodeInfo;
	private double bestTotalCost;
	private NodeInfo goalNodeInfo;
	private boolean listEmpty;
	
	//stpes
	public int steps=0;
	public AStar(Cartographer cartographer){
		this.cartographer=cartographer;
		nodeToNodeInfoMap=new HashMap();
		openNodeInfoSortedList=new LinkedList();
	}
	public boolean isGoalFound(){
		return goalNodeInfo!=null;
	}
	public boolean isListEmpty(){
		return listEmpty;
	}
	public Iterator getPath(){
		List pathList=new LinkedList();
		NodeInfo nodeInfo=goalNodeInfo;
		if(nodeInfo==null){
			nodeInfo=bestNodeInfo;
		}
		while(nodeInfo!=null){
			NodeInfo parentNodeInfo=nodeInfo.getParentNodeInfo();
			if(parentNodeInfo!=null){
				pathList.add(0, nodeInfo.getNode());//�������
			}
			nodeInfo=parentNodeInfo;
		}
		steps=pathList.size();
		
		Gdx.app.log(TAG, "path "+pathList);
		Gdx.app.log(TAG, "path "+steps);
		return pathList.iterator();
	}
	public Object getFirstStep(){
		NodeInfo nodeInfo=goalNodeInfo;
		if(nodeInfo==null){
			nodeInfo=bestNodeInfo;
		}
		Object node=null;
		while(nodeInfo!=null){
			NodeInfo parentNodeInfo=nodeInfo.getParentNodeInfo();
			if(parentNodeInfo!=null){
				node=nodeInfo.getNode();
			}
			nodeInfo=parentNodeInfo;
		}
		return node;
	}
	public void reset(Object startNode){
		goalNodeInfo=null;
		listEmpty=false;
		openNodeInfoSortedList.clear();
		nodeToNodeInfoMap.clear();
		NodeInfo nodeInfo=new NodeInfo(startNode);
		nodeToNodeInfoMap.put(startNode, nodeInfo);
		openNodeInfoSortedList.add(nodeInfo);
		bestTotalCost=Double.POSITIVE_INFINITY;
	}
	/**
	 * 
	 * openNodeInfoSortedList ���� ����Ŀ��ڵ� ������ڽڵ�
	 	
	 	adjacentNode  ����costFromStart  totalCost
	 	������ڽڵ��ѱ������ cost ��Ƚ�����·���� costFromStart ѡȡ��С��
	 *
	 *
	 */
	public boolean loop(){
		if(openNodeInfoSortedList.isEmpty()){//û�е���·��
			listEmpty=true;
			return false;
		}
		NodeInfo nodeInfo=(NodeInfo) openNodeInfoSortedList.remove(0);
		Object node=nodeInfo.getNode();
		if(cartographer.isGoalNode(node)){
			if(goalNodeInfo==null || nodeInfo.getCostFromStart()<goalNodeInfo.getCostFromStart()){
				goalNodeInfo=nodeInfo;
			}
			return false;
		}
		Iterator iterator=cartographer.getAdjacentNodes(node);
		while(iterator.hasNext()){
			Object adjacentNode=iterator.next();
			double newCostFromStart=nodeInfo.getCostFromStart()+cartographer.getCostToAdjacentNode(node, adjacentNode);
			NodeInfo adjacentNodeInfo=(NodeInfo)nodeToNodeInfoMap.get(adjacentNode);
			if(adjacentNodeInfo==null){
				adjacentNodeInfo=new NodeInfo(adjacentNode);
				nodeToNodeInfoMap.put(adjacentNode, adjacentNodeInfo);
				openNodeInfoSortedList.add(adjacentNodeInfo);
			}else if(adjacentNodeInfo.getCostFromStart()<newCostFromStart){
				continue;
			}
			//���� ��С����
			adjacentNodeInfo.setParentNodeInof(nodeInfo);
			adjacentNodeInfo.setCostFromStart(newCostFromStart);
			double totalCost=newCostFromStart+cartographer.estimateCostTotal(adjacentNode);
			adjacentNodeInfo.setTotalCost(totalCost);
			if(totalCost<=bestTotalCost){
				bestNodeInfo=adjacentNodeInfo;
				bestTotalCost=totalCost;
			}
			Collections.sort(openNodeInfoSortedList);
		}
		return true;
	}
}
