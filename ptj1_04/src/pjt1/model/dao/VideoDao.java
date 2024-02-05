package pjt1.model.dao;

import java.io.IOException;
import java.util.List;
import pjt1.model.dao.*;

import pjt1.model.Video;

public interface VideoDao {
	
	List<Video> selectVideo() throws IOException;
	
	Video selectVideoByNo(int no);
	
}
