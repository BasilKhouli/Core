package me.basil.core.data;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    private HashMap<UUID, PlayerData> playerData = new HashMap<>();

    public PlayerData getPlayerData(UUID uuid) {
        return playerData.get(uuid);
    }

}
