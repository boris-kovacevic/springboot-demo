package springbootintro.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query(value="SELECT s FROM Shop s WHERE s.city = ?1")
    public List<Shop> getByCity(String city);
}
