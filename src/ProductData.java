
public class ProductData {

	private String name;
	private int weight;
	private int amount;
	private int price;
	// Six Digits long identify Number 000.000 first 3 for Place
	private int number; 
	private String category;
	
	//constructor in Product
	void setProductData(String name, int weight, int amount, int price, int number, String category) {
		this.name = name;
		this.weight = weight;
		this.amount = amount;	
		this.price = price;
		this.number = number;
		this.category = category;
		
	}
	
	// GETTER & SETTER
    
    //getters
	public String getName() {
		return this.name;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setCategory(String category) {
		this.category = category;

	}

}
