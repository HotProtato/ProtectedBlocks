package me.MajorSkillage.ProtectedBlocks.Listeners;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import me.MajorSkillage.ProtectedBlocks.ProtectedBlocks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class onBlockBreakEvent implements Listener {
	private static ProtectedBlocks plugin;
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		if(plugin.protectedBlocks.containsKey(e.getBlock())){
			for(Entry<UUID, HashMap<String, List<Block>>> en : plugin.claimedBlocks.entrySet()){
				for(Entry<String, List<Block>> en1 : en.getValue().entrySet()){
					if(en1.getValue().contains(e.getBlock()));
					String index = en1.getKey();
					if(!index.equals(null)){
						if(!plugin.allowedUsers.containsKey(p.getUniqueId())){
							e.setCancelled(true);
							Player owner = Bukkit.getPlayer(plugin.protectedBlocks.get(e.getBlock()));
							p.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You need " + ChatColor.GOLD + owner + "\'s " + ChatColor.RED + "permission!");
						}
					}
				}
			}
		}
	}
}
