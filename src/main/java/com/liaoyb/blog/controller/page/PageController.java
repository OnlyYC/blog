package com.liaoyb.blog.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author ybliao2
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String index(Map map) {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
