package at.jku.ce.fridge.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @Column(name = "ean", nullable = false)
    private String ean;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "expirydate")
    private Timestamp expirydate;

    @Column(name = "amount_description")
    private String amount_description;

    @Column(name = "amount", nullable = false)
    private double amount;


//    @ManyToOne (cascade = CascadeType.ALL)
//    @JoinColumn(name = "fridge_id", referencedColumnName = "fridge_id", columnDefinition = "integer")
//    @JsonBackReference
//    @JsonIgnore
//    private Fridge fridge;

    @ManyToOne
    @JoinColumn(name = "fridge_id", referencedColumnName = "fridge_id", columnDefinition = "integer")
    @JsonBackReference
    @JsonIgnore
    private Fridge fridge;

    @ManyToOne
    @JoinColumn(name = "shopping_list_id", referencedColumnName = "shopping_list_id", columnDefinition = "integer")
//    @JsonIgnoreProperties(value = {"hanlder", "hibernateLazyInitializer", "product"})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.amount, amount) == 0 && Objects.equals(id, product.id) && Objects.equals(ean, product.ean) && Objects.equals(name, product.name) && Objects.equals(category, product.category) && Objects.equals(expirydate, product.expirydate) && Objects.equals(amount_description, product.amount_description) && Objects.equals(fridge, product.fridge) && Objects.equals(shoppingList, product.shoppingList);
    }

    @Override
    public int hashCode() {
        return 13;
    }
}
