package at.jku.ce.fridge.controller;

import at.jku.ce.fridge.model.Product;
import at.jku.ce.fridge.model.ShoppingList;
import at.jku.ce.fridge.service.IProductService;
import at.jku.ce.fridge.service.IShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ShoppingListController {

    @Autowired
    private final IShoppingListService shoppingListService;

    @Autowired
    private final IProductService productService;

    ShoppingListController(IShoppingListService shoppingListService, IProductService productService) {
        this.shoppingListService =  shoppingListService;
        this.productService = productService;
    }


    @GetMapping("/shoppingList")
    public List<ShoppingList> getAllShoppingLists(){
        return shoppingListService.findAll();
    }

    @GetMapping("/shoppingList/{id}")
    public Optional<ShoppingList> getShoppingList(@PathVariable Long id) {
        return shoppingListService.findById(id);
    }

    @GetMapping("/shoppingListProducts/{id}")
    public List <Product> getFridgeProducts(@PathVariable Long id) {
        List <Product> allP = productService.findAll();
        List <Product> returningP = new ArrayList<>();
            for (Product elem : allP) {
                try {
                    if (Objects.equals(elem.getShoppingList().getId(), id)) {
                        returningP.add(elem);
                    }
                } catch (Exception ignored) {
                }
            }
        return returningP;
    }

    @DeleteMapping("/shoppingList/{id}")
    void deleteShoppingList(@PathVariable Long id) {
        if(shoppingListService.findById(id).isPresent()) {
            shoppingListService.deleteById(id);
        }
    }

    @PostMapping(value = "/shoppingList" , consumes = {"application/json"})
    ShoppingList newShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.save(shoppingList);
    }


}
