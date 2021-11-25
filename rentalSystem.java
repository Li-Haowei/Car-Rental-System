import java.util.Arrays;

public class rentalSystem {
	private customer[] customerList;
	private car[] carList;
	private String[][] rentalBook;
	public revenueSystem records;
	
	/**
	 * Constructor, takes no input and creats a carList abd a customerList
	 */
	rentalSystem(){
		customerList = new customer[10];
		carList = new car[10];
		rentalBook = new String[10][4];
		records = new revenueSystem();
	}
	/**
	 * get the customer list
	 * @return customerList
	 */
	public customer[] getCustomerList() {
		return customerList;
	}
	/**
	 * get the car list
	 * @return carList
	 */
	public car[] getCarList() {
		return carList;
	}
	/**
	 * add customer into current system
	 * @param customer
	 * @throws input error
	 */
	public void addCustomer(customer customer) throws IllegalArgumentException {
		if(customer==null) {
			throw new IllegalArgumentException("addCustomer customer cannot be null");
		}
		if(!isFull(customerList)) {
			customer[] tempList = new customer[customerList.length+10];
			for(int i=0; i<customerList.length;i++) {
				tempList[i] = customerList[i];
			}
			customerList = tempList;
		}
		for(int i = 0;i<customerList.length; i++) {
			if(customerList[i]==null) {
				customerList[i] = customer;
				break;
			}
		}
	}
	/**
	 * add a new car into car list
	 * @param car
	 * @throws input error
	 */
	public void addCar(car car) throws IllegalArgumentException {
		if(car==null) {
			throw new IllegalArgumentException("addCar car cannot be null");
		}
		if(!isFull(carList)) {
			car[] tempList = new car[carList.length+10];
			for(int i=0; i<carList.length;i++) {
				tempList[i] = carList[i];
			}
			carList = tempList;
		}
		for(int i = 0;i<carList.length; i++) {
			if(carList[i]==null) {
				carList[i] = car;
				break;
			}
		}
	}
	/**
	 * check if the list is full
	 * @param any(a car list)
	 * @throws input error
	 * @return boolean
	 */
	public boolean isFull(car[] any) throws IllegalArgumentException {
		if(any==null||any.length==0) {
			throw new IllegalArgumentException("is Full car list cannot be null or have a length of 0");
		}
		for(car s:any) {
			if(s==null) {
				return false;
			}
		}
		return true;
	}
	/**
	 * check if the list is full
	 * @param any(a customer list)
	 * @throws input error
	 * @return boolean
	 */
	public boolean isFull(customer[] any) throws IllegalArgumentException {
		if(any==null||any.length==0) {
			throw new IllegalArgumentException("is Full customer list cannot be null or have a length of 0");
		}
		for(customer s:any) {
			if(s==null) {
				return false;
			}
		}
		return true;
	}
	/**
	 * check if the content is in the list(any lists)
	 * @param content
	 * @throws input error
	 * @return boolean
	 */
	public boolean isInTheList(String content) throws IllegalArgumentException {
		if(content == null || content.length()==0) {
			throw new IllegalArgumentException("isInTheList input cannot be null or have a length of 0");
		}
		for(customer c:customerList) {
			if(c!=null) {
				if(c.getName()==content) return true;
				if(c.getId()==content) return true;
				if(c.getPhoneNumber()==content) return true;
			}
		}
		for(car c:carList) {
			if(c!=null) {
				if(c.getCarId()==content) return true;
				if(c.getCarName()==content) return true;
			}
		}
		
		return false;
	}
	/**
	 * delete the car from car list by name or id
	 * @param content
	 * @throws input error
	 * @return boolean
	 */
	public boolean delCar(String content) throws IllegalArgumentException{
		if(content == null || content.length()==0) {
			throw new IllegalArgumentException("delCar input cannot be null or have a length of 0");
		}
		for(car c:carList) {
			if(c!=null) {
				if(c.getCarId()==content) {
					c = null;
					return true;
				}
				if(c.getCarName()==content) {
					c = null;
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * delete the customer from customer list
	 * @param content
	 * @throws input error
	 * @return boolean
	 */
	public boolean delCustomer(String content) throws IllegalArgumentException{
		if(content == null || content.length()==0) {
			throw new IllegalArgumentException("delCar input cannot be null or have a length of 0");
		}
		for(customer c:customerList) {
			if(c!=null) {
				if(c.getName()==content) {
					c = null;
					return true;
				}
				if(c.getId()==content) {
					c = null;
					return true;
				}
				if(c.getPhoneNumber()==content) {
					c = null;
					return true;
				}
			}
		}
		return false;
	}
	public String getCustomerNameByInfo(String content) throws IllegalArgumentException{
		if(content==null) throw new IllegalArgumentException("input cannot be null");
		for(int i=0;i<customerList.length;i++) {
			if(customerList[i]!=null) {
				if(customerList[i].getName()==content) {
					return customerList[i].getName();
				}
				if(customerList[i].getId()==content) {
					return customerList[i].getName();
				}
				if(customerList[i].getPhoneNumber()==content) {
					return customerList[i].getName();
				}
			}
		}
		return "No Such a Person";
	}
	/**
	 * To verify if there is such a customer with the ID
	 * @param ID
	 * @return
	 */
	public boolean verifyCustomerById(String ID) {
		for(customer c:customerList) {
			if(c!=null) {
				if(c.getId()==ID) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Input customer ID and the car name or the car ID to rent the car
	 * If the car is rented, it will output rented
	 * @param customerID
	 * @throws input error
	 * @param content
	 */
	public void rentACar(String customerID, String content) throws IllegalArgumentException{
		if(customerID==null||content==null||customerID.length()==0||content.length()==0) {
			throw new IllegalArgumentException("rentACar input cannot be null or have a length of 0");
		}
		if(!verifyCustomerById(customerID)) {
			System.out.println(customerID + " is an invalid ID");
			return;
		}
		for(int i =0;i< carList.length;i++) {
			if(carList[i]==null) {
				System.out.println(content + " is not in the car list");
				break;
				}
			if(carList[i].getCarId()==content||carList[i].getCarName()==content) {
				if(carList[i].getCustomerId()==null) {
					carList[i].setCustomerId(customerID);
					System.out.println(content + " is successfully rented");
					addRentalBook(getCustomerNameByInfo(customerID), customerID, carList[i].getCarName(), carList[i].getCarId());
				}else {
					System.out.println(content + " is already rented by someone");
				}
				break;
			}
		}
		
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
	/**
	 * Print car list
	 */
	public void printCarList() {
		System.out.print("This is car list: ");
		for(int i=0;i<carList.length;i++) {
			if(carList[i]!=null)System.out.print(carList[i].getCarName() + " ");
		}
		System.out.println();
	}
	/**
	 * Print customer list
	 */
	public void printCustomerList() {
		System.out.print("This is customer list: ");
		for(int i=0;i<customerList.length;i++) {
			if(customerList[i]!=null)System.out.print(customerList[i].getName() + " ");
		}
		System.out.println();
	}
	/**
	 * input customer and car information and which date to return the car
	 * @param customerInfo
	 * @param carInfo
	 * @param date
	 * @throws IllegalArgumentException
	 */
	public void returnCar(String customerInfo, String carInfo, String date) throws IllegalArgumentException{
		if(customerInfo==null||carInfo==null) throw new IllegalArgumentException("input cannot be null");
		for(int i=0;i<rentalBook.length;i++) {
			if(rentalBook[i][0] != null || rentalBook[i][0].length() !=0) {
				if((customerInfo==rentalBook[i][0]||customerInfo==rentalBook[i][1])&&(carInfo==rentalBook[i][2]||carInfo==rentalBook[i][3])) {
					for(int j =0;j< carList.length;j++) {
						if(carList[j]!=null) {
							if(carList[j].getCarName()==carInfo||carList[j].getCarId()==carInfo) {
								carList[j].setCustomerId(null);
								records.addRecord(date, carList[j].getPrice());
								break;
							}
						}
					}
				}
					rentalBook[i] = new String[4];
					System.out.println(customerInfo + " successfully returned " + carInfo);
					return;
			}
		}
		System.out.println("Return Fail, customer info or car info error, please double check.");
	}
}
