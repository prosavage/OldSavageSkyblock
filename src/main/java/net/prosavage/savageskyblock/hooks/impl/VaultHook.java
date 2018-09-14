package net.prosavage.savageskyblock.hooks;

import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;

public class VaultHook implements PluginHook<VaultHook> {
	
	@Override
	public VaultHook setup() {
		RegisteredServiceProvider<Economy> rsp = SavageSkyblock.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return null;
		}
    //
		//SavageSkyblock.getInstance().econ = rsp.getProvider();
		return this;
	}

	@Override
	public String getName() {
		return "Vault";
	}

}
