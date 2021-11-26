package gradeProcessing_project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import member.MemberVO;

class JPanel_1 extends JPanel {
	// Ŭ���� ��� �ʵ� ����
	private	JPanel panel1;
	private JLabel labelName;
	private JTextField tfName;
	private JButton btStore;
	private JButton btInit;
	private JLabel labelSubject;
	private JComboBox cBox;
	private JLabel subjectScoreName;
	private JTextField subjectScore;
	private String[] subjectList = {"JAVA", "Python", "C", "C++", "C#", "JS"};
	
	ArrayList<MemberVO> al;
	
	JPanel_1() {
		setLayout(null);
		// �� �߰�
		labelName = new JLabel("�� ��");
		labelName.setSize(180, 35); // setBounds�� �ƴϸ� setSzie�� setLocation�� �����ؾߵ˴ϴ�.
		labelName.setLocation(90, 50);

		// �ؽ�Ʈ �ʵ�
		tfName = new JTextField(); // �̸� �Է� �κ�
		tfName.setBounds(150, 50, 200, 30); // ��ġ�� ������
		
		// ���� ��ư
		btStore = new JButton("����");
		btStore.setBounds(130, 250, 100, 40);
		btStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = new DefaultTableModel();
				JTable table = new JTable(model);
				model.fireTableDataChanged();
				// �ؽ�Ʈ �ʵ尪 ��������
				String getTfName = tfName.getText(); // �̸�
				String get_cBox = cBox.getSelectedItem().toString(); // ����
				int getLabelSubject = Integer.valueOf(subjectScore.getText()); //����
				
				al = new ArrayList<MemberVO>();
				al.add(new MemberVO(getTfName, get_cBox, getLabelSubject));
				JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.", "����Ϸ�", JOptionPane.DEFAULT_OPTION);
	
				tfName.setText("");
				subjectScore.setText("");
			}
		});
				
		// �ʱ�ȭ ��ư
		btInit = new JButton("�ʱ�ȭ");
		btInit.setBounds(260, 250, 100, 40);
		btInit.addActionListener(new EventInit()); // ��ư ������ ���
		
		// ���� �� �߰�
		labelSubject = new JLabel("�� ��");
		labelSubject.setBounds(90, 95, 90, 50);
		
		// ���� �޺��ڽ� �߰�
		cBox = new JComboBox(subjectList);
		cBox.setBounds(150, 105, 200, 30);

		// ���� �� �߰�
		subjectScoreName = new JLabel("�� ��");
		subjectScoreName.setBounds(90, 165, 100, 20);
		
		// ���� �ؽ�Ʈ �ʵ� �߰�
		subjectScore = new JTextField();
		subjectScore.setBounds(150, 160, 200, 30); // ��ġ�� ������
		
		// �������� �����̳��� ���� ������Ʈ���� ���
		add(labelName);
		add(tfName);
		add(btStore);
		add(btInit);
		add(labelSubject);
		add(cBox);
		add(subjectScoreName);
		add(subjectScore);
	}
	
	// ���� ��ư �޼���
	class EventHandlerSave implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			model.fireTableDataChanged();
			// �ؽ�Ʈ �ʵ尪 ��������
			String getTfName = tfName.getText(); // �̸�
			String get_cBox = cBox.getSelectedItem().toString(); // ����
			// ��ȿ�� �ʿ�
			int getLabelSubject = Integer.valueOf(subjectScore.getText()); //����
			
			ArrayList<MemberVO> al = new ArrayList<MemberVO>();
			al.add(new MemberVO(getTfName, get_cBox, getLabelSubject));
			JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.", "����Ϸ�", JOptionPane.DEFAULT_OPTION);

			tfName.setText("");
			subjectScore.setText("");
		}
	}
	
	// �ʱ�ȭ ��ư �޼���
	class EventInit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tfName.setText(""); // �̸� �ʱ�ȭ
			subjectScore.setText(""); // ���� �ʱ�ȭ
		}
	}
}

class JPanel_2 extends JPanel {
	private JTable table;
	private String data[][];
	private JButton btStore;
	private JButton btRepresh;
	JPanel_1 jpanel1;
	
	 DefaultTableModel model;
	
	public JPanel_2() {
		jpanel1 = new JPanel_1();
		
		// �÷��� �����ӿ�ũ array�� ������ ArrayList �����մϴ�.
		ArrayList<MemberVO> members = new ArrayList<MemberVO>();
		members.add(new MemberVO("���뼺", "Python", 100));
		members.add(new MemberVO("������", "JAVA", 100));
		members.add(new MemberVO("Ȳ�α�", "C++", 100));
	
		String[] fieldName = {"�̸�", "����", "����"};
		
		String[][] data = new String[members.size()][members.size()];
		
		for (int i = 0; i < members.size(); i++) {
			for (int j = 0; j < members.size(); j++) {
				data[i][0] = members.get(i).getName();
				data[i][1] = members.get(i).getSubjectName();
				data[i][j] = String.valueOf(members.get(i).getScore());
			}
		}
        model = new DefaultTableModel(data, fieldName);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
		
		btRepresh = new JButton("���ΰ�ħ");
		btRepresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String jpanel01 = jpanel1.al.get(0).getName();
	            String jpanel02 = jpanel1.al.get(0).getSubjectName();
	            String jpanel03 = String.valueOf(jpanel1.al.get(0).getScore());
				
	            // Model���� ���̺� �������ִ� Ŭ���� �ҷ��ɴϴ�.
	            DefaultTableModel m = (DefaultTableModel)table.getModel();
	            m.insertRow(3, new Object[] {jpanel01,jpanel02,jpanel03});
	            table.updateUI();
	            	
				for (int i = 0; i < members.size(); i++) {
					for (int j = 0; j < members.size(); j++) {
						data[i][0] = members.get(i).getName();
						data[i][1] = members.get(i).getSubjectName();
						data[i][j] = String.valueOf(members.get(i).getScore());
					}
				}
			}
		});
		add(btRepresh);
	}
}

public class Index extends JFrame {
	public JPanel_2 jpanel02 = null;
	
	public Index() {
		setTitle("���� ó�� ���α׷�");
		jpanel02 = new JPanel_2();
		
		JTabbedPane jtab = new JTabbedPane(); // ��ü ����
		
		jtab.addTab("������ȸ", jpanel02);
		jtab.addTab("�����Է�", jpanel02.jpanel1);
		add(jtab);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null); // ȭ�� ��� ��ġ ����մϴ�.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Index();
	}
}