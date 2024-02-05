package pjt1.ui;

import pjt1.util.SsafitUtil;
import pjt1.model.*;
import pjt1.model.dao.*;

public class MainUi {
	
	public void service() {
		while(true) {
			
			SsafitUtil.screenClear();
			SsafitUtil.printLine();
			System.out.println("Java로 구현하는 SSAFIT");
			SsafitUtil.printLine();
			SsafitUtil.printLine();	
			System.out.println("1. 영상정보");
			System.out.println("0. 종료");
			SsafitUtil.printLine();
			switch(SsafitUtil.inputint("메뉴를 선택하세요")) {
				
			case 1:
				VideoUi.getInstance().service();
				break;
			
			case 0:
				exit();
			
			default:
				SsafitUtil.printLine();
				System.out.println("잘못된 입력입니다.");
				SsafitUtil.printLine();
			}
		}
	}
	
	private void exit() {
		SsafitUtil.printLine();
		System.out.println("시스템을 종료합니다.");
		SsafitUtil.printLine();
		System.exit(0);
	}
}
