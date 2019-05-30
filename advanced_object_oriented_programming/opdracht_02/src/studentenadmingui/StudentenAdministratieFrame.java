package studentenadmingui;

import studentenadmin.*;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StudentenAdministratieFrame extends JFrame {

    private final StudentenAdministratie studentenAdministratie;

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JScrollPane jScrollPane = null;
    private JTextArea uitvoerGebied = null;
    private JButton toonAlleKnop = null;
    private JTabbedPane mijnTabbladenPanel = null;
    private JPanel voegStudenttoePanel = null;
    private JPanel voegScholertoePanel = null;
    private JPanel studentPanel = null;
    private JPanel alleStudentenPanel = null;
    private JTextField bestaandeNaamVeld = null;
    private JTextField studentInfoVeld = null;
    private JTextField puntenVeld = null;
    private JButton moduleKnop = null;
    private JComboBox<String> opleidingComboBox = null;
    private JTextField studentTextField = null;
    private JButton studentButton = null;
    private JComboBox<String> scholingComboBox = null;
    private JTextField scholerTextField = null;
    private JButton scholerButton = null;
    private JLabel infoLabel = null;

    /**
     * This is the default constructor
     */
    public StudentenAdministratieFrame(StudentenAdministratie studentenAdministratie) {
        super();
        this.studentenAdministratie = studentenAdministratie;
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(850, 460);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(getJContentPane());
        this.setTitle("StudentAdministratie");
        this.setVisible(true);
        bindEvents();
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            infoLabel = new JLabel();
            infoLabel.setBounds(new Rectangle(35, 370, 700, 50));
            infoLabel.setText("");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(infoLabel, null);
            jContentPane.add(getMijnTabbladenPanel(), null);
        }
        return jContentPane;
    }

    /**
     * This method initializes jScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setBounds(new Rectangle(6, 65, 682, 180));
            jScrollPane.setViewportView(getUitvoerGebied());
        }
        return jScrollPane;
    }

    /**
     * This method initializes uitvoerGebied
     *
     * @return javax.swing.JTextArea
     */
    private JTextArea getUitvoerGebied() {
        if (uitvoerGebied == null) {
            uitvoerGebied = new JTextArea();
            uitvoerGebied.setEditable(false);
        }
        return uitvoerGebied;
    }

    /**
     * This method initializes toonAlleKnop
     *
     * @return javax.swing.JButton
     */
    private JButton getToonAlleKnop() {
        if (toonAlleKnop == null) {
            toonAlleKnop = new JButton();
            toonAlleKnop.setText("Toon alle studenten");
            toonAlleKnop.setBounds(new Rectangle(11, 8, 147, 20));
        }
        return toonAlleKnop;
    }

    /**
     * This method initializes mijnTabbladenPanel
     *
     * @return javax.swing.JTabbedPane
     */
    private JTabbedPane getMijnTabbladenPanel() {
        if (mijnTabbladenPanel == null) {
            mijnTabbladenPanel = new JTabbedPane();
            mijnTabbladenPanel.setBounds(new Rectangle(13, 19, 800, 400));
            mijnTabbladenPanel.addTab("nieuwe student", null,
                    getVoegStudenttoePanel(), null);
            mijnTabbladenPanel.addTab("nieuwe scholer", null,
                    getVoegScholertoePanel(), null);
            mijnTabbladenPanel.addTab("studentinfo", null, getStudentPanel(), null);
            mijnTabbladenPanel.addTab("alle studenten", null,
                    getAlleStudentenPanel(), null);
        }
        return mijnTabbladenPanel;
    }

    /**
     * This method initializes voegStudenttoePanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getVoegStudenttoePanel() {
        if (voegStudenttoePanel == null) {
            JLabel studentLabel = new JLabel();
            studentLabel.setBounds(new Rectangle(15, 55, 91, 24));
            studentLabel.setText("Naam student");
            JLabel nstudentLabel = new JLabel();
            nstudentLabel.setBounds(new Rectangle(16, 16, 146, 24));
            nstudentLabel.setText("Selecteer een opleiding");
            voegStudenttoePanel = new JPanel();
            voegStudenttoePanel.setLayout(null);
            voegStudenttoePanel.add(nstudentLabel, null);
            voegStudenttoePanel.add(getOpleidingComboBox(), null);
            voegStudenttoePanel.add(studentLabel, null);
            voegStudenttoePanel.add(getStudentTextField(), null);
            voegStudenttoePanel.add(getStudentButton(), null);
        }
        return voegStudenttoePanel;
    }

    private JPanel getVoegScholertoePanel() {
        if (voegScholertoePanel == null) {
            JLabel scholerLabel = new JLabel();
            scholerLabel.setBounds(new Rectangle(16, 54, 116, 25));
            scholerLabel.setText("Naam scholer");
            JLabel opleidingLabel = new JLabel();
            opleidingLabel.setBounds(new Rectangle(16, 16, 173, 25));
            opleidingLabel.setText("Selecteer een CPP-Opleiding");
            voegScholertoePanel = new JPanel();
            voegScholertoePanel.setLayout(null);
            voegScholertoePanel.add(opleidingLabel, null);
            voegScholertoePanel.add(getScholingComboBox(), null);
            voegScholertoePanel.add(scholerLabel, null);
            voegScholertoePanel.add(getScholerTextField(), null);
            voegScholertoePanel.add(getScholerButton(), null);
        }
        return voegScholertoePanel;
    }

    /**
     * This method initializes studentPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getStudentPanel() {
        if (studentPanel == null) {
            JLabel uitlegLabel = new JLabel();
            uitlegLabel.setBounds(new Rectangle(16, 8, 334, 19));
            uitlegLabel.setText("Geef enter om invoer te bevestigen");
            JLabel nieuwepuntenLabel = new JLabel();
            nieuwepuntenLabel.setBounds(new Rectangle(14, 63, 296, 20));
            nieuwepuntenLabel.setText("Punten behaald (alleen reguliere opleiding) ");
            JLabel bestaandenaamLabel = new JLabel();
            bestaandenaamLabel.setBounds(new Rectangle(14, 35, 86, 20));
            bestaandenaamLabel.setText("Studentnaam");
            studentPanel = new JPanel();
            studentPanel.setLayout(null);
            studentPanel.add(bestaandenaamLabel, null);
            studentPanel.add(getBestaandeNaamVeld(), null);
            studentPanel.add(getStudentInfoVeld(), null);
            studentPanel.add(nieuwepuntenLabel, null);
            studentPanel.add(getPuntenVeld(), null);
            studentPanel.add(uitlegLabel, null);
            studentPanel.add(getModuleKnop(), null);
        }
        return studentPanel;
    }

    /**
     * This method initializes alleStudentenPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getAlleStudentenPanel() {
        if (alleStudentenPanel == null) {
            alleStudentenPanel = new JPanel();
            alleStudentenPanel.setLayout(null);
            alleStudentenPanel.add(getToonAlleKnop(), null);
            alleStudentenPanel.add(getJScrollPane(), null);
        }
        return alleStudentenPanel;
    }

    /**
     * This method initializes bestaandeNaamVeld
     *
     * @return javax.swing.JTextField
     */
    private JTextField getBestaandeNaamVeld() {
        if (bestaandeNaamVeld == null) {
            bestaandeNaamVeld = new JTextField();
            bestaandeNaamVeld.setBounds(new Rectangle(114, 36, 151, 20));
        }
        return bestaandeNaamVeld;
    }

    /**
     * This method initializes studentInfoVeld
     *
     * @return javax.swing.JTextField
     */
    private JTextField getStudentInfoVeld() {
        if (studentInfoVeld == null) {
            studentInfoVeld = new JTextField();
            studentInfoVeld.setBounds(new Rectangle(10, 152, 592, 27));
            studentInfoVeld.setEditable(false);
        }
        return studentInfoVeld;
    }

    /**
     * This method initializes puntenVeld
     *
     * @return javax.swing.JTextField
     */
    private JTextField getPuntenVeld() {
        if (puntenVeld == null) {
            puntenVeld = new JTextField();
            puntenVeld.setBounds(new Rectangle(284, 63, 47, 20));
        }
        return puntenVeld;
    }

    /**
     * This method initializes moduleKnop
     *
     * @return javax.swing.JButton
     */
    private JButton getModuleKnop() {
        if (moduleKnop == null) {
            moduleKnop = new JButton();
            moduleKnop.setBounds(new Rectangle(14, 91, 328, 21));
            moduleKnop.setText("Module behaald (alleen CPP)");
        }
        return moduleKnop;
    }

    /**
     * This method initializes opleidingComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox<String> getOpleidingComboBox() {
        if (opleidingComboBox == null) {
            opleidingComboBox = new JComboBox<String>();
            opleidingComboBox.setBounds(new Rectangle(195, 16, 200, 24));
        }
        return opleidingComboBox;
    }

    /**
     * This method initializes studentTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getStudentTextField() {
        if (studentTextField == null) {
            studentTextField = new JTextField();
            studentTextField.setBounds(new Rectangle(195, 55, 197, 24));
        }
        return studentTextField;
    }

    /**
     * This method initializes studentButton
     *
     * @return javax.swing.JButton
     */
    private JButton getStudentButton() {
        if (studentButton == null) {
            studentButton = new JButton();
            studentButton.setBounds(new Rectangle(15, 106, 153, 24));
            studentButton.setText("Voeg student toe");
        }
        return studentButton;
    }

    /**
     * This method initializes scholingComboBox
     *
     * @return javax.swing.JComboBox
     */
    private JComboBox<String> getScholingComboBox() {
        if (scholingComboBox == null) {
            scholingComboBox = new JComboBox<>();
            scholingComboBox.setBounds(new Rectangle(210, 16, 167, 25));
        }
        return scholingComboBox;
    }

    /**
     * This method initializes scholerTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getScholerTextField() {
        if (scholerTextField == null) {
            scholerTextField = new JTextField();
            scholerTextField.setBounds(new Rectangle(210, 54, 166, 25));
        }
        return scholerTextField;
    }

    /**
     * This method initializes scholerButton
     *
     * @return javax.swing.JButton
     */
    private JButton getScholerButton() {
        if (scholerButton == null) {
            scholerButton = new JButton();
            scholerButton.setBounds(new Rectangle(14, 103, 163, 25));
            scholerButton.setText("Voeg scholer toe");
        }
        return scholerButton;
    }

    //  Bind events
    private void bindEvents() {

        //  Nieuwe student-tab
        populateStudentCombobox();
        bindVoegStudentToeButton();

        //  Nieuwe scholer-tab
        populateScholerCombobox();
        bindVoegScholerToeButton();

        //  Studentinfo-tab
        bindNaamEnter();
        bindPuntenEnter();
        bindModuleEnter();

        //  Alle studenten-tab
        bindToonAlleKnop();
    }

    //  Nieuwe student-tab events
    private void populateStudentCombobox() {
        for (String opleiding : studentenAdministratie.getOpleidingenList()) {
            opleidingComboBox.addItem(opleiding);
        }
    }

    private void bindVoegStudentToeButton() {
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                infoLabel.setText("");
                String student = studentTextField.getText();
                String opleiding = Objects.requireNonNull(opleidingComboBox.getSelectedItem()).toString();

                try {
                    studentenAdministratie.nieuweReguliereStudent(student, opleiding);
                } catch (StudentAdminException  err){
                    infoLabel.setText(err.message);
                }

                studentTextField.setText("");
                opleidingComboBox.setSelectedIndex(0);
            }
        });
    }

    //  Nieuwe scholer-tab events
    private void populateScholerCombobox() {
        for (String cpp : studentenAdministratie.getCppList()) {
            scholingComboBox.addItem(cpp);
        }
    }

    private void bindVoegScholerToeButton() {
        scholerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoLabel.setText("");
                String cppStudent = scholerTextField.getText();
                String cpp = Objects.requireNonNull(scholingComboBox.getSelectedItem()).toString();

                try {
                    studentenAdministratie.nieuweCPPScholer(cppStudent, cpp);
                } catch (StudentAdminException err){
                    infoLabel.setText(err.message);
                }

                scholerTextField.setText("");
                scholingComboBox.setSelectedIndex(0);
            }
        });
    }

    // Toon student info
    private void bindNaamEnter()  {
        bestaandeNaamVeld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                infoLabel.setText("");
                try {
                    studentInfoVeld.setText(studentenAdministratie.toonStudent(bestaandeNaamVeld.getText()));
                } catch (StudentAdminException err){
                    infoLabel.setText(err.message);
                }

            }
        });
    }

    //  Reguliere student
    private void bindPuntenEnter() {
        puntenVeld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoLabel.setText("");

                try {
                    studentenAdministratie.verhoogPunten(bestaandeNaamVeld.getText(),Double.parseDouble(puntenVeld.getText()));
                } catch (StudentAdminException err){
                    infoLabel.setText(err.message);
                } catch (NumberFormatException err){
                    infoLabel.setText("Let op: voer alleen cijfers in als punten");
                }

                try {
                studentInfoVeld.setText(studentenAdministratie.toonStudent(bestaandeNaamVeld.getText()));
                } catch (StudentAdminException err){
                    infoLabel.setText(err.message);
                }
            }
        });
    }

    //  CPP-student
    private void bindModuleEnter() {
        moduleKnop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoLabel.setText("");

                try {
                    studentenAdministratie.verhoogBehaaldeModules(bestaandeNaamVeld.getText());
                } catch (StudentAdminException err){
                    infoLabel.setText(err.message);
                }

                try {
                studentInfoVeld.setText(studentenAdministratie.toonStudent(bestaandeNaamVeld.getText()));
                } catch (StudentAdminException err){
                    infoLabel.setText(err.message);
                }
            }
        });
    }

    //  Alle studenten-tab
    private void bindToonAlleKnop() {
        toonAlleKnop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoLabel.setText("");
                uitvoerGebied.setText(studentenAdministratie.toonAlleStudenten());
            }
        });
    }

} // @jve:decl-index=0:visual-constraint="10,10"
