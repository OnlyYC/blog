package com.liaoyb.blog.repository;

import com.liaoyb.blog.domain.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ArticleRepository
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
