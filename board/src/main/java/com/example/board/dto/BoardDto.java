package com.example.board.dto;

import com.example.board.domain.entity.Board;
import lombok.*;

import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String comment;

    // 사용자에게 노출되는 부분만
    public Board toEntity() {
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .comment(comment)
                .build();
        return build;
    }

    // 사용자에게는 보여지지 않는 정보까지 포함
    @Builder
    public BoardDto(Long id, String author, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate, String comment) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.comment = comment;
    }
}
