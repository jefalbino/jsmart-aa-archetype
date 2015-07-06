package ${package}.bean;

import com.jsmart5.framework.annotation.WebBean;

import ${package}.auth.AuthBean;
import ${package}.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

@WebBean
public class HomeBean {

    @Autowired
    private SpringService springService;

    @Inject
    private AuthBean authBean;

    public String doLogout() {
        authBean.invalidateAuth();
        return "/login";
    }

}