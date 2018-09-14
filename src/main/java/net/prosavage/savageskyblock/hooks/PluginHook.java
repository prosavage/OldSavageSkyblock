package net.prosavage.savageskyblock.hooks;

public interface PluginHook<T> {

	T setup();

	String getName();
	
}
