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

@WebServlet("/inventory")
public class InventoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            System.out.println("ID is required");
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID is required");
            return;
        }

        try {
            InventoryService inventoryService = new InventoryService(new InventoryRepository());
            int id = Integer.parseInt(idParam);
            InventoryItem item = inventoryService.getItemById(id);

            if (item == null) {
                System.out.println("Item not found");
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Item not found");
                return;
            }

            req.setAttribute("item", item);
            req.getRequestDispatcher("/jsp/inventory-detail.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
        }
    }
}
