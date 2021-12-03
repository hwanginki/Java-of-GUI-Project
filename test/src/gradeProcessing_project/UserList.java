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
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class UserList extends JFrame implements ActionListener {
	private JPanel panel = new JPanel();
	private JButton button = new JButton("닫기");
	protected JTable table;
	protected String data[][];
	
	public UserList() {
		String[] fieldName = { "아이디", "비밀번호" };
		
        data = new String[2][2];
        String d0[] = { "test", "test1" };
        String d1[] = { "abc", "abc1" };
        data[0] = d0;
        data[1] = d1;
        
        table = new JTable(data,fieldName);

        getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
        
		setTitle("회원목록");
		setSize(500, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.add(button);
		add(panel);
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		// 로고 이미지 변경
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/a_logo.JPG");
		setIconImage(img);
		
		setResizable(false);
		setLocationRelativeTo(null);
        setVisible(true);
	}
	
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("닫기")) { // 클릭 이벤트가 발생했을 때 일어나는 Button의 텍스트가 "확인"이면
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { }
	
	class MemberAddVO1 {
		private String id;
		private String pw;
		
		public MemberAddVO1(String id, String pw) {
			this.id = id;
			this.pw = pw;
		}
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getPw() {
			return pw;
		}
		
		public void setPw(String pw) {
			this.pw = pw;
		}
	}
}