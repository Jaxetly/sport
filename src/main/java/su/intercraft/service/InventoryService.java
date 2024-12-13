package su.intercraft.service;

import su.intercraft.model.InventoryItem;
import su.intercraft.repository.InventoryRepository;

import java.util.List;

public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

    public InventoryItem getItemById(int id) {
        return inventoryRepository.findById(id);
    }
}