package com.noel.recipebook.controllers;

import com.noel.recipebook.entities.Macros;
import com.noel.recipebook.entities.Recipe;
import com.noel.recipebook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/recipe/")
@CrossOrigin
public class RecipeController {

    @Autowired
    RecipeRepository repository;

    @GetMapping
    public List getAllRecipes() {
        return repository.findAll();
    }



    @PostMapping
    public void addRecipe(@RequestBody Recipe recipe) {
        if (recipe.getName() == null || recipe.getName().isBlank()) {
            return;
        }

        Recipe prevRecipe = repository.findByName(recipe.getName().toLowerCase());
        if (prevRecipe != null) {
            return;
        }

        repository.save(recipe);
    }

    @DeleteMapping
    public void deleteAll() {
        repository.deleteAll();
    }

    @GetMapping("name/{name}")
    public Recipe getRecipeByName(@PathVariable String name) {
        return repository.findByName(name.toLowerCase());
    }

    @DeleteMapping("name/{name}")
    public void deleteRecipeByName(@PathVariable String name){
        repository.deleteByName(name);
    }

    @PutMapping("name/{name}")
    public void updateRecipe(@PathVariable String name, @RequestBody Recipe newRecipe) {
        Recipe recipe = repository.findByName(name.toLowerCase());
        if (recipe != null) {
            recipe.setName(newRecipe.getName());
            recipe.setDescription(newRecipe.getDescription());
            recipe.setIngredients(newRecipe.getIngredients());
            recipe.setServings(newRecipe.getServings());
            recipe.setInstructions(newRecipe.getInstructions());
            recipe.setEquipmentNeeded(newRecipe.getEquipmentNeeded());
            recipe.setTimeToCook(newRecipe.getTimeToCook());
            recipe.setTimeToPrepare((newRecipe.getTimeToPrepare()));
            recipe.setMainIngredient(newRecipe.getMainIngredient());

            Macros recipeMacros = recipe.getMacros();
            recipeMacros.setCalories(newRecipe.getMacros().getCalories());
            recipeMacros.setCarbs(newRecipe.getMacros().getCarbs());
            recipeMacros.setProtein(newRecipe.getMacros().getProtein());
            recipeMacros.setFats(newRecipe.getMacros().getFats());

            repository.save(recipe);
        }
    }

    @GetMapping("ingredient/{mainIngredient}")
    public List<Recipe> getByMainIngredient(@PathVariable String mainIngredient) {
        return repository.findByMainIngredient(mainIngredient.toLowerCase());
    }

    @GetMapping("macros")
    public List<Recipe> getByMacros(@RequestBody Macros macros) {
        return repository.findByMacros(macros.getCalories(), macros.getProtein(), macros.getFats(), macros.getCarbs());
    }

    @GetMapping("time/{time}")
    public List<Recipe> getByCookTime(@PathVariable String time) {
        return repository.findBytimeToCook(time);
    }

}
