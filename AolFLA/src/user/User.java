package user;

import java.util.ArrayList;

public class User {
	private String userId, name, email, password;
	private static ArrayList<User> users = new ArrayList<>();
	
	public User(String userId, String name, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

	public static User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

	public static boolean register(String name, String email, String password) {
        if (getUserByEmail(email) != null) {
            System.out.println("Email is already registered.");
            return false;
        }

        String userId = "USER" + (users.size() + 1);
        User newUser = new User(userId, name, email, password);
        users.add(newUser);
        System.out.println("Registration successful! Welcome, " + name + "\n\n");
        return true;
    }

	public static boolean login(String email, String password) {
		User user = getUserByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome back, " + user.getName());
            return true;
        } else {
            System.out.println("Invalid email or password.\n\n");
            return false;
        }
	}
	
}
