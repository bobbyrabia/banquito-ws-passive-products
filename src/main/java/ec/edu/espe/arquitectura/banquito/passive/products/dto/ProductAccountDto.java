package ec.edu.espe.arquitectura.banquito.passive.products.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Version;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
public class ProductAccountDto {
    private String uniqueId;
    private ProductAccountType productAccountType;
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
    private String state;
    private Date creationDate;
    private Date activationDate;
    private Date lastModifiedDate;
    private Date closedDate;
    private Boolean valid;
    private Long version;
    

}
