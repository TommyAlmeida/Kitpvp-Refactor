package eu.union.dev.ability.impl;

import eu.union.dev.ability.BaseAbility;
import eu.union.dev.utils.Cooldown;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.TimeUnit;

public class PyroAbility extends BaseAbility {

    private static final String NAME = "Pyro";
    private static final int TIME = 30;

    public PyroAbility() {
        super(NAME);
    }

    @Override
    public void activate(Player player) {
        Cooldown cooldown = new Cooldown(1, TIME, TimeUnit.SECONDS);
        ItemStack itemInHand = player.getItemInHand();

        if(itemInHand == null){
            return;
        }

        if(itemInHand.getType() == null){
            return;
        }

        if (itemInHand.getType() == Material.FIREBALL) {
            if (!cooldown.tryUse(player)) {
                return;
            }

            Fireball ball = player.launchProjectile(Fireball.class);

            if(ball == null){
                return;
            }

            ball.setIsIncendiary(true);
            ball.setYield(ball.getYield() * 1.5F);
        }
    }
}
