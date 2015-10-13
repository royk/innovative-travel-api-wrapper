import models.HotelAPIResponseItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by user on 13/10/2015.
 */
public class HotelsAPIWrapperTest {

    @Test
    public void searchHotelsWithNull() throws Exception {
        HotelsAPIWrapper wrapper = new HotelsAPIWrapper();
        List<HotelAPIResponseItem> result = wrapper.searchHotels(null, null);
        assertNotNull(result);
    }

    @Test
    public void searchHotelsWithValidSearch() throws Exception {
        HotelsAPIWrapper wrapper = new HotelsAPIWrapper();
        List<HotelAPIResponseItem> result = wrapper.searchHotels("ams", "en");
        assertNotNull(result);
    }
}