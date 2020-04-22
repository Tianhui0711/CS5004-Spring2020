/**
 * Use Jsoup lib to help select elements and analyze the HTML context
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class HTMLParser {
    String html;
    Document document;

    // Construct a html Parser, get the html file
    public HTMLParser(String html) {
        this.html = html;
        this.document = Jsoup.parse(html);
    }

    // use the selector the select the elements contains all the recipes on the page
    public Elements analyze() {
        Elements infoGeneral = document.select("div.recipe.recipe-215-horizontal.pure-g.image-link.display-block");
        Elements info = infoGeneral.select("div.info.pure-u");
        for (Element e: info) {
            Elements s = e.select("p.stats");
            // 补全html，防止有的菜谱没有评分或者做过的人数为0
            if (! s.text().contains("综合评分")) {
                s.prepend("综合评分&nbsp;<span class=\"score bold green-font\">0</span>");
            } else if (! s.text().contains("人做过")) {
                s.append("&nbsp;（七天内 <span class=\"bold score\">0</span> 人做过）");
            }
        }
        return info;
    }

    // get
    public ArrayList<String> getInfo(String mark) {
        Elements info = analyze().select(mark);
        ArrayList<String> infoList = new ArrayList<>();
        for (Element i : info) {
            infoList.add(i.text());
        }
        return infoList;
    }

    // get the detailed name of the meal
    public ArrayList<String> getName() {
        ArrayList nameList = getInfo("[data-expose-tracking-url]");
        return nameList;
    }

    // get the url of the recipe
    public ArrayList<String> getUrl() {
        ArrayList<String> urlList = new ArrayList<>();
        for (Element e: analyze()) {
            String url = e.select("a").first().attr("href");
            urlList.add("https://www.xiachufang.com" +url);
        }
        return urlList;
    }

    // get the ingredient of the meal
    public ArrayList<String> getIngredient() {
        ArrayList ingredientList = getInfo(".ing.ellipsis");
        return ingredientList;
    }

    // get the rating of the meal
    public ArrayList<String> getRating() {
        ArrayList ratingList = getInfo(".score.bold.green-font");
        return ratingList;
    }

    // get the number of the reviewers
    public ArrayList<String> getReviewer() {
        ArrayList reviewerList = getInfo("span[class~=bold\\sscore]");
        return reviewerList;
    }

    // Save all the information of one meal in a array of string
    // Return the arraylist of the array of string, which contains all the information of each page
    public ArrayList<String[]> getMeals() {
        ArrayList<String[]> mealTable = new ArrayList();
        int size = getName().size();
        for (int i = 0; i < size; i++) {
            String[] mealList = new String[size];
            mealList[0] = getName().get(i);
            mealList[1] = getRating().get(i);
            mealList[2] = getIngredient().get(i);
            mealList[3] = getReviewer().get(i);
            mealList[4] = getUrl().get(i);
            mealTable.add(mealList);
        }
        return mealTable;
    }
}
