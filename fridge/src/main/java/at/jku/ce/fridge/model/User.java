package at.jku.ce.fridge.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user_")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "serial")
    private Integer id;

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

//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "fridge", referencedColumnName = "id")
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
//    private Fridge fridge;
//
//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "shopping_list", referencedColumnName = "id")
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
//    private ShoppingList shoppingList;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "fridge_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer", "user"})
    private Fridge fridge;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_list_id")
    @JsonIgnoreProperties({"applications", "hibernateLazyInitializer", "user"})
    @JsonBackReference
    private ShoppingList shoppingList;

    public User () {}

    public User(Integer id, String name, String email, String password, Date birthday, String gender, Fridge fridge, ShoppingList shoppingList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.gender = gender;
        this.fridge = fridge;
        this.shoppingList = shoppingList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
