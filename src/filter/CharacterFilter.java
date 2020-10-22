package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 *
 * 过滤转账页面中的信息，防止中文乱码
 *
 */

@WebFilter(urlPatterns = {"/transfer","/modify","/payment","/manage"})
public class CharacterFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
