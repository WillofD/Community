package com.infantstudio.community.Countrylist;

/**
 * Created by Pavan on 10/10/2016.
 */
public class FragmentCountryListFeedItem {

    private String news_title;
    private String news_details;
    private String news_image;

    private String person_id;

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }




    public FragmentCountryListFeedItem(){


    }
    public FragmentCountryListFeedItem(String news_title, String news_details, String news_image,String person_id) {

        super();
        this.news_title = news_title;
        this.news_details = news_details;
        this.news_image = news_image;
        this.person_id = person_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_details() {
        return news_details;
    }

    public void setNews_details(String news_details) {
        this.news_details = news_details;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }
}
