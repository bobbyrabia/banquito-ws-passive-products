package ec.edu.espe.arquitectura.banquito.passive.products.dto;

import java.util.List;

import ec.edu.espe.arquitectura.banquito.passive.products.model.ProductAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
public class ProductAccountTypeDto {
    private String name;
    private String clientType;
    private String superType;
    private String temporalityInterest;
    private Boolean allowEarnInterest;
    private Boolean allowAccountStatement;
    private Boolean allowBranchTransactions;
    private Boolean allowWithdrawal;
    private Long version; 
}
