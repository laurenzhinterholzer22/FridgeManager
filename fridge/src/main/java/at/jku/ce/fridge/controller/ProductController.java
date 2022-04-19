package at.jku.ce.fridge.controller;

import at.jku.ce.fridge.model.Product;
import at.jku.ce.fridge.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private final IProductService productService;

    ProductController(IProductService productService){this.productService = productService;}

    @GetMapping("/product")
    public List<Product> getAllProducts() {return  productService.findAll();}

    @GetMapping("/product/{ean}")
    public Optional<Product> getProduct(@PathVariable String ean){
        return productService.findById(ean);
    }

    @DeleteMapping("/product/{ean}")
    void deleteProduct(@PathVariable String ean) {
        if(productService.findById(ean).isPresent()){
            productService.deleteById(ean);
        }
    }

    @PostMapping("/product")
    Product newProduct(@RequestBody Product product){
        return productService.save(product);
    }
}
