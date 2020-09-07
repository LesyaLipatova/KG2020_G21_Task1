package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.blue);
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
        Polygon p = new Polygon();
        p.addPoint(x, y + 5);
        p.addPoint(x - 25, y + 12);
        p.addPoint(x, y + 20);
        g.fillPolygon(p);
    }
}