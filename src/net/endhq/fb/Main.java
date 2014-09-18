package net.endhq.fb;

import net.endhq.isb.ItemStackBuilder;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		
		
		return false;
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent e) {
		//Todo qualifiers
		Item i = e.getPlayer().getWorld().dropItem(e.getPlayer().getLocation(), new ItemStack(Material.getMaterial(2261), 1));
		i.setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.5D));
		
	}
}
