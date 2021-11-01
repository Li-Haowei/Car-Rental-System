public class car{
	private String customerid = null;
	private String carid;
	private String carname;
	private String type;
	private String color;
	private String level;
	private String insurance;
	private String price;
	private String status;
	private String condition;
	
	/**
	 * this is get customer id
	 * @return customerid
	 */
	public String getCustomerid() {
		return customerid;
	}
	public final void setCustomerid(String customerid) throws IllegalArgumentException{
		if(customerid==null || customerid.length() == 0)
			throw new IllegalArgumentException("Customerid can not be NULL or length equals 0");
		this.customerid = customerid;
	}
	
	/**
	 * this is get carid
	 * @return carid
	 */
	public String getCarid() {
		return carid;
	}
	public final void setCarid(String carid) throws IllegalArgumentException{
		if(carid==null || carid.length() == 0)
			throw new IllegalArgumentException("Carid can not be NULL or length equals 0");
		this.carid = carid;
	}
	
	/**
	 * this is get carname
	 * @return carname
	 */
	public String getCarname() {
		return carname;
	}
	public final void setCarname(String carname) throws IllegalArgumentException{
		if(carname==null || carname.length() == 0)
			throw new IllegalArgumentException("Carname can not be NULL or length equals 0");
		this.carname = carname;
	}
	
	/**
	 * this is get car type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	public final void setType(String type) throws IllegalArgumentException{
		if(type==null || type.length() == 0)
			throw new IllegalArgumentException("Type can not be NULL or length equals 0");
		this.type = type;
	}
	
	/**
	 * this is get car color
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	public final void setColor(String color) throws IllegalArgumentException {
		if(color==null || color.length() == 0)
			throw new IllegalArgumentException("Color can not be NULL or length equals 0");
		this.color = color;
	}
	
	/**
	 * this is get car level
	 * @return level
	 */
	public String getLevel() {
		return level;
	}
	public final void setLevel(String level) throws IllegalArgumentException {
		if(level==null || level.length() == 0)
			throw new IllegalArgumentException("Level can not be NULL or length equals 0");
		this.level = level;
	}
	
	/**
	 * this is get car insurance
	 * @return insurance
	 */
	public String getInsurance() {
		return insurance;
	}
	public final void setInsurance(String insurance) throws IllegalArgumentException {
		if(insurance==null || insurance.length() == 0)
			throw new IllegalArgumentException("Insurance can not be NULL or length equals 0");
		this.insurance = insurance;
	}
	
	/**
	 * this is get car price
	 * @return price
	 */
	public String getPrice() {
		return price;
	}
	public final void setPrice(String price) throws IllegalArgumentException{
		if(price==null || price.length() == 0)
			throw new IllegalArgumentException("Price can not be NULL or length equals 0");
		this.price = price;
	}
	
	/**
	 * this is get car condition
	 *@return condition
	 */
	public String getCondition() {
		return condition
	}
	public final void setCondition(String condition) throws IllegalArgumentException{
		if(condition==null || condition.length() == 0)
			throw new IllegalArgumentException("Condition can not be NULL or length equals 0");
		this.condition = condition;
	
	/**
	 *this is get car status
	 *@return status
	 */
	public String getStatus(){
		return status
	}
	public final void setStatus(String status) throws IllegalArgumentException{
		if(status==null || status.length() == 0)
			throw new IllegalArgumentException("Status can not be NULL or length equals 0");
		this.status = status;
			

	/**
	 * the constructor for add a new car
	 * @param customerid
	 * @param carid
	 * @param carname
	 * @param type
	 * @param level
	 * @param color
	 * @param insurance
	 * @param price
	 */
	public car(String customerid, String carid, String carname, String type, String level, String color, String insurance, String price) {
		setcustomerid(customerid);
		setcarid(carid);
		setcarname(carname);
		settype(type);
		setlevel(level);
		setcolor(color);
		setinsurance(insurance);
		setprice(price);
		}
	
	/**
	 * test code
	 */
	public void main() {
        car car1 = new car("01","001","Mercedes","S550","Luxury","Black","Liberty","$1000")
		System.out.println(car1.getid()); 
    }

}


