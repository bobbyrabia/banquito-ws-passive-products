package ec.edu.espe.arquitectura.banquito.passive.products.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.service.ProductAccountService;

@RestController
@RequestMapping("/api/v1/productAccount")
public class ProductAccountController {
    private final ProductAccountService productAccountService;

    public ProductAccountController(ProductAccountService productAccountService) {
        this.productAccountService = productAccountService;
    }

    @GetMapping("/{uniqueKey}")
    public ResponseEntity<ProductAccount> findByUniqueKey(@PathVariable("uniqueKey") String uniqueKey ){
        return ResponseEntity.ok(this.productAccountService.findByUniqueKey(uniqueKey));
    }

    
}
