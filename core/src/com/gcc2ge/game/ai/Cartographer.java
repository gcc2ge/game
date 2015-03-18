package com.gcc2ge.game.ai;

import java.util.Iterator;

public interface Cartographer {
	public float estimateCostTotal(Object node);
	public Iterator getAdjacentNodes(Object node);
	public float getCostToAdjacentNode(Object fromNode,Object toNode);
	public boolean isGoalNode(Object node);
}
