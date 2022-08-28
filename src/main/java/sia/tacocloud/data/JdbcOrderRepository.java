package sia.tacocloud.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import sia.tacocloud.web.Order;
import sia.tacocloud.web.Taco;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcOrderRepository implements OrderRepository{

    private final SimpleJdbcInsert orderInserter;
    private final SimpleJdbcInsert orderTacoInserter;
    private final OrderMapper orderMapper;

    @Autowired
    public JdbcOrderRepository(JdbcTemplate jdbc){
        this.orderInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("TacoOrder")
                .usingGeneratedKeyColumns("id");

        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("TacoOrderTacos");

        this.orderMapper = new OrderMapper();

    }

    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Taco> tacos = order.getTacos();

        for(Taco taco : tacos){
            saveTacoToOrder(orderId, taco);
        }

        return order;
    }


    private long saveOrderDetails(Order order){
        Map<String, Object> values = orderMapper.orderToMap(order);
        return orderInserter.executeAndReturnKey(values).longValue();
    }


    private void saveTacoToOrder(long orderId, Taco taco) {
        Map<String, Object> values = new HashMap<>();
        values.put("tacoOrder", orderId);
        values.put("taco",taco.getId());
        orderTacoInserter.execute(values);
    }

}
