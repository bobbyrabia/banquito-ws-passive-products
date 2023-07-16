package ec.edu.espe.arquitectura.banquito.passive.products.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccountType;
import ec.edu.espe.arquitectura.banquito.passive.products.repository.ProductAccountTypeRepository;

@Service
public class ProductAccountTypeService {
private final ProductAccountTypeRepository productAccountTypeRepository;

public ProductAccountTypeService(ProductAccountTypeRepository productAccountTypeRepository) {
    this.productAccountTypeRepository = productAccountTypeRepository;
}

public ProductAccountType findByName(String name){
    Optional<ProductAccountType> productAccountTypeTemp =this.productAccountTypeRepository.findByName(name);
        if(productAccountTypeTemp.isPresent()){
        return productAccountTypeTemp.get();
        }
        else{
            throw new RuntimeException("ProductAccountType con nombre: " + name + " no encontrado");
        }
}    
}
