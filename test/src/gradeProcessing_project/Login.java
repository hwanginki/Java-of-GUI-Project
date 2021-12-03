package gradeProcessing_project;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class Login extends JFrame {
	
	private JPanel panel = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호");
	private JButton loginBtn = new JButton("로그인");
	private JButton loginListBtn = new JButton("가입목록");

	private JTextField idText = new JTextField(); // 아이디
	private JPasswordField pwText = new JPasswordField(); // 비밀번호
	
	private JLabel gitHub = new JLabel("깃허브 주소(hwanginki)");
	private JButton gitHubBtn = new JButton("클릭");
	
	public Login() {
		setTitle("성적 처리 프로그램_로그인");
		setSize(350, 420);
		getContentPane().setLayout(null);
		
		idLabel.setSize(50, 30);
		idLabel.setLocation(20, 40);
		getContentPane().add(idLabel);

		idText.setSize(200, 30);
		idText.setLocation(80, 40);
		getContentPane().add(idText);
		
		pwLabel.setSize(50, 30);
		pwLabel.setLocation(20, 120);
		getContentPane().add(pwLabel);
		
		pwText.setSize(200, 30);
		pwText.setLocation(80, 120);
		getContentPane().add(pwText);
		
		loginBtn.setSize(100,40);
		loginBtn.setLocation(50,200);
        getContentPane().add(loginBtn);

        loginListBtn.setSize(100,40);
        loginListBtn.setLocation(180,200);
        getContentPane().add(loginListBtn);
		
		add(loginBtn);
		add(loginListBtn);
		
		loginRun();
		loginListRun();
		
		gitHub.setBounds(100, 230, 300, 100);
		gitHubBtn.setBounds(110, 300, 100, 30);

		// 깃허브 URI 링크 들어가는 버튼 로직
		gitHubBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop();

				URI uri = null;
				try {
					uri = new URI("https://github.com/hwanginki");
				} catch (URISyntaxException e2) {
					e2.printStackTrace();
				}
				try {
					desktop.browse(uri);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		add(gitHub);
		add(gitHubBtn);
		
		setResizable(false); // 창의 크기 확대(커서) 불가능하게 설정해줍니다.
		setLocationRelativeTo(null); // 화면 가운데 배치 사용합니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// 로그인 실행 로직
	public void loginRun() {
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 아이디 비번 확인 테스트 로직
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력해주세요.", "입력창", JOptionPane.DEFAULT_OPTION);
					return;
				} else if (id.equals("test") && pw.equals("test1") || id.equals("abc") && pw.equals("abc1")) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.DEFAULT_OPTION);
					dispose(); // 주의! System.exit(0);으로 설정하면 프레임 창 뜨지 않고 프로그램 종료 주의!
					new Index(); // Index 클래스 이동
					return;
				}
				JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.DEFAULT_OPTION);
			}
		});
	}

	// 회원목록 보여주는 버튼 로직
	public void loginListRun() {
		loginListBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserList();
			}
		});
	}
}