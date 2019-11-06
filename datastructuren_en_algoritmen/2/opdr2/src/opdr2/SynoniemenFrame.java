package opdr2;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Comparator;
import java.util.Vector;
import java.util.regex.Pattern;

public class SynoniemenFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel woordLabel = null;
    private JLabel synoniemenLabel = null;
    private JScrollPane woordScrollPane = null;
    private JScrollPane synomiemenScrollPane = null;
    private JList<String> woordList = null;
    private JList<String> synoniemenList = null;
    private JTextField woordVeld = null;
    private JTextField synoniemenVeld = null;
    private JButton voegtoeKnop = null;
    private JLabel foutLabel = null;

    private Thesaurus thesaurus;

    /**
     * This is the default constructor
     */
    public SynoniemenFrame(Thesaurus thesaurus) {
        super();
        initialize();
        this.thesaurus = thesaurus;
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(460, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getJContentPane());
        this.setTitle("JFrame");
    }

    /**
     * Onvolledieg event handler voor toevoegen.
     * Er wordt gecontroleerd of een woord uit letters bestaat, en een
     * woordenlijst uit woorden gescheiden door spaties.
     */
    private void voegtoeKnopAction() {

        // Voeg hier eigen code toe
        try {
            String woord = getWoord();
            String[] synoniemen = getSynoniemen();
            thesaurus.voegToe(woord, synoniemen);
            woordList.setListData(thesaurus.getWoordenlijst());
            resetFrame();
        } catch (ThesaurusException e) {
            foutLabel.setText(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Parse het woord
     */
    private String getWoord() throws ThesaurusException {
        String woord = woordVeld.getText().trim();
        if (!Pattern.matches("[a-zA-Z]+", woord)) {
            throw new ThesaurusException("Een woord mag alleen uit letters bestaan");
        } else {
            return woord;
        }
    }

    /**
     * Parse alle synoniemen
     */
    private String[] getSynoniemen() throws ThesaurusException {
        String alleSynoniemen = synoniemenVeld.getText().trim() + ' ';
        if (!Pattern.matches("([a-zA-Z]+ +)+", alleSynoniemen)) {
            throw new ThesaurusException("Let op: de ingevoerde synoniemenlijst moet bestaan uit woorden gescheiden door spaties!");
        } else {
            return alleSynoniemen.split("\\s+");
        }
    }

    /**
     * Reset frame functie
     */
    private void resetFrame() {
        woordVeld.setText("");
        synoniemenVeld.setText("");
        foutLabel.setText("");
        woordList.setSelectedIndex(-1);
        synoniemenList.setListData(new Vector<>());
    }

    /**
     * Lege event handler voor klikken in woordList
     */
    private void woordListPressed() {
        if (woordList.getModel().getSize() > 0) {
            String woord = woordList.getSelectedValue();
            synoniemenList.setListData(thesaurus.getSynoniemenLijst(woord));
        }
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            foutLabel = new JLabel();
            foutLabel.setBounds(new Rectangle(20, 270, 590, 25));
            foutLabel.setText("");
            synoniemenLabel = new JLabel();
            synoniemenLabel.setBounds(new Rectangle(305, 10, 110, 20));
            synoniemenLabel.setText("Synoniemen");
            woordLabel = new JLabel();
            woordLabel.setBounds(new Rectangle(95, 10, 110, 20));
            woordLabel.setText("Woorden");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(woordLabel, null);
            jContentPane.add(synoniemenLabel, null);
            jContentPane.add(getWoordScrollPane(), null);
            jContentPane.add(getSynomiemenScrollPane(), null);
            jContentPane.add(getWoordVeld(), null);
            jContentPane.add(getSynoniemenVeld(), null);
            jContentPane.add(foutLabel, null);
            jContentPane.add(getVoegtoeKnop(), null);
        }
        return jContentPane;
    }

    /**
     * This method initializes woordScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getWoordScrollPane() {
        if (woordScrollPane == null) {
            woordScrollPane = new JScrollPane();
            woordScrollPane.setBounds(new Rectangle(20, 40, 200, 125));
            woordScrollPane.setViewportView(getWoordList());
        }
        return woordScrollPane;
    }

    /**
     * This method initializes synomiemenScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getSynomiemenScrollPane() {
        if (synomiemenScrollPane == null) {
            synomiemenScrollPane = new JScrollPane();
            synomiemenScrollPane.setBounds(new Rectangle(240, 40, 200, 125));
            synomiemenScrollPane.setViewportView(getSynoniemenList());
        }
        return synomiemenScrollPane;
    }

    /**
     * This method initializes woordList
     *
     * @return javax.swing.JList
     */
    private JList getWoordList() {
        if (woordList == null) {
            woordList = new JList<>();
            woordList.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mousePressed(java.awt.event.MouseEvent e) {
                    woordListPressed();
                }
            });
        }
        return woordList;
    }

    /**
     * This method initializes synoniemenList
     *
     * @return javax.swing.JList
     */
    private JList getSynoniemenList() {
        if (synoniemenList == null) {
            synoniemenList = new JList<>();
        }
        return synoniemenList;
    }

    /**
     * This method initializes woordVeld
     *
     * @return javax.swing.JTextField
     */
    private JTextField getWoordVeld() {
        if (woordVeld == null) {
            woordVeld = new JTextField();
            woordVeld.setBounds(new Rectangle(20, 200, 200, 20));
        }
        return woordVeld;
    }

    /**
     * This method initializes synoniemenVeld
     *
     * @return javax.swing.JTextField
     */
    private JTextField getSynoniemenVeld() {
        if (synoniemenVeld == null) {
            synoniemenVeld = new JTextField();
            synoniemenVeld.setBounds(new Rectangle(240, 200, 200, 20));
        }
        return synoniemenVeld;
    }

    /**
     * This method initializes voegtoeKnop
     *
     * @return javax.swing.JButton
     */
    private JButton getVoegtoeKnop() {
        if (voegtoeKnop == null) {
            voegtoeKnop = new JButton();
            voegtoeKnop.setText("Toevoegen");
            voegtoeKnop.setBounds(new Rectangle(180, 240, 100, 25));
            voegtoeKnop.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    voegtoeKnopAction();
                }
            });
        }
        return voegtoeKnop;
    }

}  //  @jve:decl-index=0:visual-constraint="10,10"
