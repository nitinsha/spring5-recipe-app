package com.nitin.app.service;

import com.nitin.app.models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> findAllRecipe();
}
