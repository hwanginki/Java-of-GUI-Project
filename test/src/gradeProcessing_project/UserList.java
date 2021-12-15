package gradeProcessing_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane; // 스크롤 바 클래스 임포트 추가
import javax.swing.JTable; // 테이블 구성하는 클래스 임포트 추가

// 가입목록 클래스
@SuppressWarnings("serial")
public class UserList extends JFrame {
	private JPanel panel = new JPanel();
	private JButton closeBtn = new JButton("닫기");
	protected JTable table;
	protected String data[][]; // 2차 배열 초기화
	
	public UserList() {
		String[] fieldName = { "아이디", "비밀번호" };
		
        data = new String[fieldName.length][fieldName.length]; // [2][2]
        String d0[] = { "test", "test1" };
        String d1[] = { "abc", "abc1" };
        data[0] = d0;
        data[1] = d1;
        
        table = new JTable(data, fieldName); // swing에서 지원하는 테이블 생성

        getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
        
		setTitle("회원목록");
		setSize(500, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.add(closeBtn); // 닫기 버튼 추가
		add(panel);
		
		FlowLayout layout = new FlowLayout(); // 배치관리자(레이아웃) 객체 생성
		setLayout(layout);
		
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 가입목록 창 종료
			}
		});
		
		// 로고 이미지 추가
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/a_logo.JPG");
		setIconImage(img);
		
		setResizable(false);
		setLocationRelativeTo(null);
        setVisible(true);
	}
}