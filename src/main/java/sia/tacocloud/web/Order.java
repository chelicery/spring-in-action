package sia.tacocloud.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Order {

    private Long id;

    private Date placedAt;

    @NotBlank(message = "Imie i nazwisko jest obowiązkowe")
    private String name;

    @NotBlank(message = "Nazwa ulicy jest obowiązkowa.")
    private String street;

    @NotBlank(message = "Nazwa miasta jest obowiązkowa.")
    private String city;

    @NotBlank(message = "Województwo jest obowiązkowe.")
    private String state;

    @NotBlank(message = "Kod pocztowy jest obowiązkowy")
    private String zip;

    @CreditCardNumber(message="Numer karty kredytowej jest nieprawidłowy.")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])(/)([2-9][\\d])$",
            message="Wartość musi być w formacie MM/RR.")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Kod CVV jest nieprawidłowy.")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    private List<Taco> designs = new ArrayList<>();

    public void addDesign(Taco saved) {
        designs.add(saved);
    }
}
