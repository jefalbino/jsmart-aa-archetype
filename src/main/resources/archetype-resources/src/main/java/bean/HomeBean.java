package ${package}.bean;

import com.jsmart5.framework.annotation.WebBean;

import ${package}.auth.MyAuthBean;
import ${package}.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

@WebBean
public class HomeBean {

    @Autowired
    private SpringService springService;

    @Inject
    private MyAuthBean myAuthBean;

    public String doLogout() {
        myAuthBean.invalidateAuth();
        return "/login";
    }

}