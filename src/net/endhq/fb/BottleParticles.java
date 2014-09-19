package net.endhq.fb;

import net.endhq.particles.ParticlesLibrary;
import net.endhq.particles.ParticlesType;

import org.bukkit.entity.Item;

public class BottleParticles implements Runnable {
	private Item i;
	public BottleParticles(Item i) {
		this.i=i;
	}
	
	@Override
	public void run() {
		try {
			ParticlesLibrary.createGlobalParticleEffect(i.getLocation(), ParticlesType.FLAME, 0.01F, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
