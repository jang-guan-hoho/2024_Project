package pjt1.ui;

import java.util.List;

import pjt1.model.VideoReview;
import pjt1.model.dao.VideoReviewDaoImpl;
import pjt1.util.SsafitUtil;

public class VideoReviewUi {
	private VideoReviewUi videoReviewUi;
	private static VideoReviewUi instance;
	private int videoNo;
	
	private VideoReviewUi(int videoNo) {
		this.videoNo=videoNo;
	}
	
	public static VideoReviewUi getInstance(int videoNo) {
		if(instance == null)
			instance = new VideoReviewUi(videoNo);
		return instance;
	}
	public void service() {
		while(true){
			SsafitUtil.screenClear();
			listReview();
			System.out.println("1. 리뷰등록");
			System.out.println("0. 이전으로");
			SsafitUtil.printLine();
			int t=SsafitUtil.inputint("메뉴를 선택하세요");
			switch(t) {
			case 1:
				registReview();
				break;
			case 0:
				return;
			default:
				System.out.println("오류!");
			}
		}
	}
	private void listReview() {
		SsafitUtil.printLine();
		List<VideoReview> list = VideoReviewDaoImpl.getInstance().selectReview(videoNo);
		System.out.printf("영상리뷰 : %d개",list.size());
		System.out.println();
		SsafitUtil.printLine();
		list.stream().forEach(
				v -> System.out.printf("%2d %s %s \n", v.getReviewNo(), v.getNickName(), v.getContent())
		);
		SsafitUtil.printLine();
		
	}
	private void registReview() {
		VideoReview r = new VideoReview();
		r.setvideoNo(videoNo);
		r.setNickName(SsafitUtil.input("닉네임을 입력하세요"));
		r.setContent(SsafitUtil.input("내용을 입력하세요"));
		VideoReviewDaoImpl.getInstance().insertReview(r);
	}
}
