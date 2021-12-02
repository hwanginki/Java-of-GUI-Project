package gradeProcessing_project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserList extends JFrame implements ActionListener {
	private JPanel panel = new JPanel();
	private JButton button = new JButton("�ݱ�");
	private JLabel label = new JLabel("ȸ�����");
	protected JTable table;
	protected String data[][];
	
	public UserList() {
		ArrayList<MemberAddVO1> mb = new ArrayList<MemberAddVO1>();
		mb.add(new MemberAddVO1("a", "b"));
		
		String[] fieldName = { "���̵�", "��й�ȣ" };
		
        data = new String[2][2];
        String d0[] = { "test", "test1" };
        String d1[] = { "abc", "abc1" };
        data[0] = d0;
        data[1] = d1;
        
        table = new JTable(data,fieldName);

        getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
        
		setTitle("ȸ�����");
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
		setLocationRelativeTo(null);
        setVisible(true);
	}
	
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("�ݱ�")) { // Ŭ�� �̺�Ʈ�� �߻����� �� �Ͼ�� Button�� �ؽ�Ʈ�� "Ȯ��"�̸�
			}
		}
	}
	
	public static void main(String[] args) {
        new UserList();
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