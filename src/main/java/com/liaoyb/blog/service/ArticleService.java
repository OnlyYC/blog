package com.liaoyb.blog.service;

import com.liaoyb.blog.domain.model.Article;
import org.springframework.data.domain.Page;

/**
 * @author ybliao2
 */
public interface ArticleService {
	//所有文章-分页
	Page<Article> findAll(int page, int size);
}
