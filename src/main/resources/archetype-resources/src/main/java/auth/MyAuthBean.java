package ${package}.auth;

import com.jsmartframework.web.manager.WebContext;
import com.jsmartframework.web.annotation.AuthBean;
import com.jsmartframework.web.annotation.AuthField;
import com.jsmartframework.web.annotation.AuthAccess;
import com.jsmartframework.web.annotation.AuthMethod;

import java.util.List;

import ${package}.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;

// Provide your own secretKey instead of the default from JSmart
@AuthBean(loginPath="/login", homePath="/home", secretKey = "WrnMAE2IXEW4jwew")
public class MyAuthBean {

    @AuthField("email")
    private String email;

    @AuthField("name")
    private String name;

    @AuthAccess
    private List<String> roles;

    @Autowired
    private SpringService springService;

    public void doAuth(String name, String email) {
        this.name = name;
        this.email = email;
        this.roles = springService.getUserRoles(name);
    }

    @AuthMethod
    public boolean isAuthenticated() {
        // Here you should consult the database or other mechanism to
        // validate if the authentication is valid
        roles = springService.getUserRoles(name);
        return name != null && email != null && !roles.isEmpty();
    }

    public void invalidateAuth() {
        email = null;
        name = null;
        roles = null;
        WebContext.invalidate();
    }

    public String getName() {
        return name;
    }
}