package com.test.core;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "video")
public class VideoJPA {
    @NotNull
    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @JsonProperty
    @Column
    private String title;

    public int getId() {
        return id;
    }

    public VideoJPA setId(int id) {
        this.id = id;

        return this;
    }

    public String getTitle() {
        return title;
    }

    public VideoJPA setTitle(String title) {
        this.title = title;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoJPA video = (VideoJPA) o;

        if (id != video.id) return false;
        if (!title.equals(video.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        return result;
    }
}
