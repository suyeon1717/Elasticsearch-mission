package com.back.domain.post.document;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.OffsetDateTime;

@Document(indexName = "posts") // posts 인덱스 생성
@Getter
public class Post {
    @Id
    private String id;
    @Field(type= FieldType.Text) // 전문 검색 가능
    private String title;
    @Field(type= FieldType.Text) // 전문 검색 가능
    private String content;
    @Field(type= FieldType.Keyword) // 정확한 일치 검색용
    private String author;

    @Field(
            type = FieldType.Date,
            format = DateFormat.date_time
    )
    private OffsetDateTime createdAt;

    @Field(
            type = FieldType.Date,
            format = DateFormat.date_time
    )
    private OffsetDateTime lastModifiedAt;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = OffsetDateTime.now();
        this.lastModifiedAt = OffsetDateTime.now();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                ", lastModifiedAt=" + lastModifiedAt +
                '}';
    }
}
