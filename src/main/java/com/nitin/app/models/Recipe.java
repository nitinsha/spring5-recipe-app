package com.nitin.app.models;

import com.nitin.app.enums.Difficulty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    private String source;
    private String url;
    @Lob
    private String directions;
    @Lob
    private Byte[] image;
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name="recipe_id")
    ,inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories = new HashSet<>();

    public Recipe() {
    }

    public Recipe addIngredients(Ingredient ingredient){
        this.getIngredients().add(ingredient);
        ingredient.setRecipe(this);
        return this;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getPrepTime() {
        return this.prepTime;
    }

    public Integer getCookTime() {
        return this.cookTime;
    }

    public Integer getServing() {
        return this.serving;
    }

    public String getSource() {
        return this.source;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDirections() {
        return this.directions;
    }

    public Byte[] getImage() {
        return this.image;
    }

    public Notes getNotes() {
        return this.notes;
    }

    public Set<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }


}
