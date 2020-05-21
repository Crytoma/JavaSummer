package IntermediateJava.OvalSlider;

import java.awt.*;
import javax.swing.*;

public class DrawOval extends JPanel 
{

        /**
    *
    */
    private static final long serialVersionUID = -1108560595184809157L;
    private int width = 10;
        private int height = 10;

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.fillOval(10, 10, width, height);

        }

        public void setWidthHeight(int w, int h)
        {
            width = (w >= 0 ? w : 10);
            height = (h >= 0 ? h : 10);
            repaint();
        }


        public Dimension getPrefferedSize()
        {
            return new Dimension(200,200);
        }

        public Dimension getMinimumSize()
        {
            return getPreferredSize();
        }
        
}




