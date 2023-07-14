package ec.edu.espe.arquitectura.banquito.passive.products.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccountType;
import ec.edu.espe.arquitectura.banquito.passive.products.repository.ProductAccountTypeRepository;

@Service
public class ProductAccountTypeService {
private final ProductAccountTypeRepository productAccountTypeRepository;

public ProductAccountTypeService(ProductAccountTypeRepository productAccountTypeRepository) {
    this.productAccountTypeRepository = productAccountTypeRepository;
}

public ProductAccountType findByName(String name){
    return this.productAccountTypeRepository.findByName(name);
}    
}
