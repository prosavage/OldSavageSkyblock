package net.prosavage.savageskyblock.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.prosavage.savageskyblock.util.gson.typeadapters.EnumTypeAdapter;
import net.prosavage.savageskyblock.util.gson.typeadapters.InventoryTypeAdapter;
import net.prosavage.savageskyblock.util.gson.typeadapters.LocationTypeAdapter;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public class GsonUtil {

    public static Gson createGson() {
        return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().enableComplexMapKeySerialization()
                .registerTypeAdapter(Location.class, new LocationTypeAdapter())
                .registerTypeAdapter(Inventory.class, new InventoryTypeAdapter())
                .registerTypeAdapterFactory(EnumTypeAdapter.ENUM_FACTORY).create();
    }


}
