package tv.sparkening.challengesplugin;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ChallengesPlugin extends JavaPlugin {

    public static String activeChallenge = null;
    public static int TimeElapsed = 0;
    public static boolean isActive = true;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new DamageRoulette(), this);

        // Registers the commands
        Objects.requireNonNull(getCommand("challenge")).setExecutor(new ChallengeCommand());
        Objects.requireNonNull(getCommand("timer")).setExecutor(new TimerCommand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        // Timer
        getServer().getScheduler().runTaskTimer(this, () -> {

            if (ChallengesPlugin.activeChallenge != null && ChallengesPlugin.isActive) {
                TimeElapsed++; // Add 1 to the clock

                int seconds = TimeElapsed % 60;
                int totalMinutes = TimeElapsed / 60;

                int totalHours = totalMinutes / 60;
                int totalDays = totalHours / 24;

                int minutes = totalMinutes % 60;
                int hours = totalHours % 24;

                // Loop through all online players
                for (Player player : getServer().getOnlinePlayers()) {

                    // Send them the action bar message
                    String timeMessage = "";
                    if (totalDays > 0) {
                        timeMessage += totalDays + "d ";
                    }
                    if (hours > 0) {
                        timeMessage += hours + "h ";
                    }
                    if (minutes >= 0) {
                        timeMessage += minutes + "m ";
                    }
                    if (seconds >= 0) {
                        timeMessage += seconds + "s";
                    }

                    player.sendActionBar(net.kyori.adventure.text.Component.text(timeMessage));
                }
            }

        }, 0L, 20L); // 0L means start immediately, 20L means repeat every 20 ticks (1 second)
    }

    public void onDisable() {
        // Plugin shutdown logic
    }
}
