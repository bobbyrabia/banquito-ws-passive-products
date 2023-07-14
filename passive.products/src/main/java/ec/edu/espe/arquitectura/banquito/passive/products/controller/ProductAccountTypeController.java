package ec.edu.espe.arquitectura.banquito.passive.products.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccountType;
import ec.edu.espe.arquitectura.banquito.passive.products.service.ProductAccountTypeService;

@RestController
@RequestMapping("/api/v1/productAccountType")
public class ProductAccountTypeController {
    private final ProductAccountTypeService productAccountTypeService;

    public ProductAccountTypeController(ProductAccountTypeService productAccountTypeService) {
        this.productAccountTypeService = productAccountTypeService;
    }

    @GetMapping("/{name}")
    public ResponseEntity <ProductAccountType>findByname(@PathVariable("name") String name) {
        return ResponseEntity.ok(this.productAccountTypeService.findByName(name));
    }

}
