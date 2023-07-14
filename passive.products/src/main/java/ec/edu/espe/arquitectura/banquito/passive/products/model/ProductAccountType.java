package ec.edu.espe.arquitectura.banquito.passive.products.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@NoArgsConstructor
@Document(collection = "productAccountType")
public class ProductAccountType {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String name;

    private String clientType;

    private String superType;

    private String temporalityInterest;

    private Boolean allowEarnInterest;

    private Boolean allowAccountStatement;

    private Boolean allowBranchTransactions;

    private Boolean allowWithdrawal;
    
    private List<ProductAccount> productAccount;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        ProductAccountType other = (ProductAccountType) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


}
