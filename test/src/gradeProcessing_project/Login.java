package gradeProcessing_project;

import java.awt.Desktop; // URL �������� �����ϴ� Ŭ���� ����Ʈ �߰�
import java.awt.Image; // �̹��� Ŭ���� ����Ʈ �߰�
import java.awt.Toolkit; // �ΰ� �̹��� �ٲ�� Ŭ���� ����Ʈ �߰� 
import java.awt.event.ActionEvent; // �̺�Ʈ(����) Ŭ���� ����Ʈ �߰�
import java.awt.event.ActionListener; // �׼Ǹ����ͳ� Ŭ���� ����Ʈ �߰�
import java.io.IOException; // ����ó�� Ŭ���� ����Ʈ �߰�
import java.net.URI; // URI ���� Ŭ���� ����Ʈ �߰�
import java.net.URISyntaxException; // URI ���� ���������� ����ó�� Ŭ���� ����Ʈ �߰�

import javax.swing.JButton; // swing�� ��ư Ŭ���� ����Ʈ �߰� 
import javax.swing.JFrame; // ���� ������(������ â) Ŭ���� ����Ʈ �߰�
import javax.swing.JLabel; // �� Ŭ���� ����Ʈ �߰�
import javax.swing.JOptionPane; // ��ȭ����(�˾�â, ���̾�α�) Ŭ���� ����Ʈ �߰�
import javax.swing.JPasswordField; // ��й�ȣ Ŭ���� ����Ʈ �߰�
import javax.swing.JTextField; // �ؽ�Ʈ�ʵ� Ŭ���� ����Ʈ �߰�

// �α��� ���� â Ŭ����
@SuppressWarnings("serial") // ��� ��(�����)�� ���ִ� ������̼� �߰�
class Login extends JFrame { // �α��� ����â
	
	private JLabel idLabel = new JLabel("���̵�");
	private JLabel pwLabel = new JLabel("��й�ȣ");
	private JButton loginBtn = new JButton("�α���");
	private JButton loginListBtn = new JButton("���Ը��");

	private JTextField idText = new JTextField(); // ���̵��ʵ�
	private JPasswordField pwText = new JPasswordField(); // ��й�ȣ�ʵ�
	
	private JLabel gitHub = new JLabel("����� �ּ�(hwanginki)");
	private JButton gitHubBtn = new JButton("Ŭ��");
	
	public Login() { // Login ������ ���
		
		setTitle("���� ó�� ���α׷�_�α���"); // ����
		setSize(350, 420); // ����, ���� ������ ����
		
		// ��ӹ��� Ŭ�������� add, setLayout ���� ����Ϸ��� getContentPane() �߰��ϰ�
		// setLayout(null)�� null �ָ� �ڵ����� ������ �ƴ� ���������� ��ġ�� ���� ��ġ�մϴ�.
		getContentPane().setLayout(null);
		
		// ���̵� ��
		idLabel.setSize(50, 30);
		idLabel.setLocation(20, 40);
		getContentPane().add(idLabel); // �߰�
		// ���̵� �ؽ�Ʈ�ʵ�
		idText.setSize(200, 30);
		idText.setLocation(80, 40);
		getContentPane().add(idText);
		// ��й�ȣ ��
		pwLabel.setSize(50, 30);
		pwLabel.setLocation(20, 120);
		getContentPane().add(pwLabel);
		// ��й�ȣ �ؽ�Ʈ�ʵ�
		pwText.setSize(200, 30);
		pwText.setLocation(80, 120);
		getContentPane().add(pwText);
		// �α��� ��ư
		loginBtn.setSize(100,40);
		loginBtn.setLocation(50,200);
        getContentPane().add(loginBtn);
        // ���Ը�� ��ư
        loginListBtn.setSize(100,40);
        loginListBtn.setLocation(180,200);
        getContentPane().add(loginListBtn);
		
		add(loginBtn);
		add(loginListBtn);
		
		loginRun(); // �α��� ������ loginRun() �޼��� ȣ��
		loginListRun(); // ���Ը�� ��ư ������ loginListRun() �޼��� ȣ��
		// ����� ��ư setSize, setLocation ��� setBounds �޼��� ���
		gitHub.setBounds(100, 230, 300, 100); // ����, ����, x, y ��ġ
		gitHubBtn.setBounds(110, 300, 100, 30);

		// ����� ��ư �̺�Ʈ �޼���
		gitHubBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop desktop = Desktop.getDesktop(); // 
				URI uri = null; // �ݵ�� null ����
				
				try {
					// URI Ŭ�������� ���ܹ߻��� �� �ֱ� ������ try catch�� �־�� �˴ϴ�.
					uri = new URI("https://github.com/hwanginki"); // URI ��ü����
				} catch (URISyntaxException e2) {
					e2.printStackTrace();
				}
				
				try {
					desktop.browse(uri); // uri ��ü�� ������ �޼��� ���� 
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		add(gitHub);
		add(gitHubBtn);
		
		// �ΰ� �̹��� ����
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/a_logo.JPG");
		setIconImage(img);
		
		setResizable(false); // â ũ�� ����
		setLocationRelativeTo(null); // â ��� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// ȸ�����  �޼��� ����
	public void loginListRun() {
		loginListBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserList();
			}
		});
	}

	// �α��� �޼��� ����
	public void loginRun() {
		loginBtn.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();

				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է����ּ���.", "�Է�â", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else if (id.equals("test") && pw.equals("test1") || id.equals("abc") && pw.equals("abc1")) {
					JOptionPane.showMessageDialog(null, "�α��� ����", "�α���", JOptionPane.PLAIN_MESSAGE);
					dispose(); // ���� ������ â ����
					new Index(); // Index Ŭ���� �̵�
					return;
				}
				JOptionPane.showMessageDialog(null, "�α��� ����", "�α���", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

}