import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

    /** The main window of the program */
    private JFrame frame;
    /** The panel for the title of the window */
    private JPanel mainPanel;
    /** The overall title of the window */
    private JLabel title;
    /** The button that starts the quiz*/
    private JButton start;
    /** Click listener object to trigger events when buttons are clicked*/
    private ClickListener listener;
    
    //city buttons
    /** */
    private JButton cityButton;
    //countrysidebuttons
    /** */
    private JButton countryButton;
    /**
     * Constructor for FilmGuiViewer 
     * Constructs starting frame with panel, title label, and start button
     * Constructs ClickListener object to work with buttons when clicked
     */
    public FilmGuiViewer()
    {
        frame = new JFrame();
        mainPanel = new JPanel();
        title = new JLabel("Which Film Are You?");
        start = new JButton("Start Quiz");
        mainPanel.add(title);
        mainPanel.add(start);
        frame.add(mainPanel);

        //add in click listener
        listener = new ClickListener();
        //add listener to button to make button function 
        start.addActionListener(listener);

        frame.setSize(1600, 1600);
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
                addFirstPage();
            }

            if(event.getSource() == )
            {
                addCityPage();
            }
            else if(event.getSource() == )
            {
                addCountrysidePage();
            }

        }
    }

    public void addFirstPage()
    {
        //make new frame -- if button pushed, make it visible
        JFrame frame2 = new JFrame();
        JPanel panel1 = new JPanel();
        JLabel title = new JLabel("SCENERY");
        JLabel question = new JLabel("What is your ideal setting?");

        JButton b1 = new JButton("City");
        JButton b2 = new JButton("Countryside");
        b1.addActionListener(listener);
        b2.addActionListener(listener);

        panel1.add(title);
        panel1.add(question);
        panel1.add(b1);
        panel1.add(b2);

        frame2.add(panel1);
        
        frame2.setSize(1600, 1600);
        frame2.setTitle("FILM AND CHARACTER");
        frame2.setVisible(true);
    }

    public void addCityPage()
    {
        JFrame frame3 = new JFrame();
        JPanel panel2 = new JPanel();
        JLabel title = new JLabel("HOBBIES");
        JLabel question = new JLabel("What is your idea of a fun weekend?");

        JButton b1 = new JButton("City Shopping"); //The Devil Wears Prada
        JButton b2 = new JButton("Restaurant Hopping"); //Julie and Julia
        JButton b3 = new JButton("Art Gallery Walk"); //Midnight in Paris
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);

        panel2.add(title);
        panel2.add(question);
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);

        frame3.add(panel2);
        
        frame3.setSize(1600, 1600);
        frame3.setTitle("FILM AND CHARACTER");
        frame3.setVisible(true);
    }

    public void addCountrysidePage()
    {
        JFrame frame4 = new JFrame();
        JPanel panel3 = new JPanel();
        JLabel title = new JLabel("HOBBIES");
        JLabel question = new JLabel("What is your idea of a fun weekend?");

        JButton b1 = new JButton("Sports Game");//Wimbledon
        JButton b2 = new JButton("Taking a Hike"); //Under the Tuscan Sun
        JButton b3 = new JButton("Camping Outside"); //The Kings of Summer
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);

        panel3.add(title);
        panel3.add(question);
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);

        frame4.add(panel3);
        
        frame4.setSize(1600, 1600);
        frame4.setTitle("FILM AND CHARACTER");
        frame4.setVisible(true);
    }

    /**
     * Main method of FilmGuiViewer makes FilmGuiViewer object
     */
    public static void main(String[] args)
    {
        FilmGuiViewer firstViewer = new FilmGuiViewer();
    }

}
