package Rice.Chen.BrilliantEndermanMushroom;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Enderman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BrilliantEndermanMushroom extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("BrilliantEndermanMushroom 插件已啟用。");
    }

    @Override
    public void onDisable() {
        getLogger().info("BrilliantEndermanMushroom 插件已關閉。");
    }

    @EventHandler
    public void onEndermanPickUp(EntityChangeBlockEvent event) {
        if (!(event.getEntity() instanceof Enderman)) {
            return;
        }

        Biome biome = event.getBlock().getBiome();
        if (biome != Biome.THE_END) {
            return;
        }

        Material blockType = event.getBlock().getType();
        if (blockType == Material.BROWN_MUSHROOM || blockType == Material.RED_MUSHROOM) {
            event.setCancelled(true);
        }
    }
}