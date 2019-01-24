package rekeninggui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * GUI-klasse voor één specifieke rekening.
 */
public class RekeningFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JLabel titelLabel;
  private JLabel rekeningLabel;
  private JLabel naamLabel;
  private JLabel saldoLabel;
  private JLabel bedragLabel;
  private JTextField nummerVeld;
  private JTextField naamVeld;
  private JTextField saldoVeld;
  private JTextField bedragVeld;
  private JButton stortKnop;
  private JButton neemOpKnop;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RekeningFrame frame = new RekeningFrame();
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
  public RekeningFrame() {
    initialize();
  }
  private void initialize() {
    setTitle("RekeningApplicatie");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 360, 324);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    contentPane.add(getTitelLabel());
    contentPane.add(getRekeningLabel());
    contentPane.add(getNaamLabel());
    contentPane.add(getSaldoLabel());
    contentPane.add(getBedragLabel());
    contentPane.add(getNummerVeld());
    contentPane.add(getNaamVeld());
    contentPane.add(getSaldoVeld());
    contentPane.add(getBedragVeld());
    contentPane.add(getStortKnop());
    contentPane.add(getNeemOpKnop());
  }

  private JLabel getTitelLabel() {
    if (titelLabel == null) {
    	titelLabel = new JLabel("Internet Bankrekening");
    	titelLabel.setBounds(61, 15, 149, 24);
    }
    return titelLabel;
  }
  private JLabel getRekeningLabel() {
    if (rekeningLabel == null) {
    	rekeningLabel = new JLabel("Rekeningnummer:");
    	rekeningLabel.setBounds(8, 59, 109, 22);
    }
    return rekeningLabel;
  }
  private JLabel getNaamLabel() {
    if (naamLabel == null) {
    	naamLabel = new JLabel("Naam:");
    	naamLabel.setBounds(37, 86, 80, 22);
    }
    return naamLabel;
  }
  private JLabel getSaldoLabel() {
    if (saldoLabel == null) {
    	saldoLabel = new JLabel("Saldo:");
    	saldoLabel.setBounds(37, 115, 80, 22);
    }
    return saldoLabel;
  }
  private JLabel getBedragLabel() {
    if (bedragLabel == null) {
    	bedragLabel = new JLabel("Bedrag:");
    	bedragLabel.setBounds(37, 148, 82, 22);
    }
    return bedragLabel;
  }
  private JTextField getNummerVeld() {
    if (nummerVeld == null) {
    	nummerVeld = new JTextField();
    	nummerVeld.setEditable(false);
    	nummerVeld.setBounds(134, 60, 75, 22);
    	nummerVeld.setColumns(10);
    }
    return nummerVeld;
  }
  private JTextField getNaamVeld() {
    if (naamVeld == null) {
    	naamVeld = new JTextField();
    	naamVeld.setEditable(false);
    	naamVeld.setBounds(134, 87, 75, 22);
    	naamVeld.setColumns(10);
    }
    return naamVeld;
  }
  private JTextField getSaldoVeld() {
    if (saldoVeld == null) {
    	saldoVeld = new JTextField();
    	saldoVeld.setEditable(false);
    	saldoVeld.setBounds(134, 118, 75, 22);
    	saldoVeld.setColumns(10);
    }
    return saldoVeld;
  }
  private JTextField getBedragVeld() {
    if (bedragVeld == null) {
    	bedragVeld = new JTextField();
    	bedragVeld.setBounds(134, 148, 75, 22);
    	bedragVeld.setColumns(10);
    }
    return bedragVeld;
  }
  private JButton getStortKnop() {
    if (stortKnop == null) {
    	stortKnop = new JButton("stort");
    	stortKnop.setBounds(16, 220, 110, 35);
    }
    return stortKnop;
  }
  private JButton getNeemOpKnop() {
    if (neemOpKnop == null) {
    	neemOpKnop = new JButton("neem op");
    	neemOpKnop.setBounds(149, 220, 110, 35);
    }
    return neemOpKnop;
  }
}
