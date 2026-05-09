package tv.sparkening.challengesplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class HubListener implements Listener {

    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent event) {
        Player player = event.getPlayer(); // saves player that joined
        player.teleport(new Location(Bukkit.getWorld("challenge_hub"), 0.0, 100.0, 0.0));
    }
}