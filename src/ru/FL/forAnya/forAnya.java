package ru.FL.forAnya;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class forAnya
{
    public static void main(String[] args)
    {
        frame frame = new frame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(350, 320));
        frame.setVisible(true);
    }

    public static class frame extends JFrame
    {
        private JLabel begin, sum, five, fore, three, two, na;
        private JTextField a, b, c, d, e, f;
        private JLabel progress, quality, SOU, GPA, getProgress, getQuality, getSOU, getGPA;
        private JPanel p1, p2, p3, p4;
        private JButton go;
        private double aa, bb, cc, dd, ee, ff;

        frame()
        {
            super("Ðàññ÷¸ò óñïåâàåìîñòè");

            setLayout(new GridBagLayout());
            BgPanel pn = new BgPanel();
            setContentPane(pn);
            Container cont = getContentPane();
            cont.setLayout(new GridBagLayout());

            begin = new JLabel("<html>Çäðàâñòâóéòå, ìèëåéøàÿ ó÷èòåëüíèöà!<br>" +
                                    "Ïîæàëóéñòà, ââåäèòå äàííûå äëÿ ðàññ÷¸òà.</html>");

            begin.setHorizontalAlignment(JLabel.CENTER);
            begin.setFont(new Font("Verdana", Font.BOLD, 12));
            begin.setForeground(Color.white);

            sum = new JLabel("Âñåãî");
            five = new JLabel("'5'");
            fore = new JLabel("'4'");
            three = new JLabel("'3'");
            two = new JLabel("'2'");
            na = new JLabel("í/à");

            progress = new JLabel("Óñïåâàåìîñòü:");
            quality = new JLabel("Êà÷åñòâî:");
            SOU = new JLabel("ÑÎÓ:");
            GPA = new JLabel("Ñðåäíèé áàëë:");
            getProgress = new JLabel("0,00%");
            getQuality = new JLabel("0,00%");
            getSOU = new JLabel("0,00%");
            getGPA = new JLabel("0,00");

            a = new JTextField(2);
            b = new JTextField(2);
            c = new JTextField(2);
            d = new JTextField(2);
            e = new JTextField(2);
            f = new JTextField(2);

            go  = new JButton("Ðàññ÷èòàòü");
            go.setForeground(Color.BLACK);

            p1 = new JPanel(); p3 = new JPanel();
            p2 = new JPanel(); p4 = new JPanel();

            p1.setOpaque(false);
            p2.setOpaque(false);
            p3.setOpaque(false);
            p4.setOpaque(false);

            p2.setLayout(new GridLayout(6, 2, 12, 6));
            p3.setLayout(new GridLayout(4, 2, 12, 6));

            cont.add(p1, new GridBagConstraints(0, 0, 6, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                    new Insets(10, 1, 1, 1), 2, 2));
            cont.add(p2, new GridBagConstraints(0, 1, 2, 5, 1, 1,
                    GridBagConstraints.SOUTHWEST, GridBagConstraints.VERTICAL,
                    new Insets(1, 50, 1, 2), 0, 0));
            cont.add(p3, new GridBagConstraints(1, 1, 3, 5, 1, 1,
                    GridBagConstraints.SOUTHEAST, GridBagConstraints.VERTICAL,
                    new Insets(1, 1, 1, 2), 0, 0));
            cont.add(p4, new GridBagConstraints(0, 7, 5, 1, 1, 1,
                    GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                    new Insets(1, 1, 10, 2), 0, 0));

            p1.add(begin);

            p2.add(sum); p2.add(a);
            p2.add(five); p2.add(b);
            p2.add(fore); p2.add(c);
            p2.add(three); p2.add(d);
            p2.add(two); p2.add(e);
            p2.add(na); p2.add(f);

            p3.add(progress); p3.add(getProgress);
            p3.add(quality); p3.add(getQuality);
            p3.add(SOU); p3.add(getSOU);
            p3.add(GPA); p3.add(getGPA);

            p4.add(go);

            for (Component comp: p2.getComponents()){
                comp.setFont(new Font("Verdana", Font.TRUETYPE_FONT, 11));
                comp.setForeground(Color.white);
            }
            a.setForeground(Color.DARK_GRAY);
            b.setForeground(Color.DARK_GRAY);
            c.setForeground(Color.DARK_GRAY);
            d.setForeground(Color.DARK_GRAY);
            e.setForeground(Color.DARK_GRAY);
            f.setForeground(Color.DARK_GRAY);
            for (Component comp: p3.getComponents()){
                comp.setFont(new Font("Verdana", Font.TRUETYPE_FONT, 11));
                comp.setForeground(Color.white);
            }

            DecimalFormatSymbols s = new DecimalFormatSymbols();
            s.setDecimalSeparator(',');
            DecimalFormat form = new DecimalFormat("#,##0.00", s);

            go.addActionListener(e1 -> {
                try
                {
                    aa = Double.valueOf(a.getText());
                    bb = Double.valueOf(b.getText());
                    cc = Double.valueOf(c.getText());
                    dd = Double.valueOf(d.getText());
                    ee = Double.valueOf(e.getText());
                    ff = Double.valueOf(f.getText());
                } catch (NumberFormatException ignored){}

                if (!a.getText().equals(""))
                {
                    getProgress.setText(String.valueOf(form.format(((bb+cc+dd)/aa)*100))+"%");
                    getQuality.setText(String.valueOf(form.format(((bb+cc)/aa)*100))+"%");
                    getSOU.setText(String.valueOf(form.format((bb*100+cc*64+dd*36+ee*16+ff*7)/aa)+"%"));
                    getGPA.setText(String.valueOf(form.format(((bb*5+cc*4+dd*3+ee*2)/(bb+cc+dd+ee)))));
                }else{
                    JOptionPane.showMessageDialog(null,"Áåñòîëî÷ü, ïðîâåðü ââåä¸ííûå äàííûå!");
                }

            });
        }
    }

    private static class BgPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            BufferedImage image = null;
            try
            {
                image = ImageIO.read(getClass().getResource("/bg.jpg"));
            } catch (IOException ignored)
            {
            }
            g.drawImage(image, 0, 0, null);
        }
    }
}
