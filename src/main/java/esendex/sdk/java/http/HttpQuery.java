package esendex.sdk.java.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpQuery {
	
	private StringBuilder queryString = new StringBuilder();
	
	public static final Key<Boolean> RETURN_MESSAGE_HEADERS 
			= new Key<Boolean>("returnMessageHeaders");
	
	public static final Key<Integer> COUNT 
			= new Key<Integer>("count");

	public static final Key<Integer> START_INDEX 
			= new Key<Integer>("startIndex");

	public static final Key<Action> ACTION 
			= new Key<Action>("action");
	
	public static final Key<String> FILTER_VALUE 
			= new Key<String>("filterValue");
	
	public static final Key<String> FILTER_BY 
			= new Key<String>("filterBy");
	
	public static final String ACCOUNT_FILTER  = "account";
	
	public enum Action {
		READ,
		UNREAD;
		public String toString() {
			return name().toLowerCase();
		}
	}
	
	public enum FilterBy {
		ACCOUNT ("");
		String value;
		private FilterBy(String v) {
			this.value = v;
		}
	}
	
	public <E> void addParameter(Key<E> key, E value) {
		if (queryString.length() > 0) queryString.append('&');
		queryString.append(key.name);
		queryString.append('=');

        try {
            String encodedValue = URLEncoder.encode(value.toString(), "UTF-8");
            queryString.append(encodedValue);
        } catch (UnsupportedEncodingException e) {
            queryString.append(value.toString());
        }
	}
	
	@Override
	public String toString() {
		return queryString.toString();
	}
	
	private static class Key<T> {
		String name;
		Key(String n) {
			name = n;
		}
	}

}
