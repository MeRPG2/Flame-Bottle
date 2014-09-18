package net.endhq.fb;

import org.bukkit.entity.Item;

public class BottleBoom implements Runnable {

	
	private Item i;
	public BottleBoom(Item i) {
		this.i=i;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		i.getLocation().getWorld().createExplosion(i.getLocation().getX(), i.getLocation().getY(), i.getLocation(), arg3, arg4, arg5)
	}

}
