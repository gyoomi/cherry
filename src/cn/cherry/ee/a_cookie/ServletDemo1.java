package cn.cherry.ee.a_cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ServletDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器端的编码方式
        response.setCharacterEncoding("UTF-8");
        //告知客户端浏览器采用什么类型的编码来解码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for(int i = 0; i < cookies.length; i++){
                if("lastAccessTime".equals(cookies[i].getName())){
                    out.print("上次访问时间：" + new Date(Long.valueOf(cookies[i].getValue())));
                }
            }
        }

        Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
        //存活时间
        ck.setMaxAge(60 * 5);
        //可以带着cookie的路径url配置
        ck.setPath("/");
        response.addCookie(ck);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
