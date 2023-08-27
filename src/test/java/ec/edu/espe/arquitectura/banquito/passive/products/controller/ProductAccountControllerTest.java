package ec.edu.espe.arquitectura.banquito.passive.products.controller;

import ec.edu.espe.arquitectura.banquito.passive.products.converts.Converters;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountDto;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountSelectResponse;
import ec.edu.espe.arquitectura.banquito.passive.products.service.ProductAccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    @DisplayName("List Loand Product - Success Scenario")
    void test_when_listLoandProduct_Success() {
        List<ProductAccountDto> expectedDtoList = List.of(new ProductAccountDto());
        when(productAccountService.productAccountList()).thenReturn(expectedDtoList);

        ResponseEntity<List<ProductAccountDto>> response = productAccountController.listLoandProduct();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDtoList, response.getBody());
    }

    @DisplayName("List Loand Product Selected - Success Scenario")
    @Test
    void test_when_listLoandProductSelected_Success() {
        List<ProductAccountSelectResponse> expectedResponseList = List.of(new ProductAccountSelectResponse());
        when(productAccountService.productAccountSelectList()).thenReturn(expectedResponseList);

        ResponseEntity<List<ProductAccountSelectResponse>> response = productAccountController.listLoandProductSelected();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponseList, response.getBody());
    }
   /* @DisplayName("List Loand Product Selected - NotFound Scenario")
    @Test
    void test_when_listLoandProductSelected_NotFound() throws Exception {
        List<ProductAccountSelectResponse> expectedResponseList = new ArrayList<>();
        when(productAccountService.productAccountSelectList()).thenThrow(DataIntegrityViolationException.class);

        ResponseEntity<List<ProductAccountSelectResponse>> response = productAccountController.listLoandProductSelected();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }*/
    @DisplayName("FindBySelected - Success Scenario")
    @Test
    void test_when_findBySelected_Success() {
        // Arrange
        String uniqueId = "someUniqueId";
        ProductAccountSelectResponse expectedResponse = new ProductAccountSelectResponse();
        expectedResponse.setUniqueId("someUniqueId");
        expectedResponse.setName("productMock");
        when(productAccountService.FindByIDSelected(uniqueId)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<ProductAccountSelectResponse> response = productAccountController.findBySelected(uniqueId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(uniqueId, response.getBody().getUniqueId());
    }

    @DisplayName("FindBySelected - NotFound Scenario")
    @Test
    void test_when_findBySelected_NotFound() throws Exception {
        // Arrange
        String uniqueId = "someUniqueId";
        ProductAccountSelectResponse expectedResponse = new ProductAccountSelectResponse();
        expectedResponse.setUniqueId("someUniqueId");
        expectedResponse.setName("productMock");
        when(productAccountService.FindByIDSelected(uniqueId)).thenThrow(DataIntegrityViolationException.class);

        // Act
        ResponseEntity<ProductAccountSelectResponse> response = productAccountController.findBySelected(uniqueId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
    @DisplayName("List Loand Product - Success Scenario")
    @Test
    void test_when_findByProductos_Success() {
        // Arrange
        String uniqueId = "someUniqueId";
        ProductAccountDto expectedDto = new ProductAccountDto();
        expectedDto.setUniqueId("someUniqueId");
        expectedDto.setName("Mockdeprueba");
        when(productAccountService.FindByID(uniqueId)).thenReturn(expectedDto);

        // Act
        ResponseEntity<ProductAccountDto> response = productAccountController.findByProductos(uniqueId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(uniqueId, response.getBody().getUniqueId());
    }
    @DisplayName("FindByProductos - NotFound Scenario")
    @Test
    void test_when_findByProductos_NotFound() {
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