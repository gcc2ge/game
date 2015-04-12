package com.gcc2ge.game.defaultability;

import com.gcc2ge.game.area.Location;
import com.gcc2ge.game.entity.Player;

public class Move implements DefaultAbility {

	@Override
	public String getActionName() {
		
		return "Move";
	}

	@Override
	public boolean canActivate(Player parent, Location target) {
		
		return true;
	}

	@Override
	public void activate(Player parent, Location target) {
		
		parent.go((int)target.getX(), (int)target.getY());
	}

	@Override
	public DefaultAbility getInstance() {
		
		return new Move();
	}

}
