package com.nitin.app.repositories;

import com.nitin.app.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
