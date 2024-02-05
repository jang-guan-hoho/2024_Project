package pjt1.model.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import pjt1.model.Video;

public class VideoDaoImpl implements VideoDao {

	private List<Video> list;
	
	private VideoDaoImpl() {}
	private static VideoDaoImpl instance = new VideoDaoImpl();
	
	public static VideoDaoImpl getInstance() {
		return instance;
	}
	
	
	
	@Override
	public List<Video> selectVideo() throws IOException {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json"))) ) {

			StringBuilder sb = new StringBuilder(); 
			String str = null; 
			while( (str = br.readLine() ) != null ) { 
				sb.append(str);
			}
			Gson gson = new Gson();
			Video[] tmp = gson.fromJson(sb.toString(), Video[].class);
			list = Arrays.asList(tmp);
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Video selectVideoByNo(int No) {
		// TODO Auto-generated method stub
		int idx = -1;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNo() == No) {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
			System.out.println("입력하신 번호는 존재하지 않습니다.");
			return null;
		}
 		return list.get(idx);
	}
	
}
