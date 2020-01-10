//package endecryption;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class keyExctactor {
//
//	public  String keyExtractor(String user,String fileformat) {
//
//		String key="";
//		
//		try {
//	
//			String sql1 = "SELECT mykey from data where user='"+user+"' and fileformat='"+fileformat+"'";
//
//			ResultSet rs1 = stmt1.executeQuery(sql1);
//			
//			if(rs1.next()){
//				key=rs1.getString("mykey");
//				System.out.println("jsnfjsnfjnsfnsfjnfjnjfnsjnfjsnfjnfjnsfj"+key);
//			}
//			
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return key;
//
//	}
//}
