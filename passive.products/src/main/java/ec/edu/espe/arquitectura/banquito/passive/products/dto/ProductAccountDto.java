package ec.edu.espe.arquitectura.banquito.passive.products.dto;

import java.math.BigDecimal;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
public class ProductAccountDto {
    private String uniqueKey;
    private String productAccountTypeId;
    private String name;
    private String temporalityAccountStatement;
    private Boolean useCheckbook;
    private Boolean allowOverdraft;
    private Boolean allowTransferences;
    private BigDecimal maxOverdraft;
    private String clientType;
    private BigDecimal minOpeningBalance;
    private BigDecimal minInterest;
    private BigDecimal maxInterest;

}
