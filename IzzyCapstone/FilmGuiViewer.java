import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.WindowConstants;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URISyntaxException;
import java.awt.Window;

/**
 * Class containing executable frames with user choice buttons
 *  eventually leads to filim trailer after various quiz questions.
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
    //scenechoices
    /** User button that chooses scenery questions of quiz*/
    private JButton sceneChoice;
    //if user chooses city
    /** User button for choosing  scenery*/
    private JButton cityChoice;
    /** First city hobby button choice.*/
    private JButton cityb1;
    /** Second city hobby button choice.*/
    private JButton cityb2;
    /** Third city hobby button choice.*/
    private JButton cityb3;
    //if user chooses country
    /** User button for choosing countryside scenery*/
    private JButton countryChoice;
    /** First country hobby button choice.*/
    private JButton countryb1;
    /** Second country hobby button choice.*/
    private JButton countryb2;
    /** Third country hobby button choice.*/
    private JButton countryb3;
    /** Click listener object to trigger events when buttons are clicked*/
    private ClickListener listener;

    //Movie
    /** The button that chooses a specific movie*/
    private JButton movie;
    /** The website link to the movie trailer chosen*/
    private URL movieURL;

    /**  Array of all button/film link options*/
    private UserChoices[] choices = new UserChoices[6];

    /** Integer flag to keep track of how many button clicks have been used by user */
    private int buttonClicks = 0;


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
        /**
         * Class listens for click events in buttons
         *      Chooses next frame to make visible and final URL choice

         */
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == start && buttonClicks == 0)
            {
                addFirstPage().setVisible(true);
                buttonClicks++;                
                start = null;
            }

            if(event.getSource() != null && buttonClicks == 1 )
            {
                sceneChoice = (JButton)event.getSource();
                if(sceneChoice == cityChoice)
                {
                    addCityPage().setVisible(true);
                    buttonClicks++; // have to put inside each nested if - 
                    //otherwise getSource will jump to next if block
                }
                else if (sceneChoice == countryChoice)
                {
                    addCountrysidePage().setVisible(true);
                    buttonClicks++;
                }
                sceneChoice = null;
            }

            if(event.getSource() != null && buttonClicks == 2)
            {
                movie = (JButton)event.getSource();
                UserChoices user = new UserChoices(movie); //Object Oriented Design :)
                
                for(int i = 0; i < choices.length; i++)
                {
                    if(user.getButton() == choices[i].getButton())
                    {
                        movieURL = choices[i].getURL();

                        //addCityPage().setVisible(false);
                        //addCountrysidePage().setVisible(false);
                        playMovie(movieURL);
                        //MediaPlayer movie1 = new MediaPlayer(movieURL); //Using Object Oriented style :)
                        //movie1.play();

                    }

                }
            }
        }
    }

        /**
         * 
         * Method adds first frame after opening frame.
         * User chooses 'scenery' choice with JButtons.
         * 
         * @return JFrame The Scenery choice page of the user quiz.
         */
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
            frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            return frame2;
        }

        /**
         * Method adds City Scenery frame containing quiz question that leads to final film trailer
         * 
         * @return JFrame The City Scenery frame containing hobby questions
         */
        public JFrame addCityPage()
        {
            JFrame cityFrame = new JFrame();
            JPanel panel2 = new JPanel();
            JLabel title = new JLabel("CITY HOBBIES");
            JLabel question = new JLabel("What is your idea of a fun weekend?");

            cityb1 = new JButton("City Shopping"); 
            //Devil Wears Prada
            
            cityb2 = new JButton("Restaurant Hopping"); 
            //Chef 

            cityb3 = new JButton("Art Gallery Walk"); 
            //Midnight in Paris
            
            cityb1.addActionListener(listener);
            cityb2.addActionListener(listener);
            cityb3.addActionListener(listener);

            try
            {   choices[0] = new UserChoices(cityb1, new URL("http://trailers.apple.com/trailers/fox/thedevilwearsprada/"));
                choices[1] = new UserChoices(cityb2, new URL("http://trailers.apple.com/trailers/independent/chef/"));
                choices[2] = new UserChoices(cityb3, new URL("http://trailers.apple.com/trailers/sony/midnightinparis/"));
                choices[3] = new UserChoices(countryb1, new URL("http://trailers.apple.com/trailers/universal/friday_night_lights/large.html"));
                choices[4] = new UserChoices(countryb2, new URL("http://trailers.apple.com/trailers/fox/walk_the_line/medium.html"));
                choices[5] = new UserChoices(countryb3, new URL("http://trailers.apple.com/trailers/embed/thekingsofsummer/trailer/"));
            }
            catch (MalformedURLException exception)
            {
                System.out.println("Incorrect URL address. Program failed.");
            }

            panel2.add(title);
            panel2.add(question);
            panel2.add(cityb1);
            panel2.add(cityb2);
            panel2.add(cityb3);

            cityFrame.add(panel2);

            cityFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
            cityFrame.setTitle("FILM AND CHARACTER");
            cityFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            return cityFrame;
        }

        /**
         * Method adds Countryside Scenery frame containing quiz question that leads to final film trailer
         * 
         * @return JFrame The Countryside Scenery frame containing hobby questions
         */
        public JFrame addCountrysidePage()
        {
            JFrame countryFrame = new JFrame();
            JPanel panel3 = new JPanel();
            JLabel title = new JLabel("COUNTRY HOBBIES");
            JLabel question = new JLabel("What is your idea of a fun weekend?");

            countryb1 = new JButton("Sports Game");
            //Friday Night Lights

            countryb2 = new JButton("Music Festival"); 
            //Walk the Line

            countryb3 = new JButton("Camping Outside"); 
            //Kings of Summer

            countryb1.addActionListener(listener);
            countryb2.addActionListener(listener);
            countryb3.addActionListener(listener);

            try
            {
                choices[0] = new UserChoices(cityb1, new URL("http://trailers.apple.com/trailers/fox/thedevilwearsprada/"));
                choices[1] = new UserChoices(cityb2, new URL("http://trailers.apple.com/trailers/independent/chef/"));
                choices[2] = new UserChoices(cityb3, new URL("http://trailers.apple.com/trailers/sony/midnightinparis/"));
                choices[3] = new UserChoices(countryb1, new URL("http://trailers.apple.com/trailers/universal/friday_night_lights/large.html"));
                choices[4] = new UserChoices(countryb2, new URL("http://trailers.apple.com/trailers/fox/walk_the_line/medium.html"));
                choices[5] = new UserChoices(countryb3, new URL("http://trailers.apple.com/trailers/embed/thekingsofsummer/trailer/"));
            }
            catch (MalformedURLException exception)
            {
                System.out.println("Incorrect URL address. Program failed.");
            }
            panel3.add(title);
            panel3.add(question);
            panel3.add(countryb1);
            panel3.add(countryb2);
            panel3.add(countryb3);

            countryFrame.add(panel3);

            countryFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
            countryFrame.setTitle("FILM AND CHARACTER");
            countryFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            return countryFrame;
        }

        /**
         * Method returns FilmGuiViewer instance variable of UserChoices array containing all JButton and 
         * URL pairings to film trailer
         * 
         * @return UserChoices[] array of button and URL pairings
         */
        public UserChoices[] getOptions()
        {
            return this.choices;
        }
        
        /** Method opens default browser and enters website link of chosen film
         * 
         * @param URL The website link of the film chosen
           
           */
        public void playMovie(URL link) 
        {
            try
            {
                //switch to default browser and open link
                Desktop.getDesktop().browse(link.toURI());
                
            }
            catch(IOException e)
            {
                System.out.println("Program failed");
            }
            catch(URISyntaxException e)
            {
                System.out.println("Program failed");
            }


        }

        /**
         * Main method of FilmGuiViewer makes FilmGuiViewer object to run code
         */
        public static void main(String[] args)
        {
            FilmGuiViewer firstViewer = new FilmGuiViewer();
        }
    }
