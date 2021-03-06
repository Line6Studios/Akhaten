package com.linesix.akhaten.common.blocks;

import com.linesix.akhaten.common.Reference;
import net.minecraft.util.IStringSerializable;

public class BlockTypes {

   /* This class contains sub-classes (enums) for Blocktypes
    *
    * Author: Felix Eckert ( TheBertrahmPlays / Angry German )
    *
    */

    public enum HartnellRoundelTypes implements IStringSerializable {

        // This enum contains different block-types
        // of the 1963 / William Hartnell Roundels

        NORMAL("normal", 0),
        HIGHRES("high_res", 1);

        private int ID;
        private String name;
        public static String[] unlocNames;

        HartnellRoundelTypes(String name, int ID) {
        	
            this.ID = ID;
            this.name = name;
        	
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public int getID() {
            return this.ID;
        }

        @Override
        public String toString() {
            return getName();
        }
        
    }

}
