import com.google.gson.*;
import models.HotelAPIResponseItem;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 13/10/2015.
 */
public class HotelsAPIWrapper {



    public HotelsAPIWrapper() {

    }

    public List<HotelAPIResponseItem> searchHotels(String searchString, String languageCode) throws Exception {
        if (StringUtils.isBlank(searchString)) {
            searchString = "";
        }
        if (StringUtils.isBlank(languageCode)) {
            languageCode = "en";
        }
        List<HotelAPIResponseItem> result;
        try {
            // make http call
            String response = "[\n" +
                    "{\n" +
                    "\"name\": \"Hotel Espresso Amsterdam\",\n" +
                    "\"id\": \"hotel:Hotel_Espresso_Ams\",\n" +
                    "\"hotelCount\": \"1\",\n" +
                    "\"type\": \"hotel\",\n" +
                    "\"subtype\": \"hotel\"\n" +
                    "},\n" +
                    "{\n" +
                    "\"name\": \"Amsterdam\",\n" +
                    "\"id\": \"place:Amsterdam\",\n" +
                    "\"hotelCount\": \"329\",\n" +
                    "\"type\": \"place\",\n" +
                    "\"subtype\": \"city\"\n" +
                    "},\n" +
                    "{\n" +
                    "\"name\": \"Amsterdam Schiphol Airport (AMS)\",\n" +
                    "\"id\": \"place:Amsterdam_Schiphol\",\n" +
                    "\"hotelCount\": \"15\",\n" +
                    "\"type\": \"place\",\n" +
                    "\"subtype\": \"airport\"\n" +
                    "}\n" +
                    "]";
            result = processAPIResponse(response);
        } catch(Exception e) {
            throw e;
        }
        return result;
    }

    private List<HotelAPIResponseItem> processAPIResponse(String response) {
        List<HotelAPIResponseItem> result = new ArrayList<HotelAPIResponseItem>();
        JsonParser parser = new JsonParser();
        JsonElement je = parser.parse(response);
        if (je.isJsonArray()) {
            for (JsonElement element : je.getAsJsonArray()) {
                result.add(new HotelAPIResponseItem(element.getAsJsonObject()));
            }
        }
        if (je.isJsonObject()) {
            result.add(new HotelAPIResponseItem(je.getAsJsonObject()));
        }
        return result;
    }
}
