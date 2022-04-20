package at.jku.ce.fridge.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ean")
    private String ean;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "expirydate")
    private Timestamp expirydate;

    @Column(name = "amount_description")
    private String amount_description;

    @Column(name = "amount")
    private double amount;


    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "fridge_id", referencedColumnName = "fridge_id")
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer", "product"})
    @JsonBackReference
    @JsonIgnore
    private Fridge fridge;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_list_id", referencedColumnName = "shopping_list_id")
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer", "product"})
    @JsonBackReference
    @JsonIgnore
    private ShoppingList shoppingList;


    public Product () {}

    public Product(Long id, String ean, String name, String category, Timestamp expirydate, String amount_description, double amount, Fridge fridge, ShoppingList shoppingList) {
        this.id = id;
        this.ean = ean;
        this.name = name;
        this.category = category;
        this.expirydate = expirydate;
        this.amount_description = amount_description;
        this.amount = amount;
        this.fridge = fridge;
        this.shoppingList = shoppingList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Timestamp expirydate) {
        this.expirydate = expirydate;
    }

    public String getAmount_description() {
        return amount_description;
    }

    public void setAmount_description(String amount_description) {
        this.amount_description = amount_description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }
}
