package me.zwoosks;

import jaco.mp3.player.MP3Player;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Paths;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PlayerFrame extends javax.swing.JFrame {

    MP3Player player;
    File songFile;
    String currentDirectory = "home.user";
    String currentPath;
    String imagePath;
    String appName = "Zwoosks' MP3 Player";
    
    boolean repeat = false;
    boolean windowCollapsed = false;
    
    int xMouse, yMouse;
    
    public PlayerFrame() {
        initComponents();
        
        // Icon
        setIcon();
        
        // Define the app title
        appTitle.setText(appName);
        
        // Default song file
        songFile = new File("C:\\Users\\Super\\Desktop\\Iuri\\Songs\\Music.mp3");
        
        // Get the name of the file
        String fileName = songFile.getName();
        
        // Setting song name label
        songNameDisplay.setText(fileName);
        
        // Add the method to the player variable
        player = mp3Player();
        // Add song to player as playlist
        player.addToPlayList(songFile);
        
        // Get current path and images path in strings
        currentPath = Paths.get(".").toAbsolutePath().normalize().toString();
        imagePath = "\\images";
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        appTitle = new javax.swing.JLabel();
        quitBtn = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JLabel();
        songNameMainPanel = new javax.swing.JPanel();
        songNameSubpanel = new javax.swing.JPanel();
        songNameDisplay = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        pauseBtn = new javax.swing.JLabel();
        playBtn = new javax.swing.JLabel();
        stopBtn = new javax.swing.JLabel();
        volumeFullBtn = new javax.swing.JLabel();
        openBtn = new javax.swing.JLabel();
        volumeDownBtn = new javax.swing.JLabel();
        volumeUpBtn = new javax.swing.JLabel();
        muteBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(720, 320));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(7, 63, 86));

        headerPanel.setBackground(new java.awt.Color(36, 93, 116));

        appTitle.setFont(new java.awt.Font("OpineHeavy", 0, 14)); // NOI18N
        appTitle.setForeground(new java.awt.Color(34, 202, 237));
        appTitle.setText("MP3 Player by Zwoosks");
        appTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                appTitleMouseDragged(evt);
            }
        });
        appTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appTitleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appTitleMousePressed(evt);
            }
        });

        quitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/quit.png"))); // NOI18N
        quitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitBtnMouseClicked(evt);
            }
        });

        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/settings.png"))); // NOI18N
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(settingsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitBtn)
                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(settingsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        songNameMainPanel.setBackground(new java.awt.Color(7, 63, 86));

        songNameSubpanel.setBackground(new java.awt.Color(7, 63, 86));
        songNameSubpanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 200, 237), 3, true));

        songNameDisplay.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        songNameDisplay.setForeground(new java.awt.Color(34, 202, 237));
        songNameDisplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        songNameDisplay.setText("PLAYING");

        javax.swing.GroupLayout songNameSubpanelLayout = new javax.swing.GroupLayout(songNameSubpanel);
        songNameSubpanel.setLayout(songNameSubpanelLayout);
        songNameSubpanelLayout.setHorizontalGroup(
            songNameSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songNameSubpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(songNameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addContainerGap())
        );
        songNameSubpanelLayout.setVerticalGroup(
            songNameSubpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(songNameSubpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(songNameDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout songNameMainPanelLayout = new javax.swing.GroupLayout(songNameMainPanel);
        songNameMainPanel.setLayout(songNameMainPanelLayout);
        songNameMainPanelLayout.setHorizontalGroup(
            songNameMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(songNameMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(songNameMainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(songNameSubpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        songNameMainPanelLayout.setVerticalGroup(
            songNameMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
            .addGroup(songNameMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(songNameMainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(songNameSubpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        controlPanel.setBackground(new java.awt.Color(7, 63, 86));

        pauseBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/pause.png"))); // NOI18N
        pauseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseBtnMouseClicked(evt);
            }
        });

        playBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/play.png"))); // NOI18N
        playBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playBtnMouseClicked(evt);
            }
        });

        stopBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/stop.png"))); // NOI18N
        stopBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopBtnMouseClicked(evt);
            }
        });

        volumeFullBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeFullBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/volume_full.png"))); // NOI18N

        openBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        openBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/open.png"))); // NOI18N
        openBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openBtnMouseClicked(evt);
            }
        });

        volumeDownBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeDownBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/volume_down.png"))); // NOI18N

        volumeUpBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volumeUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/volume_up.png"))); // NOI18N

        muteBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        muteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/me/zwoosks/images/mute.png"))); // NOI18N

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(pauseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(volumeDownBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeUpBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volumeFullBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(muteBtn)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(pauseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volumeFullBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(muteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(volumeUpBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(stopBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(volumeDownBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(songNameMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(songNameMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void playBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // Play btn
        player.play();
    }                                    

    private void stopBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // Stop btn
        player.stop();
    }                                    

    private void pauseBtnMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // Pause btn
        player.pause();
    }                                     

    private void appTitleMousePressed(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }                                     

    private void appTitleMouseDragged(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }                                     

    private void quitBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        this.dispose();
    }                                    

    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(controlPanel, "Finish it");
    }                                        

    private void openBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        JFileChooser openFileChooser = new JFileChooser(currentDirectory);
        openFileChooser.setFileFilter(new FileTypeFilter(".mp3", "Open MP3 Files only!"));
        int result = openFileChooser.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            
            songFile = openFileChooser.getSelectedFile();
            player.addToPlayList(songFile);
            player.skipForward();
            currentDirectory = songFile.getAbsolutePath();
            songNameDisplay.setText("Playing now... | " + songFile.getName());
            
        }
    }                                    

    private void appTitleMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        if(evt.getClickCount() == 2) {
            
            if(windowCollapsed == false) {
                
                windowCollapsed = true;
                this.setSize(new Dimension(this.getSize().width, 50));
                
                appTitle.setFont(new Font("Nirmala UI", 0, 12));
                appTitle.setText("Playing now... | " + songFile.getName());
                
            } else if(windowCollapsed == true) {
                
                windowCollapsed = false;
                this.setSize(new Dimension(this.getSize().width, 320));
                
                appTitle.setFont(new Font("Nirmala UI", 0, 18));
                appTitle.setText(appName);
                
            }
            
        }
    }                                     

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel appTitle;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel muteBtn;
    private javax.swing.JLabel openBtn;
    private javax.swing.JLabel pauseBtn;
    private javax.swing.JLabel playBtn;
    private javax.swing.JLabel quitBtn;
    private javax.swing.JLabel settingsBtn;
    private javax.swing.JLabel songNameDisplay;
    private javax.swing.JPanel songNameMainPanel;
    private javax.swing.JPanel songNameSubpanel;
    private javax.swing.JLabel stopBtn;
    private javax.swing.JLabel volumeDownBtn;
    private javax.swing.JLabel volumeFullBtn;
    private javax.swing.JLabel volumeUpBtn;
    // End of variables declaration                   

    // Custom MP3 Player method
    private MP3Player mp3Player() {
        
        MP3Player mp3Player = new MP3Player();
        return mp3Player;
        
    }
    
    // Set volume down method
    private void volumeDownControl(Double valueToPlusMinus) {
        
        // Get mixer information from AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        
        // For loop to get all mixers
        for (Mixer.Info mixerInfo : mixers) {
            
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Get target line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            
            // For loop to list lines
            for(Line.Info lineInfo : lineInfos) {
                
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                
                // Use try exception for opening a line
                try {
                    
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Check
                    if(!opened) {
                        
                        // Open
                        line.open();
                        
                    }
                    
                    // Float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get the current volume
                    float currentVolume = volControl.getValue();
                    // Make a temp double variable and store valuePlusMinus
                    Double volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((float)currentVolume - (double)volumeToCut);
                    // Set this changed value into volume line
                    volControl.setValue(changedCalc);
                    
                } catch(LineUnavailableException | IllegalArgumentException e) {
                } finally {
                    
                    // Close the line if it's opened
                    if(line != null && !opened) {
                        
                        line.close();
                        
                    }
                    
                }
                
            }
            
        }
        
    }
    
    // Set volume up method
    private void volumeUpControl(Double valueToPlusMinus) {
        
        // Get mixer information from AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        
        // For loop to get all mixers
        for (Mixer.Info mixerInfo : mixers) {
            
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Get target line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            
            // For loop to list lines
            for(Line.Info lineInfo : lineInfos) {
                
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                
                // Use try exception for opening a line
                try {
                    
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Check
                    if(!opened) {
                        
                        // Open
                        line.open();
                        
                    }
                    
                    // Float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get the current volume
                    float currentVolume = volControl.getValue();
                    // Make a temp double variable and store valuePlusMinus
                    Double volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((float)currentVolume + (double)volumeToCut);
                    // Set this changed value into volume line
                    volControl.setValue(changedCalc);
                    
                } catch(LineUnavailableException | IllegalArgumentException e) {
                } finally {
                    
                    // Close the line if it's opened
                    if(line != null && !opened) {
                        
                        line.close();
                        
                    }
                    
                }
                
            }
            
        }
        
    }
    
    // Set volume method
    private void volumeControl(Double valueToPlusMinus) {
        
        // Get mixer information from AudioSystem
        Mixer.Info[] mixers = AudioSystem.getMixerInfo();
        
        // For loop to get all mixers
        for (Mixer.Info mixerInfo : mixers) {
            
            // Get Mixer
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            // Get target line
            Line.Info[] lineInfos = mixer.getTargetLineInfo();
            
            // For loop to list lines
            for(Line.Info lineInfo : lineInfos) {
                
                // Make a null line
                Line line = null;
                // Make a boolean as opened
                boolean opened = true;
                
                // Use try exception for opening a line
                try {
                    
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;
                    // Check
                    if(!opened) {
                        
                        // Open
                        line.open();
                        
                    }
                    
                    // Float control
                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
                    // Get the current volume
                    float currentVolume = volControl.getValue();
                    // Make a temp double variable and store valuePlusMinus
                    Double volumeToCut = valueToPlusMinus;
                    // Make a float and calculate the addition or subtraction in volume
                    float changedCalc = (float) ((double)volumeToCut);
                    // Set this changed value into volume line
                    volControl.setValue(changedCalc);
                    
                } catch(LineUnavailableException | IllegalArgumentException e) {
                } finally {
                    
                    // Close the line if it's opened
                    if(line != null && !opened) {
                        
                        line.close();
                        
                    }
                    
                }
                
            }
            
        }
        
    }
    
    private void setIcon() {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        
    }
    
}
