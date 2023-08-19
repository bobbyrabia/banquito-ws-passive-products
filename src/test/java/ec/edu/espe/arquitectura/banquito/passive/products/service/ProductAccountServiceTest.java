package ec.edu.espe.arquitectura.banquito.passive.products.service;

import ec.edu.espe.arquitectura.banquito.passive.products.converts.Converters;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountDto;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountSelectResponse;
import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.repository.ProductAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductAccountServiceTest {
    @Mock
    private ProductAccountRepository productAccountRepository;
    @InjectMocks
    private ProductAccountService productAccountService;
    private ProductAccount productAccount;
    @Mock
    private Converters converters ;

    @Test
    void productAccountList() {
        ProductAccount productAccount1 = new ProductAccount(); // Supongamos que creas un objeto ProductAccount
        ProductAccount productAccount2 = new ProductAccount(); // Supongamos que creas otro objeto ProductAccount

        List<ProductAccount> productAccountList = new ArrayList<>();
        productAccountList.add(productAccount1);
        productAccountList.add(productAccount2);

        List<ProductAccountDto> productAccountDtoList = new ArrayList<>(); // Supongamos que creas objetos ProductAccountDto
        ProductAccountDto dto1 = new ProductAccountDto();
        ProductAccountDto dto2 = new ProductAccountDto();
        productAccountDtoList.add(dto1);
        productAccountDtoList.add(dto2);

        when(productAccountRepository.findByValidIsTrue()).thenReturn(productAccountList);
        when(converters.convertProductAccountToDtoList(productAccountList)).thenReturn(productAccountDtoList);

        List<ProductAccountDto> result = productAccountService.productAccountList();

        assertNotNull(result);
        assertEquals(productAccountDtoList, result);
    }

    @Test
    void productAccountSelectList() {

            when(productAccountRepository.findByValidIsTrue()).thenReturn(Arrays.asList(productAccount));
            assertNotNull(productAccountRepository.findByValidIsTrue());
    }

    @Test
    void findByIDSelected() {
        String uniqueId = "someUniqueId";
        ProductAccount productAccount = new ProductAccount();
        ProductAccountSelectResponse selectResponse = new ProductAccountSelectResponse();

        when(productAccountRepository.findByValidIsTrueAndUniqueId(uniqueId)).thenReturn(Optional.of(productAccount));
        when(converters.convertProductAccountSelectedToDto(productAccount)).thenReturn(selectResponse);

        ProductAccountSelectResponse result = productAccountService.FindByIDSelected(uniqueId);

        assertNotNull(result);
        assertEquals(selectResponse, result);
    }

    @Test
    void testFindByIDSelected_NotExists() {
        String uniqueId = "nonExistentUniqueId";

        when(productAccountRepository.findByValidIsTrueAndUniqueId(uniqueId)).thenReturn(Optional.empty());

        assertThrows(DataIntegrityViolationException.class, () -> {
            productAccountService.FindByIDSelected(uniqueId);
        });
    }

    @Test
    void findByID() {
        String uniqueId = "someUniqueId";
        ProductAccount productAccount = new ProductAccount();
        ProductAccountDto accountDto = new ProductAccountDto();

        when(productAccountRepository.findByValidIsTrueAndUniqueId(uniqueId)).thenReturn(Optional.of(productAccount));
        when(converters.convertProductAccountToDto(productAccount)).thenReturn(accountDto);

        ProductAccountDto result = productAccountService.FindByID(uniqueId);

        assertNotNull(result);
        assertEquals(accountDto, result);
    }
    @Test
    void testFindByID_NotExists() {
        String uniqueId = "nonExistentUniqueId";

        when(productAccountRepository.findByValidIsTrueAndUniqueId(uniqueId)).thenReturn(Optional.empty());

        assertThrows(DataIntegrityViolationException.class, () -> {
            productAccountService.FindByID(uniqueId);
        });
    }
}