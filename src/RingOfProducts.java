import java.util.NoSuchElementException;

public class RingOfProducts {
	private Product currentProduct; //Product in Ring which is currently selected
	private int size; //of Ring
	String[][] arrayOfAllData;

		//
		public RingOfProducts(){ 
			//initialize with 0/null automatically in Java
		}
		
		public int getSize() {
			return this.size;
		}
		public Product getCurrentProduct() {
			return this.currentProduct;
		}

		public void add(Product addMe) {
			if (currentProduct == null) {					
				currentProduct = new Product(addMe.getName(), addMe.getWeight(), addMe.getAmount(), addMe.getPrice(), addMe.getNumber(), addMe.getCategory(), null, null);
				//Set Next and Previous on itself
				currentProduct.setPrev(currentProduct); 
				currentProduct.setNext(currentProduct); 
			}
				
			else{
				//Previous of current Product is new Product.
				currentProduct.setPrev(new Product(addMe.getName(), addMe.getWeight(), addMe.getAmount(), addMe.getPrice(), addMe.getNumber(), addMe.getCategory(), currentProduct.getPrev(), currentProduct));
				//predecessor of the new Products points at new Product
				currentProduct.getPrev().getPrev().setNext(currentProduct.getPrev());
				
			}
			this.size += 1;	 
		}
		
		//go to Predecessor of current Product
		public void back() {
			if (currentProduct == null) {
				throw new NoSuchElementException("Keine Producte enthalten");
			}
			else {
				this.currentProduct = currentProduct.getPrev();
			}
		}
		
		//go to successor of current Product
		public void next() {
			if (currentProduct== null) {
				throw new NoSuchElementException("Keine Producte enthalten");
			}
			else {
				this.currentProduct = currentProduct.getNext();
			}
		}
		
		//
		public void remove() {
			if (currentProduct == null) {
				throw new NoSuchElementException("Keine Producte enthalten");
			}
			else {
				currentProduct = currentProduct.getNext();					//
				currentProduct.setPrev(currentProduct.getPrev().getPrev());	//
				currentProduct.getPrev().setNext(currentProduct);				//
				System.gc();											//
				this.size=this.size-1; //
			}
		}

		//Return String-Array of current Product NAME>WEIGHT>AMOUNT>PRICE>NUMBER>CATEGORY
		//used by toStrings
		private String[] currentValuesStrings(){
			String[] allData = new String[6];
			
			allData[0] = currentProduct.getName();
			allData[1] = Integer.toString(currentProduct.getWeight());
			allData[2] = Integer.toString(currentProduct.getAmount());
			allData[3] = Integer.toString(currentProduct.getPrice());
			allData[4] = Integer.toString(currentProduct.getNumber());
			allData[5] = currentProduct.getCategory();
			
			return allData;
		}
		
		//returns Array of Array of Strings
		public void toStrings() {
			
			String[][] arrayOfAllData = new String[size][6];
			for(int ii = 0; ii < this.size; ii++) {
				arrayOfAllData[ii] = currentValuesStrings();
				this.currentProduct = currentProduct.getNext();
			}
			this.arrayOfAllData = arrayOfAllData;
		}	

}
