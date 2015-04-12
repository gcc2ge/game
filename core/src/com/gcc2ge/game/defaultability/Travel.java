package com.gcc2ge.game.defaultability;

import com.gcc2ge.game.area.Location;
import com.gcc2ge.game.area.Portal;
import com.gcc2ge.game.entity.Player;

public class Travel implements DefaultAbility {

	@Override
	public String getActionName() {
		
		return "Travel";
	}

	@Override
	public boolean canActivate(Player parent, Location target) {
		Portal p=target.getPortal();
		if(p!=null){
			return true;
		}
		return false;
	}

	@Override
	public void activate(Player parent, Location target) {
		boolean needToMove=true;
		if(target.getDistance(parent.positionX, parent.positionY)<=1){
			needToMove=false;
		}
		if(needToMove){
			parent.addFinishMoveCallBack(new TravelCallBack(parent, target));
			parent.go((int)target.getX(), (int)target.getY());
		}else{
			//�л�����
			parent.positionX=target.getX();
			parent.positionY=target.getY();
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
			if(target.getDistance(parent.positionX, parent.positionY)<=1){
				//�л�����
				parent.positionX=target.getX();
				parent.positionY=target.getY();
			}
		}
	}
}
