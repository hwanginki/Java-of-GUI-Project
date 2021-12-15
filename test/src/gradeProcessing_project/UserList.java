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
import javax.swing.JScrollPane; // ��ũ�� �� Ŭ���� ����Ʈ �߰�
import javax.swing.JTable; // ���̺� �����ϴ� Ŭ���� ����Ʈ �߰�

// ���Ը�� Ŭ����
@SuppressWarnings("serial")
public class UserList extends JFrame {
	private JPanel panel = new JPanel();
	private JButton closeBtn = new JButton("�ݱ�");
	protected JTable table;
	protected String data[][]; // 2�� �迭 �ʱ�ȭ
	
	public UserList() {
		String[] fieldName = { "���̵�", "��й�ȣ" };
		
        data = new String[fieldName.length][fieldName.length]; // [2][2]
        String d0[] = { "test", "test1" };
        String d1[] = { "abc", "abc1" };
        data[0] = d0;
        data[1] = d1;
        
        table = new JTable(data, fieldName); // swing���� �����ϴ� ���̺� ����

        getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
        
		setTitle("ȸ�����");
		setSize(500, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.add(closeBtn); // �ݱ� ��ư �߰�
		add(panel);
		
		FlowLayout layout = new FlowLayout(); // ��ġ������(���̾ƿ�) ��ü ����
		setLayout(layout);
		
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // ���Ը�� â ����
			}
		});
		
		// �ΰ� �̹��� �߰�
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/a_logo.JPG");
		setIconImage(img);
		
		setResizable(false);
		setLocationRelativeTo(null);
        setVisible(true);
	}
}