package at.jku.ce.fridge.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.text.html.Option;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "user_")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "gender")
    private String gender;



    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "fridge_id", referencedColumnName = "fridge_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer", "user"})
    @JsonBackReference
    @JsonIgnore
    private Fridge fridge;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_list_id", referencedColumnName = "shopping_list_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer", "user"})
    @JsonBackReference
    @JsonIgnore
    private ShoppingList shoppingList;

    public User () {}

    public User(String name, String email, String password, Date birthday, String gender, Fridge fridge,ShoppingList shoppingList) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.fridge = fridge;
        this.shoppingList = shoppingList;
    }

    public User(Long id, String name, String email, String password, Date birthday, String gender, Fridge fridge, ShoppingList shoppingList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.fridge = fridge;
        this.shoppingList = shoppingList;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(birthday, user.birthday) && Objects.equals(gender, user.gender) && Objects.equals(fridge, user.fridge) && Objects.equals(shoppingList, user.shoppingList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, birthday, gender, fridge, shoppingList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", fridge=" + fridge +
                ", shoppingList=" + shoppingList +
                '}';
    }
}
