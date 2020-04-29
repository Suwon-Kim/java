class Subject {
	private String name;
	private int score;
	
	// 교과목 찾을때 사용
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
	// 이름이 같으면 같은 교과목임.
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
	// 개인별 총점
	public int getTotal() {
		int total = 0;
		for(Subject temp : scores) {
			total += temp.getScore();
		}
		return total;
	}
	// 개인별 평균
	public int getAvg() {
		return getTotal() / scores.length;
	}
	/*
		교과목 점수 찾기
		param : 교과목 이름
		return : 점수. 단, 존재하지 않는 교과목인 경우 -1
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
		info += "총점 : " + getTotal() + "\n";
		info += "평균 : " + getAvg();

		return info;
	}
}

// 학급
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
	// 교과목 총점
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
	// 교과목 평균
	public int getAvg(String subjectName) {
		return getTotal(subjectName) / list.length;
	}

	@Override
	public String toString() {
		String info = "- 학급정보 -\n";
		for(Student temp : list) {
			info += temp.toString() + "\n";
		}
		// 같은 학급의 학생은 시험 교과가 같으므로...
		Subject[] scores = list[0].getScores();		
		for(Subject temp : scores) {
			String name = temp.getName();
			info += name + " 총점 : " + getTotal(name) + "\n";
			info += name + "평균 : " + getAvg(name) + "\n";
		}

		return info;
	}
}

class Answer {
	public static void main(String[] args) {
		
		Subject s1 = new Subject("국어", 90);
		Subject s2 = new Subject("영어", 70);
		Subject s3 = new Subject("수학", 100);

		Student st1 = new Student("애봉이", s1, s2, s3);
		Student st2 = new Student(
			"김수현",
			new Subject("국어", 90),
			new Subject("영어", 100),
			new Subject("수학", 100)
		);
		Student st3 = new Student(
			"김유정",
			new Subject("국어", 100),
			new Subject("영어", 100),
			new Subject("수학", 100)
		);

		System.out.println(new Klass(st1, st2, st3));		
	}
}
