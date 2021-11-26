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
	private JLabel idLabel = new JLabel("���̵�");
	private JLabel pwLabel = new JLabel("��й�ȣ");
	private JButton loginBtn = new JButton("�α���");
	private JButton loginListBtn = new JButton("���Ը��");

	protected JTextField idText = new JTextField(); // ���̵�
	protected JPasswordField pwText = new JPasswordField(); // ��й�ȣ
	protected JTextArea textArea;

	public Login() {
		setTitle("�α���");
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
		setLocationRelativeTo(null); // ȭ�� ��� ��ġ ����մϴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	// �α��� ���� ����
	public void loginRun() {
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���̵� ��� Ȯ�� �׽�Ʈ ����
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է����ּ���.", "���̵� �Ǵ� ��й�ȣ�� �Է����ּ���.",
							JOptionPane.DEFAULT_OPTION);
					return;
				} else if (id.equals("test") && pw.equals("test1") || id.equals("abc") && pw.equals("abc1")) {
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ�����ּ���", JOptionPane.DEFAULT_OPTION);
					dispose(); // ����! System.exit(0);���� �����ϸ� ������ â ���� ����!
					new Index(); // Index Ŭ���� �̵�
					return;
				}
				JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ�����ּ���", JOptionPane.DEFAULT_OPTION);
			}
		});
	}

	// ȸ����� �����ִ� ����
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