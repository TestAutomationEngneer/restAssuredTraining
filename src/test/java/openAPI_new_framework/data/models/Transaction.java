package openAPI_new_framework.data.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;


@Data
@Builder
public class Transaction {
    private BigDecimal amount;
    private String currency;
    private Instant paymentDate;
    private boolean is3DSecure;
    private List<String> products;
    private String cardType;
    private String ownerFirstName;
    private String ownerLastName;

    public static Transaction getExpectedTransactionObject() {
        Transaction transaction = builder()
                .amount(BigDecimal.valueOf(100))
                .cardType("VISA")
                .currency("USD")
                .is3DSecure(true)
                .ownerFirstName("Angelina")
                .ownerLastName("Jolie")
                .products(List.of("Cucumber", "Paprica", "Tomato"))
                .paymentDate(Instant.now())
                .build();
        return transaction;
    }

    public static Transaction getActualTransactionObject() {
        Transaction transaction = builder()
                .amount(BigDecimal.valueOf(100))
                .cardType("VISA")
                .currency("USD")
                .is3DSecure(true)
                .ownerFirstName("Angelina")
                .ownerLastName("Jolie")
                .products(List.of("Cucumber", "Paprica", "Tomato"))
                .paymentDate(Instant.now())
                .build();
        return transaction;
    }
}
