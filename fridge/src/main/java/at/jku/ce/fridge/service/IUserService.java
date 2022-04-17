package at.jku.ce.fridge.service;

import at.jku.ce.fridge.model.ShoppingList;
import at.jku.ce.fridge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserService extends JpaRepository<User, Integer> {
}
