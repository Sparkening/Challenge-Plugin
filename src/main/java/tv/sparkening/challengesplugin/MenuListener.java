package tv.sparkening.challengesplugin;

import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;

import javax.swing.*;
import java.awt.*;

public class MenuListener implements Listener {

    @EventHandler
    public void OnMenuClick(InventoryClickEvent event) {
        String menuTitle = PlainTextComponentSerializer.plainText().serialize(event.getView().title());
        if (menuTitle.equals("Challenge-Selector")) {
            event.setCancelled(true);

            //who clicked?
            Player player = (Player) event.getWhoClicked();

            //close menu if redstone/ slot0 was selected
            if (event.getRawSlot() == 0) {
                player.closeInventory();
                ChallengesPlugin.isRouletteActive = true;

            }
        }
    }
}
