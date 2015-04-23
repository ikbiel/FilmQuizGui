import javax.swing.JButton;
import java.net.URL;

/**
 * Class creates an instance of a matching button to its film trailer link.
 * 
 * @author (ikbiel) 
 * @version (20 April 2015)
 */
public class UserChoices
{
   
    /** The button of user choice that chooses the film */
    private JButton button;
    /** The website link to the film that is chosen */
    private URL film;

    /**
     * Constructs button and URL instance variables.
     * 
     * @param JButton The button of user's choice that directs to film trailer
     * @param URL The website link that directs user to film trailer of choice.
     */
    public UserChoices(JButton button, URL film)
    {
        this.button = button;
        this.film = film;
    }
    
    /**
     * Constructs button instance variable. 
     * 
     * @param JButton The button of user's choice.
     */
    public UserChoices(JButton button)
    {
        this.button = button;

    }
    
    /** 
     * Returns the button the user has chosen that leads to a specific movie trailer.
     * 
     * @return JButton The button chosen by user to indicate film choice and hobby
     */
    
    public JButton getButton()
    {
        return button;
    }
    
    /** 
     * Returns the website link to the specific movie chosen for the user 
     * based on their final button choice
     * 
     * @return URL The URL website link to the correct film trailer based upon user choice
     */
    public URL getURL()
    {
        return film;   
    }
    
}
