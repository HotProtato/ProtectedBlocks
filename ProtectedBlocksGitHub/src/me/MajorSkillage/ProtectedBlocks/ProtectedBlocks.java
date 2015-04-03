package me.MajorSkillage.ProtectedBlocks;

import me.MajorSkillage.ProtectedBlocks.Listeners.onBlockBreakEvent;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ProtectedBlocks extends JavaPlugin implements Listener{
	Plugin plugin;
	public void onEnable(){
		plugin = this;
	}
	public void onDisable(){
		plugin = null;
	}
	public void registerEvents(){
		getServer().getPluginManager().registerEvents(onBlockBreakEvent(plugin), this);
	}
}