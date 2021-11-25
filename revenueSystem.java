import java.util.*;
/**
 * @author Haowei Li
 */
public class revenueSystem {
	private Hashtable<String, String[]> records; 
	
	revenueSystem(){
		records = new Hashtable<String, String[]>();
	}
	/**
	 * Takes in two input, one is for date and second is for income, then add into records
	 * Please enter the date in such form MM/DD/YYYY for consistency
	 * @param date
	 * @param income
	 */
	public void addRecord(String date, String income){
		if(records.get(date) != null) {
			String[] record = records.get(date);
			for(int i=0;i<record.length;i++) {
				if (record[i]==null) record[i] = income;
			}
		}
		else {
			String[] record = new String[20];
			record[0]=income;
			records.put(date, record);
			}
	}
	/**
	 * Takes in two input, one is for date and second is for income, then remove from records
	 * Please enter the date in such form MM/DD/YYYY for consistency
	 * @param date
	 * @param income
	 */
	public void delRecord(String date, String income){
		if(records.get(date) != null) {
			String[] record = records.get(date);
			for(int i=0;i<record.length;i++) {
				if (record[i]==income) record[i] = null;
			}
		}
		else {
			System.out.println("Date not found");
			}
	}
	/**
	 * Takes in one input, for date, then return all records on that date
	 * Please enter the date in such form MM/DD/YYYY for consistency
	 * @param date
	 * @return record
	 */
	public String[] searchRecord(String date){
		if(records.get(date) != null) {
			String[] record = records.get(date);
			return record;
		}
		else {
			throw new IllegalArgumentException("Date not found");
		}
	}
	/**
	 * print the revenue book
	 */
	public void printRevenue() {
		Set<String> keys = records.keySet();
		for(String key: keys) {
			System.out.print(key + ":  ");
			String[] record = records.get(key);
			for(int i=0;i<record.length;i++) {
				if (record[i]!=null) System.out.print(record[i] + ", ");;
			}
			System.out.println();
		}
	}
}
