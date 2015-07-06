package ${package}.auth;

import com.jsmart5.framework.manager.WebContext;
import com.jsmart5.framework.annotation.AuthenticateBean;
import com.jsmart5.framework.annotation.AuthenticateField;
import com.jsmart5.framework.annotation.AuthorizeAccess;

import java.util.List;
import java.util.ArrayList;

import ${package}.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;

@AuthenticateBean(loginPath="/login", homePath="/home")
public class AuthBean {

    @AuthenticateField
    private String email;

    @AuthenticateField
    private String name;

    @AuthorizeAccess
    private List<String> roles;

    @Autowired
    private SpringService springService;

    public void doAuth(String name, String email) {
        this.name = name;
        this.email = email;
        this.roles = springService.getUserRoles(name);
    }

    public void invalidateAuth() {
        email = null;
        name = null;
        roles = null;
        WebContext.invalidate();
    }
}