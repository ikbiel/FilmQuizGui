import javax.swing.JButton;
import java.net.URL;

/**
 * Write a description of class UserChoices here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserChoices
{
    
    /** The button of user choice that chooses the film */
    private JButton finalChoice;
    /** The website link to the film that is chosen */
    private URL filmLink;

    /**
     * Default constructor for objects of class FinalChoiceFilm
     */
    public UserChoices(JButton button, URL link)
    {
        finalChoice = button;
        filmLink = link;
    }
    
    //make array of button choices?
    //make array of url choices?

    

}
