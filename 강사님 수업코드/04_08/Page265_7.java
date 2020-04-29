class Student {
	private String name;
	private String id;
	private String major;
	private int grade;
	private int point;		// 이수학점

	public Student(
		String name, String id, String major, int grade, int point) {

		setName(name);
		setId(id);
		setMajor(major);
		setGrade(grade);
		setPoint(point);
	}

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getMajor() {
		return major;
	}
	public int getGrade() {
		return grade;
	}
	public int getPoint() {
		return point;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		String info = "name : " + name + "\n";
		info += "id : " + id + "\n";
		info += "major : " + major + "\n";
		info += "grade : " + grade + "\n";
		info += "point : " + point;
		return info;
	}
}

class UnderGraduate extends Student {
	private String club;

	public UnderGraduate(
		String name, String id, String major, int grade, int point, String club) {
		
		super(name, id, major, grade, point);
		setClub(club);
	}

	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}

	@Override
	public String toString() {
		String info = super.toString() + "\n";
		info += "club : " + club;

		return info;
	}
}
class Graduate extends Student {
	/*
		0 => 교육조교
		1 => 연구조교
	*/
	public static final int EDU_TYPE = 0;
	public static final int RND_TYPE = 1;

	public static final double MIN_RATE = 0;
	public static final double MAX_RATE = 1;
	public static final double DEFAULT_RATE = 0.1;

	private int assType;
	private double sRate;
	// String name, String id, String major, int grade, int point
	public Graduate(
		String name, String id, String major, int grade, 
		int point, int assType, double sRate) {

		super(name, id, major, grade, point);

		setAssType(assType);
		setSRate(sRate);
	}

	public int getAssType() {
		return assType;
	}
	public double getSRate() {
		return sRate;
	}
	public void setAssType(int assType) {		
		if(assType != EDU_TYPE && assType != RND_TYPE) {
			assType = EDU_TYPE;
		} else {
			this.assType = assType;
		}
	}
	public void setSRate(double sRate) {
		if(sRate >= MIN_RATE && sRate <= MAX_RATE) {
			this.sRate = sRate;
		} else {
			this.sRate = DEFAULT_RATE;
		}
	}
	@Override
	public String toString() {
		String info = super.toString() + "\n";
		String type = (assType == EDU_TYPE) ? "교육조교" : "연구조교";
		info += "assType : " + type + "\n";
		info += "sRate : " + sRate;
		return info;
	}
}
class Page265_7 {
	public static void main(String[] args) {
		// String name, String id, String major, int grade, int point, String club
		UnderGraduate ug = new UnderGraduate(
			"승미", "97101147", "컴공", 4, 140, "학술"				
		);
		System.out.println(ug);

		System.out.println(
			new Graduate(
				"승민", "0000001", "경제", 2, 30, Graduate.RND_TYPE, 0.4
			)	
		);
	}
}
