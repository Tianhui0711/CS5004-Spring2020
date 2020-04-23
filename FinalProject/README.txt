Web Crawler for XiaChuFang

Tianhui Li 04/20/2020
CS5004 Final Project

1. Instruction:
To run the program, use the ProjectRunner.java file.
To see the structure of the project, read the FinalProject_MyWebCrawler.pptx.

2. Basic Idea of the Project:
Since people all stay at home during this special period, it is kind of hard to decide what to eat everyday. So the project can help them find what to eat and how to cook these meals.

This project will:
Crawl the recipes from this website: https://www.xiachufang.com/
Download the recipes for your breakfast, lunch, dinner and dessert as csv files
Randomly pick up recipes for your today’s meals.

3. Tools and Technologies
httpCilent - Get HTML from the url
Jsoup - Select the elements from HTML
Use multi-thread to crawl the website
Javacsv - write csv file
Swing - build the GUI

4. Challenges
Find proper tools to crawl the website
Analysis the HTML, since some of tags are missing, I need to complete them myself
Figure out a reasonable structure of the whole project
Add listener to the buttons and allow new windows to open a new window when click on the button 

5. Things that can be improved
What If the website has an anti-crawler protection - change the ip？ 
Do more analysis on the crawled data 


