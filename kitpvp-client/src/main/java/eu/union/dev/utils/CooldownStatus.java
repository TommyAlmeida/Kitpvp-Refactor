package eu.union.dev.utils;

import java.util.concurrent.TimeUnit;

public class CooldownStatus {

    private int charges;
    private long cooldown;
    private boolean recharged;

    public CooldownStatus(int charges) {
        this.charges = charges;
        this.cooldown = 0L;
        this.recharged = true;
    }

    public int getCharges() {
        return this.charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public boolean isRecharged() {
        return this.recharged;
    }

    public void setRecharged(boolean recharged) {
        this.recharged = recharged;
    }

    public void setCooldown(long delay, TimeUnit unit) {
        this.cooldown = (System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(delay, unit));
    }

    public boolean isExpired() {
        long rem = getRemainingTime(TimeUnit.MILLISECONDS);
        return rem < 0L;
    }

    public long getRemainingTime(TimeUnit unit) {
        return unit.convert(this.cooldown - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
}
