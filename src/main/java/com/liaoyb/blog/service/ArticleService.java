package com.liaoyb.blog.service;

import com.liaoyb.blog.domain.dto.PageParam;
import com.liaoyb.blog.domain.model.Article;
import org.springframework.data.domain.Page;

/**
 * @author ybliao2
 */
public interface ArticleService {

	/**
	 * all articles
	 * @param queryParam
	 * @return top 10 record if queryParam is null
	 */
	Page<Article> getArticles(PageParam queryParam);
	Article getArticle(Long articleId);
}
