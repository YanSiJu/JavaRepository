package com.alibaba.entity;

import java.time.LocalDateTime;

/**
 * @author Bill
 *
 */
public class Post {

	private int postsId;
	private String title;
	private String content;
	private LocalDateTime time;
	private int userId;
	// µãÔÞÊý
	/**
	 * 
	 */
	private int praiseCount;

	public int getPostsId() {
		return postsId;
	}

	public void setPostsId(int postsId) {
		this.postsId = postsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getPraiseCount() {
		return praiseCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + postsId;
		result = prime * result + praiseCount;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + userId;
		return result;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int postsId, String title, String content, LocalDateTime time, int userId, int praiseCount) {
		super();
		this.postsId = postsId;
		this.title = title;
		this.content = content;
		this.time = time;
		this.userId = userId;
		this.praiseCount = praiseCount;
	}

	@Override
	public String toString() {
		return "Post [postsId=" + postsId + ", title=" + title + ", content=" + content + ", time=" + time + ", userId="
				+ userId + ", praiseCount=" + praiseCount + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			{
				return false;
			}
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (postsId != other.postsId) {
			return false;
		}
		if (praiseCount != other.praiseCount) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}

}
