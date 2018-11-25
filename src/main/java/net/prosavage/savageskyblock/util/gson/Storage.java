package net.prosavage.savageskyblock.util.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import com.google.gson.reflect.TypeToken;
import net.prosavage.savageskyblock.SavageSkyblock;
import net.prosavage.savageskyblock.island.Island;

import java.util.Set;

public class Storage {

    private Gson gson;
    private SavageSkyblock plugin;


    public Storage() {
        this.plugin = SavageSkyblock.getInstance();
        this.gson = GsonUtil.createGson();
    }



    public Set<Island> deserializeIslands(String rawIslandsString) {
        return this.gson.fromJson(rawIslandsString, new TypeToken<Set<Island>>() {}.getType());
    }

    public String serializeIslands(Set<Island> islands) {
        return this.gson.toJson(plugin.getIslands());
    }


}
