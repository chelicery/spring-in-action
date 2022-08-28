package sia.tacocloud.data;

import sia.tacocloud.web.Order;

public interface OrderRepository {

    Order save(Order order);

}
