
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.acidpop.escapevelocity.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.acidpop.escapevelocity.entity.RegolithCollectorEntity;
import net.acidpop.escapevelocity.entity.LunarLanderEntity;
import net.acidpop.escapevelocity.entity.LunaRocketEntity;
import net.acidpop.escapevelocity.EscapeVelocityMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EscapeVelocityModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EscapeVelocityMod.MODID);
	public static final RegistryObject<EntityType<RegolithCollectorEntity>> REGOLITH_COLLECTOR = register("regolith_collector", EntityType.Builder.<RegolithCollectorEntity>of(RegolithCollectorEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RegolithCollectorEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LunaRocketEntity>> LUNA_ROCKET = register("luna_rocket", EntityType.Builder.<LunaRocketEntity>of(LunaRocketEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(LunaRocketEntity::new).fireImmune().sized(3f, 16f));
	public static final RegistryObject<EntityType<LunarLanderEntity>> LUNAR_LANDER = register("lunar_lander", EntityType.Builder.<LunarLanderEntity>of(LunarLanderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LunarLanderEntity::new).fireImmune().sized(3f, 2.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			RegolithCollectorEntity.init();
			LunaRocketEntity.init();
			LunarLanderEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(REGOLITH_COLLECTOR.get(), RegolithCollectorEntity.createAttributes().build());
		event.put(LUNA_ROCKET.get(), LunaRocketEntity.createAttributes().build());
		event.put(LUNAR_LANDER.get(), LunarLanderEntity.createAttributes().build());
	}
}
