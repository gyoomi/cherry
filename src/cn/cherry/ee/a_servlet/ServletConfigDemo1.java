package cn.cherry.ee.a_servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取的servletConfig配置的方法一
 */
public class ServletConfigDemo1 extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1:
        /* String val = config.getInitParameter("encoding");
        System.out.println(val);*/
        String val2 = this.getServletConfig().getInitParameter("encoding");
        String val3 = this.getInitParameter("encoding");
        System.out.println(val2);
        System.out.println(val3);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
