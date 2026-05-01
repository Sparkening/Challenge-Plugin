package tv.sparkening.challengesplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ChallengesPlugin extends JavaPlugin {

    public static String activeChallenge = null;
    public static int rouletteTimeElapsed = 0;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DamageRoulette(), this);

        // Register our new command and menu listener too!
        Objects.requireNonNull(getCommand("challenge")).setExecutor(new ChallengeCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        // Timer
        getServer().getScheduler().runTaskTimer(this, () -> {

            if (Objects.equals(ChallengesPlugin.activeChallenge, "DamageRoulette")) {
                rouletteTimeElapsed++; // Add 1 to the clock

                // Loop through all online players
                for (Player player : getServer().getOnlinePlayers()) {

                    // Send them the action bar message
                    player.sendActionBar(net.kyori.adventure.text.Component.text("Time: " + rouletteTimeElapsed + "s"));
                }
            }

        }, 0L, 20L); // 0L means start immediately, 20L means repeat every 20 ticks (1 second)
    }

    public void onDisable() {
        // Plugin shutdown logic
    }
}
