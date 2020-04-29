/*
	Car 클래스를 작성 하고 정렬하라.
	멤버 변수 : 가격 , 제조사, 엔진

	정렬 기준 : 가격 -> 제조사 -> 엔진
*/
import java.util.Arrays;
class Engine implements Comparable<Engine>{
	private int price;
	private String maker;
	private int cc;

	public Engine(int price , String maker,int cc){
		setPrice(price);
		setMaker(maker);
		setCc(cc);
	}

	public void setPrice(int price){
		this.price = price;
	}
	public int getPrice(){
		return this.price;
	}
	public void setMaker(String maker){
		this.maker = maker;
	}
	public String getMaker(){
		return this.maker;
	}
	public void setCc(int cc){
		this.cc = cc;
	}
	public int getCc(){
		return this.cc;
	}

	@Override
	public String toString(){
		return String.format("엔진 가격은 %d 이고 제조사는 %s 이며  CC 는 %d 입니다",getPrice(),getMaker(),getCc());
	}	
	@Override
	public int compareTo(Engine e){
		int checkPirce = getPrice()-e.getPrice();
		if(checkPirce !=0){
			return checkPirce;
		}
		int checkMaker = getMaker().compareTo(e.getMaker());
		if (checkMaker !=0){
			return checkMaker;
		}
		return getCc()- e.getCc();
	}
}


class Car implements Comparable<Car>{
	private int price;
	private String maker;
	private Engine engine;
	
	public Car(int price, String maker,Engine engine){
		setPrice(price);
		setMaker(maker);
		setEngine(engine);
	}

	public void setPrice(int price){
		this.price = price;
	}
	public int getPrice(){
		return this.price;
	}
	public void setMaker(String maker){
		this.maker = maker;
	}
	public String getMaker(){
		return this.maker;
	}
	public void setEngine(Engine engine){
		this.engine = engine;
	}
	public Engine getEngine(){
		return this.engine;
	}

	@Override
	public int compareTo(Car c){
		int checkPirce = getPrice()-c.getPrice();
		if(checkPirce !=0){
			return checkPirce;
		}
		int checkMaker = getMaker().compareTo(c.getMaker());
		if (checkMaker !=0){
			return checkMaker;
		}
		return getEngine().compareTo(c.getEngine());
	}
	@Override
	public String toString(){
		String result = String.format("차량 가격은 %d 이고 , 제조사는 %s 이며 , 엔진은 %s \n",getPrice(),getMaker(),getEngine());
		return result;
	}
}

class UseCar {
	public static void main(String[] args) {
		Engine e1 = new Engine(500,"기아",2000);
		Car c1 = new Car(4000, "현대", e1);
		Engine e2 = new Engine(1200,"현대",3000);
		Car c2 = new Car(2000, "기아", e2);
		Engine e3 = new Engine(3300,"현대",4000);
		Car c3 = new Car(2000, "현대", e3);
		Engine e4 = new Engine(4400,"현대",5000);
		Car c4 = new Car(3000, "현대", e4);
		Engine e5 = new Engine(500,"현대",2000);
		Car c5 = new Car(4000, "현대", e5);

		Car[] cars ={c1,c2,c3,c4,c5};

		System.out.println(Arrays.toString(cars));
		Arrays.sort(cars);
		System.out.println(Arrays.toString(cars));
	}
}
