package com.nitin.app.bootstrap;

import com.nitin.app.enums.Difficulty;
import com.nitin.app.models.*;
import com.nitin.app.repositories.CategoryRepository;
import com.nitin.app.repositories.RecipeRepository;
import com.nitin.app.repositories.UnitOfMeasureRepository;
import org.slf4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DevBootstrap.class);
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public DevBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData() {
        List<Recipe> recipes = new ArrayList<>(2);
        Recipe recipe = new Recipe();
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanCategoryOptional.isPresent()) {

            throw new RuntimeException("*** Mexican category not present ***");
        }

        Category mexicanCat = mexicanCategoryOptional.get();
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if (!americanCategoryOptional.isPresent()) {

            throw new RuntimeException("*** American category not present ***");
        }

        Category americanCat = americanCategoryOptional.get();


        Optional<UnitOfMeasure> numberUomOptional = unitOfMeasureRepository.findByDescription("Number");
        if (!numberUomOptional.isPresent()) {
            throw new RuntimeException("UOM Number is not present");
        }
        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("TeaSpoon");
        if (!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("UOM TeaSpoon is not present");
        }
        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("TableSpoon");
        if (!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException("UOM TableSpoon is not present");
        }
        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException("UOM Dash is not present");
        }
        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupUomOptional.isPresent()) {
            throw new RuntimeException("UOM Cup is not present");
        }
        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if (!pinchUomOptional.isPresent()) {
            throw new RuntimeException("UOM Pinch is not present");
        }

        UnitOfMeasure pinch = pinchUomOptional.get();
        UnitOfMeasure cup = cupUomOptional.get();
        UnitOfMeasure dash = dashUomOptional.get();
        UnitOfMeasure tableSppon = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoon = teaSpoonUomOptional.get();
        UnitOfMeasure number = numberUomOptional.get();

        Ingredient avocados = new Ingredient();
        avocados.setAmount(new BigDecimal(2));
        avocados.setDescription("ripe avocados");
        avocados.setRecipe(recipe);
        avocados.setUnitOfMeasure(number);

        Ingredient salt = new Ingredient();
        salt.setDescription("teaspoon Kosher salt");
        salt.setUnitOfMeasure(teaSpoon);
        salt.setRecipe(recipe);
        salt.setAmount(new BigDecimal(0.5));

        Ingredient limeJuice = new Ingredient();
        limeJuice.setAmount(new BigDecimal(1));
        limeJuice.setUnitOfMeasure(tableSppon);
        limeJuice.setRecipe(recipe);
        limeJuice.setDescription("of fresh lime juice or lemon juice");

        Ingredient onion = new Ingredient();
        onion.setDescription("of minced red onion or thinly sliced green onion");
        onion.setRecipe(recipe);
        onion.setUnitOfMeasure(tableSppon);
        onion.setAmount(new BigDecimal(2));

        Ingredient chilies = new Ingredient();
        chilies.setAmount(new BigDecimal(1));
        chilies.setUnitOfMeasure(number);
        chilies.setRecipe(recipe);
        chilies.setDescription("serrano chiles, stems and seeds removed, minced");

        Ingredient cilantro = new Ingredient();
        cilantro.setDescription("cilantro (leaves and tender stems), finely chopped");
        cilantro.setRecipe(recipe);
        cilantro.setUnitOfMeasure(tableSppon);
        cilantro.setAmount(new BigDecimal(2));

        Ingredient blackPepper = new Ingredient();
        blackPepper.setAmount(new BigDecimal(1));
        blackPepper.setUnitOfMeasure(dash);
        blackPepper.setDescription("of freshly grated black pepper");
        blackPepper.setRecipe(recipe);

        Ingredient tomato = new Ingredient();
        tomato.setRecipe(recipe);
        tomato.setDescription("tomato, seeds and pulp removed, chopped");
        tomato.setUnitOfMeasure(number);
        tomato.setAmount(new BigDecimal(0.5));

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(avocados);
        ingredients.add(salt);
        ingredients.add(limeJuice);
        ingredients.add(onion);
        ingredients.add(chilies);
        ingredients.add(cilantro);
        ingredients.add(blackPepper);
        ingredients.add(tomato);

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");


        recipe.setIngredients(ingredients);
        recipe.setPrepTime(10);
        recipe.setSource("Internet");
        recipe.setUrl("www.simplyrecipes.com");
        recipe.setServing(4);
        recipe.setNotes(guacNotes);
        recipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd\"");

        recipe.setDifficulty(Difficulty.EASY);
        recipe.setDescription("Perfet Guacamole");
        recipe.setCookTime(10);
        Set<Category> categories = new HashSet<>();
        categories.add(mexicanCat);
        categories.add(mexicanCat);
        recipe.setCategories(categories);
        log.debug("Recipe '" + recipe.getDescription() + "' CRreated.");
        recipes.add(recipe);

        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        tacosRecipe.setNotes(tacoNotes);


        tacosRecipe.addIngredients(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tableSppon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("Sugar", new BigDecimal(1), teaSpoon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("Salt", new BigDecimal(".5"), teaSpoon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), number, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSppon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSppon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("Olive Oil", new BigDecimal(2), tableSppon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("boneless chicken thighs", new BigDecimal(4), tableSppon, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("small corn tortillasr", new BigDecimal(8), number, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("packed baby arugula", new BigDecimal(3), cup, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), number, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("radishes, thinly sliced", new BigDecimal(4), number, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pinch, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), number, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), number, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cup, tacosRecipe));
        tacosRecipe.addIngredients(new Ingredient("lime, cut into wedges", new BigDecimal(4), number, tacosRecipe));

        tacosRecipe.getCategories().add(americanCat);
        tacosRecipe.getCategories().add(mexicanCat);
        log.debug("Recipe '"+tacosRecipe.getDescription()+"' created.");
        recipes.add(tacosRecipe);
        System.out.println("Recipes added:"+recipes.size());
        recipeRepository.saveAll(recipes);
    }
}
