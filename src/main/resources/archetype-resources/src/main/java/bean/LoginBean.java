package ${package}.bean;

import com.jsmart5.framework.util.WebAlert;
import com.jsmart5.framework.util.WebText;
import com.jsmart5.framework.manager.WebContext;
import com.jsmart5.framework.annotation.WebBean;
import com.jsmart5.framework.annotation.PreSubmit;

import org.apache.commons.lang.StringUtils;
import ${package}.auth.AuthBean;

import ${package}.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

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

        if (StringUtils.isBlank(email)) {
            WebContext.addAlert("login-error", getAlert(WebAlert.AlertType.DANGER,
                    WebText.getString("texts", "aa.archetype.invalid.email", email)));
            validated = false;
        }
        if (StringUtils.isBlank(password)) {
            WebContext.addAlert("login-error", getAlert(WebAlert.AlertType.DANGER,
                    WebText.getString("texts", "aa.archetype.invalid.password")));
            validated = false;
        }
        return validated;
    }

    public String doLogin() {
        String userName = springService.getUser(email, password);

        if (userName != null) {
            authBean.doAuth(userName, email);

            // Redirect to Home case login succeed
            return "/home";
        }

        WebContext.addAlert("login-error", getAlert(WebAlert.AlertType.WARNING,
                WebText.getString("texts", "aa.archetype.invalid.login",
                        SpringService.ADMIN_EMAIL, SpringService.USER_EMAIL)));

        // Return null to stay in the same page
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

    private WebAlert getAlert(WebAlert.AlertType type, String message) {
        WebAlert alert = new WebAlert(type);
        alert.setTitleIcon("glyphicon-fire");
        alert.setTitle(WebText.getString("texts", "aa.archetype.server.error"));
        alert.setMessage(message);
        return alert;
    }
}