package ec.edu.espe.arquitectura.banquito.passive.products.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
@Repository
public interface ProductAccountRepository extends MongoRepository <ProductAccount, String> {
    List<ProductAccount> findByValidIsTrue();
    Optional<ProductAccount> findByValidIsTrueAndUniqueId(String uniqueId);
}
