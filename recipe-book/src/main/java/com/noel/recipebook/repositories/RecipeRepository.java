package com.noel.recipebook.repositories;

import com.noel.recipebook.entities.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    public Recipe findByName(String name);

    public List<Recipe> findByMainIngredient(String mainIngredient);

    @Query("{ 'macros.calories': { $lte: ?0 }, 'macros.fats': { $lte: ?1 }, 'macros.protein': { $lte: ?2 }, 'macros.carbs': { $lte: ?3} }")
    public List<Recipe> findByMacros(int calories, int fats, int protein, int carbs);

    public List<Recipe> findBytimeToCook(String timeToCook);

    public void deleteByName(String name);
}
