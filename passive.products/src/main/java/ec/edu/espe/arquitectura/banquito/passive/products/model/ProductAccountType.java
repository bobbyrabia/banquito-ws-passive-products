package ec.edu.espe.arquitectura.banquito.passive.products.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductAccountType {
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
