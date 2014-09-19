package net.endhq.fb;

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
	}
	
	@EventHandler
	public void onPlayerPickupItemEvent(PlayerPickupItemEvent e) {
		if(e.getItem().getItemStack().getType()==Material.getMaterial(2261) && (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED+"Fire "+ChatColor.GOLD+"Bomb"))) e.setCancelled(true);
	}
}
