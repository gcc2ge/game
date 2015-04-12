package com.gcc2ge.game.area.defaultability;

import com.gcc2ge.game.area.Location;
import com.gcc2ge.game.entity.Player;

interface  DefaultAbility {
	public String getActionName();
	public boolean canActivate(Player parent,Location target);
	public void activate(Player parent,Location target);
	public DefaultAbility getInstance();
}
