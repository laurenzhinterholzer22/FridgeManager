package at.jku.ce.fridge.controller;

import at.jku.ce.fridge.model.Fridge;
import at.jku.ce.fridge.model.ShoppingList;
import at.jku.ce.fridge.service.IFridgeService;
import at.jku.ce.fridge.service.IShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShoppingListController {

    @Autowired
    private final IShoppingListService shoppingListService;

    ShoppingListController (IShoppingListService shoppingListService) {
        this.shoppingListService =  shoppingListService;
    }


    @GetMapping("/shoppingList")
    public List<ShoppingList> getAllShoppingLists(){
        return shoppingListService.findAll();
    }

    @GetMapping("/shoppingList/{id}")
    public Optional<ShoppingList> getShoppingList(@PathVariable Long id) {
        return shoppingListService.findById(id);
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
