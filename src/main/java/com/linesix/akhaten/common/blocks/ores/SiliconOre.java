package com.linesix.akhaten.common.blocks.ores;

import java.util.Random;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.Names;
import com.linesix.akhaten.common.blocks.registries.DimBlocks;
import com.linesix.akhaten.common.items.registries.Materials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class SiliconOre extends Block {

	public SiliconOre() {
		super(Material.ROCK);
		
		setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Ores.silicon_ore);
        setCreativeTab(DimBlocks.dimblocktab);
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 1);
	}

    @Override
    public String getUnlocalizedName() {
        return "tile." + Reference.RESOURCE_PREFIX + Names.Ores.silicon_ore;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	return Materials.silicate_clump;
    }
    
    @Override
    public int quantityDropped(Random random) {
        return random.nextInt(6);
    }
    
}
