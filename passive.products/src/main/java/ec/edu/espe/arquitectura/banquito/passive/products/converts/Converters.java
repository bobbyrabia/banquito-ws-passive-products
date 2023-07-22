package ec.edu.espe.arquitectura.banquito.passive.products.converts;

import java.util.List;

import org.modelmapper.ModelMapper;
import java.lang.reflect.Type;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountDto;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountSelectResponse;
import ec.edu.espe.arquitectura.banquito.passive.products.dto.ProductAccountTypeDto;
import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccountType;
@Component
public class Converters {
    private final ModelMapper modelMapper;

    public Converters(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }

    // ProductAccount
    public ProductAccountDto convertProductAccountToDto(ProductAccount productAccount) {
        ProductAccountDto productAccountDto = modelMapper.map(productAccount, ProductAccountDto.class);
        return productAccountDto;
    }

    public ProductAccount convertProductAccountToEntity(ProductAccountDto productAccountDto) {
        ProductAccount productAccount = modelMapper.map(productAccountDto, ProductAccount.class);
        return productAccount;
    }

        public List<ProductAccountDto> convertProductAccountToDtoList(List<ProductAccount> productAccounts) {
        Type listType = new TypeToken<List<ProductAccountDto>>() {
        }.getType();
        List<ProductAccountDto> productAccountDtos = modelMapper.map(productAccounts, listType);
        return productAccountDtos;
    }
            public ProductAccountSelectResponse convertProductAccountSelectedToDto(ProductAccount productAccount) {
        ProductAccountSelectResponse productAccountSelectResponse = modelMapper.map(productAccount, ProductAccountSelectResponse.class);
        return productAccountSelectResponse;
    }
        public List<ProductAccountSelectResponse> convertProductAccountToSelectTDtoList(List<ProductAccount> productAccounts) {
        Type listType = new TypeToken<List<ProductAccountSelectResponse>>() {
        }.getType();
        List<ProductAccountSelectResponse> productAccountSelectResponses = modelMapper.map(productAccounts, listType);
        return productAccountSelectResponses;
    }
    
     // ProductAccountType

        public ProductAccountTypeDto convertProductAccountTypeToDto(ProductAccountType productAccountType) {
        ProductAccountTypeDto productAccountTypeDto = modelMapper.map(productAccountType, ProductAccountTypeDto.class);
        return productAccountTypeDto;
    }

            public ProductAccountType convertProductAccountTypeToEntity(ProductAccountTypeDto productAccountTypeDto) {
        ProductAccountType productAccountType = modelMapper.map(productAccountTypeDto, ProductAccountType.class);
        return productAccountType;
    }

        public List<ProductAccountTypeDto> convertProductAccountTypeToDtoList(List<ProductAccountType> productAccountTypes) {
        Type listType = new TypeToken<List<ProductAccountTypeDto>>() {
        }.getType();
        List<ProductAccountTypeDto> productAccountTypeDtos = modelMapper.map(productAccountTypes, listType);
        return productAccountTypeDtos;
    }



}
