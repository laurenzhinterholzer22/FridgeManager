package at.jku.ce.fridge.controller;

import at.jku.ce.fridge.model.Product;
import at.jku.ce.fridge.service.IFridgeService;
import at.jku.ce.fridge.service.IProductService;
import at.jku.ce.fridge.service.IShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private final IProductService productService;

    @Autowired
    private final IFridgeService fridgeService;

    @Autowired
    private final IShoppingListService shoppingListService;

    ProductController(IProductService productService, IFridgeService fridgeService, IShoppingListService shoppingListService){this.productService = productService;
        this.fridgeService = fridgeService;
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {return  productService.findAll();}

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable Long id){
        return productService.findById(id);
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id) {
        if(productService.findById(id).isPresent()){
            productService.deleteById(id);
        }
    }

//    @PostMapping("/product")
//    Product newProduct(@RequestBody Product product){
//        product.setFridge(new Fridge());
//        product.setShoppingList(new ShoppingList());
//        return productService.save(product);
//    }

    @PostMapping(value = "/product/fridge/{fridge_id}" , consumes = {"application/json"})
    Product newProductFridge(@PathVariable Long fridge_id, @RequestBody Product product){
        product.setFridge(fridgeService.getById(fridge_id));
//        product.setShoppingList(null);
        return productService.save(product);
    }

    @PostMapping(value = "/product/shoppingList/{shopping_list_id}" , consumes = {"application/json"})
    Product newProductShoppingList(@PathVariable Long shopping_list_id, @RequestBody Product product){
        product.setShoppingList(shoppingListService.getById(shopping_list_id));
//        product.setFridge(null);
        return productService.save(product);
    }
}
