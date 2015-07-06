package ${package}.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class SpringService {

    public static final String ADMIN_EMAIL = "admin@admin.com";

    public static final String USER_EMAIL = "user@user.com";

    public List<String> getUserRoles(String name) {
        List<String> roles = new ArrayList<String>();
        roles.add("user");
        if (name.contains("Administrator")) {
            roles.add("admin");
        }
        return roles;
    }

    public String getUser(String email, String password) {
        if (ADMIN_EMAIL.equals(email)) {
            return "Administrator";
        } else if (USER_EMAIL.equals(email)) {
            return "User";
        }
        return null;
    }
}
