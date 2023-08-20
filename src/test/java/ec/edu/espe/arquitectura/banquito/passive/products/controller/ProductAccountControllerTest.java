package ec.edu.espe.arquitectura.banquito.passive.products.controller;

import ec.edu.espe.arquitectura.banquito.passive.products.converts.Converters;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountDto;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountSelectResponse;
import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.service.ProductAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductAccountControllerTest {
    @Mock
    private ProductAccountService productAccountService;
   @InjectMocks
    private ProductAccountController productAccountController;
   private ProductAccountDto productAccountDto;
    @Mock
    private Converters converters ;

    @Test
    void listLoandProduct() {
        List<ProductAccountDto> expectedDtoList = List.of(new ProductAccountDto());
        when(productAccountService.productAccountList()).thenReturn(expectedDtoList);

        // Act
        ResponseEntity<List<ProductAccountDto>> response = productAccountController.listLoandProduct();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDtoList, response.getBody());
    }

    @Test
    void listLoandProductSelected() {
        // Arrange
        List<ProductAccountSelectResponse> expectedResponseList = List.of(new ProductAccountSelectResponse());
        when(productAccountService.productAccountSelectList()).thenReturn(expectedResponseList);

        // Act
        ResponseEntity<List<ProductAccountSelectResponse>> response = productAccountController.listLoandProductSelected();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponseList, response.getBody());
    }
    @Test
    void listLoandProductSelectedNotFound() {
        // Arrange
        String uniqueId = "nonExistentUniqueId";
        when(productAccountService.FindByIDSelected(uniqueId)).thenThrow(DataIntegrityViolationException.class);

        // Act
        ResponseEntity<ProductAccountSelectResponse> response = productAccountController.findBySelected(uniqueId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
    @Test
    void findBySelected() {
        // Arrange
        String uniqueId = "someUniqueId";
        ProductAccountSelectResponse expectedResponse = new ProductAccountSelectResponse();
        when(productAccountService.FindByIDSelected(uniqueId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<ProductAccountSelectResponse> response = productAccountController.findBySelected(uniqueId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void findByProductos() {
        // Arrange
        String uniqueId = "someUniqueId";
        ProductAccountDto expectedDto = new ProductAccountDto();
        when(productAccountService.FindByID(uniqueId)).thenReturn(expectedDto);

        // Act
        ResponseEntity<ProductAccountDto> response = productAccountController.findByProductos(uniqueId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDto, response.getBody());
    }
    @Test
    void findByProductosNotFound() {
        // Arrange
        String uniqueId = "nonExistentUniqueId";
        when(productAccountService.FindByID(uniqueId)).thenThrow(DataIntegrityViolationException.class);

        // Act
        ResponseEntity<ProductAccountDto> response = productAccountController.findByProductos(uniqueId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
}