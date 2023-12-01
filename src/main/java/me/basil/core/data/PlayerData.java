package me.basil.core.data;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import me.basil.core.Main;
import org.bson.Document;

import javax.print.Doc;
import java.util.List;
import java.util.UUID;

public class PlayerData {

    private UUID uuid;
    public PlayerData(Main main, UUID uuid, String username, String rank) {
        this.uuid = uuid;


    }

}
