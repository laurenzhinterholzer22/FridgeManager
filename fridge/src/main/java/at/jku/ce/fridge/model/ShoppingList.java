package at.jku.ce.fridge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "shopping_list_id", columnDefinition = "serial")
    private Long id;


    @OneToMany(orphanRemoval = true, mappedBy = "shoppingList", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> products;

    public ShoppingList() {

    }


    public ShoppingList(Long id, Set<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingList that = (ShoppingList) o;
        return Objects.equals(id, that.id)  && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return 13;
    }
}
