import java.net.URL;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.WindowConstants;
/**
 * Creates Mini browser to play film clip of viewer's choice.
 * Influenced by Christopher Deckers with help of his class JWebBrowser.
   */
public class MediaPlayer
{
    /** URL assigned to play inside frame*/
    private URL film;

    /**
     * Default constructor declares URL film instance variable
       */
    public MediaPlayer(URL film)
    {
        this.film = film;
    }

    /**
     * Main method of program. Runs NativeInterface to open new window for film. 
       */
    public void play()
    {
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable()
            {
                /**
                 * Method creates new frame and adds movie inside.*/
                public void run() 
                {
                    JFrame frame = new JFrame("Your Movie");
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.getContentPane().add(getBrowserPanel(film), BorderLayout.CENTER);
                    frame.setSize(800, 800);
                    frame.setVisible(true);
                }
            });
        NativeInterface.runEventPump();
        //properly close native components
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
                {
                    @Override
                    public void run() 
                    {
                        NativeInterface.close();
                    }
                }));
    }

    /**
     * Method creates new webbrowser for video to play.
     * 
     * @return JPanel A panel for new frame.
       */
    public static JPanel getBrowserPanel(URL film)
    {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        webBrowser.setBarsVisible(false);
        webBrowser.navigate("");
        return webBrowserPanel;
    }

}




