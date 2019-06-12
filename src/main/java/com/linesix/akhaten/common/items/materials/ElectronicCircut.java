package com.linesix.akhaten.common.items.materials;

import com.linesix.akhaten.common.items.ItemBase;
import com.linesix.akhaten.common.items.ItemNames;
import com.linesix.akhaten.common.items.registries.Materials;
import net.minecraft.creativetab.CreativeTabs;

public class ElectronicCircut extends ItemBase {
    public ElectronicCircut() {
        super(ItemNames.Materials.electronic_circuit, ItemNames.Materials.electronic_circuit, Materials.materialtab);
    }
}
