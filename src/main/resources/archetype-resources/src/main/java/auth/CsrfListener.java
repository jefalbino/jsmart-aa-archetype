package ${package}.auth;

import com.jsmartframework.web.adapter.CsrfAdapter;
import com.jsmartframework.web.annotation.WebSecurity;
import com.jsmartframework.web.listener.CsrfRequestListener;

import javax.inject.Inject;

@WebSecurity
public class CsrfListener implements CsrfRequestListener {

    @Inject
    private MyAuthBean authBean;

    @Override
    public CsrfAdapter generateToken() {
        // This method is called every GET so you can generate
        // token per request or per session or per customer
        // You can decide how store your token by using session or any other mechanism
        return new CsrfAdapter("token_name", "token_value");
    }

    @Override
    public boolean isValidToken(CsrfAdapter csrfAdapter) {
        // This method is called per POST and here you can validate if the
        // token name and value is valid for this request
        return csrfAdapter.getName().equals("token_name") && csrfAdapter.getToken().equals("token_value");
    }
}