package sia.tacocloud.web;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class Order {

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

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Wartość musi być w formacie MM/RR.")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Kod CVV jest nieprawidłowy.")
    private String ccCVV;

}
