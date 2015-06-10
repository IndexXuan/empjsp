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

/** �����漴����֤�룬����һ��jpg��ʽ���漴ͼƬ*/

public class CheckcodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("image/jpeg");
        
        /* ��ͼ */
        BufferedImage img = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
        // ��û��� 
        Graphics g = img.getGraphics();
        // ���ñ�����ɫ
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        // ��䱳����ɫ
        g.fillRect(0, 0, 60, 20);
        // ����ǰ����ɫ
        g.setColor(Color.black);
        // ���������
        String number = String.valueOf(r.nextInt(999999));
        // ����ͼƬ��
        g.drawString(number, 5, 15);
        
        /** 3.ѹ�����ͼƬ */
        /* ����ֽ����������ΪҪ�������ͼ��ѹ��֮����ֽ����飬���Բ�����PrintWriter */
        OutputStream os = resp.getOutputStream();
        // ѹ��ͼƬ
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        encoder.encode(img);
        
        // �����ɵ���֤��󶨵�session��
        HttpSession session = req.getSession();
        session.setAttribute("checkcode", number);
        
    }
}
