package ec.edu.espe.arquitectura.banquito.passive.products.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountDto;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountSelectResponse;
import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.service.ProductAccountService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/productAccount")
public class ProductAccountController {
    private final ProductAccountService productAccountService;

    public ProductAccountController(ProductAccountService productAccountService) {
        this.productAccountService = productAccountService;
    }

        @GetMapping("/productos")
    public ResponseEntity<List<ProductAccountDto>> listLoandProduct() {
        List<ProductAccountDto> loanProductResponses = productAccountService.productAccountList();
        try
        {
            return ResponseEntity.ok(loanProductResponses);
        }catch (Exception e){
            log.info("Error {}", e);
            return ResponseEntity.notFound().build();
        }
    }

        @GetMapping("/selected")
    public ResponseEntity<List<ProductAccountSelectResponse>> listLoandProductSelected() {
        List<ProductAccountSelectResponse> productAccountSelectResponses = productAccountService.productAccountSelectList();
        try
        {
            return ResponseEntity.ok(productAccountSelectResponses);
        }catch (Exception e){
            log.info("Error {}", e);
            return ResponseEntity.notFound().build();
        }
    }

        
    @GetMapping("/selected/{uniqueId}")
    public ResponseEntity<ProductAccountSelectResponse> findBySelected(@PathVariable String uniqueId) {
        try {
            return ResponseEntity.ok(productAccountService.FindByIDSelected(uniqueId));
        } catch (DataIntegrityViolationException dataNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }

        @GetMapping("/productos/{uniqueId}")
    public ResponseEntity<ProductAccountDto> findByProductos(@PathVariable String uniqueId) {
        try {
            return ResponseEntity.ok(productAccountService.FindByID(uniqueId));
        } catch (DataIntegrityViolationException dataNotFoundException) {
            return ResponseEntity.notFound().build();
        }
    }
}
