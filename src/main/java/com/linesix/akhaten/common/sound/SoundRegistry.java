package com.linesix.akhaten.common.sound;

import com.linesix.akhaten.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber( modid = Reference.MODID )
public class SoundRegistry {

   /* This class Handles sound registration of Akhaten
    *
    * Author: Felix Eckert ( TheBertrahmPlays / Angry German )
    *
    * NOTE: ONLY APPEND TO ARRAYS
    *
    */

    public static String[] sound_paths;
    public static String[] sound_names;

    public static List<SoundEvent> sound_events = new ArrayList<SoundEvent>();

    public static void init() { // Function to write the sound names to array "sounds"

        sound_paths = new String[] {

          "machines/tardis_demat",
          "machines/tardis_remat"

        };

        sound_names = new String[] {

                "tardis_demat",
                "tardis_remat"

        };

        for (String sound_name : sound_names) {

            for (String sound_path : sound_paths) {

                sound_events.add(registerSound(sound_name, sound_path));

            }

        }

    }

    public static SoundEvent registerSound(String sound_name, String sound_path) { // Basically returns a new SoundEvent for the given name

        ResourceLocation location = new ResourceLocation(Reference.MODID, sound_path); // Create the new resource location for the sound
        SoundEvent event = new SoundEvent(location); // Create the new SoundEvent
        event.setRegistryName(Reference.RESOURCE_PREFIX + sound_path); // Set the registry name

        return event; // Return the sound event

    }

    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<SoundEvent> event) { // Register the sounds

        final IForgeRegistry<SoundEvent> registry = event.getRegistry(); // Get the registry from the event

        for (SoundEvent sound : sound_events) { // Loop through the sounds array and register the according sound

            registry.register(sound); // Register the sound

            System.out.println(sound);

        }
    }

}
