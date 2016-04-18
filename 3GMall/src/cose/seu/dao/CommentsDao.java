package cose.seu.dao;

import java.util.List;

import cose.seu.entity.Comments;

public interface CommentsDao {

	public List<Comments> findComByBID(Long bid);
	public void insertCom (Comments com);
	
}
