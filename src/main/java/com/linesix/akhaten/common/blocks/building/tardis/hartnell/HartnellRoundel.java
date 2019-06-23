package com.linesix.akhaten.common.blocks.building.tardis.hartnell;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.BlockTypes;
import com.linesix.akhaten.common.blocks.registries.BuildingBlocks;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.blocks.item.IMetaBlockName;
import com.linesix.akhaten.util.Misc;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class HartnellRoundel extends Block {

    public HartnellRoundel() {
        super(Material.IRON);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Hartnell.hartnell_roundels);
        setCreativeTab(BuildingBlocks.buildblocktab);
        setSoundType(SoundType.METAL);
    }

    @Override
    public String getUnlocalizedName() {return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Hartnell.hartnell_roundels;}

}
