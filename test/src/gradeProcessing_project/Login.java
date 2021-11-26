package gradeProcessing_project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class Login extends JFrame {
	
	private JPanel panel = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호");
	private JButton loginBtn = new JButton("로그인");
	private JButton loginListBtn = new JButton("가입목록");

	protected JTextField idText = new JTextField(); // 아이디
	protected JPasswordField pwText = new JPasswordField(); // 비밀번호
	protected JTextArea textArea;

	public Login() {
		setTitle("로그인");
		setSize(350, 350);
		
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
        loginListBtn.setLocation(200,200);
        getContentPane().add(loginListBtn);
		
		add(loginBtn);
		add(loginListBtn);
		
		loginRun();
		loginListRun();
		
		setResizable(false);
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
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력해주세요.", "아이디 또는 비밀번호를 입력해주세요.",
							JOptionPane.DEFAULT_OPTION);
					return;
				} else if (id.equals("test") && pw.equals("test1") || id.equals("abc") && pw.equals("abc1")) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인해주세요", JOptionPane.DEFAULT_OPTION);
					dispose(); // 주의! System.exit(0);으로 설정하면 프레임 창 뜨지 않음!
					new Index(); // Index 클래스 이동
					return;
				}
				JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인해주세요", JOptionPane.DEFAULT_OPTION);
			}
		});
	}

	// 회원목록 보여주는 로직
	public void loginListRun() {
		loginListBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserList();
			}
		});
	}

	public static void run() {
		new Login();
	}

	public static void main(String[] args) {
		run();
	}
}