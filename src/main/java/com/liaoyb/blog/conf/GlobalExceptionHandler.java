package com.liaoyb.blog.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author liaoyb
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BasicErrorController {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Override
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.TEXT_HTML));
		HttpStatus status = getStatus(request);
		//404
		if (HttpStatus.NOT_FOUND == status) {
			return new ModelAndView("errorPage/404", model);
		}
		// 指定自定义的视图
		return new ModelAndView("errorPage/error", model);
	}

	@RequestMapping(produces = "text/html", value = "/404")
	public ModelAndView errorHtml404(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(HttpStatus.NOT_FOUND.value());
		return new ModelAndView("errorPage/404");
	}

	@RequestMapping("/404")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> error404(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "not found");
		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
	}

	@Autowired
	public GlobalExceptionHandler(ServerProperties serverProperties) {
		super(new DefaultErrorAttributes(), serverProperties.getError());
	}


	@Override
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
		HttpStatus status = getStatus(request);
		logger.error(body.toString());

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", body.get("error"));

		return new ResponseEntity<>(map, status);
	}


}
