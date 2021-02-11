package com.nasBoukehil.blogPress.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nasBoukehil.blogPress.util.BlogpressCommentComparator;
import com.nasBoukehil.blogPress.util.BlogpressUtil;

@Document(indexName = "blog", shards = 1, replicas = 0, createIndex = true)
public class Blog {

	@Id
	private String _id;
	
	private String title;
	private String body;
	private String status;
	private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyy'T'HH:mm:ss")
	private Date createdDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyy'T'HH:mm:ss")
	private Date publishDate;
	
	@Field(includeInParent = true, type = FieldType.Nested)
	private List<Comment> comments;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public List<Comment> getComments() {
		if (comments != null && !comments.isEmpty()) {
			Collections.sort(comments, new BlogpressCommentComparator());
		}
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getPublishDateForDisplay() {
		String returnDateStr = "";
		if (this.getPublishDate() != null) {
			returnDateStr = BlogpressUtil.getFormattedDateForDisplayOnPage(publishDate);
		}
		return returnDateStr;
	}
	
	public int getCommentSize() {
		if (this.comments != null) {
			return this.comments.size();
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Blog {" + 
						"title=" + title + 
						", body=" + body + 
						", status=" + status + 
						", createdBy=" + createdBy + 
						", createdDate=" + BlogpressUtil.getFormattedDateForElasticSearch(createdDate) + 
						", publishDate=" + BlogpressUtil.getFormattedDateForElasticSearch(publishDate) + 
						", comments=" + comments +
				"}";
	}
	
	
	
}
