package id.zar.shipping.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import id.zar.shipping.entities.Order;
import id.zar.shipping.repositories.OrderRepository;

@RestController
@RequestMapping("/api/shipping/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        var rows = orderRepository.findAll();

        return ResponseEntity.ok().body(rows);
    }

    @GetMapping("/detail")
    public ResponseEntity<Object> getDetail(@RequestParam UUID id) {
        var q = orderRepository.findById(id);
        if (q.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            var row = q.get();
            var resp = new HashMap<>();
            resp.put("order", row);
            try{
                var rt = restTemplate.getForObject(
                    "http://ACCOUNT-SERVICE/user/detail?id=" + row.getUserId(), 
                    String.class
                    );
                resp.put("user", rt);
            }
            catch(Exception e){
                System.out.println(e);
                resp.put("user", null);
            }
            
            return ResponseEntity.ok().body(resp);
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        order.setId(UUID.randomUUID());
        order.setStatus("CREATED");
        order.setOrderDate(LocalDateTime.now());

        // Save the order to the repository
        Order savedOrder = orderRepository.save(order);

        return ResponseEntity.ok().body(savedOrder);
    }
}
