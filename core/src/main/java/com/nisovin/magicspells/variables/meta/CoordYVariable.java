package com.nisovin.magicspells.variables.meta;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import com.nisovin.magicspells.util.PlayerNameUtils;
import com.nisovin.magicspells.variables.variabletypes.MetaVariable;

public class CoordYVariable extends MetaVariable {

	@Override
	public double getValue(String player) {
		Player p = PlayerNameUtils.getPlayerExact(player);
		if (p != null) return p.getLocation().getY();
		return 0D;
	}
	
	@Override
	public void set(String player, double amount) {
		Player p = PlayerNameUtils.getPlayerExact(player);
		if (p == null) return;

		Location to = p.getLocation();
		to.setY(amount);
		p.teleport(to, TeleportCause.PLUGIN);
	}

}
