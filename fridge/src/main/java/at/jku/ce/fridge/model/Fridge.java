package at.jku.ce.fridge.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "fridge")
public class Fridge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "fridge_id",columnDefinition = "serial")
    private Long id;

    @Column(name="name")
    private String name;



//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fridge", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<Product> products;

    @OneToMany(orphanRemoval = true, mappedBy = "fridge", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> products;

    public Fridge () {

    }

//    public Fridge(Long id, String name, User user, Set<Product> products) {
//        this.id = id;
//        this.name = name;
//        this.user = user;
//        this.products = products;
//    }

    public Fridge(Long id, String name, Set<Product> products) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fridge fridge = (Fridge) o;
        return Objects.equals(id, fridge.id) && Objects.equals(name, fridge.name) && Objects.equals(products, fridge.products);
    }

    @Override
    public int hashCode() {
        return 13;
    }
}
