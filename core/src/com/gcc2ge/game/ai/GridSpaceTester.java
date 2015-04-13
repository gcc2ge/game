package com.gcc2ge.game.ai;

import com.gcc2ge.game.MapProcess;

/**
 * 测试障碍物
 * @author Administrator
 *
 */
public class GridSpaceTester implements SpaceTester {
	final int width=172;
	final int height=314;
	@Override
	public boolean isSpaceAvailable(PointXY point) {
		GridXY g=(GridXY)point;
		if(MapProcess.mapCollideArray.contains(g)){
			return false;
		}
		if(g.getX()<0||g.getY()<0||g.getX()>=width||g.getY()>=height){
			return false;
		}
		return true;
	}

}
