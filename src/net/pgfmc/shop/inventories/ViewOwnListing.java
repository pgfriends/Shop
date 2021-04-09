package net.pgfmc.shop.inventories;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import net.pgfmc.shop.Listing;
import net.pgfmc.shop.Main;

public class ViewOwnListing implements InventoryHolder {
	
	private Listing listing;
	private Inventory inv;
	public boolean isTaken = false;
	
	public ViewOwnListing(Listing listing) {
		this.listing = listing;
		inv = Bukkit.createInventory(this, 27, Main.getName(listing.getItem().getType()));
		
		invBuilder();
	}
	
	private void invBuilder() {
		
		inv.setItem(0, Main.createItem("�eBack", Material.FEATHER));
		inv.setItem(12, Main.switchLore(listing.getItem(), new ArrayList<String>()));
		inv.setItem(14, Main.createItem("take the item to delete the Listing!", Material.PAPER));
	}
	
	public Listing getListing() {
		return listing;
	}
	
	public void confirmBuy() { // clears the inventory, and makes it to where all actions in the inventory are cancelled.
		
		isTaken = true;
		inv.setItem(14, new ItemStack(Material.AIR));
		listing.deleteListing();
		
		ItemStack ironBars = Main.createItem("Item has been taken!", Material.IRON_BARS);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() { // in-inventory animations
            @Override
            public void run() {
            	ItemStack[] itemList = {ironBars, ironBars, ironBars, ironBars, ironBars, ironBars, ironBars, ironBars};
            	int index = 1;
        		for (ItemStack item : itemList) {
        			inv.setItem(index, item);
        			index++;
        		}
            }
        }, 1);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() { // in-inventory animations
            @Override
            public void run() {
            	ItemStack[] itemList = {ironBars, ironBars, ironBars, ironBars, ironBars, ironBars, ironBars, ironBars, ironBars};
            	int index = 9;
        		for (ItemStack item : itemList) {
        			inv.setItem(index, item);
        			index++;
        		}
            }
        }, 4);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
            @Override
            public void run() {
            	ItemStack[] itemList = {ironBars, ironBars, ironBars, ironBars, ironBars, ironBars, ironBars, ironBars, ironBars};
            	int index = 18;
        		for (ItemStack item : itemList) {
        			inv.setItem(index, item);
        			index++;
        		}
            }
        }, 7);
	}
		
	@Override
	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return inv;
	}
}