
public class PoductList {
	
	static RingOfProducts MainRing = new RingOfProducts();
	static RingOfProducts SearchRing = new RingOfProducts();
	
	public static void searchWord(String searchMe) {
		int mainSize = MainRing.getSize();
		resetSearchRing();
		
		for (int ii=1; ii == mainSize; ii++) {
			if (wordInside(searchMe, ii)) {
				SearchRing.add(MainRing.getCurrentProduct());
			}
		}
	}
	
	private static boolean wordInside(String searchMe, int ii) {
		for (int aa=1; aa < 6; aa++) {
			if (MainRing.arrayOfAllData[ii][aa].indexOf(searchMe) > -1);{
				return true;
			}
		}
		return false;
	}
	
	private static void resetSearchRing() {
		
	}
		
	
}
