package com.back.sbb.Article;

import com.back.sbb.Member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Member author;
}
