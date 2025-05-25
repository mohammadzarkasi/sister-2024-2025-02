package id.zar.shipping.controllers;

import java.util.ArrayList;
import java.util.List;

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
        return ResponseEntity.ok().body(result);
    }
}
