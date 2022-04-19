package at.jku.ce.fridge.service;

import at.jku.ce.fridge.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductService extends JpaRepository<Product, String> {
}
