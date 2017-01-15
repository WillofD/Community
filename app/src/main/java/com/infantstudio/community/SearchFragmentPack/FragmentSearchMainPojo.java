package com.infantstudio.community.SearchFragmentPack;

/**
 * Created by Lincoln on 18/05/16.
 */
public class FragmentSearchMainPojo {
    private String name;

    private int thumbnail;

    public FragmentSearchMainPojo() {
    }

    public FragmentSearchMainPojo(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
