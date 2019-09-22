package eu.union.dev.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ItemBuilder {

    private String name;
    private List<String> lore;

    public int amount;
    public Material type;

    private ItemBuilder(String name, String... lore) {
        this.name = name;
        this.lore = Arrays.asList(lore);
        this.amount = 1;
    }

    private ItemBuilder(String name) {
        this(name, "");
    }

    public static ItemBuilder of(String name, String... lore){
        return new ItemBuilder(name, lore);
    }

    public static ItemBuilder of(String name){
        return new ItemBuilder(name);
    }

    public ItemBuilder with(Consumer<ItemBuilder> consumer){
        consumer.accept(this);
        return this;
    }

    public ItemStack wrap(){
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);

        item.setItemMeta(meta);

        return item;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public void setName(String name) {
        this.name = name;
    }
}
