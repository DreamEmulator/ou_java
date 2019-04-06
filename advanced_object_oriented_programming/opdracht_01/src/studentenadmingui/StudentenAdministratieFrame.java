package studentenadmingui;

import studentenadmin.*;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentenAdministratieFrame extends JFrame {

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
    private JLabel bestaandenaamLabel = null;
    private JTextField bestaandeNaamVeld = null;
    private JLabel infoLabel = null;
    private JTextField studentInfoVeld = null;
    private JLabel nieuwepuntenLabel = null;
    private JTextField puntenVeld = null;
    private JLabel uitlegLabel = null;
    private JButton moduleKnop = null;
    private JLabel opleidingLabel = null;
    private JLabel nstudentLabel = null;
    private JComboBox opleidingComboBox = null;
    private JLabel studentLabel = null;
    private JTextField studentTextField = null;
    private JButton studentButton = null;
    private JComboBox scholingComboBox = null;
    private JLabel scholerLabel = null;
    private JTextField scholerTextField = null;
    private JButton scholerButton = null;

    private StudentenAdministratie studentenAdministratie;

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
        this.setSize(850, 330);
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
            infoLabel.setBounds(new Rectangle(14, 278, 700, 350));
            infoLabel.setText("");
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getMijnTabbladenPanel(), null);
            jContentPane.add(infoLabel, null);
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
            jScrollPane.setBounds(new Rectangle(6, 65, 382, 121));
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
            mijnTabbladenPanel.setBounds(new Rectangle(13, 19, 800, 224));
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
            studentLabel = new JLabel();
            studentLabel.setBounds(new Rectangle(15, 55, 91, 24));
            studentLabel.setText("Naam student");
            nstudentLabel = new JLabel();
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
            scholerLabel = new JLabel();
            scholerLabel.setBounds(new Rectangle(16, 54, 116, 25));
            scholerLabel.setText("Naam scholer");
            opleidingLabel = new JLabel();
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
            uitlegLabel = new JLabel();
            uitlegLabel.setBounds(new Rectangle(16, 8, 334, 19));
            uitlegLabel.setText("Geef enter om invoer te bevestigen");
            nieuwepuntenLabel = new JLabel();
            nieuwepuntenLabel.setBounds(new Rectangle(14, 63, 256, 20));
            nieuwepuntenLabel.setText("Punten behaald (alleen reguliere opleiding) ");
            bestaandenaamLabel = new JLabel();
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
            studentInfoVeld.setBounds(new Rectangle(10, 152, 392, 27));
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
    private JComboBox getOpleidingComboBox() {
        if (opleidingComboBox == null) {
            opleidingComboBox = new JComboBox();
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
    private JComboBox getScholingComboBox() {
        if (scholingComboBox == null) {
            scholingComboBox = new JComboBox();
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
        bindStudentButton();
        bindEnter();
        bindPuntenEnter();
    }

    //  Studentpanel events
    private void bindStudentButton() {
        for (Opleiding o : studentenAdministratie.getOpleidingen()) {
            opleidingComboBox.addItem(o.getNaam());
        }
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String student = studentTextField.getText();
                String opleiding = opleidingComboBox.getSelectedItem().toString();
                studentenAdministratie.nieuweReguliereStudent(student, opleiding);
            }
        });
    }

    //  Studentinfo events

    private void updateStudentInfo() {
        Student s = studentenAdministratie.zoekStudent(bestaandeNaamVeld.getText());
        switch (s.getClass().getName()) {
            case "studentenadmin.ReguliereStudent":
                ReguliereStudent student = (ReguliereStudent) s;
                String studentNaam = student.getNaam();
                String opleiding = student.getOpleiding().getNaam();
                double punten = student.getBehaaldePunten();
                studentInfoVeld.setText(studentNaam + ", " + opleiding + ", " + punten);
                break;
            case "studentenadmin.CPPStudent":
                CPPStudent cppStudent = (CPPStudent) s;
                String naam = cppStudent.getNaam();
                String cpp = cppStudent.getOpleiding().getNaam();
                int modules = cppStudent.getBehaaldeModules();
                studentInfoVeld.setText(naam + ", " + cpp + ", " + modules);
                break;
            default:
                System.out.println("Student nieuw type");
        }
    }

    private void bindEnter() {
        bestaandeNaamVeld.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudentInfo();
            }
        });
    }

    private void bindPuntenEnter() {
        puntenVeld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = studentenAdministratie.zoekStudent(bestaandeNaamVeld.getText());
                if (s instanceof studentenadmin.ReguliereStudent) {
                    System.out.println("HOLO");
                    ((ReguliereStudent) s).setBehaaldePunten(Double.parseDouble(puntenVeld.getText()));
                    updateStudentInfo();
                }
            }
        });
    }


} // @jve:decl-index=0:visual-constraint="10,10"
