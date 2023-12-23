package jez.exo4;

public class Database {
	private static final String host = "192.168.1.27";
	private static final String database = "spring";
	private static final String user = "postgres";
	private static final String password = "12345678aAbB!";
	public static final String url = "jdbc:postgresql://" + host + "/" + database + "?user=" + user + "&password=" + password + "&ssl=false";
}
