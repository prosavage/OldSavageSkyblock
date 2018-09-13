public interface PluginHook<T> {

	T setup();

	String getName();
	
}
