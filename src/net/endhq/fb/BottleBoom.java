package net.endhq.fb;

import org.bukkit.entity.Item;

public class BottleBoom implements Runnable {

	
	private Item i;
	public BottleBoom(Item i) {
		this.i=i;
	}
	
	
	@Override
	public void run() {
		// TODO particles
		i.getLocation().getWorld().createExplosion(i.getLocation().getX(), i.getLocation().getY(), i.getLocation().getZ(), 2F, true, false);
		i.remove();
	}

}
