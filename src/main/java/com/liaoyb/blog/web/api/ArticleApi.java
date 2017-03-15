package com.liaoyb.blog.web.api;

import com.liaoyb.blog.domain.dto.PageDto;
import com.liaoyb.blog.domain.dto.PageParam;
import com.liaoyb.blog.domain.model.Article;
import com.liaoyb.blog.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author liaoyb
 */
@Controller
@RequestMapping("/api")
public class ArticleApi {
	@Resource
	private ArticleService articleService;

	@RequestMapping("/articles")
	@ResponseBody
	public PageDto<Article> findAll(@RequestBody PageParam pageParam) {
		Page<Article> articlePage=articleService.getArticles(pageParam);
		return PageDto.convertFor(articlePage);
	}
}
