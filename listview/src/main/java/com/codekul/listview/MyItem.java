package com.codekul.listview;

/**
 * Created by aniruddha on 1/1/17.
 */

public class MyItem {

    private Long id;
    private int image;
    private String text;

    public MyItem(Long id, int image, String text) {
        this.id = id;
        this.image = image;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
