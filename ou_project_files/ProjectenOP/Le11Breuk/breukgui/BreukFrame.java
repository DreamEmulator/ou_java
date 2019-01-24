package breukgui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import breuk.Breuk;

/*
 * Deze klasse biedt een gebruikersinterface op de klasse Breuk.
 * De gebruiker kan een teller en een noemer invoeren en
 * de breuk laten vereenvoudigen.
 */
public class BreukFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JTextField tellerVeld;
  private JTextField noemerVeld;
  private JLabel streepLabel;
  private JButton vereenvoudigKnop;
  private JLabel foutLabel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          BreukFrame frame = new BreukFrame();
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
  public BreukFrame() {
    initialize();
  }
  private void initialize() {
    setTitle("Breuken vereenvoudigen");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 350, 199);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getTellerVeld());
    contentPane.add(getNoemerVeld());
    contentPane.add(getStreepLabel());
    contentPane.add(getVereenvoudigKnop());
    contentPane.add(getFoutLabel());
  }
  private JTextField getTellerVeld() {
    if (tellerVeld == null) {
    	tellerVeld = new JTextField();
    	tellerVeld.setBounds(17, 15, 74, 35);
    	tellerVeld.setColumns(10);
    }
    return tellerVeld;
  }
  private JTextField getNoemerVeld() {
    if (noemerVeld == null) {
    	noemerVeld = new JTextField();
    	noemerVeld.setColumns(10);
    	noemerVeld.setBounds(17, 75, 74, 35);
    }
    return noemerVeld;
  }
  private JLabel getStreepLabel() {
    if (streepLabel == null) {
    	streepLabel = new JLabel("_______");
    	streepLabel.setFont(new Font("Elephant", Font.BOLD, 24));
    	streepLabel.setBounds(5, 30, 98, 41);
    }
    return streepLabel;
  }
  private JButton getVereenvoudigKnop() {
    if (vereenvoudigKnop == null) {
    	vereenvoudigKnop = new JButton("Vereenvoudig");
    	vereenvoudigKnop.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	    vereenvoudigKnopAction();
    	  }
    	});
    	vereenvoudigKnop.setBounds(116, 50, 122, 29);
    }
    return vereenvoudigKnop;
  }
  private JLabel getFoutLabel() {
    if (foutLabel == null) {
    	foutLabel = new JLabel("");
    	foutLabel.setForeground(Color.RED);
    	foutLabel.setBounds(5, 120, 249, 25);
    }
    return foutLabel;
  }
  
  /*
   * Maakt een breuk aan met de teller en noemer uit tellerVeld en
   * noemerVeld, roept daarop de methode vereenvoudig aan en toont
   * teller en noemer in hun respecievelijke velden.
   * Als de teller negatief is of de noemer niet positief, volgt een
   * foutmelding.
   */
  private void vereenvoudigKnopAction() {
    foutLabel.setText("");
    int teller = Integer.parseInt(tellerVeld.getText());
    int noemer = Integer.parseInt(noemerVeld.getText());
    if (noemer <= 0) {
      foutLabel.setText("Noemer moet positief zijn");
    }
    else if (teller < 0) {
      foutLabel.setText("Teller mag niet negatief zijn");
    }
    else {
      Breuk breuk = new Breuk(teller, noemer);    
      if (breuk != null) {
        breuk.vereenvoudig();
        tellerVeld.setText(breuk.getTeller() + "");
        noemerVeld.setText(breuk.getNoemer() + "");
      }
    }
  }
}
