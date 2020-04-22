/**
 * A model for Meal
 */

import java.util.ArrayList;
import java.util.Random;

public class Meal {
    String name; // name of the meal: breakfast, lunch, dinner and dessert
    int pageStart;
    int pageEnd;
    ArrayList<String[]> allRecipe;

    public Meal(String name, int pageStart, int pageEnd) {
        this.name = name;
        this.pageStart = pageStart;
        this.pageEnd = pageEnd;
    }

    // crawl the recipe for the specific meal, specific pages of the website
    // save the recipes in the Meal
    public void crawl() {
        ArrayList<String[]> allRecipe = new ArrayList<>();
        HTMLGetter m = new HTMLGetter(name);
        for (int i = pageStart; i < pageEnd+1; i++) {
            String originHTML = m.getHTML(i);
            HTMLParser editedHTML = new HTMLParser(originHTML);
            allRecipe.addAll(editedHTML.getMeals());
        }
        this.allRecipe = allRecipe;
    }

    // save the result as csv file
    public void recordMeals() {
        CSVEditor.write(name, allRecipe);
    }

    // randomly choose the recipe from all the result
    public String randomChoose() {
        Random random = new Random();
        int i = random.nextInt(100);
        String[] randomMeal = allRecipe.get(i);
        String recipe = name.toUpperCase() + "\n";
        recipe += "Name: " + randomMeal[0] + "\n";
        recipe += "Rating: " + randomMeal[1] + "\n";
        recipe += "Ingredient: " + randomMeal[2] + "\n";
        recipe += "Reviewer: " + randomMeal[3] + "\n";
        recipe += "Url: " + randomMeal[4];
        return recipe;
    }
}
