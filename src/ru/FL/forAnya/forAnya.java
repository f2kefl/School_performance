package ru.FL.forAnya;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Created by F4keFLy on 18.12.2015.
 * fL
 */

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
        private JLabel begin;
        private JLabel[] labels;
        private JTextField[] textFields;
        private JLabel progress, quality, SOU, GPA, getProgress, getQuality, getSOU, getGPA;
        private JPanel[] panels;
        private JButton go;
        private double aa, bb, cc, dd, ee, ff;

        frame()
        {
            super("Рассчёт успеваемости");

            panels = new JPanel[4];
            labels = new JLabel[6];
            textFields = new JTextField[6];

            setLayout(new GridBagLayout());
            BgPanel pn = new BgPanel();
            setContentPane(pn);
            Container cont = getContentPane();
            cont.setLayout(new GridBagLayout());
            Font font = new Font("Verdana", Font.BOLD, 12);
            Font font1 = new Font("Verdana", Font.BOLD, 11);

            begin = new JLabel("<html>Здравствуйте, милейшая учительница!<br>" +
                    "Пожалуйста, введите данные для рассчёта.</html>");

            begin.setHorizontalAlignment(JLabel.CENTER);
            begin.setFont(font);
            begin.setForeground(Color.white);

            labels[0] = new JLabel("Всего");
            labels[1] = new JLabel("'5'");
            labels[2] = new JLabel("'4'");
            labels[3] = new JLabel("'3'");
            labels[4] = new JLabel("'2'");
            labels[5] = new JLabel("н/а");

            progress = new JLabel("Успеваемость:");
            quality = new JLabel("Качество:");
            SOU = new JLabel("СОУ:");
            GPA = new JLabel("Средний балл:");
            getProgress = new JLabel("0,00%");
            getQuality = new JLabel("0,00%");
            getSOU = new JLabel("0,00%");
            getGPA = new JLabel("0,00");

            for (int i = 0; i < textFields.length; i++) {
                textFields[i] = new JTextField(2);
                textFields[i].setFont(font);
                textFields[i].setForeground(Color.DARK_GRAY);
                labels[i].setForeground(Color.white);
            }

            go = new JButton("Рассчитать");
            go.setForeground(Color.BLACK);

            for (int i = 0; i < panels.length; i++) {

                panels[i] = new JPanel();
                panels[i].setOpaque(false);
            }

            panels[1].setLayout(new GridLayout(6, 2, 12, 6));
            panels[2].setLayout(new GridLayout(4, 2, 12, 6));

            cont.add(panels[0], new GridBagConstraints(0, 0, 6, 1, 1, 1, GridBagConstraints.NORTH,
                    GridBagConstraints.HORIZONTAL, new Insets(10, 1, 1, 1), 2, 2));
            cont.add(panels[1], new GridBagConstraints(0, 1, 2, 5, 1, 1, GridBagConstraints.SOUTHWEST,
                    GridBagConstraints.VERTICAL, new Insets(1, 40, 1, 2), 0, 0));
            cont.add(panels[2], new GridBagConstraints(1, 1, 3, 5, 1, 1, GridBagConstraints.SOUTHEAST,
                    GridBagConstraints.VERTICAL, new Insets(1, 1, 1, 2), 0, 0));
            cont.add(panels[3], new GridBagConstraints(0, 7, 5, 1, 1, 1, GridBagConstraints.SOUTH,
                    GridBagConstraints.HORIZONTAL, new Insets(1, 1, 10, 2), 0, 0));

            panels[0].add(begin);

            for (int i = 0; i < labels.length; i++) {
                panels[1].add(labels[i]);
                panels[1].add(textFields[i]);
            }

            panels[2].add(progress);
            panels[2].add(getProgress);
            panels[2].add(quality);
            panels[2].add(getQuality);
            panels[2].add(SOU);
            panels[2].add(getSOU);
            panels[2].add(GPA);
            panels[2].add(getGPA);

            panels[3].add(go);

            for (Component comp : panels[1].getComponents()) {
                comp.setFont(font1);
            }

            for (Component comp : panels[2].getComponents()) {
                comp.setFont(font1);
                comp.setForeground(Color.white);
            }

            DecimalFormatSymbols s = new DecimalFormatSymbols();
            s.setDecimalSeparator(',');
            DecimalFormat form = new DecimalFormat("#,##0.00", s);

            go.addActionListener(e1 -> {

                try {
                    aa = Double.valueOf(textFields[0].getText());
                    bb = Double.valueOf(textFields[1].getText());
                    cc = Double.valueOf(textFields[2].getText());
                    dd = Double.valueOf(textFields[3].getText());
                    ee = Double.valueOf(textFields[4].getText());
                    ff = Double.valueOf(textFields[5].getText());
                } catch (NumberFormatException ignored) {}

                getProgress.setText(String.valueOf(form.format(((bb + cc + dd) / aa) * 100)) + "%");
                getQuality.setText(String.valueOf(form.format(((bb + cc) / aa) * 100)) + "%");
                getSOU.setText(String.valueOf(form.format((bb * 100 + cc * 64 + dd * 36 + ee * 16 + ff * 7) / aa) + "%"));
                getGPA.setText(String.valueOf(form.format(((bb * 5 + cc * 4 + dd * 3 + ee * 2) / (bb + cc + dd + ee)))));
            });
        }
    }

    private static class BgPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            BufferedImage image = null;
            try {
                image = ImageIO.read(getClass().getResource("/bg.jpg"));
            } catch (IOException ignored) {
            }
            g.drawImage(image, 0, 0, null);
        }
    }
}
