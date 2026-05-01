package me.f4stbutterfly.MCPeFramework;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class ConfigFile {

	private final JavaPlugin plugin;
	private File file;
	public FileConfiguration data;

	public ConfigFile(JavaPlugin p, String configFileName) throws IOException {
		this.plugin = p;
		loadConfig(configFileName);
	}

	private void loadConfig(String path) throws IOException {
		file = new File(plugin.getDataFolder(), path);
		if(!file.exists()) {
			plugin.saveResource(path, false);
		}
		data = YamlConfiguration.loadConfiguration(file);
	}
}
