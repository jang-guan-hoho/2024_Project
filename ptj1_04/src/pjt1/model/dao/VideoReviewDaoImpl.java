package pjt1.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pjt1.model.VideoReview;

public class VideoReviewDaoImpl implements IVideoReviewDao{

	private int reviewNo=1;
	private static Map<Integer, List<VideoReview>> videoReviewDb = new HashMap();
	
	private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();
	private VideoReviewDaoImpl() {}
	
	public static VideoReviewDaoImpl getInstance() {
		return instance;
	}
	
	 
	@Override
	public int insertReview(VideoReview videoReview) {
		// TODO Auto-generated method stub
		int videoNo = videoReview.getvideoNo();
		videoReview.setReviewNo(reviewNo++);
		List<VideoReview> list = selectReview(videoNo);
		if(list == null) {
			list = new ArrayList<>();
		}
		list.add(videoReview);
		videoReviewDb.put(videoNo,list);
		return list.size();
	}

	@Override
	public List<VideoReview> selectReview(int videoNo) {
		if(videoReviewDb.get(videoNo)==null) {
			videoReviewDb.put(videoNo,new ArrayList<>());
		}
		return videoReviewDb.get(videoNo);
	
	}
	
}
