package com.nasBoukehil.blogPress.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.nasBoukehil.blogPress.model.Blog;

public interface BlogRepository extends ElasticsearchRepository<Blog, String> {

	
}
