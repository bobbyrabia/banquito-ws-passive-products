package ec.edu.espe.arquitectura.banquito.passive.products.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
@Document(collection = "productAccount")
public class ProductAccount {
    @Id
    private String id;
    @Indexed(unique = true)
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
    @Version
    private Long version;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uniqueId == null) ? 0 : uniqueId.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductAccount other = (ProductAccount) obj;
        if (uniqueId == null) {
            if (other.uniqueId != null)
                return false;
        } else if (!uniqueId.equals(other.uniqueId))
            return false;
        return true;
    }




    

}
