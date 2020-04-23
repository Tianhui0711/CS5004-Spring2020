public interface CrawlerController {
    // download all the information for breakfast, lunch, dinner and dessert to csv file
    void downLoadDiet();

    // randomly choose the recipes to recommend
    // Return a array of string of every meal's recipe
    String[] recipeCollect();
}
