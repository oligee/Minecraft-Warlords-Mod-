package com.Testmod;

import com.Testmod.init.item.TestItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestTab extends CreativeTabs {

	public TestTab(String label) {
		super(label);
		this.setBackgroundImageName("test.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return TestItems.wooden_dagger;
	}

}
