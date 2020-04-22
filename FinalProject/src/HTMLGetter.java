/**
 * Use httpClient to help get the HTML context of the web page
 */

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class HTMLGetter {
    String meal;
    String url;

    /**
     * Construct a HTMLGetter
     */
    public HTMLGetter(String meal) {
        this.meal = meal;       // breakfast|lunch|dinner|dessert
        // 大小写是否区分？或者用一个字母代替？
        if (meal == "breakfast") {
            this.url = "https://www.xiachufang.com/category/40071/?page=";
        } else if (meal == "lunch" || meal == "dinner") {
            this.url = "https://www.xiachufang.com/category/40076/?page=";
        } else {
            this.url = "https://www.xiachufang.com/category/51759/?page=";
        }
    }

    /**
     * Get the HTML of the given page
     * @param page
     * @return
     */
    // 是否需要处理ip的问题？
    public String getHTML(int page) {
        try {
            // create httpclient, like opening a browser
            CloseableHttpClient httpclient = HttpClients.createDefault();
            // create get request, like typing url in the browser
            HttpGet httpget = new HttpGet(url + page);
            // set header, set the program like a browser
            httpget.setHeader("User-Agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/" +
                            "80.0.3987.163 Safari/537.36");
            // process the request, like entering the url
            CloseableHttpResponse response = httpclient.execute(httpget);
            int status = response.getCode();
            if (status >= HttpStatus.SC_SUCCESS && status < HttpStatus.SC_REDIRECTION) {
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity, "utf-8");
                return content;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        HTMLGetter html = new HTMLGetter("breakfast");
//        System.out.println(html.getHTML(1));
//    }
}
