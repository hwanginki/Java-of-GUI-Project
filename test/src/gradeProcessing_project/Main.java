package gradeProcessing_project;

import javax.swing.SwingUtilities; // Swing�� ��ƿ��Ƽ Ŭ���� �߰�

public class Main {
	public static void main(String[] args) {
		// run() �޼��带 �̺�Ʈ ����ġ������� �񵿱������� ��������ݴϴ�.
		SwingUtilities.invokeLater(new Runnable() { 
			@Override
			public void run() {
				new Login(); // ��ȸ�� Login Ŭ���� ��ü ����
			}
		});
	}
}