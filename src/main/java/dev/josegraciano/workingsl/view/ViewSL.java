package dev.josegraciano.workingsl.view;

import dev.josegraciano.workingsl.WorkingSL;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewSL {
    private static final Logger LOGGER = Logger.getLogger( ViewSL.class.getName() );
    public ViewSL() {
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            JDialog dialog = new JDialog();
            dialog.setVisible(true);
            dialog.setTitle("  WorkingSL 1.0");
            dialog.setResizable(false);
            dialog.setAlwaysOnTop(true);
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

            JPanel contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            dialog.setContentPane(contentPane);

            SpringLayout layout = new SpringLayout();
            contentPane.setLayout(layout);

            BufferedImage img = Thumbnails.of(ImageIO.read(getClass().getClassLoader().getResource("resources/laptop.png"))).size(screenSize.width / 8, screenSize.width / 8).asBufferedImage();

            JLabel imgLabel = new JLabel();
            imgLabel.setSize(256, 256);
            imgLabel.setIcon(new ImageIcon(img));
            layout.putConstraint(SpringLayout.NORTH, imgLabel, 20, SpringLayout.NORTH, contentPane);
            layout.putConstraint(SpringLayout.WEST, imgLabel, 80, SpringLayout.WEST, contentPane);
            contentPane.add(imgLabel);

            Font f20 = new Font("SansSerif", Font.BOLD, 20);
            Font f40 = new Font("SansSerif", Font.BOLD, 40);

            JLabel lblTitle1 = new JLabel("WorkingSL 1.0");
            lblTitle1.setFont(f40);
            layout.putConstraint(SpringLayout.NORTH, lblTitle1, 40, SpringLayout.NORTH, contentPane);
            layout.putConstraint(SpringLayout.WEST, lblTitle1, 310, SpringLayout.WEST, contentPane);
            contentPane.add(lblTitle1);

            JLabel lblTitle2 = new JLabel("keep working ...");
            lblTitle2.setFont(f20);
            layout.putConstraint(SpringLayout.NORTH, lblTitle2, 120, SpringLayout.NORTH, contentPane);
            layout.putConstraint(SpringLayout.WEST, lblTitle2, 310, SpringLayout.WEST, contentPane);
            contentPane.add(lblTitle2);

            JLabel lblTitle3 = new JLabel("even over coffee!");
            lblTitle3.setFont(f20);
            layout.putConstraint(SpringLayout.NORTH, lblTitle3, 180, SpringLayout.NORTH, contentPane);
            layout.putConstraint(SpringLayout.WEST, lblTitle3, 415, SpringLayout.WEST, contentPane);
            contentPane.add(lblTitle3);

            final URI siteUri = new URI("https://www.josegraciano.dev/");
            final JLabel linkSite = new JLabel("josegraciano.dev");
            linkSite.setForeground(Color.blue);
            linkSite.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    linkSite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    linkSite.setToolTipText("https://www.josegraciano.dev/");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    linkSite.setCursor(Cursor.getDefaultCursor());
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(siteUri);
                        } catch (IOException ex) {
                            LOGGER.log(Level.SEVERE, ex.toString(), ex.getStackTrace());
                        }
                    }
                }
            });
            layout.putConstraint(SpringLayout.SOUTH, linkSite, -5, SpringLayout.SOUTH, contentPane);
            layout.putConstraint(SpringLayout.EAST, linkSite, -5, SpringLayout.EAST, contentPane);
            //contentPane.add(linkSite); TODO removido até o site estar pronto

            final URI ghUri = new URI("https://github.com/josegraciano/WorkingSL");
            BufferedImage ghImg = Thumbnails.of(ImageIO.read(getClass().getClassLoader().getResource("resources/gh.png"))).size(screenSize.width / 60, screenSize.width / 60).asBufferedImage();
            final JLabel ghLabel = new JLabel();
            ghLabel.setIcon(new ImageIcon(ghImg));
            ghLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    ghLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    ghLabel.setToolTipText("https://github.com/josegraciano/WorkingSL");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    ghLabel.setCursor(Cursor.getDefaultCursor());
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (Desktop.isDesktopSupported()) {
                        try {
                            Desktop.getDesktop().browse(ghUri);
                        } catch (IOException ex) {
                            LOGGER.log(Level.SEVERE, ex.toString(), ex.getStackTrace());
                        }
                    }
                }
            });
            layout.putConstraint(SpringLayout.SOUTH, ghLabel, -5, SpringLayout.SOUTH, contentPane);
            layout.putConstraint(SpringLayout.EAST, ghLabel, -5, SpringLayout.EAST, contentPane);
            contentPane.add(ghLabel);

            JLabel slideLabel = new JLabel("Selecione e aplique o período de execução do SL (em minutos):");
            layout.putConstraint(SpringLayout.SOUTH, slideLabel, -160, SpringLayout.SOUTH, contentPane);
            layout.putConstraint(SpringLayout.WEST, slideLabel, 55, SpringLayout.WEST, contentPane);
            contentPane.add(slideLabel);

            final JSlider slider = new JSlider(1,15,2);
            slider.setMajorTickSpacing(1);
            slider.setPaintLabels(true);
            slider.setPaintTicks(true);
            layout.putConstraint(SpringLayout.NORTH, slider, 30, SpringLayout.NORTH, slideLabel);
            layout.putConstraint(SpringLayout.WEST, slider, 50, SpringLayout.WEST, contentPane);
            layout.putConstraint(SpringLayout.EAST, slider, -50, SpringLayout.EAST, contentPane);
            contentPane.add(slider);

            Font fb = new Font("SansSerif", Font.BOLD, 14);
            final JLabel runningLabel = new JLabel("Parado");
            runningLabel.setFont(fb);
            runningLabel.setForeground(new Color(110, 0, 0));
            layout.putConstraint(SpringLayout.SOUTH, runningLabel, -35, SpringLayout.SOUTH, contentPane);
            layout.putConstraint(SpringLayout.WEST, runningLabel, 320, SpringLayout.WEST, contentPane);
            contentPane.add(runningLabel);

            final JButton startButton = new JButton("Iniciar"); //text: Aplicar - se app executar automaticamente ao iniciar
            startButton.setPreferredSize(new Dimension(100, 30));
            startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            startButton.setFocusable(false);
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int delay = slider.getValue() * 60000; //1000 = 1min - 60000 = 1min
                    startButton.setText("Aplicar");
                    WorkingSL.StartTask(delay);
                    runningLabel.setText("Executando...");
                    runningLabel.setForeground(new Color(0, 110, 0));
                }
            });
            layout.putConstraint(SpringLayout.SOUTH, startButton, -30, SpringLayout.SOUTH, contentPane);
            layout.putConstraint(SpringLayout.WEST, startButton, 50, SpringLayout.WEST, contentPane);
            contentPane.add(startButton);

            JButton stopButton = new JButton("Parar");
            stopButton.setPreferredSize(new Dimension(100, 30));
            stopButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            stopButton.setFocusable(false);
            stopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startButton.setText("Iniciar");
                    WorkingSL.StopTask();
                    runningLabel.setText("Parado");
                    runningLabel.setForeground(new Color(110, 0, 0));
                }
            });
            layout.putConstraint(SpringLayout.SOUTH, stopButton, -30, SpringLayout.SOUTH, contentPane);
            layout.putConstraint(SpringLayout.WEST, stopButton, 180, SpringLayout.WEST, contentPane);
            contentPane.add(stopButton);

            dialog.setContentPane(contentPane);
            dialog.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("resources/icon.png")).getImage());
            dialog.pack();
            dialog.setSize(screenSize.width / 2 ,screenSize.height / 2);
            dialog.setLocationRelativeTo(null);
        } catch (IIOException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e.getStackTrace());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e.getStackTrace());
        }
    }

    public static Runnable threadView = new Runnable() {
        public void run() {
            new ViewSL();
        }
    };
}
