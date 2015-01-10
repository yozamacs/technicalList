package com.springapp.mvc;

import org.hibernate.validator.constraints.NotEmpty;

public class Checklist {
    private boolean itemCompleted;

    private String itemTitle;

    private String itemDescription;

    public boolean isItemCompleted() {
        return itemCompleted;
    }

    @NotEmpty(message = "Please enter a title")
    public String getItemTitle() {
        return itemTitle;
    }
    
    @NotEmpty(message = "Please enter a description")
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setItemCompleted(boolean itemCompleted) {
        this.itemCompleted = itemCompleted;
    }
}
