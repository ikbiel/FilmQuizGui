import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.WindowConstants;
import java.net.URL;

/**
 * Class that contains main method for program and creates frame containing component.
 * 
 * @author (ikbiel) 
 * @version (13 April 2015)
 */
public class FilmGuiViewer 
{
    /** Width of window frame */
    private static final int FRAME_WIDTH = 1600;
    /** Height of window frame */
    private static final int FRAME_HEIGHT = 1600;
    
    //mainpage
    /** The beginning window of the program */
    private JFrame frame;
    /** The button that starts the quiz*/
    private JButton start;

    /** User button that chooses scenery questions of quiz*/
    private JButton sceneChoice;
    //if user chooses city
    /** User button for choosing  scenery*/
    private JButton cityChoice;
    //if user chooses country
    /** User button for choosing countryside scenery*/
    private JButton countryChoice;
    
    /** Click listener object to trigger events when buttons are clicked*/
    private ClickListener listener;
    
    
    
    //Movie
    /** The button that chooses a specific movie*/
    private JButton movie;
    /** The website link to the movie trailer chosen*/
    URL movieURL;
    
    /**
     * Constructor for FilmGuiViewer 
     * Constructs starting frame with panel, title label, and start button
     * Constructs ClickListener object to work with buttons when clicked
     */
    public FilmGuiViewer()
    {
        frame = new JFrame();
        JPanel mainPanel = new JPanel();
        JLabel title = new JLabel("Which Film Are You?");
        start = new JButton("Start Quiz");
        mainPanel.add(title);
        mainPanel.add(start);
        frame.add(mainPanel);

        //add in click listener
        listener = new ClickListener();
        //add listener to button to make button function 
        start.addActionListener(listener);

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("FILM AND CHARACTER");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Inner class of FilmGuiViewer that waits for user to click a button and generates
     *   event specific to the button pushed
     */
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == start)
            {
                addFirstPage().setVisible(true);
                if(event.getSource() != null)
                {
                     sceneChoice = (JButton)event.getSource();
                     
                     if(sceneChoice == cityChoice)
                     {
                         addCityPage().setVisible(true);
                        }
                     else 
                     {
                         addCountrysidePage().setVisible(true);
                        }
                        
                     if(event.getSource() != null)
                     {
                         movie = (JButton)event.getSource();
                         MediaPlayer myMovie = new MediaPlayer
                        }
                }
            }



        }
    }
    

    public JFrame addFirstPage()
    {
        //make new frame -- if button pushed, make it visible
        JFrame frame2 = new JFrame();
        JPanel panel1 = new JPanel();
        JLabel title = new JLabel("SCENERY");
        JLabel question = new JLabel("What is your ideal setting?");

        cityChoice = new JButton("City");
        countryChoice = new JButton("Countryside");
        cityChoice.addActionListener(listener);
        countryChoice.addActionListener(listener);

        panel1.add(title);
        panel1.add(question);
        panel1.add(cityChoice);
        panel1.add(countryChoice);

        frame2.add(panel1);
        
        frame2.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame2.setTitle("FILM AND CHARACTER");
        frame2.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        return frame2;
    }

    public JFrame addCityPage()
    {
        JFrame cityFrame = new JFrame();
        JPanel panel2 = new JPanel();
        JLabel title = new JLabel("HOBBIES");
        JLabel question = new JLabel("What is your idea of a fun weekend?");

        JButton b1 = new JButton("City Shopping"); 
        //https://www.youtube.com/watch?v=LG0xYJJbko8
        JButton b2 = new JButton("Restaurant Hopping"); 
        //https://www.youtube.com/watch?v=ozRK7VXQl-k
        JButton b3 = new JButton("Art Gallery Walk"); 
        //https://www.youtube.com/watch?v=FAfR8omt-CY
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);

        panel2.add(title);
        panel2.add(question);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);

        cityFrame.add(panel2);
        
        cityFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        cityFrame.setTitle("FILM AND CHARACTER");
        cityFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        return cityFrame;
    }

    public JFrame addCountrysidePage()
    {
        JFrame countryFrame = new JFrame();
        JPanel panel3 = new JPanel();
        JLabel title = new JLabel("HOBBIES");
        JLabel question = new JLabel("What is your idea of a fun weekend?");

        JButton b1 = new JButton("Sports Game");
        //https://www.youtube.com/watch?v=0fKtglMo5qw
        JButton b2 = new JButton("Taking a Hike"); 
        //https://www.youtube.com/watch?v=vdJGMZDY0-8
        JButton b3 = new JButton("Camping Outside"); 
        //https://www.youtube.com/watch?v=GoPPhItyA74
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);

        panel3.add(title);
        panel3.add(question);
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);

        countryFrame.add(panel3);
        
        countryFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        countryFrame.setTitle("FILM AND CHARACTER");
        countryFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        return countryFrame;
    }

    /**
     * Main method of FilmGuiViewer makes FilmGuiViewer object
     */
    public static void main(String[] args)
    {
        FilmGuiViewer firstViewer = new FilmGuiViewer();
    }

}
