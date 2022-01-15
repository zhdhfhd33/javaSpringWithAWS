package com.SpringBoot.web.dto;

import com.SpringBoot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter //Dto클래스에는 반드시 getter가 있어야 한다.
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
