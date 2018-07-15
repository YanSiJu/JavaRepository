package com.alibaba.entity;

import java.time.LocalDateTime;

public class PostComment {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentId;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + postsId;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostComment other = (PostComment) obj;
		if (commentId != other.commentId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (postsId != other.postsId)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public PostComment() {
		super();
	}

	

	public PostComment(int commentId, int postsId, String content, LocalDateTime time, int userId) {
		super();
		this.commentId = commentId;
		this.postsId = postsId;
		this.content = content;
		this.time = time;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PostComment [commentId=" + commentId + ", postsId=" + postsId + ", content=" + content + ", time="
				+ time + ", userId=" + userId + "]";
	}

	private int commentId;
	private int postsId;
	private String content;
	private LocalDateTime time;
	private int userId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getPostsId() {
		return postsId;
	}

	public void setPostsId(int postsId) {
		this.postsId = postsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
