package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.blue);
        // gr.drawLine(100, 100, 100, 100);
        // drawSun(gr, 100, 100, 20, 20, 100, Color.blue);
        // gr.fillOval(15, 15, 15, 15);
        Color lightBlue = new Color(150, 150, 255);
        drawBackground(gr, getWidth(), getHeight(), lightBlue, Color.LIGHT_GRAY);
        drawSnowman(gr, getWidth() / 2, getHeight() / 2);

    }

    public void drawBackground(Graphics g, int width, int height, Color c1, Color c2) {
        int hh = height / 2;
        g.setColor(c1);
        g.fillRect(0, 0, width, hh);
        g.setColor(c2);
        g.fillRect(0, hh, width, hh);
    }

    public void drawSnowman(Graphics g, int x, int y) {
        drawSnowmanBall(g, x, y + 140, 100, Color.BLACK, Color.WHITE);
        drawSnowmanBall(g, x, y, 80, Color.BLACK, Color.WHITE);
        drawSnowmanBall(g, x, y - 120, 60, Color.BLACK, Color.WHITE);
        drawSnowmanFace(g, x, y - 120, Color.BLACK, Color.ORANGE);
    }

    public void drawSnowmanBall(Graphics g, int x, int y, int r, Color stroke, Color fill) {
        g.setColor(fill);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);
        g.setColor(stroke);
        g.drawOval(x - r, y - r, 2 * r, 2 * r);
    }

    public void drawSnowmanFace(Graphics g, int x, int y, Color eyes, Color nose) {
        g.setColor(eyes);
        int r = 10;
        int x1 = x - r / 2;
        int y1 = y - r / 2;
        g.fillOval(x1 - 20, y1 - 20, r, r);
        g.fillOval(x1 + 20, y1 - 20, r, r);

        g.setColor(nose);
        g.drawLine(x, y + 5, x, y + 20);
        g.drawLine(x, y + 5, x - 25, y + 12);
        g.drawLine(x, y + 20, x - 25, y + 12);

    }

    public void drawArm(Graphics2D g, int x1, int y1, int x2, int y2) {

    }


    public static void drawSun(Graphics g, int x, int y, int r, int R, int n, Color c) {
        g.setColor(c);
        g.fillOval(x - r, y - r, r + r, r + r);
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n; i++) {
            double dx1 = r * Math.cos(da * i);
            double dy1 = r * Math.sin(da * i);
            double dx2 = R * Math.cos(da * i);
            double dy2 = R * Math.sin(da * i);
            g.drawLine(x + (int) dx1, y + (int) dy1, x + (int) dx2, x + (int) dy2);
        }
    }

   /* public static void drawKub (Graphics g, int x, int y, int x2, int y2, Color c) {
        g.setColor(c);

    }*/
}