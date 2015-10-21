package ${package}.auth;

import com.jsmartframework.web.manager.WebContext;
import com.jsmartframework.web.annotation.AuthBean;
import com.jsmartframework.web.annotation.AuthField;
import com.jsmartframework.web.annotation.AuthAccess;

import java.io.Serializable;
import java.util.List;

import ${package}.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;

@AuthBean(loginPath="/login", homePath="/home")
public class MyAuthBean implements Serializable {

    @AuthField
    private String email;

    @AuthField
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