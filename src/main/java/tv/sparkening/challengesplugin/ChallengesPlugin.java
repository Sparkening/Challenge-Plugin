package tv.sparkening.challengesplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class ChallengesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Hello from the Challenges Plugin!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
