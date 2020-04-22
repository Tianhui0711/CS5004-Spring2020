import java.util.ArrayList;
import java.util.Random;

public class Meal {
    String meal;
    int pageStart;
    int pageEnd;
    ArrayList<String[]> allRecipe;

    public Meal(String meal, int pageStart, int pageEnd) {
        this.meal = meal;
        this.pageStart = pageStart;
        this.pageEnd = pageEnd;
    }

    // 爬取指定餐点类型、指定页数的食谱，并存到arraylist中
    public void crawl() {
        ArrayList<String[]> allRecipe = new ArrayList<>();
        HTMLGetter m = new HTMLGetter(meal);
        for (int i = pageStart; i < pageEnd+1; i++) {
            String originHTML = m.getHTML(i);
            HTMLParser editedHTML = new HTMLParser(originHTML);
            allRecipe.addAll(editedHTML.getMeals());
        }
        this.allRecipe = allRecipe;
    }

    // 爬取结果写入csv
    public void recordMeals() {
        CSVEditor.write(meal, allRecipe);
    }

    // 随机抽取，进行推荐
    public String randomChoose() {
        Random random = new Random();
        int i = random.nextInt(100);
        String[] randomMeal = allRecipe.get(i);
        String recipe = meal.toUpperCase() + "\n";
        recipe += "Name: " + randomMeal[0] + "\n";
        recipe += "Rating: " + randomMeal[1] + "\n";
        recipe += "Ingredient: " + randomMeal[2] + "\n";
        recipe += "Reviewer: " + randomMeal[3] + "\n";
        recipe += "Url: " + randomMeal[4];
        return recipe;
    }
}
