package pjt1.model.dao;

import java.util.List;

import pjt1.model.VideoReview;

public interface IVideoReviewDao {
	
	int insertReview(VideoReview vidioReview);
	List<VideoReview> selectReview(int videoNo);
	
}
