package at.jku.ce.fridge.service;

import at.jku.ce.fridge.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface IShoppingListService extends JpaRepository<ShoppingList, Integer> {
}
