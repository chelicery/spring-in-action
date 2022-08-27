package sia.tacocloud.web;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

    @NotNull
    private Long id;

    @NotNull
    private Date createdAt;

    @NotNull
    @Size(min=5, message="Nazwa musi składać się z przynajmniej pięciu znaków")
    private String name;

    @Size(min=1, message="Musisz wybrać conajmniej jeden składnik.")
    private List<String> ingredients;

}
