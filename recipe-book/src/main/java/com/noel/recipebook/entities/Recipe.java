package com.noel.recipebook.entities;

import org.springframework.data.annotation.Id;

import java.util.Arrays;

public class Recipe {
    @Id
    private String id;

    private String name;

    private String mainIngredient;

    private String ingredients;

    private String instructions;

    private String timeToCook;

    private String timeToPrepare;

    private String description;

    private int servings;

    private String equipmentNeeded;

    private Macros macros;

    private Recipe() {}

    public Recipe(
            String id,
            String name,
            String mainIngredient,
            String ingredients,
            String instructions,
            String timeToCook,
            String timeToPrepare,
            String description,
            int servings,
            String equipmentNeeded
    ) {
        this.id = id;
        setName(name);
        setMainIngredient(mainIngredient);
        setIngredients(ingredients);
        setInstructions(instructions);
        setTimeToCook(timeToCook);
        setTimeToPrepare(timeToPrepare);
        setDescription(description);
        setServings(servings);
        setEquipmentNeeded(equipmentNeeded);
        this.macros = null;
    }

    public Recipe(
            String id,
            String name,
            String mainIngredient,
            String ingredients,
            String instructions,
            String timeToCook,
            String timeToPrepare,
            String description,
            int servings,
            String equipmentNeeded,
            Macros macros
    ) {
        this.id = id;
        setName(name);
        setMainIngredient(mainIngredient);
        setIngredients(ingredients);
        setInstructions(instructions);
        setTimeToCook(timeToCook);
        setTimeToPrepare(timeToPrepare);
        setDescription(description);
        setServings(servings);
        setEquipmentNeeded(equipmentNeeded);
        setMacros(new Macros(macros.getCalories(), macros.getFats(), macros.getProtein(), macros.getCarbs()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name.toLowerCase();
        }
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        if (mainIngredient != null && !mainIngredient.isBlank()) {
            this.mainIngredient = mainIngredient.toLowerCase();
        }
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        if (ingredients != null && !ingredients.isBlank()) {
            this.ingredients = ingredients.toLowerCase();
        }
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        if (instructions != null && !instructions.isBlank()) {
            this.instructions = instructions;
        }
    }

    public String getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(String timeToCook) {
        if (timeToCook != null && !timeToCook.isBlank()) {
            this.timeToCook = timeToCook.toLowerCase();
        }
    }

    public String getTimeToPrepare() {
        return timeToPrepare;
    }

    public void setTimeToPrepare(String timeToPrepare) {
        if (timeToPrepare != null && !timeToPrepare.isBlank()) {
            this.timeToPrepare = timeToPrepare.toLowerCase();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && !description.isBlank()) {
            this.description = description.toLowerCase();
        }
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        if (servings >= 1) {
            this.servings = servings;
        }
    }

    public String getEquipmentNeeded() {
        return equipmentNeeded;
    }

    public void setEquipmentNeeded(String equipmentNeeded) {
        if (equipmentNeeded != null && !equipmentNeeded.isBlank()) {
            this.equipmentNeeded = equipmentNeeded.toLowerCase();
        }
    }

    public Macros getMacros() {
        return macros;
    }

    public void setMacros(Macros macros) {
        if (macros != null) {
            this.macros = new Macros(macros.getCalories(), macros.getProtein(), macros.getCarbs(), macros.getFats());
        }
    }

    @Override
    public String toString() {
        return "Recipe {" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                ", timeToCook='" + timeToCook + '\'' +
                ", timeToPrepare='" + timeToPrepare + '\'' +
                ", description='" + description + '\'' +
                ", servings=" + servings +
                ", equipmentNeeded='" + equipmentNeeded + '\'' +
                ", macros=" + macros +
                '}';
    }
}
