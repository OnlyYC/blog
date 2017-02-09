/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.liaoyb.blog.repository;

import com.liaoyb.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * <code>ArticleRepository</code>
 * </p>
 *
 * @author ybliao2
 * @version 1.0
 * @since 1.0
 */
public interface ArticleRepository extends JpaRepository<Article,String> {
}
