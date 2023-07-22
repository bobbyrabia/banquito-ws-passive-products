package ec.edu.espe.arquitectura.banquito.passive.products.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountDto;
import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.repository.ProductAccountRepository;

@Service
public class ProductAccountService {
    private final ProductAccountRepository productAccountRepository;

    public ProductAccountService(ProductAccountRepository productAccountRepository) {
        this.productAccountRepository = productAccountRepository;
    }

    public ProductAccountDto findByUniqueKey(String uniqueKey){
        Optional<ProductAccount> productAccountTemp =this.productAccountRepository.findByUniqueKey(uniqueKey);
        if(productAccountTemp.isPresent()){
            
            ProductAccount productAccount = productAccountTemp.get();
            ProductAccountDto productAccountDto = this.converToDto(productAccount);

        return productAccountDto;
        }
        else{
            throw new RuntimeException("ProductAccount con uniqueKey: " + uniqueKey + " no encontrado");
        }
    }

    private ProductAccountDto converToDto(ProductAccount productAccount) {
        ProductAccountDto productAccountDto = new ProductAccountDto();
        productAccountDto.setUniqueKey(productAccount.getUniqueKey());
        productAccountDto.setProductAccountTypeId(productAccount.getProductAccountTypeId());
        productAccountDto.setName(productAccount.getName());
        productAccountDto.setTemporalityAccountStatement(productAccount.getTemporalityAccountStatement());
        productAccountDto.setUseCheckbook(productAccount.getUseCheckbook());
        productAccountDto.setAllowOverdraft(productAccount.getAllowOverdraft());
        productAccountDto.setMaxOverdraft(productAccount.getMaxOverdraft());
        productAccountDto.setClientType(productAccount.getClientType());
        productAccountDto.setMinOpeningBalance(productAccount.getMinOpeningBalance());
        productAccountDto.setMinInterest(productAccount.getMinInterest());
        productAccountDto.setMaxInterest(productAccount.getMaxInterest());
        return productAccountDto;
    }
}
