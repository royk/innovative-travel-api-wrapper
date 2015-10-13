package models;

import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 13/10/2015.
 */
public class HotelAPIResponseItemTest {

    @Test
    public void nullInitialization() {
        HotelAPIResponseItem item = new HotelAPIResponseItem(null);
        assertEquals("", item.getId());
        assertEquals("", item.getName());
        assertEquals("", item.getType());
        assertEquals("", item.getSubtype());
        assertNotNull(item.getAsJson());
    }

    @Test
    public void emptyInitialization() {
        HotelAPIResponseItem item = new HotelAPIResponseItem(new JsonObject());
        assertEquals("", item.getId());
        assertEquals("", item.getName());
        assertEquals("", item.getType());
        assertEquals("", item.getSubtype());
        assertNotNull(item.getAsJson());
    }

    @Test
    public void properInitiailization() {
        JsonObject jo = new JsonObject();
        String name = "some name";
        String id = "my id";
        String type = "a type";
        String subtype = "type:subtype";
        jo.addProperty("name", name);
        jo.addProperty("id", id);
        jo.addProperty("type", type);
        jo.addProperty("subtype", subtype);
        HotelAPIResponseItem item = new HotelAPIResponseItem(jo);
        assertEquals(id, item.getId());
        assertEquals(name, item.getName());
        assertEquals(type, item.getType());
        assertEquals(subtype, item.getSubtype());
        assertNotNull(item.getAsJson());
        assertEquals(id, item.getAsJson().get("id").getAsString());
        assertEquals(name, item.getAsJson().get("name").getAsString());
        assertEquals(type, item.getAsJson().get("type").getAsString());
        assertEquals(subtype, item.getAsJson().get("subtype").getAsString());
    }


}