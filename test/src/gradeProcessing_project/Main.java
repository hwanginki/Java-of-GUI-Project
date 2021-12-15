package gradeProcessing_project;

import javax.swing.SwingUtilities; // Swing용 유틸리티 클래스 추가

public class Main {
	public static void main(String[] args) {
		// run() 메서드를 이벤트 디스패치스레드로 비동기적으로 실행시켜줍니다.
		SwingUtilities.invokeLater(new Runnable() { 
			@Override
			public void run() {
				new Login(); // 일회용 Login 클래스 객체 생성
			}
		});
	}
}