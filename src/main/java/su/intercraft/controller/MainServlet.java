package su.intercraft.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import su.intercraft.model.InventoryItem;
import su.intercraft.repository.InventoryRepository;
import su.intercraft.service.InventoryService;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InventoryService inventoryService = new InventoryService(new InventoryRepository());

        List<InventoryItem> items = inventoryService.getAllItems();
        req.setAttribute("items", items);
        req.getRequestDispatcher("/jsp/inventory-list.jsp").forward(req, resp);
    }
}
