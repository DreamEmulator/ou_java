package breukgui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import breuk.Breuk;

/**
 * User interface voor vereenvoudiging van enkele breuken
 * met grote teller en noemer, met het doel de efficiency van
 * twee algoritmen voor vereenvoudiging te onderzoeken.
 * De eerste twee breuken zijn gekozen als ongunstige gevallen
 * voor een naïef vereenvoudigingsalgoritme. De derde breuk is
 * een ongunstig geval voor het algoritme van Euclides.
 * Elke breuk heeft een knop die de vereenvoudiging start.
 * De knoppen voor de tweede en derde breuk zijn om te beginnen
 * disabled.
 */
public class GroteBreukenFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JButton groot1Knop;
  private JButton groot2Knop;
  private JButton groot3Knop;
  private JLabel tijd1Label;
  private JLabel tijd2Label;
  private JLabel tijd3Label;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GroteBreukenFrame frame = new GroteBreukenFrame();
          frame.setVisible(true);
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public GroteBreukenFrame() {
    initialize();
  }
  private void initialize() {
    setTitle("Grote breuken vereenvoudigen");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 389, 200);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getGroot1Knop());
    contentPane.add(getGroot2Knop());
    contentPane.add(getGroot3Knop());
    contentPane.add(getTijd1Label());
    contentPane.add(getTijd2Label());
    contentPane.add(getTijd3Label());
  }

  private JButton getGroot1Knop() {
    if (groot1Knop == null) {
    	groot1Knop = new JButton("<html>2147482661 / <br>2147473697</html>");
    	groot1Knop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    groot1KnopAction();
    	  }
    	});
    	groot1Knop.setBounds(16, 10, 122, 35);
    }
    return groot1Knop;
  }
  private JButton getGroot2Knop() {
    if (groot2Knop == null) {
    	groot2Knop = new JButton("<html> 9223372036854774893 /<br>9223372036854765809</html>");
    	groot2Knop.setEnabled(false);
    	groot2Knop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    groot2KnopAction();
    	  }
    	});
    	groot2Knop.setBounds(16, 55, 180, 35);
    }
    return groot2Knop;
  }
  private JButton getGroot3Knop() {
    if (groot3Knop == null) {
    	groot3Knop = new JButton("<html>4660046610375530309 / <br>7540113804746346429</html>");
    	groot3Knop.setEnabled(false);
    	groot3Knop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    groot3KnopAction();
    	  }
    	});
    	groot3Knop.setBounds(16, 100, 179, 35);
    }
    return groot3Knop;
  }
  private JLabel getTijd1Label() {
    if (tijd1Label == null) {
    	tijd1Label = new JLabel("Tijd:");
    	tijd1Label.setBounds(210, 10, 136, 32);
    }
    return tijd1Label;
  }
  private JLabel getTijd2Label() {
    if (tijd2Label == null) {
    	tijd2Label = new JLabel("Tijd:");
    	tijd2Label.setBounds(210, 55, 136, 32);
    }
    return tijd2Label;
  }
  private JLabel getTijd3Label() {
    if (tijd3Label == null) {
    	tijd3Label = new JLabel("Tijd:");
    	tijd3Label.setBounds(210, 100, 136, 32);
    }
    return tijd3Label;
  }
  
  /**
   * Deze methode probeert een breuk te vereenvoudigen met teller
   * en noemer in de buurt van Integer.MAX_VALUE en toont
   * vervolgens hoelang dat heeft geduurd. Teller en noemer
   * zijn relatief priem; de ggd is dus 1. 
   */
  private void groot1KnopAction() {
    groteBreuk(2147482661, 2147473697, tijd1Label);
  }
  
  /**
   * Deze methode probeert een breuk te vereenvoudigen met teller
   * en noemer in de buurt van Long.MAX_VALUE en toont
   * vervolgens hoelang dat heeft geduurd. Teller en noemer
   * zijn relatief priem; de ggd is dus 1. 
   */
  private void groot2KnopAction() {
    groteBreuk(9223372036854774893L, 9223372036854765809L, tijd2Label);
  }

  /**
   * Deze methode probeert een breuk te vereenvoudigen met teller
   * en noemer het 91-e respectievelijk het 92-e fibonaccigetal
   * (dit zijn de grootste fibonaccigetallen die in het type
   * long passen). Fibonaccigetallen zijn het meest ongunstige geval
   * voor het algoritme van Euclides.
   */
  private void groot3KnopAction() {
    groteBreuk(4660046610375530309L, 7540113804746346429L, tijd3Label);
  }
  
  /**
   * Private methode die een breuk maakt met de gegeven teller en
   * de gegeven noemer. De verstreken systeemtijd wordt getoond in
   * het gegeven label.
   * @param teller  de teller van de te vereenvoudigen breuk
   * @param noemer  de teller van de te vereenvoudigen breuk
   * @param tijdLabel  het label waarin de tijd moet worden getoond
   */
  private void groteBreuk(long teller, long noemer, JLabel tijdLabel) {
    Breuk breuk = new Breuk(teller, noemer);
    long start = System.currentTimeMillis();
    breuk.vereenvoudig();
    long eind = System.currentTimeMillis();
    tijdLabel.setText("Tijd: " + (eind - start));    
  }
}
