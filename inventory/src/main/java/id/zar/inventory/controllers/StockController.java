package id.zar.inventory.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.zar.inventory.entities.InventoryItem;

@RestController
@RequestMapping("/api/inventory/stock")
public class StockController {
    @GetMapping
    public ResponseEntity<List<InventoryItem>> getAll(){
        var result = new ArrayList<InventoryItem>();
        result.add(InventoryItem.builder().id(UUID.randomUUID()).name("apel").quantity(10).build());
        return ResponseEntity.ok().body(result);
    }
}
