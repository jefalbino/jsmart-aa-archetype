package ${package}.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class SpringService {

    public List<String> getUserRoles(String name) {
        List<String> roles = new ArrayList<String>();
        roles.add('user');
        if (name.contains("Administrator")) {
            roles.add('admin');
        }
        return roles;
    }

    public String getUser(String email, String password) {
        if ("admin@admin.com".equals(email)) {
            return "Administrator";
        } else if ("user@user.com".equals(email)) {
            return "User";
        }
        return null;
    }
}
