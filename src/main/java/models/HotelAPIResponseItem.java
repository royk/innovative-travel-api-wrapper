package models;

import com.google.gson.JsonObject;

/**
 * Created by user on 13/10/2015.
 */
public class HotelAPIResponseItem {

    private JsonObject initializer;

    public HotelAPIResponseItem(JsonObject initializer) {
        this.initializer = initializer;
    }

    private String getPropFromInitializer(String prop) {
        if (initializer!=null && initializer.has(prop)) {
            return initializer.get(prop).getAsString();
        }
        return "";
    }

    public String getAsJson() {
        if (initializer!=null) {
            return initializer.getAsString();
        }
        return "";
    }

    public String getName() {
        return getPropFromInitializer("name");
    }
    public String getId() {
        return getPropFromInitializer("id");
    }
    public String getType() {
        return getPropFromInitializer("type");
    }
    public String getSubtype() {
        return getPropFromInitializer("subtype");
    }
}