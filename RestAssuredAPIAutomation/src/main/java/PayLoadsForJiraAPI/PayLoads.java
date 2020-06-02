package PayLoadsForJiraAPI;

public class PayLoads {

	// for authentication
	public static String authenticationBody() {
		return "{ \"username\": \"pnilava03\", \"password\": \"8431812353\" }";
	}

	// for create issue in Jira
	public static String createIssueBody() {

		return "{\r\n" + "    \"fields\": {\r\n" + "        \"project\": {\r\n" + "            \"key\": \"RES\"\r\n"
				+ "        },\r\n" + "        \"summary\": \"Debit Card issue\",\r\n"
				+ "        \"description\": \"This is Debit card bug created by Rest Assured API with core java\",\r\n"
				+ "        \"issuetype\": {\r\n" + "        	\"name\": \"Bug\" \r\n" + "        \r\n"
				+ "        }\r\n" + "}\r\n" + "}";
	}

	// for add comment in jira
	public static String addCommentBody() {
		return "	{\r\n"
				+ "	    \"body\": \"Hey this is my first comment from Rest Assured API through Automation\",\r\n"
				+ "	    \"visibility\": {\r\n" + "	        \"type\": \"role\",\r\n"
				+ "	        \"value\": \"Administrators\"\r\n" + "	    }\r\n" + "	}";
	}
	
	

	// for add Update in jira
	public static String updateCommentBody() {
		return "{\r\n"
				+ "    \"body\": \"Nilava update the  comments:: Hey This is my update comment from Rest Assured API through Automation\",\r\n"
				+ "    \"visibility\": {\r\n" + "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n" + "    }\r\n" + "}";
	}
	
	

}
