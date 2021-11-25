import java.util.*;
/**
 * @author Haowei Li
 */
public class revenueSystem {
	private Hashtable<String, String[]> records; 
	
	revenueSystem(){
		records = new Hashtable<String, String[]>();
	}
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
	public void deleteRecord(String date, String income){
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
	public String[] searchRecord(String date, String income){
		if(records.get(date) != null) {
			String[] record = records.get(date);
			return record;
		}
		else {
			throw new IllegalArgumentException("Date not found");
		}
	}
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
