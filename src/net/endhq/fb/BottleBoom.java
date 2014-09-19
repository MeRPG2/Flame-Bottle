package net.endhq.fb;

import net.endhq.particles.ParticlesLibrary;
import net.endhq.particles.ParticlesType;

import org.bukkit.entity.Item;

public class BottleBoom implements Runnable {

	
	private Item i;
	public BottleBoom(Item i) {
		this.i=i;
	}
	
	
	@Override
	public void run() {
		// TODO particles
		if(!Main.fbon) return;
		i.getLocation().getWorld().createExplosion(i.getLocation().getX(), i.getLocation().getY(), i.getLocation().getZ(), 2F, true, false);
		try {
			ParticlesLibrary.createGlobalParticleEffect(i.getLocation(), ParticlesType.FLAME, 1F, 100);
			ParticlesLibrary.createGlobalParticleEffect(i.getLocation(), ParticlesType.FLAME, 0.03F, 300);
			ParticlesLibrary.createGlobalParticleEffect(i.getLocation(), ParticlesType.LARGE_SMOKE, 1F, 100);
			ParticlesLibrary.createGlobalParticleEffect(i.getLocation(), ParticlesType.LARGE_SMOKE, 0.03F, 200);
			ParticlesLibrary.createGlobalParticleEffect(i.getLocation(), ParticlesType.FIREWORKS_SPARK, 0.5F, 20);
		} catch (Exception e) {
			e.printStackTrace();
		}
		i.remove();
	}

}
