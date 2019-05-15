package com.linesix.akhaten.blocks.building;

import com.linesix.akhaten.Reference;
import com.linesix.akhaten.blocks.BlockTypes;
import com.linesix.akhaten.blocks.DimBlocks;
import com.linesix.akhaten.blocks.Names;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import com.linesix.akhaten.blocks.interfaces.item.IMetaBlockName;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

public class HartnellRoundel extends Block implements IMetaBlockName {

    public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockTypes.HartnellRoundelTypes.class);

    public HartnellRoundel() { // Hartnell Roundel constructor

        super(Material.IRON);

        setUnlocalizedName(getUnlocalizedName());
        setRegistryName(Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Roundels.hartnell_roundels);
        setCreativeTab(DimBlocks.dimblocktab);
        setSoundType(SoundType.METAL);
        setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockTypes.HartnellRoundelTypes.NORMAL));

    }

    @Override
    public String getUnlocalizedName() {

        return "tile." + Reference.RESOURCE_PREFIX + Names.Machines.Tardis.Roundels.hartnell_roundels;

    }

    // Block State related code below \/

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, new IProperty[] {TYPE});

    }

    @Override
    public int getMetaFromState(IBlockState state) {

        BlockTypes.HartnellRoundelTypes type = (BlockTypes.HartnellRoundelTypes) state.getValue(TYPE);

        return type.getID();

    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(TYPE, BlockTypes.HartnellRoundelTypes.values()[meta]);

    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {

        for(int i = 0; i < BlockTypes.HartnellRoundelTypes.values().length; i++) {

            items.add(new ItemStack(this, 1, i));

        }

    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return BlockTypes.HartnellRoundelTypes.values()[stack.getItemDamage()].getName();
    }

}
