package com.liaoyb.blog.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ybliao2
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
