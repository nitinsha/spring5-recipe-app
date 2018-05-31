package com.nitin.app.bootstrap.util;

import com.nitin.app.enums.Difficulty;
import com.nitin.app.models.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class BootStrapUtility {

    public static Recipe createRecipePerfectGuacamole(){
        Recipe recipe = new Recipe();
        Set<Category> categorySet = new HashSet<>();

        Category mexicanCat = new Category();
        mexicanCat.setDescription("Mexican");

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);

        mexicanCat.setRecipes(recipes);

        categorySet.add(mexicanCat);

        recipe.setCategories(categorySet);
        recipe.setCookTime(10);
        recipe.setDescription("Perfect Guacamole");
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setDirections("Guacamole is so easy. All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity— will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.\n" +
                "\n" +
                "Once you have basic guacamole down, you may experiment with variations including strawberries, pineapple, mangoes, even watermelon. You can get creative with homemade guacamole!");

        Notes notes = new Notes();
        notes.setRecipe(recipe);
        notes.setRecipeNotes("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n 2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)+" +
                "\n 3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.+" +
                "\n 4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");

        recipe.setNotes(notes);
        recipe.setServing(4);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        recipe.setSource("Internet");
        recipe.setPrepTime(10);

        Ingredient avocados = new Ingredient();
        avocados.setAmount(new BigDecimal(2));
        avocados.setDescription("ripe avocados");
        avocados.setRecipe(recipe);

        UnitOfMeasure number = new UnitOfMeasure();
        number.setDescription("Number");

        avocados.setUnitOfMeasure(number);

        Ingredient salt = new Ingredient();
        salt.setDescription("teaspoon Kosher salt");

        UnitOfMeasure teaSpoon = new UnitOfMeasure();
        number.setDescription("Teaspoon");

        salt.setUnitOfMeasure(teaSpoon);

        salt.setRecipe(recipe);
        salt.setAmount(new BigDecimal(0.5));

        Ingredient limeJuice = new Ingredient();
        limeJuice.setAmount(new BigDecimal(1));

        UnitOfMeasure tableSppon = new UnitOfMeasure();
        tableSppon.setDescription("Tablespoon");

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

        Ingredient cilantro =new Ingredient();
        cilantro.setDescription("cilantro (leaves and tender stems), finely chopped");
        cilantro.setRecipe(recipe);
        cilantro.setUnitOfMeasure(tableSppon);
        cilantro.setAmount(new BigDecimal(2));

        UnitOfMeasure dash = new UnitOfMeasure();
        dash.setDescription("Dash");

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

        recipe.setIngredients(ingredients);

        return recipe;

    }
}
