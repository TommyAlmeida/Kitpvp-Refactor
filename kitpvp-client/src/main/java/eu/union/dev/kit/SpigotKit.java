package eu.union.dev.kit;

import eu.union.dev.utils.ItemBuilder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface SpigotKit extends IKit {

    ItemStack getIcon();
    void setIcon(ItemBuilder itemBuilder);

    void apply(Player player);
}
