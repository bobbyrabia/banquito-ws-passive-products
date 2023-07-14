package ec.edu.espe.arquitectura.banquito.passive.products.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.repository.ProductAccountRepository;

@Service
public class ProductAccountService {
    private final ProductAccountRepository productAccountRepository;
    

    public ProductAccountService(ProductAccountRepository productAccountRepository) {
        this.productAccountRepository = productAccountRepository;
    }



    public ProductAccount findByUniqueKey(String uniqueKey){
        return  this.productAccountRepository.findByUniqueKey(uniqueKey);
    }
}
