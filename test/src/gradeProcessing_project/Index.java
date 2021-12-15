package gradeProcessing_project;

import java.awt.Dimension; // 사각형과 폭과 높이의 값을 관리할 수 있도록 도와주는 클래스
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList; // 배열 버전된 컬렉션 프레임워크 중에 배열리스트 클래스

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane; // Swing에서 제공한 탭 클래스
import javax.swing.JTable; // Swing에서 제공한 테이블 클래스
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import member.MemberVO; // 패키지 중에 MemberVO 클래스를 임포트

/**
 * @프로젝트 시작일_2021.11.25 - 종료일_2021.12.03
 * @author HWNAG INKI
 * @see 성적조회, 성적입력 탭창
 * @수정해야될 것 : 과목 추가 및 합계(12.03완료), 평점 추가할 수 있도록 구현(12.03완료), 점수 유효성(12.02완료)
 * A+, A, -A 그런식 평가할것(12.03완료), 테이블에서 한줄 삭제 구현(12.03완료), 깃허브 URI 버튼 추가(12.02완료)
 * 테이블 크기 조정 추가(12.02 완료) 아이콘 이미지 구현(12.03완료) 팝업창 아이콘 추가(12.03완료)
 * 
 */

// 성적입력 탭 클래스
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
	// 프로그래밍 언어 과목 배열으로 요소 추가
	private String[] subjectList = { "JAVA", "Python", "C", "C++", "C#", "JS" };
	
	// 제네릭(<>)에 MemberVO 클래스 타입으로 ArrayList 초기화 선언해줍니다.
	ArrayList<MemberVO> al = new ArrayList<>();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JPanel_1() {
		setLayout(null);
		
		// 이름
		labelName = new JLabel("이 름");
		labelName.setSize(180, 35);
		labelName.setLocation(90, 50);

		// 이름 텍스트
		tfName = new JTextField(); // 이름 입력 부분
		tfName.setBounds(150, 50, 200, 30); // 위치와 사이즈
		
		// 과목
		labelSubject = new JLabel("과 목");
		labelSubject.setBounds(90, 95, 90, 50);
		
		// 과목 콤보박스
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
				// 추가, 삭제 등 사용하기 위해서 DefaultTableModel 클래스 객체 생성 
				// 이유는 JTable에서 원래 추가, 삭제 기능이 없기 떄문에
				// DefaultTableModel 클래스가 해주기 때문에 생성합니다.
				DefaultTableModel model = new DefaultTableModel();
				JTable table = new JTable(model); // Swing에서 제공한 Table 객체 생성
				model.fireTableDataChanged(); // 선언된 테이블 반영합니다.
				
				String getTfName = tfName.getText().trim(); // 이름 가져오는 호출
				String get_cBox = cBox.getSelectedItem().toString(); // 과목 가져오는 호출
				String getLabelSubject = subjectScore.getText().trim(); // 점수 가져오는 호출

				try {
					if (getTfName.equals("")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "에러창", JOptionPane.INFORMATION_MESSAGE);
					} else if (getLabelSubject.equals("")) {
						JOptionPane.showMessageDialog(null, "점수를 입력해주세요.", "에러창", JOptionPane.INFORMATION_MESSAGE);
					} else if (Integer.parseInt(getLabelSubject) > 100) {
						JOptionPane.showMessageDialog(null, "점수는 100자리이하까지 입력 가능합니다.", "에러창", JOptionPane.INFORMATION_MESSAGE);
						subjectScore.setText("");
					} else {
						al = new ArrayList<MemberVO>(); // 전역변수 선언
						// ArrayList의 add() 사용하여 값 요소 저장 
						al.add(new MemberVO(getTfName, get_cBox, Integer.parseInt(getLabelSubject)));
						JOptionPane.showMessageDialog(null, "저장되었어요", "저장완료", JOptionPane.DEFAULT_OPTION);
						tfName.setText("");	subjectScore.setText("");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "문자를 입력하시면 안됩니다.", "에러창", JOptionPane.ERROR_MESSAGE);
					subjectScore.setText("");
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "예외 발생했습니다.", "에러창", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
			}
		});
		
		// 초기화 버튼
		btInit = new JButton("초기화");
		btInit.setBounds(260, 250, 100, 40);
		btInit.addActionListener(new EventInit()); // 버튼 리스너 등록
		
		// 컨테이너의 각종 컴포넌트 추가
		add(labelName);
		add(tfName);
		add(labelSubject);
		add(cBox);
		add(subjectScoreName);
		add(subjectScore);
		add(btStore);
		add(btInit);
	}
	// 초기화 버튼 메서드
	class EventInit implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tfName.setText(""); // 이름 초기화
			subjectScore.setText(""); // 점수 초기화
		}
	}
	// 저장 버튼 메서드
	class EventHandlerSave implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable(model);
			model.fireTableDataChanged();
			
			String getTfName = tfName.getText(); // 이름 값 가져오기
			String get_cBox = cBox.getSelectedItem().toString(); // 과목 값 가져오기
			// 유효성으로 인해 Integer.valueOf() 사용하여
			// String 타입형인 문자열을 int 타입형으로 변환합니다.
			int getLabelSubject = Integer.valueOf(subjectScore.getText()); //성적 값 가져오기
			
			ArrayList<MemberVO> al = new ArrayList<MemberVO>();
			al.add(new MemberVO(getTfName, get_cBox, getLabelSubject));
			JOptionPane.showMessageDialog(null, "저장되었습니다.", "저장완료", JOptionPane.DEFAULT_OPTION);

			tfName.setText("");
			subjectScore.setText("");
		}
	}
}
// 성적조회 탭 클래스
@SuppressWarnings("serial")
final class JPanel_2 extends JPanel {
	private JTable table; // 테이블 선언	
	private String data[][];
	private JButton btUpdate;
	private Label avgBtn; // 평균 라벨
	private JButton btDelete; // 삭제 버튼
	private JButton btRepresh; // 새로고침 버튼
    private JPanel tablePane;
    private JScrollPane scroll;
	JPanel_1 jpanel1; // 클래스 생성
	
	DefaultTableModel model;
	
	public JPanel_2() {
		jpanel1 = new JPanel_1();
		
		// 컬렉션 프레임워크 array업 버전의 ArrayList 선언합니다.
		ArrayList<MemberVO> members = new ArrayList<MemberVO>();
		members.add(new MemberVO("조용성", "Python", 100));
		members.add(new MemberVO("김재현", "JAVA", 100));
		members.add(new MemberVO("황인기", "C++", 100));
		
		String[] fieldName = {"이름", "과목", "성적", "등급"};
		String[][] data = new String[members.size()][fieldName.length];
		
		for (int i = 0; i < members.size(); i++) {
			for (int j = 0; j < members.size(); j++) {
				data[i][0] = members.get(i).getName();
				data[i][1] = members.get(i).getSubjectName();
				data[i][2] = String.valueOf(members.get(i).getScore());
			}
		}
		
		// 등급 판별 로직
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
        table.setRowHeight(20); // 칼럼(셀) 높이 설정
        
        // 테이블 크기 조절합니다
        table.setPreferredScrollableViewportSize(new Dimension(420, 250));
        table.setFillsViewportHeight(true);
        
        // JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS 임시로 주석
        add(new JScrollPane(table));
        
        DefaultTableModel m = (DefaultTableModel) table.getModel();
        avgBtn = new Label("평균은 100 입니다.");
        avgBtn.setPreferredSize(new Dimension(100, 50));
        add(avgBtn);
        
        btDelete = new JButton("삭제");
        btDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) throws ArithmeticException {
				int index = table.getSelectedRow();
		        if (index < 0) {
		        	JOptionPane.showMessageDialog(null, "삭제할 행을 선택해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
		        } else {
		        	try {
		        		model.removeRow(index);
		        		
		        		int sum = 0;
		        		for (int i = 0; i < m.getRowCount(); i++) {
		        			String convert = String.valueOf(model.getValueAt(i, 2));
		        			sum += Integer.valueOf(convert);
		        		}
		        		avgBtn.setText("평균은 " + (sum / m.getRowCount()) + " 입니다.");
					} catch (Exception ex) {
						avgBtn.setText("평균은 0 입니다.");
						JOptionPane.showMessageDialog(null, "삭제할 행이 없습니다.", "에러창", JOptionPane.ERROR_MESSAGE);
						ex.printStackTrace();
					}
		        }
			}
		});
        btDelete.setPreferredSize(new Dimension(90, 28));
        add(btDelete);
        
		btRepresh = new JButton("새로고침");
		btRepresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				try {
					String jpanel01 = jpanel1.al.get(0).getName();
					String jpanel02 = jpanel1.al.get(0).getSubjectName();
					int jpanel03 = jpanel1.al.get(0).getScore();
					String jpanel04 = null;

					// 등급 판별 로직
					for (int i = 0; i < members.size(); i++) {
						switch (Integer.valueOf(jpanel03) / 10) {
						case 10: jpanel04 = "A"; break;	case 9:	jpanel04 = "B";	break;
						case 8:	jpanel04 = "C";	break;	case 7:	jpanel04 = "D";	break;
						default: jpanel04 = "F";
						}
					}

					int sum = 0; // 점수 합계 변수
					// Model관련 테이블 관리해주는 클래스 불러옵니다.
					DefaultTableModel m = (DefaultTableModel) table.getModel();
					// getRowCount() 사용해 밑으로 추가할 수 있도록 출력합니다.
					m.insertRow(m.getRowCount(), new Object[] { jpanel01, jpanel02, jpanel03, jpanel04 });
					table.updateUI();
					// 합계 추가한다.
					for (int i = 0; i < m.getRowCount(); i++) {
						String convert = String.valueOf(model.getValueAt(i, 2));
						sum += Integer.valueOf(convert);
					}
					// 평균 구한다.
					avgBtn.setText("평균은 " + (sum / m.getRowCount()) + " 입니다.");
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "성적입력 후, 다시시도해보세요.", "경고", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "다른 예외 문제가 발생했습니다.(관리자에게 문의해보세요)", "에러", JOptionPane.ERROR_MESSAGE);
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
		setTitle("성적 처리 프로그램");
		jpanel02 = new JPanel_2();
		
		JTabbedPane jtab = new JTabbedPane(); // 객체 생성
		
		jtab.addTab("성적조회", jpanel02);
		jtab.addTab("성적입력", jpanel02.jpanel1);
		add(jtab);
		
		// 로고 이미지 변경
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("src/img/a_logo.JPG");
		setIconImage(img);

		setResizable(false); // 확대 커서 못하게 하도록 설정합니다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setLocationRelativeTo(null); // 화면 가운데 배치 사용합니다.
		setVisible(true);
	}
}