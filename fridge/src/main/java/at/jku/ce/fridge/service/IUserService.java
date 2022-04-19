package at.jku.ce.fridge.service;

import at.jku.ce.fridge.model.ShoppingList;
import at.jku.ce.fridge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface IUserService extends JpaRepository<User,Long> {


}
