package web;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/** 生成随即的验证码，返回一张jpg格式的随即图片*/

public class CheckcodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("image/jpeg");
        
        /* 画图 */
        BufferedImage img = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        // 获得画笔 
        Graphics g = img.getGraphics();
        // 设置背景颜色
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        // 填充背景颜色
        g.fillRect(0, 0, 60, 20);
        // 设置前景颜色
        g.setColor(Color.black);
        // 生成随机数
        String number = String.valueOf(r.nextInt(999999));
        // 画到图片上
        g.drawString(number, 5, 15);
        
        /** 3.压缩输出图片 */
        /* 获得字节输出流，因为要输出的是图像压缩之后的字节数组，所以不能用PrintWriter */
        OutputStream os = resp.getOutputStream();
        // 压缩图片
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        encoder.encode(img);
        
        // 将生成的验证码绑定到session中
        HttpSession session = req.getSession();
        session.setAttribute("checkcode", number);
        
    }
}
