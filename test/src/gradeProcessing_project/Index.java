package gradeProcessing_project;

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

/**
 * @프로젝트 시작일_2021.11.25
 * @author HWNAG INKI
 * @see 성적조회, 성적입력 탭창
 * @수정해야될 것 : 성적 처리하는 데 필요한 계산기 구현,
 * 과목 추가 및 합계, 평점 추가할 수 있도록 구현, 점수 유효성(12.02완료)
 * A+, A, -A 그런식 평가할것, 테이블에서 한줄 수정 또는 삭제 구현, 깃허브 URI 버튼 추가(12.02완료)
 * 
 */
class JPanel_1 extends JPanel {
	// 클래스 멤버 필드 설정
	private	JPanel panel1;
	private JLabel labelName;
	private JTextField tfName;
	private JLabel labelSubject;
	private JComboBox cBox;
	private JLabel subjectScoreName;
	private JTextField subjectScore;
	private JButton btStore;
	private JButton btInit;
	private String[] subjectList = {"JAVA", "Python", "C", "C++", "C#", "JS"};
	
	ArrayList<MemberVO> al;
	
	JPanel_1() {
		setLayout(null);
		// 라벨 추가
		labelName = new JLabel("이 름");
		labelName.setSize(180, 35); // setBounds가 아니면 setSzie와 setLocation을 동시해야됩니다.
		labelName.setLocation(90, 50);

		// 텍스트 필드
		tfName = new JTextField(); // 이름 입력 부분
		tfName.setBounds(150, 50, 200, 30); // 위치와 사이즈
		
		// 과목 라벨 추가
		labelSubject = new JLabel("과 목");
		labelSubject.setBounds(90, 95, 90, 50);
		
		// 과목 콤보박스 추가
		cBox = new JComboBox(subjectList);
		cBox.setBounds(150, 105, 200, 30);
				
		// 점수 라벨 추가
		subjectScoreName = new JLabel("점 수");
		subjectScoreName.setBounds(90, 165, 100, 20);
		
		// 점수 텍스트 필드 추가
		subjectScore = new JTextField();
		subjectScore.setBounds(150, 160, 200, 30); // 위치와 사이즈
				
		// 저장 버튼
		btStore = new JButton("저장");
		btStore.setBounds(130, 250, 100, 40);
		btStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				DefaultTableModel model = new DefaultTableModel();
				JTable table = new JTable(model);
				model.fireTableDataChanged();
				
				// 텍스트 필드값 가져오기
				String getTfName = tfName.getText(); // 이름
				String get_cBox = cBox.getSelectedItem().toString(); // 과목
				String getLabelSubject = subjectScore.getText(); //성적

				// 12.02 이름, 점수 유효성 검증 추가 완료
				try {
					if (getTfName.toString().length() == 0) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "에러창", JOptionPane.DEFAULT_OPTION);
					} else if (getLabelSubject.toString().length() == 0) {
						JOptionPane.showMessageDialog(null, "점수를 입력해주세요.", "에러창", JOptionPane.DEFAULT_OPTION);
					} else if (Integer.parseInt(getLabelSubject) > 100) {
						JOptionPane.showMessageDialog(null, "점수는 100자리이하 받을 수 있습니다.", "에러창", JOptionPane.DEFAULT_OPTION);
						subjectScore.setText("");
					} else {
						al = new ArrayList<MemberVO>();
						al.add(new MemberVO(getTfName, get_cBox, Integer.parseInt(getLabelSubject)));
						JOptionPane.showMessageDialog(null, "저장되었어요", "저장완료", JOptionPane.DEFAULT_OPTION);
						tfName.setText("");	subjectScore.setText("");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "문자를 입력하시면 안됩니다.", "에러창", JOptionPane.DEFAULT_OPTION);
					tfName.setText("");	subjectScore.setText("");
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "예외 발생했습니다.", "에러창", JOptionPane.DEFAULT_OPTION);
					e2.printStackTrace();
				}
			}
		});
				
		// 초기화 버튼
		btInit = new JButton("초기화");
		btInit.setBounds(260, 250, 100, 40);
		btInit.addActionListener(new EventInit()); // 버튼 리스너 등록
		
		// 프레임의 컨테이너의 각종 컴포넌트들을 등록
		add(labelName);
		add(tfName);
		add(btStore);
		add(btInit);
		add(labelSubject);
		add(cBox);
		add(subjectScoreName);
		add(subjectScore);
	}
	
	// 저장 버튼 메서드
	class EventHandlerSave implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			model.fireTableDataChanged();
			// 텍스트 필드값 가져오기
			String getTfName = tfName.getText(); // 이름
			String get_cBox = cBox.getSelectedItem().toString(); // 과목
			// 유효성 필요
			int getLabelSubject = Integer.valueOf(subjectScore.getText()); //성적
			
			ArrayList<MemberVO> al = new ArrayList<MemberVO>();
			al.add(new MemberVO(getTfName, get_cBox, getLabelSubject));
			JOptionPane.showMessageDialog(null, "저장되었습니다.", "저장완료", JOptionPane.DEFAULT_OPTION);

			tfName.setText("");
			subjectScore.setText("");
		}
	}
	
	// 초기화 버튼 메서드
	class EventInit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tfName.setText(""); // 이름 초기화
			subjectScore.setText(""); // 점수 초기화
		}
	}
}

final class JPanel_2 extends JPanel {
	private JTable table;
	private String data[][];
	private JButton btStore;
	private JButton btRepresh;
	JPanel_1 jpanel1;
	
	DefaultTableModel model;
	
	public JPanel_2() {
		jpanel1 = new JPanel_1();
		
		// 컬렉션 프레임워크 array업 버전의 ArrayList 선언합니다.
		ArrayList<MemberVO> members = new ArrayList<MemberVO>();
		members.add(new MemberVO("조용성", "Python", 100));
		members.add(new MemberVO("김재현", "JAVA", 100));
		members.add(new MemberVO("황인기", "C++", 100));
		
		String[] fieldName = {"이름", "과목", "성적"};
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
       
        table.setRowHeight(20); // 칼럼(셀) 높이 설정
        
        add(new JScrollPane(table));
        
		btRepresh = new JButton("새로고침");

		btRepresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String jpanel01 = jpanel1.al.get(0).getName();
	            String jpanel02 = jpanel1.al.get(0).getSubjectName();
	            String jpanel03 = String.valueOf(jpanel1.al.get(0).getScore());
	            
	            // Model관련 테이블 관리해주는 클래스 불러옵니다.
	            DefaultTableModel m = (DefaultTableModel) table.getModel();
	            // getRowCount() 사용해 밑으로 추가할 수 있도록 출력
	            m.insertRow(m.getRowCount(), new Object[] { jpanel01, jpanel02, jpanel03 });
	            table.updateUI();
			}
		});
		add(btRepresh);
	}
}

public class Index extends JFrame {
	public JPanel_2 jpanel02 = null;
	
	public Index() {
		setTitle("성적 처리 프로그램");
		jpanel02 = new JPanel_2();
		
		JTabbedPane jtab = new JTabbedPane(); // 객체 생성
		
		jtab.addTab("성적조회", jpanel02);
		jtab.addTab("성적입력", jpanel02.jpanel1);
		add(jtab);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null); // 화면 가운데 배치 사용합니다.
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Index();
	}
}