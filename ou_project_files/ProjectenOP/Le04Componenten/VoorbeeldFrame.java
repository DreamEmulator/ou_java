import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

/**
 * Deze gui-klasse bevat een label, een knop, een tekstveld,
 * een tekstgebied en een keuzelijst; puur om te laten zien
 * hoe die er uit zien.
 * @author Medewerker OU
 */
public class VoorbeeldFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JLabel voorbeeldLabel;
  private JButton voorbeeldKnop;
  private JTextField voorbeeldVeld;
  private JTextArea voorbeeldGebied;
  private JComboBox voorbeeldKeuze;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          VoorbeeldFrame frame = new VoorbeeldFrame();
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
  public VoorbeeldFrame() {
    initialize();
    mijnInit();
  }
  private void initialize() {
    setTitle("Enkele Swing-componenten");
    setBounds(new Rectangle(0, 0, 336, 306));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getVoorbeeldLabel());
    contentPane.add(getVoorbeeldKnop());
    contentPane.add(getVoorbeeldVeld());
    contentPane.add(getVoorbeeldGebied());
    contentPane.add(getVoorbeeldKeuze());
  }
  private JLabel getVoorbeeldLabel() {
    if (voorbeeldLabel == null) {
    	voorbeeldLabel = new JLabel("Dit is een label");
    	voorbeeldLabel.setBounds(14, 16, 97, 32);
    }
    return voorbeeldLabel;
  }
  private JButton getVoorbeeldKnop() {
    if (voorbeeldKnop == null) {
    	voorbeeldKnop = new JButton("Dit is een knop");
    	voorbeeldKnop.setBounds(122, 16, 137, 32);
    }
    return voorbeeldKnop;
  }
  private JTextField getVoorbeeldVeld() {
    if (voorbeeldVeld == null) {
    	voorbeeldVeld = new JTextField();
    	voorbeeldVeld.setText("Dit is een tekstveld. U kunt er tekst in typen");
    	voorbeeldVeld.setBounds(14, 59, 244, 32);
    	voorbeeldVeld.setColumns(10);
    }
    return voorbeeldVeld;
  }
  private JTextArea getVoorbeeldGebied() {
    if (voorbeeldGebied == null) {
    	voorbeeldGebied = new JTextArea();
    	voorbeeldGebied.setBounds(14, 105, 244, 90);
    }
    return voorbeeldGebied;
  }
  private JComboBox getVoorbeeldKeuze() {
    if (voorbeeldKeuze == null) {
    	voorbeeldKeuze = new JComboBox();
    	voorbeeldKeuze.setBounds(14, 211, 244, 32);
    }
    return voorbeeldKeuze;
  }
  
  private void mijnInit() {
    voorbeeldGebied.append("Dit is een tekstgebied\n");
    voorbeeldGebied.append("Er kunnen verschillende regels\n");
    voorbeeldGebied.append("tekst getoond worden.\n");
    voorbeeldGebied.append("Een tekstgebied kan ook als invoer\n");
    voorbeeldGebied.append("gebruikt worden\n");
    
    voorbeeldKeuze.addItem("Dit is keuze1 in de keuzelijst");
    voorbeeldKeuze.addItem("Keuze2");
    voorbeeldKeuze.addItem("Of keuze 3");
    voorbeeldKeuze.addItem("Zoveel als u wilt");
  }
}
