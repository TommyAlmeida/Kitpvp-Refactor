package eu.union.dev.ability;

import eu.union.dev.kit.Ability;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.swing.*;
import java.util.List;

public interface SpigotAbility extends Ability {

    ItemStack getItemStack();

    List<Action> getActions();

    boolean hasAction(Action action);

    void activate(Player player);
}
