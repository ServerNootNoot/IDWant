package lol.nightshade.idwant;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class IDWant extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        FileConfiguration config = getConfig();
        List<String> recipesToRemove = config.getStringList("Recipes");

        for (String recipe : recipesToRemove) {
            removeRecipe(recipe);
        }

        getLogger().info("Configured recipes have been removed.");
    }

    private void removeRecipe(String recipeName) {
        NamespacedKey key = NamespacedKey.minecraft(recipeName);
        if (Bukkit.removeRecipe(key)) {
            getLogger().info("Removed recipe: " + recipeName);
        } else {
            getLogger().warning("Failed to remove recipe: " + recipeName);
        }
    }
}
