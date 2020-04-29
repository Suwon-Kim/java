class Subject {
	private String name;
	private int score;
	
	// ������ ã���� ���
	public Subject(String name) {
		setName(name);
	}

	public Subject(String name, int score) {
		setName(name);
		setScore(score);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return name + " : " + score;
	}
	// �̸��� ������ ���� ��������.
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Subject)) {
			return false;
		}
		Subject temp = (Subject)o;
		return name.equals(temp.getName());
	}
}

class Student {
	private String name;
	private Subject[] scores;

	public Student(String name, Subject... scores) {
		setName(name);
		setScores(scores);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Subject[] getScores() {
		return scores;
	}
	public void setScores(Subject... scores) {
		this.scores = scores;
	}
	// ���κ� ����
	public int getTotal() {
		int total = 0;
		for(Subject temp : scores) {
			total += temp.getScore();
		}
		return total;
	}
	// ���κ� ���
	public int getAvg() {
		return getTotal() / scores.length;
	}
	/*
		������ ���� ã��
		param : ������ �̸�
		return : ����. ��, �������� �ʴ� �������� ��� -1
	*/
	public int getSubjectScore(String name) {
		Subject goal = new Subject(name);
		int score = -1;
		for(Subject temp : scores) {
			if(temp.equals(goal)) {
				score = temp.getScore();				
			}
		}
		return score;
	}

	@Override
	public String toString() {
		String info = "<<" + name + ">>\n";
		for(Subject temp : scores) {
			info += temp.toString() + "\n";
		}
		info += "���� : " + getTotal() + "\n";
		info += "��� : " + getAvg();

		return info;
	}
}

// �б�
class Klass {
	private Student[] list;
	
	public Klass(Student... list){
		setList(list);
	}
	public Student[] getList() {
		return list;
	}
	public void setList(Student... list) {
		this.list = list;
	}
	// ������ ����
	public int getTotal(String subjectName) {
		int total = 0;
		for(Student temp : list) {
			int score = temp.getSubjectScore(subjectName);
			if(score >= 0) {
				total += score;
			}
		}
		return total;
	}
	// ������ ���
	public int getAvg(String subjectName) {
		return getTotal(subjectName) / list.length;
	}

	@Override
	public String toString() {
		String info = "- �б����� -\n";
		for(Student temp : list) {
			info += temp.toString() + "\n";
		}
		// ���� �б��� �л��� ���� ������ �����Ƿ�...
		Subject[] scores = list[0].getScores();		
		for(Subject temp : scores) {
			String name = temp.getName();
			info += name + " ���� : " + getTotal(name) + "\n";
			info += name + "��� : " + getAvg(name) + "\n";
		}

		return info;
	}
}

class Answer {
	public static void main(String[] args) {
		
		Subject s1 = new Subject("����", 90);
		Subject s2 = new Subject("����", 70);
		Subject s3 = new Subject("����", 100);

		Student st1 = new Student("�ֺ���", s1, s2, s3);
		Student st2 = new Student(
			"�����",
			new Subject("����", 90),
			new Subject("����", 100),
			new Subject("����", 100)
		);
		Student st3 = new Student(
			"������",
			new Subject("����", 100),
			new Subject("����", 100),
			new Subject("����", 100)
		);

		System.out.println(new Klass(st1, st2, st3));		
	}
}
