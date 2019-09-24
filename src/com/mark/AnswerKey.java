package com.mark;

public class AnswerKey {
	
	String qno;
	String answer;
	int mark;
	
	public AnswerKey(String qno, String answer, int mark) {
		super();
		this.qno = qno;
		this.answer = answer;
		this.mark = mark;
	}

	public String getQno() {
		return qno;
	}

	public void setQno(String qno) {
		this.qno = qno;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	
	

}
