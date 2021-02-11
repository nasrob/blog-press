package com.nasBoukehil.blogPress.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nasBoukehil.blogPress.repository.BlogRepository;

public class BlogService {

	private Logger logger = LoggerFactory.getLogger(BlogService.class);
	
	@Autowired
	private BlogRepository blogRepository;
}
