package sia.tacocloud.web;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import javax.validation.Valid;


import sia.tacocloud.data.IngredientRepository;
import sia.tacocloud.data.JdbcIngredientRepository;
import sia.tacocloud.web.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    private static final String DESIGN_RESOURCE_NAME = "design";
    private IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository repository){
        ingredientRepository = repository;
    }

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
                ingredientRepository.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();
        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute(DESIGN_RESOURCE_NAME, new Taco());
        return DESIGN_RESOURCE_NAME;
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors){
        if (errors.hasErrors()){
            log.debug("Designed TACO contains errors:" + errors);
            return DESIGN_RESOURCE_NAME;
        }
        log.info("Przetwarzanie utworzonego projektu Taco:" + design.toString());
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .toList();
    }

}
