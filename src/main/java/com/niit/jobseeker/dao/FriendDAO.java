package com.niit.jobseeker.dao;

import java.util.List;

import com.niit.jobseeker.model.Friend;

public interface FriendDAO {
	public boolean saveOrUpdate(Friend friend);

	public boolean delete(Friend friend);

	public Friend newrequest(String uid, String fid);

	public List<Friend> getfriendlist(String uid);

	public List<Friend> getrequestlist(String uid);

	public List<Friend> setonline(String uid);
}
