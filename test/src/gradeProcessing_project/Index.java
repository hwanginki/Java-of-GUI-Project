package gradeProcessing_project;

import java.awt.Dimension; // �簢���� ���� ������ ���� ������ �� �ֵ��� �����ִ� Ŭ����
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; // �迭 ������ �÷��� �����ӿ�ũ �߿� �迭����Ʈ Ŭ����

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane; // Swing���� ������ �� Ŭ����
import javax.swing.JTable; // Swing���� ������ ���̺� Ŭ����
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import member.MemberVO; // ��Ű�� �߿� MemberVO Ŭ������ ����Ʈ

/**
 * @������Ʈ ������_2021.11.25 - ������_2021.12.03
 * @author HWNAG INKI
 * @see ������ȸ, �����Է� ��â
 * @�����ؾߵ� �� : ���� �߰� �� �հ�(12.03�Ϸ�), ���� �߰��� �� �ֵ��� ����(12.03�Ϸ�), ���� ��ȿ��(12.02�Ϸ�)
 * A+, A, -A �׷��� ���Ұ�(12.03�Ϸ�), ���̺��� ���� ���� ����(12.03�Ϸ�), ����� URI ��ư �߰�(12.02�Ϸ�)
 * ���̺� ũ�� ���� �߰�(12.02 �Ϸ�) ������ �̹��� ����(12.03�Ϸ�) �˾�â ������ �߰�(12.03�Ϸ�)
 * 
 */

// �����Է� �� Ŭ����
@SuppressWarnings("serial")
class JPanel_1 extends JPanel {
	private JLabel labelName;
	private JTextField tfName;
	private JLabel labelSubject;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cBox;
	private JLabel subjectScoreName;
	private JTextField subjectScore;
	private JButton btStore;
	private JButton btInit;
	// ���α׷��� ��� ���� �迭���� ��� �߰�
	private String[] subjectList = { "JAVA", "Python", "C", "C++", "C#", "JS" };
	
	// ���׸�(<>)�� MemberVO Ŭ���� Ÿ������ ArrayList �ʱ�ȭ �������ݴϴ�.
	ArrayList<MemberVO> al = new ArrayList<>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JPanel_1() {
		setLayout(null);
		
		// �̸�
		labelName = new JLabel("�� ��");
		labelName.setSize(180, 35);
		labelName.setLocation(90, 50);

		// �̸� �ؽ�Ʈ
		tfName = new JTextField(); // �̸� �Է� �κ�
		tfName.setBounds(150, 50, 200, 30); // ��ġ�� ������
		
		// ����
		labelSubject = new JLabel("�� ��");
		labelSubject.setBounds(90, 95, 90, 50);
		
		// ���� �޺��ڽ�
		cBox = new JComboBox(subjectList);
		cBox.setBounds(150, 105, 200, 30);
				
		// ���� �� �߰�
		subjectScoreName = new JLabel("�� ��");
		subjectScoreName.setBounds(90, 165, 100, 20);
		
		// ���� �ؽ�Ʈ �ʵ� �߰�
		subjectScore = new JTextField();
		subjectScore.setBounds(150, 160, 200, 30); // ��ġ�� ������
				
		// ���� ��ư
		btStore = new JButton("����");
		btStore.setBounds(130, 250, 100, 40);
		btStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				// �߰�, ���� �� ����ϱ� ���ؼ� DefaultTableModel Ŭ���� ��ü ���� 
				// ������ JTable���� ���� �߰�, ���� ����� ���� ������
				// DefaultTableModel Ŭ������ ���ֱ� ������ �����մϴ�.
				DefaultTableModel model = new DefaultTableModel();
				JTable table = new JTable(model); // Swing���� ������ Table ��ü ����
				model.fireTableDataChanged(); // ����� ���̺� �ݿ��մϴ�.
				
				String getTfName = tfName.getText().trim(); // �̸� �������� ȣ��
				String get_cBox = cBox.getSelectedItem().toString(); // ���� �������� ȣ��
				String getLabelSubject = subjectScore.getText().trim(); // ���� �������� ȣ��

				try {
					if (getTfName.equals("")) {
						JOptionPane.showMessageDialog(null, "���̵� �Է����ּ���.", "����â", JOptionPane.INFORMATION_MESSAGE);
					} else if (getLabelSubject.equals("")) {
						JOptionPane.showMessageDialog(null, "������ �Է����ּ���.", "����â", JOptionPane.INFORMATION_MESSAGE);
					} else if (Integer.parseInt(getLabelSubject) > 100) {
						JOptionPane.showMessageDialog(null, "������ 100�ڸ����ϱ��� �Է� �����մϴ�.", "����â", JOptionPane.INFORMATION_MESSAGE);
						subjectScore.setText("");
					} else {
						al = new ArrayList<MemberVO>(); // �������� ����
						// ArrayList�� add() ����Ͽ� �� ��� ���� 
						al.add(new MemberVO(getTfName, get_cBox, Integer.parseInt(getLabelSubject)));
						JOptionPane.showMessageDialog(null, "����Ǿ����", "����Ϸ�", JOptionPane.DEFAULT_OPTION);
						tfName.setText("");	subjectScore.setText("");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "���ڸ� �Է��Ͻø� �ȵ˴ϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
					subjectScore.setText("");
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "���� �߻��߽��ϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
			}
		});
		
		// �ʱ�ȭ ��ư
		btInit = new JButton("�ʱ�ȭ");
		btInit.setBounds(260, 250, 100, 40);
		btInit.addActionListener(new EventInit()); // ��ư ������ ���
		
		// �����̳��� ���� ������Ʈ �߰�
		add(labelName);
		add(tfName);
		add(labelSubject);
		add(cBox);
		add(subjectScoreName);
		add(subjectScore);
		add(btStore);
		add(btInit);
	}
	// �ʱ�ȭ ��ư �޼���
	class EventInit implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tfName.setText(""); // �̸� �ʱ�ȭ
			subjectScore.setText(""); // ���� �ʱ�ȭ
		}
	}
	// ���� ��ư �޼���
	class EventHandlerSave implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			model.fireTableDataChanged();
			
			String getTfName = tfName.getText(); // �̸� �� ��������
			String get_cBox = cBox.getSelectedItem().toString(); // ���� �� ��������
			// ��ȿ������ ���� Integer.valueOf() ����Ͽ�
			// String Ÿ������ ���ڿ��� int Ÿ�������� ��ȯ�մϴ�.
			int getLabelSubject = Integer.valueOf(subjectScore.getText()); //���� �� ��������
			
			ArrayList<MemberVO> al = new ArrayList<MemberVO>();
			al.add(new MemberVO(getTfName, get_cBox, getLabelSubject));
			JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.", "����Ϸ�", JOptionPane.DEFAULT_OPTION);

			tfName.setText("");
			subjectScore.setText("");
		}
	}
}
// ������ȸ �� Ŭ����
@SuppressWarnings("serial")
final class JPanel_2 extends JPanel {
	private JTable table; // ���̺� ����	
	private String data[][];
	private JButton btUpdate;
	private Label avgBtn; // ��� ��
	private JButton btDelete; // ���� ��ư
	private JButton btRepresh; // ���ΰ�ħ ��ư
    private JPanel tablePane;
    private JScrollPane scroll;
	JPanel_1 jpanel1; // Ŭ���� ����
	
	DefaultTableModel model;
	
	public JPanel_2() {
		jpanel1 = new JPanel_1();
		
		// �÷��� �����ӿ�ũ array�� ������ ArrayList �����մϴ�.
		ArrayList<MemberVO> members = new ArrayList<MemberVO>();
		members.add(new MemberVO("���뼺", "Python", 100));
		members.add(new MemberVO("������", "JAVA", 100));
		members.add(new MemberVO("Ȳ�α�", "C++", 100));
		
		String[] fieldName = {"�̸�", "����", "����", "���"};
		String[][] data = new String[members.size()][fieldName.length];
		
		for (int i = 0; i < members.size(); i++) {
			for (int j = 0; j < members.size(); j++) {
				data[i][0] = members.get(i).getName();
				data[i][1] = members.get(i).getSubjectName();
				data[i][2] = String.valueOf(members.get(i).getScore());
			}
		}
		
		// ��� �Ǻ� ����
		for (int i = 0; i < members.size(); i++) {
			int conScore = members.get(i).getScore();
				switch (conScore / 10) {
				case 10: data[i][3] = "A"; break; case 9: data[i][3] = "B"; break;
				case 8: data[i][3] = "C"; break; case 7: data[i][3] = "D"; break;
				default: data[i][3] = "F";
			}
		}
		
        model = new DefaultTableModel(data, fieldName);
        table = new JTable(model);
        table.setRowHeight(20); // Į��(��) ���� ����
        
        // ���̺� ũ�� �����մϴ�
        table.setPreferredScrollableViewportSize(new Dimension(420, 250));
        table.setFillsViewportHeight(true);
        
        // JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS �ӽ÷� �ּ�
        add(new JScrollPane(table));
        
        DefaultTableModel m = (DefaultTableModel) table.getModel();
        avgBtn = new Label("����� 100 �Դϴ�.");
        avgBtn.setPreferredSize(new Dimension(100, 50));
        add(avgBtn);
        
        btDelete = new JButton("����");
        btDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) throws ArithmeticException {
				int index = table.getSelectedRow();
		        if (index < 0) {
		        	JOptionPane.showMessageDialog(null, "������ ���� �������ּ���.", "���", JOptionPane.WARNING_MESSAGE);
		        } else {
		        	try {
		        		model.removeRow(index);
		        		
		        		int sum = 0;
		        		for (int i = 0; i < m.getRowCount(); i++) {
		        			String convert = String.valueOf(model.getValueAt(i, 2));
		        			sum += Integer.valueOf(convert);
		        		}
		        		avgBtn.setText("����� " + (sum / m.getRowCount()) + " �Դϴ�.");
					} catch (Exception ex) {
						avgBtn.setText("����� 0 �Դϴ�.");
						JOptionPane.showMessageDialog(null, "������ ���� �����ϴ�.", "����â", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
		        }
			}
		});
        btDelete.setPreferredSize(new Dimension(90, 28));
        add(btDelete);
        
		btRepresh = new JButton("���ΰ�ħ");
		btRepresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				try {
					String jpanel01 = jpanel1.al.get(0).getName();
					String jpanel02 = jpanel1.al.get(0).getSubjectName();
					int jpanel03 = jpanel1.al.get(0).getScore();
					String jpanel04 = null;

					// ��� �Ǻ� ����
					for (int i = 0; i < members.size(); i++) {
						switch (Integer.valueOf(jpanel03) / 10) {
						case 10: jpanel04 = "A"; break;	case 9:	jpanel04 = "B";	break;
						case 8:	jpanel04 = "C";	break;	case 7:	jpanel04 = "D";	break;
						default: jpanel04 = "F";
						}
					}

					int sum = 0; // ���� �հ� ����
					// Model���� ���̺� �������ִ� Ŭ���� �ҷ��ɴϴ�.
					DefaultTableModel m = (DefaultTableModel) table.getModel();
					// getRowCount() ����� ������ �߰��� �� �ֵ��� ����մϴ�.
					m.insertRow(m.getRowCount(), new Object[] { jpanel01, jpanel02, jpanel03, jpanel04 });
					table.updateUI();
					// �հ� �߰��Ѵ�.
					for (int i = 0; i < m.getRowCount(); i++) {
						String convert = String.valueOf(model.getValueAt(i, 2));
						sum += Integer.valueOf(convert);
					}
					// ��� ���Ѵ�.
					avgBtn.setText("����� " + (sum / m.getRowCount()) + " �Դϴ�.");
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "�����Է� ��, �ٽýõ��غ�����.", "���", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "�ٸ� ���� ������ �߻��߽��ϴ�.(�����ڿ��� �����غ�����)", "����", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
			}
		});
		avgBtn.setPreferredSize(new Dimension(150, 100));
		add(btRepresh);
	}
}

@SuppressWarnings("serial")
public class Index extends JFrame {
	public JPanel_2 jpanel02 = null;
	
	public Index() {
		setTitle("���� ó�� ���α׷�");
		jpanel02 = new JPanel_2();
		
		JTabbedPane jtab = new JTabbedPane(); // ��ü ����
		
		jtab.addTab("������ȸ", jpanel02);
		jtab.addTab("�����Է�", jpanel02.jpanel1);
		add(jtab);
		
		// �ΰ� �̹��� ����
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/a_logo.JPG");
		setIconImage(img);

		setResizable(false); // Ȯ�� Ŀ�� ���ϰ� �ϵ��� �����մϴ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null); // ȭ�� ��� ��ġ ����մϴ�.
		setVisible(true);
	}
}