<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: wangchong
  Date: 2019/9/4
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
    <%
        response.setHeader("Cache-control","no-cache");
        int width = 60, height = 20;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(255,200,255));
        g.fillRect(0,0,width,height);
        Random random = new Random();
        int randNum = random.nextInt(8999) + 1000;
        String randStr = String.valueOf(randNum);
        session.setAttribute("randStr",randStr);
        g.setColor(Color.black);
        g.setFont(new Font("",Font.PLAIN,20));
        g.drawString(randStr,10,17);
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.drawOval(x,y,1,1);
            ImageIO.write(image,"JPEG",response.getOutputStream());
            out.clear();
            out = pageContext.pushBody();
        }
    %>
</body>
</html>
