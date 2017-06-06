package com.niit.jobseeker.dao;

import java.util.List;

import com.niit.jobseeker.model.ForumComment;

public interface ForumCommentDAO {
	public boolean saveOrUpdate(ForumComment forumcomment);

	public boolean delete(ForumComment forumcomment);

	public List<ForumComment> list(int fid);
}
