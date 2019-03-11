package bank_gui;

import bank_domain.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankFrame {
    private JPanel bankOverzicht;
    private JPanel knoppenbalk;
    private JPanel debitRekening;
    private JPanel creditRekening;
    private JTextField debitRekeningNummerInput;
    private JTextField debitBedragInput;
    private JTextField creditRekeningNummerInput;
    private JTextField creditBedragInput;
    private JLabel Rekeningnummer;
    private JLabel Bedrag;
    private JButton debitStortButton;
    private JButton creditZoekButton;
    private JButton debitNeemOpButton;
    private JButton debitZoekButton;
    private JButton creditStortButton;
    private JButton creditNeemOpButton;
    private JButton maakOver;
    private JLabel debitNaamLabel;
    private JLabel creditNaamLabel;
    private JLabel debitSaldoLabel;
    private JLabel creditSaldoLabel;
    private JLabel debitNaamOutput;
    private JLabel debitSaldoOutput;
    private JLabel creditNaamOutput;
    private JLabel creditSaldoOutput;
    private JLabel infoDialogueOutput;

    private Bank bank;

    public BankFrame(Bank bank) {
        this.bank = bank;
        System.out.println("Bank GUI Initiated!");
        JFrame frame = new JFrame("Hols bank");
        frame.setContentPane(bankOverzicht);
        frame.setBounds(800, 300, 800, 300);
        frame.setVisible(true);
        execute("Welkom");
        bindEvents();
    }

    private void execute(String message) {

        if (debitBedragInput.getText().length() == 0) debitBedragInput.setText("0.00");
        if (creditBedragInput.getText().length() == 0) creditBedragInput.setText("0.00");

        debitRekeningNummerInput.setText(String.valueOf(bank.getDebitRekeningNr()));
        debitNaamOutput.setText(bank.getDebitRekeningNaam());
        debitSaldoOutput.setText(String.format("%.2f", bank.getDebitRekeningSaldo()));

        creditRekeningNummerInput.setText(String.valueOf(bank.getCreditRekeningNr()));
        creditNaamOutput.setText(bank.getCreditRekeningNaam());
        creditSaldoOutput.setText(String.format("%.2f", bank.getCreditRekeningSaldo()));

        infoDialogueOutput.setText(message);
    }

    private void bindEvents() {

        // Debit rekening events

        // Zoeken
        debitZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    execute(bank.setDebitRekeningNr(Integer.parseInt(debitRekeningNummerInput.getText())));
                } catch (NumberFormatException e1) {
                    infoDialogueOutput.setText("Error: Geef een geldig rekening nummer");
                }
            }
        });

        // Opnemen = 0
        debitNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(debitRekeningNummerInput.getText()) == bank.getDebitRekeningNr()) {
                        execute(bank.requestTransactie(0, Integer.parseInt(debitRekeningNummerInput.getText()), Double.parseDouble(debitBedragInput.getText())));
                    } else {
                        infoDialogueOutput.setText("Error: het debit-rekeningnummer klopt niet, zoek de rekening opnieuw...");
                    }
                } catch (NumberFormatException e1) {
                    infoDialogueOutput.setText("Error: Geef een geldig bedrag om op te nemen van de debit rekening");
                }
            }
        });

        // Storten = 1
        debitStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(debitRekeningNummerInput.getText()) == bank.getDebitRekeningNr()) {
                        execute(bank.requestTransactie(1, Integer.parseInt(debitRekeningNummerInput.getText()), Double.parseDouble(debitBedragInput.getText())));
                    } else {
                        infoDialogueOutput.setText("Error: het debit-rekeningnummer klopt niet, zoek de rekening opnieuw...");
                    }
                } catch (NumberFormatException e1) {
                    infoDialogueOutput.setText("Error: Voer alleen correcte bedragen in");
                }
            }
        });

        // Credit rekening events

        // Zoeken
        creditZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    execute(bank.setCreditRekeningNr(Integer.parseInt(creditRekeningNummerInput.getText())));
                } catch (NumberFormatException e1) {
                    infoDialogueOutput.setText("Error: Geef een geldig rekening nummer");
                }
            }
        });

        // Opnemen = 0
        creditNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(creditRekeningNummerInput.getText()) == bank.getCreditRekeningNr()) {
                        execute(bank.requestTransactie(0, Integer.parseInt(creditRekeningNummerInput.getText()), Double.parseDouble(creditBedragInput.getText())));
                    } else {
                        infoDialogueOutput.setText("Error: het credit-rekeningnummer klopt niet, zoek de rekening opnieuw...");
                    }
                } catch (NumberFormatException e1) {
                    infoDialogueOutput.setText("Error: Voer alleen correcte bedragen in");
                }
            }
        });

        // Storten = 1
        creditStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(creditRekeningNummerInput.getText()) == bank.getCreditRekeningNr()) {
                        execute(bank.requestTransactie(1, Integer.parseInt(creditRekeningNummerInput.getText()), Double.parseDouble(creditBedragInput.getText())));
                    } else {
                        infoDialogueOutput.setText("Error: het credit-rekeningnummer klopt niet, zoek de rekening opnieuw...");
                    }
                } catch (NumberFormatException e1) {
                    infoDialogueOutput.setText("Error: Voer alleen correcte bedragen in");
                }
            }
        });

        // Debit naar Credit events

        //Overmaken = 2
        maakOver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    execute(bank.requestTransactie(2, Integer.parseInt(debitRekeningNummerInput.getText()), Integer.parseInt(creditRekeningNummerInput.getText()), Double.parseDouble(debitBedragInput.getText())));
                } catch (NumberFormatException e1) {
                    infoDialogueOutput.setText("Error: Voer alleen correcte getallen in");
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        bankOverzicht = new JPanel();
        bankOverzicht.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 4, new Insets(0, 0, 0, 0), -1, -1));
        bankOverzicht.setBackground(new Color(-2072));
        knoppenbalk = new JPanel();
        knoppenbalk.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1));
        knoppenbalk.setBackground(new Color(-2072));
        bankOverzicht.add(knoppenbalk, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        debitStortButton = new JButton();
        debitStortButton.setBackground(new Color(-67073));
        Font debitStortButtonFont = UIManager.getFont("ToolTip.font");
        if (debitStortButtonFont != null) debitStortButton.setFont(debitStortButtonFont);
        debitStortButton.setForeground(new Color(-13026502));
        debitStortButton.setText("Stort");
        knoppenbalk.add(debitStortButton, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creditZoekButton = new JButton();
        creditZoekButton.setBackground(new Color(-67073));
        Font creditZoekButtonFont = UIManager.getFont("ToolTip.font");
        if (creditZoekButtonFont != null) creditZoekButton.setFont(creditZoekButtonFont);
        creditZoekButton.setForeground(new Color(-13026502));
        creditZoekButton.setHideActionText(true);
        creditZoekButton.setText("Zoek");
        knoppenbalk.add(creditZoekButton, new com.intellij.uiDesigner.core.GridConstraints(0, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        debitNeemOpButton = new JButton();
        debitNeemOpButton.setBackground(new Color(-67073));
        debitNeemOpButton.setEnabled(true);
        Font debitNeemOpButtonFont = UIManager.getFont("ToolTip.font");
        if (debitNeemOpButtonFont != null) debitNeemOpButton.setFont(debitNeemOpButtonFont);
        debitNeemOpButton.setForeground(new Color(-13026502));
        debitNeemOpButton.setText("Neem op");
        knoppenbalk.add(debitNeemOpButton, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        debitZoekButton = new JButton();
        debitZoekButton.setBackground(new Color(-67073));
        Font debitZoekButtonFont = UIManager.getFont("ToolTip.font");
        if (debitZoekButtonFont != null) debitZoekButton.setFont(debitZoekButtonFont);
        debitZoekButton.setForeground(new Color(-13026502));
        debitZoekButton.setText("Zoek");
        knoppenbalk.add(debitZoekButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creditStortButton = new JButton();
        creditStortButton.setBackground(new Color(-67073));
        Font creditStortButtonFont = UIManager.getFont("ToolTip.font");
        if (creditStortButtonFont != null) creditStortButton.setFont(creditStortButtonFont);
        creditStortButton.setForeground(new Color(-13026502));
        creditStortButton.setText("Stort");
        knoppenbalk.add(creditStortButton, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creditNeemOpButton = new JButton();
        creditNeemOpButton.setBackground(new Color(-67073));
        Font creditNeemOpButtonFont = UIManager.getFont("ToolTip.font");
        if (creditNeemOpButtonFont != null) creditNeemOpButton.setFont(creditNeemOpButtonFont);
        creditNeemOpButton.setForeground(new Color(-13026502));
        creditNeemOpButton.setText("Neem op");
        knoppenbalk.add(creditNeemOpButton, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        maakOver = new JButton();
        maakOver.setBackground(new Color(-67073));
        Font maakOverFont = UIManager.getFont("ToolTip.font");
        if (maakOverFont != null) maakOver.setFont(maakOverFont);
        maakOver.setText("Maak over ->");
        knoppenbalk.add(maakOver, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        debitRekening = new JPanel();
        debitRekening.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        debitRekening.setBackground(new Color(-2072));
        bankOverzicht.add(debitRekening, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(270, 312), null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = UIManager.getFont("ToolTip.font");
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Rekeningnummer");
        debitRekening.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        debitBedragInput = new JTextField();
        debitBedragInput.setBackground(new Color(-67073));
        Font debitBedragInputFont = UIManager.getFont("ToolTip.font");
        if (debitBedragInputFont != null) debitBedragInput.setFont(debitBedragInputFont);
        debitRekening.add(debitBedragInput, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        debitRekeningNummerInput = new JTextField();
        debitRekeningNummerInput.setBackground(new Color(-67073));
        Font debitRekeningNummerInputFont = UIManager.getFont("ToolTip.font");
        if (debitRekeningNummerInputFont != null) debitRekeningNummerInput.setFont(debitRekeningNummerInputFont);
        debitRekening.add(debitRekeningNummerInput, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = UIManager.getFont("ToolTip.font");
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Bedrag");
        debitRekening.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        debitNaamLabel = new JLabel();
        Font debitNaamLabelFont = UIManager.getFont("ToolTip.font");
        if (debitNaamLabelFont != null) debitNaamLabel.setFont(debitNaamLabelFont);
        debitNaamLabel.setText("Naam");
        debitRekening.add(debitNaamLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        debitSaldoLabel = new JLabel();
        Font debitSaldoLabelFont = UIManager.getFont("ToolTip.font");
        if (debitSaldoLabelFont != null) debitSaldoLabel.setFont(debitSaldoLabelFont);
        debitSaldoLabel.setText("Saldo");
        debitRekening.add(debitSaldoLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        debitNaamOutput = new JLabel();
        Font debitNaamOutputFont = UIManager.getFont("ToolTip.font");
        if (debitNaamOutputFont != null) debitNaamOutput.setFont(debitNaamOutputFont);
        debitNaamOutput.setText("Geen naam");
        debitRekening.add(debitNaamOutput, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        debitSaldoOutput = new JLabel();
        Font debitSaldoOutputFont = UIManager.getFont("ToolTip.font");
        if (debitSaldoOutputFont != null) debitSaldoOutput.setFont(debitSaldoOutputFont);
        debitSaldoOutput.setText("Geen saldo");
        debitRekening.add(debitSaldoOutput, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creditRekening = new JPanel();
        creditRekening.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        creditRekening.setBackground(new Color(-2072));
        creditRekening.setDoubleBuffered(false);
        bankOverzicht.add(creditRekening, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(270, 312), null, 0, false));
        Rekeningnummer = new JLabel();
        Font RekeningnummerFont = UIManager.getFont("ToolTip.font");
        if (RekeningnummerFont != null) Rekeningnummer.setFont(RekeningnummerFont);
        Rekeningnummer.setText("Rekeningnummer");
        creditRekening.add(Rekeningnummer, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Bedrag = new JLabel();
        Font BedragFont = UIManager.getFont("ToolTip.font");
        if (BedragFont != null) Bedrag.setFont(BedragFont);
        Bedrag.setText("Bedrag");
        creditRekening.add(Bedrag, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creditRekeningNummerInput = new JTextField();
        creditRekeningNummerInput.setBackground(new Color(-67073));
        Font creditRekeningNummerInputFont = UIManager.getFont("ToolTip.font");
        if (creditRekeningNummerInputFont != null) creditRekeningNummerInput.setFont(creditRekeningNummerInputFont);
        creditRekening.add(creditRekeningNummerInput, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        creditBedragInput = new JTextField();
        creditBedragInput.setBackground(new Color(-67073));
        Font creditBedragInputFont = UIManager.getFont("ToolTip.font");
        if (creditBedragInputFont != null) creditBedragInput.setFont(creditBedragInputFont);
        creditRekening.add(creditBedragInput, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        creditNaamLabel = new JLabel();
        Font creditNaamLabelFont = UIManager.getFont("ToolTip.font");
        if (creditNaamLabelFont != null) creditNaamLabel.setFont(creditNaamLabelFont);
        creditNaamLabel.setText("Naam");
        creditRekening.add(creditNaamLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creditSaldoLabel = new JLabel();
        Font creditSaldoLabelFont = UIManager.getFont("ToolTip.font");
        if (creditSaldoLabelFont != null) creditSaldoLabel.setFont(creditSaldoLabelFont);
        creditSaldoLabel.setText("Saldo");
        creditRekening.add(creditSaldoLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creditNaamOutput = new JLabel();
        Font creditNaamOutputFont = UIManager.getFont("ToolTip.font");
        if (creditNaamOutputFont != null) creditNaamOutput.setFont(creditNaamOutputFont);
        creditNaamOutput.setText("Geen naam");
        creditRekening.add(creditNaamOutput, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        creditSaldoOutput = new JLabel();
        Font creditSaldoOutputFont = UIManager.getFont("ToolTip.font");
        if (creditSaldoOutputFont != null) creditSaldoOutput.setFont(creditSaldoOutputFont);
        creditSaldoOutput.setText("Geen saldo");
        creditRekening.add(creditSaldoOutput, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = UIManager.getFont("ToolTip.font");
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Debit rekening");
        bankOverzicht.add(label3, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = UIManager.getFont("ToolTip.font");
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("Credit rekening");
        bankOverzicht.add(label4, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        bankOverzicht.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        bankOverzicht.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        bankOverzicht.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        bankOverzicht.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        bankOverzicht.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        bankOverzicht.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        infoDialogueOutput = new JLabel();
        infoDialogueOutput.setText("");
        bankOverzicht.add(infoDialogueOutput, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return bankOverzicht;
    }
}