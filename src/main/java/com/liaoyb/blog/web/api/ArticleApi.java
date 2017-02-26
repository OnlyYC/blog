package com.liaoyb.blog.web.api;

import com.liaoyb.blog.domain.model.Article;
import com.liaoyb.blog.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author liaoyb
 */
@Controller
@RequestMapping("/api/article")
public class ArticleApi {
	@Resource
	private ArticleService articleService;

	@RequestMapping("/articles")
	@ResponseBody
	public Page<Article> findAll(@RequestParam(defaultValue = "0") int page,
	                             @RequestParam(defaultValue = "10") int size) {
		return articleService.findAll(page, size);
	}
}
