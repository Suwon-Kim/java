

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class MyMainTabbedPaneUI extends BasicTabbedPaneUI {

    private boolean tabsOverlapBorder = UIManager.getBoolean("TabbedPane.tabsOverlapBorder");

//    private Color SELECT_COLOR = new Color(57, 181, 215);
    private Color SELECT_COLOR = new Color(0xf0c022);
    private Color N_SELECT_COLOR = new Color(255, 255, 255);

    /*
    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        super.paintTabArea(g, tabPlacement, selectedIndex);
    }*/

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
//        g.setColor(SELECT_COLOR);
//        switch (tabPlacement) {
//            case LEFT:
//                g.drawLine(x, y, x, y + h - 1);
//                g.drawLine(x, y, x + w - 1, y);
//                g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
//                break;
//            case RIGHT:
//                g.drawLine(x, y, x + w - 1, y);
//                g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
//                g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
//                break;
//            case BOTTOM:
//                g.drawLine(x, y, x, y + h - 1);
//                g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
//                g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
//                break;
//            case TOP:
//            default:
//                g.drawLine(x, y, x, y + h - 1);
//                g.drawLine(x, y, x + w - 1, y);
//                g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
//        }
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient;
        switch (tabPlacement) {
            case LEFT:
                if (isSelected) {
                    gradient = new GradientPaint(x + 1, y, SELECT_COLOR, x + w, y, Color.WHITE, true);
                } else {
                    gradient = new GradientPaint(x + 1, y, N_SELECT_COLOR, x + w, y, Color.WHITE, true);
                }
                g2d.setPaint(gradient);
                g.fillRect(x + 1, y + 1, w - 1, h - 2);
                break;
            case RIGHT:
                if (isSelected) {
                    gradient = new GradientPaint(x + w, y, SELECT_COLOR, x + 1, y, Color.WHITE, true);
                } else {
                    gradient = new GradientPaint(x + w, y, N_SELECT_COLOR, x + 1, y, Color.WHITE, true);
                }
                g2d.setPaint(gradient);
                g.fillRect(x, y + 1, w - 1, h - 2);
                break;
            case BOTTOM:
                if (isSelected) {
                    gradient = new GradientPaint(x + 1, y + h, SELECT_COLOR, x + 1, y, Color.WHITE, true);
                } else {
                    gradient = new GradientPaint(x + 1, y + h, N_SELECT_COLOR, x + 1, y, Color.WHITE, true);
                }
                g2d.setPaint(gradient);
                g.fillRect(x + 1, y, w - 2, h - 1);
                break;
            case TOP:
            default:
                if (isSelected) {
                    gradient = new GradientPaint(x + 1, y, SELECT_COLOR, x + 1, y + h, Color.WHITE, true);
                } else {
                    gradient = new GradientPaint(x + 1, y, N_SELECT_COLOR, x + 1, y + h, Color.WHITE, true);
                }
                g2d.setPaint(gradient);
                g2d.fillRect(x + 1, y + 1, w - 2, h - 1);
        }

    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {

        int width = tabPane.getWidth();
        int height = tabPane.getHeight();
        Insets insets = tabPane.getInsets();
        Insets tabAreaInsets = getTabAreaInsets(tabPlacement);

        int x = insets.left;
        int y = insets.top;
        int w = width - insets.right - insets.left;
        int h = height - insets.top - insets.bottom;

        switch (tabPlacement) {
            case LEFT:
                x += calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                if (tabsOverlapBorder) {
                    x -= tabAreaInsets.right;
                }
                w -= (x - insets.left);
                break;
            case RIGHT:
                w -= calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                if (tabsOverlapBorder) {
                    w += tabAreaInsets.left;
                }
                break;
            case BOTTOM:
                h -= calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                if (tabsOverlapBorder) {
                    h += tabAreaInsets.top;
                }
                break;
            case TOP:
            default:
                y += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                if (tabsOverlapBorder) {
                    y -= tabAreaInsets.bottom;
                }
                h -= (y - insets.top);
        }

        paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        paintContentBorderBottomEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        paintContentBorderRightEdge(g, tabPlacement, selectedIndex, x, y, w, h);
    }

    @Override
    protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        g.setColor(SELECT_COLOR);
        g.drawLine(x, y, x, y + h - 2);
    }

    @Override
    protected void paintContentBorderTopEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        g.setColor(SELECT_COLOR);
        g.drawLine(x, y, x + w - 2, y);
    }

    @Override
    protected void paintContentBorderRightEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        g.setColor(SELECT_COLOR);
        g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
    } 

    @Override
    protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement, int selectedIndex, int x, int y, int w, int h) {
        g.setColor(SELECT_COLOR);
        g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
    }

    @Override
    protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
        return super.calculateTabWidth(tabPlacement, tabIndex, metrics) +55;
    }

    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
        return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) +5 ;
    }

}