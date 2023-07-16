package ec.edu.espe.arquitectura.banquito.passive.products.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccountType;

@Repository
public interface ProductAccountTypeRepository extends MongoRepository <ProductAccountType, String> {
    Optional<ProductAccountType> findByName(String name);
}
