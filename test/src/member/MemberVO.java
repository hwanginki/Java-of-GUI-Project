package member;

// �л� ������ �����ϴ� Ŭ����
public class MemberVO {
	private String name; // �̸�
	private String subjectName; // ����
	private int score; // ����
	
	public MemberVO(String name, String subjectName, int score) {
		this.name = name;
		this.subjectName = subjectName;
		this.score = score;
	}

	public String getName() {
		return name;
	}

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
	public String toString() {
		return super.toString();
	}
}