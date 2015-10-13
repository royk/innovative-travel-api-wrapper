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

    public JsonObject getAsJson() {
        JsonObject jo = new JsonObject();
        jo.addProperty("name", getPropFromInitializer("name"));
        jo.addProperty("id", getPropFromInitializer("id"));
        jo.addProperty("type", getPropFromInitializer("type"));
        jo.addProperty("subtype", getPropFromInitializer("subtype"));
        return jo;
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