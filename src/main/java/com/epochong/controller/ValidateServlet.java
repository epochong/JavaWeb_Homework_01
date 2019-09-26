package com.epochong.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author epochong
 * @date 2019/9/4 20:17
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
@WebServlet(urlPatterns = "/ValidateServlet")
public class ValidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String randStr = (String) session.getAttribute("randStr");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if (userName.equals("") || password.equals("") || email.equals("")) {
            writer.println("<script>\n" +
                    "    alert(\"信息不能有空\");\n" +
                    "    window.location.href = \"/RegisterForm.html\" ;\n" +
                    "</script>");
        }
        int passwordLen = password.length();
        int removeLen = password.replaceAll("[0-9]","").replaceAll("[a-zA-Z]","").length();
        if (removeLen != 0){
            writer.println("<script>\n" +
                    "    alert(\"密码必须包含数字和字符\");\n" +
                    "    window.location.href = \"/RegisterForm.html\" ;\n" +
                    "</script>");
        }
        int atIndex = email.indexOf("@");
        int dotIndex = email.indexOf(".");
        if (atIndex < 1 || atIndex + 2 > dotIndex || dotIndex + 2 >= email.length()) {
            writer.println("<script>\n" +
                    "    alert(\"邮箱格式不正确！\");\n" +
                    "    window.location.href = \"/RegisterForm.html\" ;\n" +
                    "</script>");
        }
        if (!code.equals(randStr)) {
            writer.println("<script>\n" +
                    "    alert(\"验证码错误，请重新输入！\");\n" +
                    "    window.location.href = \"/RegisterForm.html\" ;\n" +
                    "</script>");
        } else {
            writer.println("<script>\n" +
                    "    alert(\"注册成功！\");\n" +
                    "    window.location.href = \"/RegisterForm.html\" ;\n" +
                    "</script>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
