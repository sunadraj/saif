package com.example.saif;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedModel {@SerializedName("id")
@Expose
private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("description")
    @Expose
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}