package com.gcc2ge.game.ai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AStarTest implements Cartographer{
	private static final int MIN_X=-10;
	private static final int MIN_Y=-10;
	private static final int MAX_X=10;
	private static final int MAX_Y=10;
	
	private final Set blockedSet;
	private final GridXY goalPoint;
	private final GridXY jumpPoint;
	
	public static void main(String[] args){
		System.out.println(test(args));
	}
	
	public static boolean test(String[] args){
		AStarTest test1=new AStarTest(new GridXY(4,0),new GridXY[]{new GridXY(1,1),new GridXY(1,0)});
		
		return test(test1);
	}
	public static boolean test(AStarTest test){
		System.out.println("testing...............");
		AStar aStar=new AStar(test);
		aStar.reset(new GridXY(0,0));
		while(true){
			aStar.loop();
			if(aStar.isListEmpty()){
				break;
			}
		}
		System.out.println("goalFound: "+aStar.isGoalFound());
		Iterator iterator=aStar.getPath();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		return true;
	}
	
	public AStarTest(GridXY goalPoint,GridXY[] blockedPoints,GridXY jumpPoint){
		this.goalPoint=goalPoint;
		blockedSet=new HashSet();
		for(int i=0;i<blockedPoints.length;i++){
			blockedSet.add(blockedPoints[i]);
		}
		this.jumpPoint=jumpPoint;
	}
	public AStarTest(GridXY goalPoint,GridXY[] blockedPoints){
		this(goalPoint,blockedPoints,null	);
	}
	
	@Override
	public float estimateCostTotal(Object node) {
		
		return getCostToAdjacentNode(node, goalPoint);
	}

	@Override
	public Iterator getAdjacentNodes(Object node) {
		GridXY nodePoint=(GridXY)node;
		float x=nodePoint.x;
		float y=nodePoint.y;
		List list=new ArrayList();
		if(nodePoint.equals(jumpPoint)){
			list.add(goalPoint);
			return list.iterator();
		}
		for(int offsetx=-1;offsetx<2;offsetx++){
			for(int offsety=-1;offsety<2;offsety++){
				if((offsety==0&& offsetx==0) ||(offsety==-1&& offsetx==-1)||(offsety==1&& offsetx==1)||(offsety==-1&& offsetx==1)||(offsety==1&& offsetx==1)){
					continue;
				}
				float newX=x+offsetx;
				float newY=y+offsety;
				if((newX<MIN_X) ||(newY<MIN_Y) ||(newX>MAX_X) ||(newY>MAX_Y)){
					continue;
				}
				GridXY point=new GridXY(newX,newY);
				if(!blockedSet.contains(point)){
					list.add(point);
				}
			}
		}
		return list.iterator();
	}

	@Override
	public float getCostToAdjacentNode(Object fromNode, Object toNode) {
		if(fromNode.equals(jumpPoint)){
			return 0;
		}
		
		return ((GridXY)fromNode).distanceXY((GridXY)toNode);
	}

	@Override
	public boolean isGoalNode(Object node) {
		return ((GridXY)node).equals(goalPoint);
	}
	
}
