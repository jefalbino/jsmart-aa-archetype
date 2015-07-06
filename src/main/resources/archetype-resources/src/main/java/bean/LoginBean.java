package ${package}.bean;

import com.jsmart5.framework.util.WebText;
import com.jsmart5.framework.manager.WebContext;
import com.jsmart5.framework.annotation.WebBean;
import com.jsmart5.framework.annotation.PreSubmit;

import java.util.Map;
import java.util.HashMap;

import ${package}.auth.AuthBean;

import ${package}.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;

@WebBean
public class LoginBean {

    @Autowired
    private SpringService springService;

    @Inject
    private AuthBean authBean;

    private String email;

    private String password;

    @PreSubmit(forAction = "doLogin")
    public boolean preLogin() {
        boolean validated = true;

        if (email == null || email.trim().isEmpty()) {
            //WebAlert alert = new WebAlert()
            //WebContext.addError("login-error", WebText.getString("texts", "basic.archetype.action.failure", inputValue));
            validated = false;
        }

        return validated;
    }

    public String doLogin() {


        return "/home";

        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}