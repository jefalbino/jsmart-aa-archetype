package ${package}.bean;

import com.jsmart5.framework.annotation.WebBean;

import ${package}.service.SpringService;
import org.springframework.beans.factory.annotation.Autowired;

@WebBean
public class HomeBean {

    @Autowired
    private SpringService springService;


}
