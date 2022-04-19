package at.jku.ce.fridge.service;

import at.jku.ce.fridge.model.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFridgeService extends JpaRepository<Fridge,Long> {
}
