import java.net.URL;
import javax.swing.JFrame;
import java.lang.*;
/**
 * Write a description of class MediaPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MediaPlayer extends JFrame 
{

    /**
     * Default constructor for objects of class MediaPlayer
     */
    public MediaPlayer(URL filmChoice)
    {
        Player mediaPlayer = Manager.createRealizedPlayer(filmChoice);
        Component video = mediaPlayer.getVisualComponent();
        Component controls = mediaPlayer.getControlPanelComponent();
        add(video);
        add(controls);
    }



}
