package com.gcc2ge.game.ai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GridCartographer implements Cartographer {
	public static final int DEFAULT_SETP_SIZE=1;
	
	public final List adjcentList;
	public final int stepSize;
	private final SpaceTester spaceTester;
	private PointXY goalPointXY;
	
	public GridCartographer(SpaceTester spaceTester,int stepSize){
		this.spaceTester=spaceTester;
		this.stepSize=stepSize;
		adjcentList=new ArrayList();
	}
	public GridCartographer(SpaceTester spaceTest){
		this(spaceTest,DEFAULT_SETP_SIZE);
	}
	public void setGoalPointXY(PointXY pointXY){
		this.goalPointXY=pointXY;
	}
	
	
	@Override
	public float estimateCostTotal(Object node) {
		return ((PointXY)node).distanceXY(goalPointXY);
	}

	@Override
	public Iterator getAdjacentNodes(Object node) {
		PointXY pointXY=(PointXY)node;
		adjcentList.clear()	;
		float distanceToGoal=pointXY.distanceXY(goalPointXY);//estimate
		///////以前点相邻节点会通过，因为没判断目标节点是否可以通过
		if(distanceToGoal<=stepSize && spaceTester.isSpaceAvailable(goalPointXY)){
			adjcentList.add(goalPointXY);
			return adjcentList.iterator();
		}
		float x=pointXY.getX();
		float y=pointXY.getY();
		for(int ix=-1;ix<2;ix++){
			for(int iy=-1;iy<2;iy++){
				//(iy==1&& ix==-1) 以前写错一个判断
				if((iy==0&& ix==0) ||(iy==-1&& ix==-1)||(iy==1&& ix==1)||(iy==-1&& ix==1)||(iy==1&& ix==-1)){
					continue;
				}
//				PointXY step=new GridXY(((int)(x/stepSize)+ix)*stepSize,((int)(y/stepSize)+iy)*stepSize);
				PointXY step=new GridXY(x+ix,y+iy);
				if(spaceTester.isSpaceAvailable(step)){
					adjcentList.add(step);
				}
			}
		}
		
		return adjcentList.iterator();
	}

	@Override
	public float getCostToAdjacentNode(Object fromNode, Object toNode) {
		return ((PointXY)fromNode).distanceXY((PointXY)toNode);
	}

	@Override
	public boolean isGoalNode(Object node) {
		return goalPointXY.distanceXY((PointXY)node)==0;
	}

}
