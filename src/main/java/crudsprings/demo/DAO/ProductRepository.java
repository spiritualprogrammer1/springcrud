package crudsprings.demo.DAO;

import crudsprings.demo.model.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produit,Long> {
     /*********on faire une recherche en fonction  de la designation qui va retourner une page*************/
   public Page<Produit> findByDesignationContains(String mc,Pageable pageable);
}
