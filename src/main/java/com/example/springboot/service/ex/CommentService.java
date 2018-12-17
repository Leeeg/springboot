package com.example.springboot.service.ex;

import com.example.springboot.dto.ArticleCommentDto;

import javax.xml.stream.events.Comment;
import java.util.List;

/**
 * @title:留言的Service
 * @gmail jefferyleeeg@gmail.com
 * @author:Lee
 * @date: 2018/12/16
 */
public interface CommentService {
    void addComment(Comment comment);

    void addArticleComment(ArticleCommentDto articleCommentDto);

    void deleteCommentById(Long id);

    void deleteArticleCommentById(Long id);

    List<Comment> listAllComment();

    List<ArticleCommentDto> listAllArticleCommentById(Long id);
}
