package me.MajorSkillage.ProtectedBlocks;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import me.MajorSkillage.ProtectedBlocks.Listeners.onBlockBreakEvent;

import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ProtectedBlocks extends JavaPlugin implements Listener{
	Plugin plugin;
	public HashMap<UUID, HashMap<String, List<Block>>> claimedBlocks = new HashMap<UUID, HashMap<String, List<Block>>>();
	public HashMap<List<UUID>, String> allowedUsers = new HashMap<List<UUID>, String>();
	public HashMap<Block, UUID> protectedBlocks = new HashMap<Block, UUID>();
	public void onEnable(){
		plugin = this;
		onBlockBreakEvent breakListener = new onBlockBreakEvent();
		getServer().getPluginManager().registerEvents(breakListener, this);
	}
	public void onDisable(){
		plugin = null;
	}
}