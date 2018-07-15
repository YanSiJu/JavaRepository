package com.alibaba.entity;

import java.time.LocalDateTime;

public class MenuComment {

	private int commentId;
	private String content;
	private LocalDateTime date;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	private int userId;
	private int menuId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentId;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + menuId;
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
		MenuComment other = (MenuComment) obj;
		if (commentId != other.commentId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (menuId != other.menuId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public MenuComment() {
		super();
	}

	public MenuComment(int commentId, String content, LocalDateTime date, int userId, int menuId) {
		super();
		this.commentId = commentId;
		this.content = content;
		this.date = date;
		this.userId = userId;
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "MenuComment [commentId=" + commentId + ", content=" + content + ", date=" + date + ", userId=" + userId
				+ ", menuId=" + menuId + "]";
	}

}
