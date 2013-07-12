
package esendex.sdk.java.service.auth;

// TODO: Auto-generated Javadoc
/**
 * Simple holder for a user/password pair.  Used for Basic Authentication and
 * initial aquisition of a session for Session Authentication. 
 * @author Mike Whittaker
 */
public final class UserPassword {
	
	private String user;
	private String password;

	/**
	 * Creates a UserPassword with the provided arguments.
	 * @param user must not be null
	 * @param password must not be null
	 */
	public UserPassword(String user, String password) {
		if (user == null || password == null) throw new NullPointerException(
				"'user' and 'password' must not be null");
		this.user = user;
		this.password = password;
	}

	/**
	 * Creates a UserPassword with empty String fields. A safe non authenticating
	 * object.
	 */
	public UserPassword() {
		this.user = "";
		this.password = "";
	}

	/**
	 * Retrieve the user.
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Retrieve the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof UserPassword)) return false;
		UserPassword that = (UserPassword)obj;
		return this.user.equals(that.user) 
			&& this.password.equals(that.password);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 37 * result + user.hashCode();
		result = 37 * result + password.hashCode();
		return result;
	}
}
