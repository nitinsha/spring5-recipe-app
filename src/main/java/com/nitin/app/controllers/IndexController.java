package com.nitin.app.controllers;

import com.nitin.app.models.Recipe;
import com.nitin.app.repositories.CategoryRepository;
import com.nitin.app.repositories.RecipeRepository;
import com.nitin.app.repositories.UnitOfMeasureRepository;
import com.nitin.app.service.RecipeService;
import com.nitin.app.service.RecipeServiceImpl;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class IndexController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(IndexController.class);

    private RecipeService recipeService;


    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"","/","/index"})
    public String retriveHomePage(Model model){
        System.out.println("Hello");
        log.info("Home Pagerequest received..");

//        log.debug("Size of Recipes:"+recipes.size());
        model.addAttribute("recipes",recipeService.findAllRecipe());
        return "index";
    }
}
