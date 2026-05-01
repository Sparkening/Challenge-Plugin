package tv.sparkening.challengesplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.Objects;

public class DamageRoulette implements Listener {

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (Objects.equals(ChallengesPlugin.activeChallenge, "DamageRoulette")) {
            if (event.getEntity() instanceof Player player) {
                org.bukkit.Location dropLocation = player.getLocation();

                java.util.Random random = new java.util.Random();

                org.bukkit.Material[] allItems = org.bukkit.Material.values();
                org.bukkit.Material randomType = allItems[random.nextInt(allItems.length)];

                dropLocation.getWorld().dropItemNaturally(dropLocation, new org.bukkit.inventory.ItemStack(randomType));
            }
        }
    }
}
