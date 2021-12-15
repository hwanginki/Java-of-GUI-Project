package member;

// 학생의 성적을 관리하는 클래스
public class MemberVO {
	private String name; // 이름
	private String subjectName; // 과목
	private int score; // 성적
	
	// 기본 생성자
	public MemberVO(String name, String subjectName, int score) {
		this.name = name;
		this.subjectName = subjectName;
		this.score = score;
	}

	// Getter 
	public String getName() {
		return name;
	}
	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() { // toString()는  말그대로 문자열을 호출하는 메서드
		return super.toString();
	}
}