package at.jku.ce.fridge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "shopping_list_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name")
    private String name;

//    @OneToOne(fetch = FetchType.EAGER, mappedBy = "shoppingList", cascade = CascadeType.ALL)
////    @JsonManagedReference
////    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer", "shoppping_list"})
////    @JsonIgnore
//    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shoppingList", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer", "shopping_list"})
    @JsonIgnore
    private Set<Product> products;

    public ShoppingList() {

    }

//    public ShoppingList(Long id, String name, User user, Set<Product> products) {
//        this.id = id;
//        this.name = name;
//        this.user = user;
//        this.products = products;
//    }

    public ShoppingList(Long id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
