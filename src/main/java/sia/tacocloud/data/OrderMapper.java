package sia.tacocloud.data;

import sia.tacocloud.web.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderMapper {

    protected Map<String, Object> orderToMap(Order order){
        Map<String, Object> values = new HashMap<>();
        values.put("deliveryName", order.getName());
        values.put("deliveryStreet", order.getStreet());
        values.put("deliveryCity", order.getCity());
        values.put("deliveryState", order.getState());
        values.put("deliveryZip", order.getZip());
        values.put("ccNumber", order.getCcNumber());
        values.put("ccExpiration", order.getCcExpiration());
        values.put("ccCVV", order.getCcCVV());
        values.put("placedAt", order.getPlacedAt());
        return values;
    }

}
