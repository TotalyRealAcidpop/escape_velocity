package net.acidpop.escapevelocity.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.EntityMountEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;

import net.acidpop.escapevelocity.entity.LunaRocketEntity;

@Mod.EventBusSubscriber
public class PreventRocketExitProcedure {

    @SubscribeEvent
    public static void onEntityDismount(EntityMountEvent event) {
        try {
            // Null-safety checks first
            Entity entity = event.getEntityMounting();
            Entity mount = event.getEntityBeingMounted();
            if (entity == null || mount == null) return;

            // Check if this is a player dismounting from a LunaRocketEntity
            if (event.isDismounting() && entity instanceof Player player && mount instanceof LunaRocketEntity rocket) {

                // Ignore if player is dead or the rocket is being removed
                if (!player.isAlive() || !rocket.isAlive()) return;

                // Check if the rocket has the "takeoff" tag
                if (rocket.getPersistentData().getBoolean("takeoff")) {
                    // Prevent dismount during takeoff
                    event.setCanceled(true);

                    // Show message only on server side, and only if player is alive
                    if (!player.level().isClientSide && player.isAlive()) {
                        player.displayClientMessage(Component.literal("You cannot exit the rocket during takeoff!"), true);
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("[Escape Velocity] Error in PreventRocketExitProcedure: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
