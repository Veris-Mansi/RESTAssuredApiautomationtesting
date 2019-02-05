package files;

public class payloadData {
// This class will return the payload data that is neede to be put in the body ofpost request
	public static String getPostData()
	{
		String b="{\r\n" + 
				"	\"username\":\"skkrrp8\",\r\n" + 
				"	\"email\":\"sandmm@gmail.com\",\r\n" + 
				"	\"password\":\"mansi\"\r\n" + 
				"}";
		return b ;
		
	}
	
	public static String getDuplicateUsername()
	{
		String s= "{\r\n" + 
				"	\"username\":\"maneq11908\",\r\n" + 
				"	\"email\":\"kkkk@gmail.com\",\r\n" + 
				"	\"password\":\"mansi\"\r\n" + 
				"}";
		return s;
		
	}
	
	public static String getDuplicateEmail()
	{
		String k="{\r\n" + 
				"	\"username\":\"nykaa\",\r\n" + 
				"	\"email\":\"manuq1111@gmail.com\",\r\n" + 
				"	\"password\":\"mansi\"\r\n" + 
				"}";
		return k;
	}
	
	public static String correctLoginPayload()
	{
		String data="{\r\n" + 
				"	\"email\":\"manuq1111@gmail.com\",\r\n" + 
				"	\"password\":\"mansi\"\r\n" + 
				"}";
		
		return data;
		
	}
	public static String incorrectLoginPayload()
	{
		String data="{\r\n" + 
				"	\"email\":\"sss@com\",\r\n" + 
				"	\"password\":\"mansi\"\r\n" + 
				"}";
		
		return data;
		
	}
	public static String emptyemailLoginPayload()
	{
		String data="{\r\n" + 
				"	\"email\":null,\r\n" + 
				"	\"password\":\"mansi\"\r\n" + 
				"}";
		
		return data;
		
	}
	public static String emptypasswordLoginPayload()
	{
		String data="{\r\n" + 
				"	\"email\":\"manuq1111@gmail.com\",\r\n" + 
				"	\"password\":null\r\n" + 
				"}";
		
		return data;
		
	}
	public static String incorrectpasswordLoginPayload()
	{
		String data="{\r\n" + 
				"	\"email\":\"manuq1111@gmail.com\",\r\n" + 
				"	\"password\":\"pppp\"\r\n" + 
				"}";
		
		return data;
		
	}
}
