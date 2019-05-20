package com.linesix.akhaten.common.blocks.gallifrey;

import com.linesix.akhaten.common.Reference;
import com.linesix.akhaten.common.blocks.DimBlocks;
import com.linesix.akhaten.common.blocks.Names;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class GallifreyDirt extends Block {

  public GallifreyDirt() {

    super(Material.GROUND);
    
    setUnlocalizedName(getUnlocalizedName());
    setRegistryName(Reference.RESOURCE_PREFIX + Names.Dimensional.gallifrey_dirt);
    setCreativeTab(DimBlocks.dimblocktab);
    setSoundType(SoundType.PLANT);

  }
  
  @Override
  public String getUnlocalizedName() {
	  
	  return "tile." + Reference.RESOURCE_PREFIX + Names.Dimensional.gallifrey_dirt;
	  
  }

}
