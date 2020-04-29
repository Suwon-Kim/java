/*
	=========================
			Book
	=========================
	- title : String
	- author : String
	- price : int
	=========================
	+ Book(title:String, author:String, price:int)
	+ getters / setters 
	+ toString() : String
	=========================


	=========================
			Bookcase
	=========================
	- category : String
	- books : Book[]
	=========================
	+ Bookcase(category:String, books:Book[])
	+ getters / setters
	+ toString() : String
	=========================


	=========================
		Bookstore
	=========================
	- name : String
	- tel : String
	- cases : Bookcase[]
	=========================
	+ Bookstore(name:String, tel:String, cases:Bookcase[])
	+ getters / setters
	+ toString
	=========================
*/

class Book {
	private String title;
	private String author;
	private int price;

	public Book(String title, String author, int price) {
		setTitle(title);
		setAuthor(author);
		setPrice(price);
	}

	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		String info = "title : " + title + "\n";
		info += "author : " + author + "\n";
		info += "price : " + price;
		return info;
	}
}
class Bookcase {
	private String category;
	private Book[] books;

	public Bookcase(String category, Book... books) {
		setCategory(category);
		setBooks(books);
	}

	public String getCategory() {
		return category;
	}
	public Book[] getBooks() {
		return books;
	}
	public void setCategory(String category) {
		this.category = category;	
	}
	public void setBooks(Book... books) {
		this.books = books;
	}
	@Override
	public String toString() {
		String info = "-- category : " + category + "\n";
		for(Book book : books) {
			info += book + "\n";
		}
		return info;
	}
}
class Bookstore {
	private String name;
	private String tel;
	private Bookcase[] cases;

	public Bookstore(String name, String tel, Bookcase... cases) {
		setName(name);
		setTel(tel);
		setCases(cases);
	}

	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public Bookcase[] getCases() {
		return cases;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setCases(Bookcase... cases) {
		this.cases = cases;
	}
	@Override
	public String toString() {
		String info = "<<" + name + " information>>\n";
		info += "tel : " + tel + "\n";
		for(Bookcase temp : cases ) {
			info += temp + "\n";
		}
		return info;
	}
}
class BookstoreEx {
	public static void main(String[] args)	{
		// Book(String title, String author, int price)
		Book b1 = new Book("파워자바", "천인국", 29000);
		Book b2 = new Book("슈퍼자바", "만인국", 32000);
		Book b3 = new Book("울트라자바", "억인국", 35000);

		// Bookcase(String category, Book... books)	
		Bookcase case1 = new Bookcase("IT", b1, b2, b3);

		Bookcase case2 = new Bookcase(
			"novel",
			new Book("누가내아이폰을치웠니?", "쿡", 18000),
			new Book("거미", "베루베루", 22000),
			new Book("노인과 자바", "고슬링", 25000),
			new Book("제3의루프", "승미", 15000)
		);

		Bookstore store = new Bookstore(
			"그린서점",
			"051-912-8282",
			case1, case2
		);

		System.out.println(store);
	}
}
