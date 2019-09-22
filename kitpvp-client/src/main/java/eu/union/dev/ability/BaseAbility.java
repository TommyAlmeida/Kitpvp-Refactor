package eu.union.dev.ability;

import org.bukkit.entity.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseAbility implements SpigotAbility {

    private List<Action> actions;
    private String name;

    public BaseAbility(String name) {
        this.name = name.toLowerCase();
        actions = new ArrayList<>();
    }

    @Override
    public List<Action> getActions() {
        return actions;
    }

    @Override
    public boolean hasAction(Action action) {
        return actions.contains(action);
    }

    @Override
    public String getName() {
        return name;
    }
}
