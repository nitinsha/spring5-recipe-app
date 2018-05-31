package com.nitin.app.service;

import com.nitin.app.models.Recipe;
import com.nitin.app.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> findAllRecipe() {

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet :: add);
        System.out.println("Service fetched recipes from Repository:"+recipeSet.size());
        return recipeSet;
    }
}
