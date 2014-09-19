package net.endhq.fb;

import net.endhq.particles.ParticlesLibrary;
import net.endhq.particles.ParticlesType;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static boolean fbon = true;
	@Override
	public void onEnable() {
		this.getCommand("givefirebomb").setExecutor(this);
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if((cmd.getName().equalsIgnoreCase("givefirebomb"))&&(sender.hasPermission("firebomb.give"))&&(args.length==1)) {
			if((Bukkit.getPlayer(args[0])==null)) {
				sender.sendMessage("Player not found");
				return true;
			}
			ItemStack s = new ItemStack(Material.getMaterial(2261), 1);
			ItemMeta m = s.getItemMeta();
			m.setDisplayName(ChatColor.RED+"Fire "+ChatColor.GOLD+"Bomb");
			s.setItemMeta(m);
			Bukkit.getPlayer(args[0]).getInventory().addItem(s);
			return true;
		}
		if((cmd.getName().equalsIgnoreCase("firebombtoggle"))&&(sender.hasPermission("firebomb.toggle"))) {
			fbon=!fbon;
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e) {
		if(!(e.getAction()==Action.RIGHT_CLICK_AIR || e.getAction()==Action.RIGHT_CLICK_BLOCK) || 
				!(e.getPlayer().getItemInHand().getType()==Material.getMaterial(2261)) ||
				!(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED+"Fire "+ChatColor.GOLD+"Bomb"))) 
			return;
		Item i = e.getPlayer().getWorld().dropItem(e.getPlayer().getEyeLocation(), new ItemStack(Material.getMaterial(2261), 1));
		i.setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.5D));
		i.setPickupDelay(100000);
		ItemStack old = new ItemStack(e.getPlayer().getItemInHand().getType(), e.getPlayer().getItemInHand().getAmount() - 1);
        e.getPlayer().setItemInHand(old);
		Bukkit.getScheduler().runTaskLater(this, new BottleBoom(i), 30L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 1L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 2L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 3L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 4L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 5L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 6L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 7L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 8L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 9L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 10L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 11L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 12L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 13L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 14L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 15L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 16L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 17L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 18L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 19L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 20L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 21L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 22L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 23L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 24L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 25L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 26L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 27L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 28L);
		Bukkit.getScheduler().runTaskLater(this, new BottleParticles(i), 29L);
		try {
			ParticlesLibrary.createGlobalParticleEffect(e.getPlayer().getEyeLocation(), ParticlesType.LARGE_SMOKE, 1F, 30);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@EventHandler
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent e) {
		if(e.getItem().getItemStack().getType()==Material.getMaterial(2261) && (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED+"Fire "+ChatColor.GOLD+"Bomb"))) e.setCancelled(true);
	}
}
