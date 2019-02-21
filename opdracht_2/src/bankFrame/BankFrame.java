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


/**  Er zijn twee rekeningtypes:
 //  0: debit
 //  1: credit
 //  Als de desbetreffende rekeningtype die meegegeven wordt in de request, niet succesvol aangevraagd is met de "set[rekening type]RekeningNr" methode bij Bank wordt de transactie op voorhand afgewezen

 //  De type moet meegegeven te worden bij alle requests aan bank

 //  This method gets the values from the bank and sets them in the GUI.
 */

    /**
     * Alle interactie met Bank moeten gebeuren inbinnen in execute
     */

    private void updateGui() {
        if (debitBedragInput.getText().length() == 0) {
            debitBedragInput.setText("0.00");
        }

        if (creditBedragInput.getText().length() == 0) {
            creditBedragInput.setText("0.00");
        }
        debitRekeningNummerInput.setText(String.valueOf(bank.getDebitRekeningNr()));
        debitNaamOutput.setText(bank.getDebitRekeningNaam());
        debitSaldoOutput.setText(String.format("%.2f", bank.getDebitRekeningSaldo()));

        creditRekeningNummerInput.setText(String.valueOf(bank.getCreditRekeningNr()));
        creditNaamOutput.setText(bank.getCreditRekeningNaam());
        creditSaldoOutput.setText(String.format("%.2f", bank.getCreditRekeningSaldo()));
    }

    private void checkInputs() {
        try {
//            if (debitBedragInput.getText().length() == 0) {
//                debitBedragInput.setText("0.00");
//            }
//
//            if (creditBedragInput.getText().length() == 0) {
//                creditBedragInput.setText("0.00");
//            }

            Integer.parseInt(debitRekeningNummerInput.getText());
            Integer.parseInt(creditRekeningNummerInput.getText());
            Double.parseDouble(creditBedragInput.getText());
            Double.parseDouble(debitBedragInput.getText());
        } catch (NumberFormatException e1) {
            error("voer alleen getallen in!");
        }
    }

    private void execute() {
        updateGui();
        infoDialogueOutput.setText("");
    }

    private void execute(String message) {
        updateGui();
        infoDialogueOutput.setText(message);
    }

    /**
     * This logs an error to the GUI and the console.
     *
     * @param error is the message to log outz
     */
    private void error(String error) {
        error = "Error: " + error;
        infoDialogueOutput.setText(error);
        System.out.println(error);
    }

    /**
     * This method binds the event handlers to the GUI.
     * This should only happen during ONCE inititation.
     */
    private void bindEvents() {

// Debit rekening events
        // Zoeken
        debitZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputs();
                execute(bank.setDebitRekeningNr(Integer.parseInt(debitRekeningNummerInput.getText())));
            }
        });

        // Opnemen = 0
        debitNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputs();
                if (Integer.parseInt(debitRekeningNummerInput.getText()) == bank.getDebitRekeningNr()) {
                    execute(bank.requestTransactie(0, Integer.parseInt(debitRekeningNummerInput.getText()), Double.parseDouble(debitBedragInput.getText())));
                } else {
                    error("het debit-rekeningnummer klopt niet, zoek de rekening opnieuw...");
                }
            }
        });

        // Storten = 1
        debitStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputs();
                if (Integer.parseInt(debitRekeningNummerInput.getText()) == bank.getDebitRekeningNr()) {
                    execute(bank.requestTransactie(1, Integer.parseInt(debitRekeningNummerInput.getText()), Double.parseDouble(debitBedragInput.getText())));
                } else {
                    error("het debit-rekeningnummer klopt niet, zoek de rekening opnieuw...");
                }
            }
        });

// Credit rekening events
        // Zoeken
        creditZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputs();
                execute(bank.setCreditRekeningNr(Integer.parseInt(creditRekeningNummerInput.getText())));
            }
        });
        // Opnemen = 0
        creditNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputs();
                if (Integer.parseInt(creditRekeningNummerInput.getText()) == bank.getCreditRekeningNr()) {
                    execute(bank.requestTransactie(0, Integer.parseInt(creditRekeningNummerInput.getText()), Double.parseDouble(creditBedragInput.getText())));
                } else {
                    error("het credit-rekeningnummer klopt niet, zoek de rekening opnieuw...");
                }
            }
        });
        // Storten = 1
        creditStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputs();
                if (Integer.parseInt(creditRekeningNummerInput.getText()) == bank.getCreditRekeningNr()) {
                    execute(bank.requestTransactie(1, Integer.parseInt(creditRekeningNummerInput.getText()), Double.parseDouble(creditBedragInput.getText())));
                } else {
                    error("het credit-rekeningnummer klopt niet, zoek de rekening opnieuw...");
                }
            }
        });

// Debit naar Credit events
        //Overmaken = 2
        maakOver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputs();
                execute(bank.requestTransactie(2, Integer.parseInt(debitRekeningNummerInput.getText()), Integer.parseInt(creditRekeningNummerInput.getText()), Double.parseDouble(debitBedragInput.getText())));
            }
        });
    }
}