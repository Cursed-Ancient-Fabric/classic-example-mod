package net.fabricmc.example;

import com.mojang.minecraft.MinecraftApplet;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.entrypoint.EntrypointTransformer;
import net.fabricmc.loader.launch.common.FabricLauncherBase;
import java.lang.reflect.InvocationTargetException;

public class ExampleMod implements ModInitializer {

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// This is a workaround to let loader load the class.
		try {
			MinecraftApplet clazz = (MinecraftApplet) FabricLauncherBase.getLauncher().getTargetClassLoader().loadClass(EntrypointTransformer.appletMainClass).getDeclaredConstructor().newInstance();
			clazz.run();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
			e.printStackTrace();
		}


		System.out.println("Hello Fabric world!");
	}
}
