package eu.union.dev.events;

import eu.union.dev.kit.Ability;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;


public class PlayerAbilityActivateEvent extends PlayerEvent implements Cancellable {

    private HandlerList list;
    private boolean cancellable;

    private Ability ability;

    public PlayerAbilityActivateEvent(Player who) {
        super(who);
        list = new HandlerList();
    }

    @Override
    public boolean isCancelled() {
        return cancellable;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancellable = b;
    }

    public Ability getAbility() {
        return ability;
    }

    @Override
    public HandlerList getHandlers() {
        return list;
    }
}
