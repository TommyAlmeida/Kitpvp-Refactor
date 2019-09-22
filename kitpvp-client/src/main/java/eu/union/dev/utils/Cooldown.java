package eu.union.dev.utils;

import com.google.common.collect.Maps;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Cooldown {

    private final int defaultCharges;
    private final long defaultDelay;
    private Map<String, CooldownStatus> playerStatus;

    public Cooldown(int defaultCharges) {
        this(defaultCharges, 5, TimeUnit.SECONDS);
    }

    public Cooldown(int defaultCharges, int defaultDelay, TimeUnit unit) {
        playerStatus = Maps.newHashMap();
        this.defaultCharges = defaultCharges;
        this.defaultDelay = TimeUnit.MILLISECONDS.convert(defaultDelay, unit);
    }

    public CooldownStatus getStatus(Player player) {
        CooldownStatus status = this.playerStatus.get(player.getName());
        if (status == null) {
            status = createStatus(player);
            this.playerStatus.put(player.getName(), status);
        }

        checkStatus(player, status);
        return status;
    }

    public boolean tryUse(Player player) {
        return tryUse(player, 1, this.defaultDelay, TimeUnit.MILLISECONDS);
    }

    public boolean tryUse(Player player, long delay, TimeUnit unit) {
        return tryUse(player, delay, unit);
    }

    public boolean tryUse(Player player, int charges, long delay, TimeUnit unit) {
        CooldownStatus status = getStatus(player);
        int current = status.getCharges();

        if (!status.isExpired()) {
            return false;
        }

        if(current >= charges){
            status.setCharges(current - charges);
        }

        status.setRecharged(false);
        status.setCharges(0);
        status.setCooldown(delay, unit);

        return current > 0;
    }

    private void checkStatus(Player player, CooldownStatus status) {
        if ((!status.isRecharged()) && (status.isExpired())) {
            rechargeStatus(player, status);
        }
    }

    protected CooldownStatus rechargeStatus(Player player, CooldownStatus status) {
        status.setRecharged(true);
        status.setCharges(this.defaultCharges);
        return status;
    }

    protected CooldownStatus createStatus(Player player) {
        return new CooldownStatus(this.defaultCharges);
    }
}
