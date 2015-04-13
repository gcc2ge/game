package com.gcc2ge.game.defaultability;

import com.gcc2ge.game.area.Location;
import com.gcc2ge.game.area.Portal;
import com.gcc2ge.game.entity.Player;

public class Travel implements DefaultAbility {
	public Portal currentPortal;
	@Override
	public String getActionName() {
		
		return "Travel";
	}

	@Override
	public boolean canActivate(Player parent, Location target) {
		currentPortal=target.getPortal();
		if(currentPortal!=null){
			return true;
		}
		return false;
	}

	@Override
	public void activate(Player parent, Location target) {
		boolean needToMove=true;
		if(target.getDistance(parent.positionX/16, parent.positionY/16)<=0){
			needToMove=false;
		}
		if(needToMove){
			parent.addFinishMoveCallBack(new TravelCallBack(parent, target));
			parent.go((int)target.getX(), (int)target.getY());
		}else{
			//切换场景
			parent.positionX=currentPortal.targetLocation.getX()*16;
			parent.positionY=currentPortal.targetLocation.getY()*16;
		}
	}

	@Override
	public DefaultAbility getInstance() {
		
		return new Travel();
	}
	private class TravelCallBack implements Runnable{
		private Player parent;
		private Location target;
		private TravelCallBack (Player parent,Location target){
			this.parent=parent;
			this.target=target;
		}
		public void run(){
			if(target.getDistance(parent.positionX/16, parent.positionY/16)<=0){
				//切换场景
				parent.positionX=currentPortal.targetLocation.getX()*16;
				parent.positionY=currentPortal.targetLocation.getY()*16;
			}
		}
	}
}
