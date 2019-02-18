package bankFrame;

import bank.Bank;

import javax.swing.*;
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
    private String infoDialogueMessage;

    public BankFrame(Bank bank) {
        this.bank = bank;
        System.out.println("Bank GUI Initiated!");
        JFrame frame = new JFrame("Hols bank");
        frame.setContentPane(bankOverzicht);
        frame.setBounds(700, 200, 700, 200);
        frame.setVisible(true);
        updateGui();
        bindEvents();
    }

//  Er zijn 3 transactietypes:
//  0: storten
//  1: opnemen
//  3: overmaken
//  Het is niet mogelijk de transacties direct te manipuleren dus bij iedere transactie moet het type meegegeven worden aan de bank

//  Er zijn twee rekeningtypes:
//  0: debit
//  1: credit
//  Als de desbetreffende rekeningtype die meegegeven wordt in de request, niet succesvol aangevraagd is met de "set[rekening type]RekeningNr" methode bij Bank wordt de transactie op voorhand afgewezen

//  De type moet meegegeven te worden bij alle requests aan bank

    //  This method gets the values from the bank and sets them in the GUI.
//  This method should be implemented as a callback on any event-handlers that require the GUI to be updated.
    public void updateGui() {
        debitRekeningNummerInput.setText(String.valueOf(bank.getDebitRekeningNr()));
        debitNaamOutput.setText(bank.getDebitRekeningNaam());
        debitSaldoOutput.setText(bank.getDebitRekeningSaldo());

        creditRekeningNummerInput.setText(String.valueOf(bank.getCreditRekeningNr()));
        creditNaamOutput.setText(bank.getCreditRekeningNaam());
        creditSaldoOutput.setText(bank.getCreditRekeningSaldo());
        infoDialogueOutput.setText(infoDialogueMessage);
    }

    //   This method binds the event handlers to the GUI.
//   This should only happen during inititation.
    private void bindEvents() {

// Debit = 0

        // Zoek
        debitZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoDialogueMessage = bank.setDebitRekeningNr(Integer.parseInt(debitRekeningNummerInput.getText()));
                updateGui();
            }
        });

        // Stort = 0
        debitStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double bedrag = Double.parseDouble(debitBedragInput.getText());
                    int accountNumber = Integer.parseInt(debitRekeningNummerInput.getText());
                    infoDialogueMessage = bank.requestMutatie(0, 0, accountNumber, bedrag);
                    updateGui();
                } catch (NumberFormatException e1) {
                    infoDialogueMessage = "Error: voer alleen getallen in";
                    updateGui();
                }
            }
        });
        // Neem op = 1
        debitNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double bedrag = Double.parseDouble(debitBedragInput.getText());
                    int accountNumber = Integer.parseInt(debitRekeningNummerInput.getText());
                    infoDialogueMessage = bank.requestMutatie(1, 0, accountNumber, bedrag);
                    updateGui();
                } catch (NumberFormatException e1) {
                    infoDialogueMessage = "Error: voer alleen getallen in";
                    updateGui();
                }
            }
        });

// Credit = 1
        // Zoek
        creditZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoDialogueMessage = bank.setCreditRekeningNr(Integer.parseInt(creditRekeningNummerInput.getText()));
                updateGui();
            }
        });
        // Stort = 0
        creditStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double bedrag = Double.parseDouble(creditBedragInput.getText());
                    int accountNumber = Integer.parseInt(creditRekeningNummerInput.getText());
                    infoDialogueMessage = bank.requestMutatie(0, 1, accountNumber, bedrag);
                    updateGui();
                } catch (NumberFormatException e1) {
                    infoDialogueMessage = "Error: voer alleen getallen in";
                    updateGui();
                }
            }
        });
        // Neem op = 1
        creditNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double bedrag = Double.parseDouble(creditBedragInput.getText());
                    int accountNumber = Integer.parseInt(creditRekeningNummerInput.getText());
                    infoDialogueMessage = bank.requestMutatie(1, 1, accountNumber, bedrag);
                    updateGui();
                } catch (NumberFormatException e1) {
                    infoDialogueMessage = "Error: voer alleen getallen in";
                    updateGui();
                }
            }
        });

// Debit -> Credit events
        //Maak over
        maakOver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double bedrag = Double.parseDouble(debitBedragInput.getText());
                    infoDialogueMessage = bank.requestTransactie(Integer.parseInt(debitRekeningNummerInput.getText()), Integer.parseInt(creditRekeningNummerInput.getText()), bedrag);
                    updateGui();
                } catch (NumberFormatException e1) {
                    infoDialogueMessage = "Error: voer alleen getallen in";
                    updateGui();
                }
            }
        });
    }
}