package tv.sparkening.challengesplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NonNull;

public class ChallengeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String @NonNull [] args) {
        if (sender instanceof Player player) {

            // Initialize the menu AND assign it to the 'menu' variable
            Inventory menu = Bukkit.createInventory(null, 9, "Challenge-Selector");

            // Item to represent Challenge
            ItemStack rouletteItem = new ItemStack(Material.REDSTONE);

            // Place the item into the first slot (index 0) of the 'menu'
            menu.setItem(0, rouletteItem);

            // Open the 'menu' for the player
            player.openInventory(menu);
        }
        return true;
    }
}