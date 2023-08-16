package ec.edu.espe.arquitectura.banquito.passive.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.banquito.passive.products.converts.Converters;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountDto;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountSelectResponse;
import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.repository.ProductAccountRepository;

@Service
public class ProductAccountService {
    private final ProductAccountRepository productAccountRepository;
    private final Converters converters;

    public ProductAccountService(ProductAccountRepository productAccountRepository, Converters converters) {
        this.productAccountRepository = productAccountRepository;
        this.converters = converters;
    }

    public List<ProductAccountDto> productAccountList() {
        List<ProductAccount> productAccounts = productAccountRepository.findByValidIsTrue();
        List<ProductAccountDto> productAccountDtos = converters.convertProductAccountToDtoList(productAccounts);
        return productAccountDtos;
    }

    public List<ProductAccountSelectResponse> productAccountSelectList (){
        List<ProductAccount> productAccounts = productAccountRepository.findByValidIsTrue();
        List<ProductAccountSelectResponse> productAccountSelectResponses = converters.convertProductAccountToSelectTDtoList(productAccounts);
        return productAccountSelectResponses;
    }

       public ProductAccountSelectResponse FindByIDSelected(String uniqueId) {
        Optional<ProductAccount> loan_productOpt = productAccountRepository.findByValidIsTrueAndUniqueId(uniqueId);
        if (loan_productOpt.isPresent()) {

            ProductAccountSelectResponse productAccountSelectResponse = converters.convertProductAccountSelectedToDto(loan_productOpt.get());
            return productAccountSelectResponse;
        } else {
            throw new DataIntegrityViolationException(
                    "El no existe el producto con la clave unica:  " + uniqueId );

        }
    }

    public ProductAccountDto FindByID(String uniqueId) {
        Optional<ProductAccount> productAccountOpt = productAccountRepository.findByValidIsTrueAndUniqueId(uniqueId);
        if (productAccountOpt.isPresent()) {

            ProductAccountDto productAccountDto = converters.convertProductAccountToDto(productAccountOpt.get());
            return productAccountDto;
        } else {
            throw new DataIntegrityViolationException(
                    "El no existe el producto con la clave unica:  " + uniqueId );

        }
    }

}
