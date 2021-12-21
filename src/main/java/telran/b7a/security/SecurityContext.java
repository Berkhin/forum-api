package telran.b7a.security;

public interface SecurityContext {
	boolean addUser(UserProfile userProfile);

	UserProfile removeUser(String login);

	UserProfile getUser(String login);
}
