package gradeProcessing_project;

import java.awt.Desktop; // URL 브라우저로 실행하는 클래스 임포트 추가
import java.awt.Image; // 이미지 클래스 임포트 추가
import java.awt.Toolkit; // 로고 이미지 바뀌는 클래스 임포트 추가 
import java.awt.event.ActionEvent; // 이벤트(반응) 클래스 임포트 추가
import java.awt.event.ActionListener; // 액션리스터너 클래스 임포트 추가
import java.io.IOException; // 예외처리 클래스 임포트 추가
import java.net.URI; // URI 관련 클래스 임포트 추가
import java.net.URISyntaxException; // URI 구문 에러방지용 예외처리 클래스 임포트 추가

import javax.swing.JButton; // swing용 버튼 클래스 임포트 추가 
import javax.swing.JFrame; // 메인 프레임(윈도우 창) 클래스 임포트 추가
import javax.swing.JLabel; // 라벨 클래스 임포트 추가
import javax.swing.JOptionPane; // 대화상자(팝업창, 다이얼로그) 클래스 임포트 추가
import javax.swing.JPasswordField; // 비밀번호 클래스 임포트 추가
import javax.swing.JTextField; // 텍스트필드 클래스 임포트 추가

// 로그인 메인 창 클래스
@SuppressWarnings("serial") // 노란 줄(경고줄)을 없애는 어노테이션 추가
class Login extends JFrame { // 로그인 메인창
	
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호");
	private JButton loginBtn = new JButton("로그인");
	private JButton loginListBtn = new JButton("가입목록");

	private JTextField idText = new JTextField(); // 아이디필드
	private JPasswordField pwText = new JPasswordField(); // 비밀번호필드
	
	private JLabel gitHub = new JLabel("깃허브 주소(hwanginki)");
	private JButton gitHubBtn = new JButton("클릭");
	
	public Login() { // Login 생성자 사용
		
		setTitle("성적 처리 프로그램_로그인"); // 제목
		setSize(350, 420); // 가로, 세로 사이즈 조절
		
		// 상속받은 클래스에서 add, setLayout 등을 사용하려면 getContentPane() 추가하고
		// setLayout(null)은 null 주면 자동적인 정렬이 아닌 수동적으로 위치에 따라 배치합니다.
		getContentPane().setLayout(null);
		
		// 아이디 라벨
		idLabel.setSize(50, 30);
		idLabel.setLocation(20, 40);
		getContentPane().add(idLabel); // 추가
		// 아이디 텍스트필드
		idText.setSize(200, 30);
		idText.setLocation(80, 40);
		getContentPane().add(idText);
		// 비밀번호 라벨
		pwLabel.setSize(50, 30);
		pwLabel.setLocation(20, 120);
		getContentPane().add(pwLabel);
		// 비밀번호 텍스트필드
		pwText.setSize(200, 30);
		pwText.setLocation(80, 120);
		getContentPane().add(pwText);
		// 로그인 버튼
		loginBtn.setSize(100,40);
		loginBtn.setLocation(50,200);
        getContentPane().add(loginBtn);
        // 가입목록 버튼
        loginListBtn.setSize(100,40);
        loginListBtn.setLocation(180,200);
        getContentPane().add(loginListBtn);
		
		add(loginBtn);
		add(loginListBtn);
		
		loginRun(); // 로그인 누르면 loginRun() 메서드 호출
		loginListRun(); // 가입목록 버튼 누르면 loginListRun() 메서드 호출
		// 깃허브 버튼 setSize, setLocation 대신 setBounds 메서드 사용
		gitHub.setBounds(100, 230, 300, 100); // 가로, 세로, x, y 위치
		gitHubBtn.setBounds(110, 300, 100, 30);

		// 깃허브 버튼 이벤트 메서드
		gitHubBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop(); // 
				URI uri = null; // 반드시 null 선언
				
				try {
					// URI 클래스에서 예외발생이 들어가 있기 때문에 try catch문 넣어야 됩니다.
					uri = new URI("https://github.com/hwanginki"); // URI 객체생성
				} catch (URISyntaxException e2) {
					e2.printStackTrace();
				}
				
				try {
					desktop.browse(uri); // uri 객체로 브라우져 메서드 실행 
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		add(gitHub);
		add(gitHubBtn);
		
		// 로고 이미지 변경
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/a_logo.JPG");
		setIconImage(img);
		
		setResizable(false); // 창 크기 고정
		setLocationRelativeTo(null); // 창 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// 회원목록  메서드 실행
	public void loginListRun() {
		loginListBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserList();
			}
		});
	}

	// 로그인 메서드 실행
	public void loginRun() {
		loginBtn.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력해주세요.", "입력창", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else if (id.equals("test") && pw.equals("test1") || id.equals("abc") && pw.equals("abc1")) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.PLAIN_MESSAGE);
					dispose(); // 메인 프레임 창 종료
					new Index(); // Index 클래스 이동
					return;
				}
				JOptionPane.showMessageDialog(null, "로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

}