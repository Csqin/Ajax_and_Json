package it.cast.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html;charset=utf-8");
        //设置服务器数据响应格式为Json
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");

        ObjectMapper om;
        Map<String,Object> map=new HashMap<String,Object>();
        if ("tom".contains(username))
        {
            //如果用户名重复
            map.put("userExsit",true);
            map.put("msg","当前用户名太受欢迎，请更换一个");

            om=new ObjectMapper();
            //Map集合转Json,并且发送到客户端
            om.writeValue(response.getWriter(),map);
        }
        else {
            //如果用户名不重复
            map.put("userExsit",false);
            map.put("msg","用户名可用");

            om=new ObjectMapper();
            //Map集合转Json,并且发送到客户端
            om.writeValue(response.getWriter(),map);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
