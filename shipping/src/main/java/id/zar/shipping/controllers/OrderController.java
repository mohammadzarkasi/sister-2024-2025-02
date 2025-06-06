package id.zar.shipping.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.zar.shipping.entities.Order;

@RestController
@RequestMapping("/api/shipping/orders")
public class OrderController {
    @GetMapping
    public ResponseEntity<List<Order>> getAll(){
        var result = new ArrayList<Order>();
        result.add(Order.builder().id(UUID.randomUUID()).address("jember").status("sedang diantar").build());
        return ResponseEntity.ok().body(result);
    }
}
