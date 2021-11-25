package carRentalSystem;

public class orderSystem {
	public String[][] rentalBook;
	orderSystem(){
		rentalBook = new String[10][4];
	}
	public void printRentalBook() {
		for(int i=0;i<rentalBook.length;i++) {
			System.out.print(i + ": ");
			for (int j=0;j<rentalBook[i].length;j++) {
				switch(j) {
				case 0:
					System.out.print("Customer Name: ");
					break;
				case 1:
					System.out.print(", Customer ID: ");
					break;
				case 2:
					System.out.print(", Car Name: ");
					break;
				case 3:
					System.out.print(", Car ID: ");
					break;
				}
				if(rentalBook[i][j]!=null) {
					System.out.print(rentalBook[i][j]);
				}
				else System.out.print("Empty_Slot");
			}
			System.out.println();
		}
	}
	/**
	 * add information of rental into record to keep track of all rentals
	 * @param customerName
	 * @param customerId
	 * @param carName
	 * @param carId
	 */
	public void addRentalBook(String customerName, String customerId, String carName, String carId) throws IllegalArgumentException{
		if(customerName==null||customerId==null||carName==null||carId==null||customerName.length()==0||customerId.length()==0||carName.length()==0||carId.length()==0) {
			throw new IllegalArgumentException("addRentalBook input cannot be null or with a length of 0");
		}
		for(int i=0;i<rentalBook.length;i++) {
			if(rentalBook[i][0] == null || rentalBook[i][0].length()==0) {
				rentalBook[i][0] = customerName;
				rentalBook[i][1] = customerId;
				rentalBook[i][2] = carName;
				rentalBook[i][3] = carId;
				break;
			}
			if(i==rentalBook.length-1) {
				//In case if rental book is full, extend its capacity
				String[][] tempList = new String[rentalBook.length+10][4];
				for(int k=0; k<rentalBook.length;k++) {
					tempList[k] = rentalBook[k];
				}
				rentalBook = tempList;
			}
		}
	}
	/**
	 * to remove a rental record from the rental book only needs customer ID and car ID as input
	 * @param customerId
	 * @param carId
	 * @return
	 */
	public boolean removeRentalBook(String customerId, String carId) {
		if(customerId==null||carId==null||customerId.length()==0||carId.length()==0) {
			throw new IllegalArgumentException("removeRentalBook input cannot be null or with a length of 0");
		}
		for(int i=0;i<rentalBook.length;i++) {
			if(rentalBook[i][1] == customerId || rentalBook[i][3] == carId) {
				rentalBook[i] = new String[4];
				return true;
			}
		}
		return false;
	}
}
