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
	private JLabel idLabel = new JLabel("���̵�");
	private JLabel pwLabel = new JLabel("��й�ȣ");
	private JButton loginBtn = new JButton("�α���");
	private JButton loginListBtn = new JButton("���Ը��");

	private JTextField idText = new JTextField(); // ���̵�
	private JPasswordField pwText = new JPasswordField(); // ��й�ȣ
	
	private JLabel gitHub = new JLabel("����� �ּ�(hwanginki)");
	private JButton gitHubBtn = new JButton("Ŭ��");
	
	public Login() {
		setTitle("���� ó�� ���α׷�_�α���");
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

		// ����� URI ��ũ ���� ��ư ����
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
		
		setResizable(false); // â�� ũ�� Ȯ��(Ŀ��) �Ұ����ϰ� �������ݴϴ�.
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
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է����ּ���.", "�Է�â", JOptionPane.DEFAULT_OPTION);
					return;
				} else if (id.equals("test") && pw.equals("test1") || id.equals("abc") && pw.equals("abc1")) {
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α���", JOptionPane.DEFAULT_OPTION);
					dispose(); // ����! System.exit(0);���� �����ϸ� ������ â ���� �ʰ� ���α׷� ���� ����!
					new Index(); // Index Ŭ���� �̵�
					return;
				}
				JOptionPane.showMessageDialog(null, "�α��� ����", "�α���", JOptionPane.DEFAULT_OPTION);
			}
		});
	}

	// ȸ����� �����ִ� ��ư ����
	public void loginListRun() {
		loginListBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserList();
			}
		});
	}
}