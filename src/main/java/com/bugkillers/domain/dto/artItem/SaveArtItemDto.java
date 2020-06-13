package com.bugkillers.domain.dto.artItem;

import java.time.LocalDate;

public class SaveArtItemDto {
    private String artist; //조인해야혀
    private String title;
    private String description;
    private int price;
    private LocalDate create_at;
    private LocalDate modify_at;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDate create_at) {
        this.create_at = create_at;
    }

    public LocalDate getModify_at() {
        return modify_at;
    }

    public void setModify_at(LocalDate modify_at) {
        this.modify_at = modify_at;
    }
}
