package com.linesix.akhaten.sound;

import com.linesix.akhaten.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class SoundRegistry {

   /* This class Handles sound registration of Akhaten
    *
    * Author: Felix Eckert ( TheBertrahmPlays / Angry German )
    *
    */

    public static String[] sounds;

    public static void init() { // Function to write the sound names to array "sounds"

        sounds = new String[] {

          "tardis_demat"

        };

    }

    public static SoundEvent registerSound(String sound) { // Basically returns a new SoundEvent for the given name

        ResourceLocation location = new ResourceLocation(Reference.RESOURCE_PREFIX + sound); // Create the new resource location for the sound
        SoundEvent event = new SoundEvent(location); // Create the new SoundEvent
        event.setRegistryName(Reference.RESOURCE_PREFIX + sound); // Set the registry name

        return event; // Return the sound event

    }

    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<SoundEvent> event) { // Register the sounds

        final IForgeRegistry<SoundEvent> registry = event.getRegistry(); // Get the registry from the event

        for (String sound : sounds) { // Loop through the sounds array and register the according sound

            registry.register(registerSound(sound)); // Register the sound

        }

    }

}
