package com.ll.sapp.domain.post.entity;

import com.ll.sapp.domain.member.entity.Member;
import com.ll.sapp.global.jpa.entity.BaseTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Builder
@Getter
@Setter
public class Post extends BaseTime {
    @ManyToOne
    private Post parent;

    @ManyToOne
    private Member author;
    private String title;
    private String body;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Post> children = new ArrayList<>();

    public Post addChild(Member author, String title, String body) {
        Post post = Post.builder()
                .parent(this)
                .author(author)
                .title(title)
                .body(body)
                .build();

        children.add(post);

        return post;
    }
}

