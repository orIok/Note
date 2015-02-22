package com.code.shity.note;

import java.io.Serializable;

public class Note implements Serializable{
    private int colorStatusBar, colorActionBar;
    private String name, note, tag;

    public Note() {
        colorActionBar = R.color.BrownActionBar;
        colorStatusBar = R.color.BrownStatusbar;
    }
    public int getColorStatusBar() {
        return colorStatusBar;
    }

    public Note setColorStatusBar(int colorStatusBar) {
        this.colorStatusBar = colorStatusBar;
        return this;
    }

    public int getColorActionBar() {
        return colorActionBar;
    }

    public Note setColorActionBar(int colorActionBar) {
        this.colorActionBar = colorActionBar;
        return this;
    }

    public String getName() {
        return name;
    }

    public Note setName(String name) {
        this.name = name;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Note setNote(String note) {
        this.note = note;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Note setTag(String tag) {
        this.tag = tag;
        return this;
    }
}
