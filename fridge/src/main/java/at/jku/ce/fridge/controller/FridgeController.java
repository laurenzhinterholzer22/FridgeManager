package at.jku.ce.fridge.controller;

import at.jku.ce.fridge.model.Fridge;
import at.jku.ce.fridge.model.Product;
import at.jku.ce.fridge.service.IFridgeService;
import at.jku.ce.fridge.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class FridgeController {

    @Autowired
    private final IFridgeService fridgeService;

    @Autowired
    private final IProductService productService;

    FridgeController(IFridgeService fridgeService, IProductService productService) {
        this.fridgeService = fridgeService;
        this.productService = productService;
    }

    @GetMapping("/fridge")
    public List<Fridge> getAllFridges() {
        return fridgeService.findAll();
    }


    @GetMapping("/fridge/{id}/products")
    public List <Product> getFridgeProducts(@PathVariable Long id) {
        List <Product> allP = productService.findAll();
        List <Product> returningP = new ArrayList<>();
        for (Product elem : allP) {
            try {
                if (Objects.equals(elem.getFridge().getId(), id)) {
                    returningP.add(elem);
                }
            }catch (Exception ignored){}
        }
        return returningP;
    }



}
