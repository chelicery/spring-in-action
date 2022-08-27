package sia.tacocloud.data;
import sia.tacocloud.web.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);

}
