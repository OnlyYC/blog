/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.liaoyb.blog.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * <code>HelloController</code>
 * </p>
 *
 * @author ybliao2
 * @version 1.0
 * @since 1.0
 */
@Controller
public class HelloController {
	@RequestMapping("/")
	@ResponseBody
	public String index(){
		return "hello";
	}
}
