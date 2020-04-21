import java.util.ArrayList;
import java.util.Random;

/**
 * Author: Tianhui Li
 * Data: 04/18/2020
 * Class: CS5004 Final Project
 *
 * The program is a web crawler for the website "XiaChuFang(下厨房)", which is a website about cooking and
 * sharing recipes. The program will help people to design their daily diet, since we all stay at home these days and
 * deciding what to cook is kind of a hard work for me.
 * The program will gather the recipes of breakfast, lunch, dinner and dessert in this website, save them as csv files
 * and randomly choose recipes to form a daily diet. And then you don't have to worry about what to eat today!
 */

public class MyCrawler {
    Meal breakfast = new Meal("breakfast", 1, 5);
    Meal lunch = new Meal("lunch", 1, 5);
    Meal dinner = new Meal("dinner", 6, 10);
    Meal dessert = new Meal("dessert", 1, 5);
    Meal[] meals = new Meal[]{breakfast, lunch, dinner, dessert};

    public MyCrawler() {
        for (Meal m : meals) {
            m.crawl();
        }
    }

    public void downLoadDiet() {
        for (Meal m : meals) {
            m.recordMeals();
        }
    }

    public String[] recipeCollect() {
        String[] randomMeals = new String[4];
        for (int i = 0; i < 4; i++) {
            randomMeals[i] = meals[i].randomChoose();
        }
        return randomMeals;
    }
}
