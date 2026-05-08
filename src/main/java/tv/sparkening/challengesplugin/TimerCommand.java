package tv.sparkening.challengesplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NonNull;

public class TimerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String @NonNull [] args) {

        if (sender instanceof Player player) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("pause")) {
                    ChallengesPlugin.isActive = false;
                    player.sendMessage(net.kyori.adventure.text.Component.text("Timer Paused!"));
                } else if (args[0].equalsIgnoreCase("resume")) {
                    ChallengesPlugin.isActive = true;
                    player.sendMessage(net.kyori.adventure.text.Component.text("Timer Resumed!"));
                } else if (args[0].equalsIgnoreCase("stop")) {
                    ChallengesPlugin.isActive = false;
                    ChallengesPlugin.TimeElapsed = 0;
                    player.sendMessage(net.kyori.adventure.text.Component.text("Timer Stopped!"));
                }
            }
        }
        return true;
    }
}