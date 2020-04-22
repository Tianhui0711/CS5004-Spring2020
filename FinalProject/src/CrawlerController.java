/**
 * A controller deals with all information for breakfast, lunch, dinner and dessert
 */

public class CrawlerController {
    Meal breakfast = new Meal("breakfast", 1, 5);
    Meal lunch = new Meal("lunch", 1, 5);
    Meal dinner = new Meal("dinner", 6, 10);
    Meal dessert = new Meal("dessert", 1, 5);
    Meal[] meals = new Meal[]{breakfast, lunch, dinner, dessert};

    // crawl all the information for breakfast, lunch, dinner and dessert
    public CrawlerController() {
        for (Meal m : meals) {
            m.crawl();
        }
    }

    // download all the information for breakfast, lunch, dinner and dessert to csv file
    public void downLoadDiet() {
        for (Meal m : meals) {
            m.recordMeals();
        }
    }

    // randomly choose the recipes to recommend
    // Return a array of string of every meal's recipe
    public String[] recipeCollect() {
        String[] randomMeals = new String[4];
        for (int i = 0; i < 4; i++) {
            randomMeals[i] = meals[i].randomChoose();
        }
        return randomMeals;
    }
}
