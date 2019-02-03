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

    private Bank bank;

    public BankFrame(Bank bank) {
        this.bank = bank;
        System.out.println("bank.Bank GUI Initiated!");

        JFrame frame = new JFrame("Hols bank.Bank");
        frame.setContentPane(bankOverzicht);
        frame.setBounds(700, 200, 700, 200);
        frame.setVisible(true);

        updateGui();
        bindEvents();
    }


    public void updateGui() {
        debitRekeningNummerInput.setText("" + bank.getDebitRekeningNr());
        debitNaamOutput.setText(bank.getRekening(bank.getDebitRekeningNr()).getNaam());
        debitSaldoOutput.setText(String.format("%.2f", bank.getRekening(bank.getDebitRekeningNr()).getSaldo()));

        creditRekeningNummerInput.setText("" + bank.getCreditRekeningNr());
        creditNaamOutput.setText(bank.getRekening(bank.getCreditRekeningNr()).getNaam());
        creditSaldoOutput.setText(String.format("%.2f", bank.getRekening(bank.getCreditRekeningNr()).getSaldo()));
    }

    private void bindEvents() {
// Debit events
        // Zoek
        debitZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.setDebitRekeningNr(Integer.parseInt(debitRekeningNummerInput.getText()));
                updateGui();
            }
        });
        // Stort
        debitStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double bedrag = Double.parseDouble(debitBedragInput.getText());
                if(bedrag > 0 ) {
                    bank.getRekening(bank.getDebitRekeningNr()).stortBedrag(bedrag);
                    updateGui();
                } else {
                    debitBedragInput.setText("Geen negatieve bedragen...");
                }
            }
        });
        // Neem op
        debitNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double bedrag = Double.parseDouble(debitBedragInput.getText());
                if(bedrag > 0 ) {
                    bank.getRekening(bank.getDebitRekeningNr()).neemBedragOp(bedrag);
                    updateGui();
                } else {
                    debitBedragInput.setText("Geen negatieve bedragen...");
                }
            }
        });

// Credit events
        // Zoek
        creditZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.setCreditRekeningNr(Integer.parseInt(creditRekeningNummerInput.getText()));
                updateGui();
            }
        });
        // Stort
        creditStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double bedrag = Double.parseDouble(creditBedragInput.getText());
                if(bedrag > 0 ) {
                    bank.getRekening(bank.getCreditRekeningNr()).stortBedrag(bedrag);
                    updateGui();
                } else {
                    creditBedragInput.setText("Geen negatieve bedragen...");
                }
            }
        });
        // Neem op
        creditNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double bedrag = Double.parseDouble(creditBedragInput.getText());
                if(bedrag > 0 ) {
                    bank.getRekening(bank.getCreditRekeningNr()).neemBedragOp(bedrag);
                    updateGui();
                } else {
                    creditBedragInput.setText("Geen negatieve bedragen...");
                }
            }
        });

// Debit -> Credit events
        //Maak over
        maakOver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double bedrag = Double.parseDouble(debitBedragInput.getText());
                if (bedrag > 0) {
                    bank.maakOver(bank.getDebitRekeningNr(), bank.getCreditRekeningNr(), bedrag);
                    updateGui();
                } else {
                    debitBedragInput.setText("Geen negatieve bedragen...");
                }
            }
        });
    }
}