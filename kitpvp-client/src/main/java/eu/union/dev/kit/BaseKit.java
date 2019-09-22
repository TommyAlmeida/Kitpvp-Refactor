package eu.union.dev.kit;

import eu.union.dev.utils.ItemBuilder;
import org.bukkit.inventory.ItemStack;

public abstract class BaseKit implements SpigotKit {

    private String name;
    private ItemStack icon;

    @Override
    public ItemStack getIcon() {
        return icon;
    }

    @Override
    public void setIcon(ItemBuilder itemBuilder) {
        this.icon = itemBuilder.wrap();
    }

    @Override
    public String getName() {
        return  name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
