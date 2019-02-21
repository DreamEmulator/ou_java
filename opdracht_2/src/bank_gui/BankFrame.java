package bank_gui;

import bank_domain.Bank;

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
}