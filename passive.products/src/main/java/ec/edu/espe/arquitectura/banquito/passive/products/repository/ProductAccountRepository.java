package ec.edu.espe.arquitectura.banquito.passive.products.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
@Repository
public interface ProductAccountRepository extends MongoRepository <ProductAccount, String> {
    ProductAccount findByUniqueKey(String uniqueKey);
}
