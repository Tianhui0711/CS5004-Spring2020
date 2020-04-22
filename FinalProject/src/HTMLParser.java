import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Use Jsoup selector to help analyze the HTML context and get what I want
 */

public class HTMLParser {
    String html;
    Document document;

    /**
     * Construct a HTML Parser
     */
    // 接收已经get的html文本，进行清洗
    public HTMLParser(String html) {
        this.html = html;
        this.document = Jsoup.parse(html);
    }

    // 使用选择器先选择出每个页面上的所有菜谱,方便后面的分类筛选
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

    public ArrayList<String> getInfo(String mark) {
        Elements info = analyze().select(mark);
        ArrayList<String> infoList = new ArrayList<>();
        for (Element i : info) {
            infoList.add(i.text());
        }
        return infoList;
    }

    public ArrayList<String> getName() {
        ArrayList nameList = getInfo("[data-expose-tracking-url]");
        return nameList;
    }

    public ArrayList<String> getUrl() {
        ArrayList<String> urlList = new ArrayList<>();
        for (Element e: analyze()) {
            String url = e.select("a").first().attr("href");
            urlList.add("https://www.xiachufang.com" +url);
        }
        return urlList;
    }

    public ArrayList<String> getIngredient() {
        ArrayList ingredientList = getInfo(".ing.ellipsis");
        return ingredientList;
    }

    public ArrayList<String> getRating() {
        ArrayList ratingList = getInfo(".score.bold.green-font");
        return ratingList;
    }

    public ArrayList<String> getReviewer() {
        ArrayList reviewerList = getInfo("span[class~=bold\\sscore]");
        return reviewerList;
    }

    // 把每个菜谱输出成array的形式
    // 改用string[] 方便和后面衔接
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

//    public static void main(String[] args) {
//        HTMLGetter html = new HTMLGetter("breakfast");
//        String h = html.getHTML(1);
//        HTMLParser p = new HTMLParser(h);
//    }
}
