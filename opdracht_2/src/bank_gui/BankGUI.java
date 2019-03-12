package bank_gui;

import bank_domain.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI {
    private JPanel bankView;
    private JPanel knoppenbalk;
    private JPanel debitTransacties;
    private JPanel maakOver;
    private JPanel creditTransacties;
    private JButton debitOpnemen;
    private JButton debitStorten;
    private JButton overmaken;
    private JButton creditOpnemen;
    private JButton creditStorten;
    private JButton debitZoeken;
    private JButton creditZoeken;
    private JPanel debit;
    private JPanel credit;
    private JLabel debitTitel;
    private JLabel creditTitel;
    private JPanel debitRekeningNrPanel;
    private JPanel debitNaamPanel;
    private JPanel debitSaldoPanel;
    private JPanel debitBedragPanel;
    private JLabel debitRekeningNrLabel;
    private JLabel debitNaamLabel;
    private JTextField debitRekeningNrInput;
    private JLabel debitNaam;
    private JLabel debitSaldoLabel;
    private JLabel debitSaldo;
    private JLabel debitBedragLabel;
    private JTextField debitBedragInput;
    private JPanel titels;
    private JPanel creditRekeningNrPanel;
    private JLabel creditRekeningNrLabel;
    private JTextField creditRekeningNrInput;
    private JPanel creditNaamPanel;
    private JLabel creditNaamLabel;
    private JLabel creditNaam;
    private JPanel creditSaldoPanel;
    private JLabel creditSaldoLabel;
    private JLabel creditSaldo;
    private JPanel creditBedragPanel;
    private JLabel creditBedragLabel;
    private JTextField creditBedragInput;
    private JPanel debitZoekenPanel;
    private JPanel creditZoekenPanel;

    private Bank bank;

    public BankGUI(Bank bank) {
        this.bank = bank;
        System.out.println("Bank GUI Initiated!");
        JFrame frame = new JFrame("Hols bank");
        frame.setContentPane(bankView);
        frame.setBounds(300, 200, 600, 280);
        frame.setVisible(true);
        bindEvents();
    }


    private void bindEvents() {

        // Debit Zoeken
        debitZoeken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                debitNaam.setText(bank.zoeken(Integer.parseInt(debitRekeningNrInput.getText())).getNaam());
                debitSaldo.setText(String.format("%.2f", bank.zoeken(Integer.parseInt(debitRekeningNrInput.getText())).getSaldo()));
            }
        });

        // Debit Opnemen
        debitOpnemen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.opnemen(Integer.parseInt(debitRekeningNrInput.getText()), Double.parseDouble(debitBedragInput.getText()));
                debitSaldo.setText(String.format("%.2f", bank.zoeken(Integer.parseInt(debitRekeningNrInput.getText())).getSaldo()));
            }
        });

        // Debit Storten
        debitStorten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.storten(Integer.parseInt(debitRekeningNrInput.getText()), Double.parseDouble(debitBedragInput.getText()));
                debitSaldo.setText(String.format("%.2f", bank.zoeken(Integer.parseInt(debitRekeningNrInput.getText())).getSaldo()));
            }
        });


        // Credit Zoeken
        creditZoeken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditNaam.setText(bank.zoeken(Integer.parseInt(creditRekeningNrInput.getText())).getNaam());
                creditSaldo.setText(String.format("%.2f", bank.zoeken(Integer.parseInt(creditRekeningNrInput.getText())).getSaldo()));
            }
        });

        // Opnemen
        creditOpnemen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.opnemen(Integer.parseInt(creditRekeningNrInput.getText()), Double.parseDouble(creditBedragInput.getText()));
                creditSaldo.setText(String.format("%.2f", bank.zoeken(Integer.parseInt(creditRekeningNrInput.getText())).getSaldo()));
            }
        });

        // Storten
        creditStorten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.storten(Integer.parseInt(creditRekeningNrInput.getText()), Double.parseDouble(creditBedragInput.getText()));
                creditSaldo.setText(String.format("%.2f", bank.zoeken(Integer.parseInt(creditRekeningNrInput.getText())).getSaldo()));
            }
        });

        //Overmaken
        overmaken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.overmaken(Integer.parseInt(debitRekeningNrInput.getText()), Integer.parseInt(creditRekeningNrInput.getText()), Double.parseDouble(debitBedragInput.getText()));
                debitSaldo.setText(String.format("%.2f", bank.zoeken(Integer.parseInt(debitRekeningNrInput.getText())).getSaldo()));
                creditSaldo.setText(String.format("%.2f", bank.zoeken(Integer.parseInt(creditRekeningNrInput.getText())).getSaldo()));
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
        bankView = new JPanel();
        bankView.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(30, 30));
        bankView.add(panel1, BorderLayout.CENTER);
        titels = new JPanel();
        titels.setLayout(new BorderLayout(0, 0));
        panel1.add(titels, BorderLayout.NORTH);
        debitTitel = new JLabel();
        debitTitel.setText("Debit Rekening");
        titels.add(debitTitel, BorderLayout.WEST);
        creditTitel = new JLabel();
        creditTitel.setText("Credit Rekening");
        titels.add(creditTitel, BorderLayout.EAST);
        credit = new JPanel();
        credit.setLayout(new BorderLayout(0, 0));
        panel1.add(credit, BorderLayout.EAST);
        creditRekeningNrPanel = new JPanel();
        creditRekeningNrPanel.setLayout(new BorderLayout(0, 0));
        credit.add(creditRekeningNrPanel, BorderLayout.NORTH);
        creditNaamPanel = new JPanel();
        creditNaamPanel.setLayout(new BorderLayout(0, 0));
        creditRekeningNrPanel.add(creditNaamPanel, BorderLayout.SOUTH);
        creditSaldoPanel = new JPanel();
        creditSaldoPanel.setLayout(new BorderLayout(0, 0));
        creditNaamPanel.add(creditSaldoPanel, BorderLayout.SOUTH);
        creditBedragPanel = new JPanel();
        creditBedragPanel.setLayout(new BorderLayout(0, 0));
        creditSaldoPanel.add(creditBedragPanel, BorderLayout.SOUTH);
        creditBedragLabel = new JLabel();
        creditBedragLabel.setText("Bedrag");
        creditBedragPanel.add(creditBedragLabel, BorderLayout.WEST);
        creditBedragInput = new JTextField();
        creditBedragInput.setText("0.00");
        creditBedragPanel.add(creditBedragInput, BorderLayout.EAST);
        creditSaldoLabel = new JLabel();
        creditSaldoLabel.setText("Saldo");
        creditSaldoPanel.add(creditSaldoLabel, BorderLayout.WEST);
        creditSaldo = new JLabel();
        creditSaldo.setText("Geen");
        creditSaldoPanel.add(creditSaldo, BorderLayout.EAST);
        creditNaamLabel = new JLabel();
        creditNaamLabel.setText("Naam");
        creditNaamPanel.add(creditNaamLabel, BorderLayout.WEST);
        creditNaam = new JLabel();
        creditNaam.setText("Geen");
        creditNaamPanel.add(creditNaam, BorderLayout.EAST);
        creditRekeningNrLabel = new JLabel();
        creditRekeningNrLabel.setText("Rekening Nummer");
        creditRekeningNrPanel.add(creditRekeningNrLabel, BorderLayout.WEST);
        creditRekeningNrInput = new JTextField();
        creditRekeningNrInput.setText("enter rekening nr");
        creditRekeningNrPanel.add(creditRekeningNrInput, BorderLayout.EAST);
        debit = new JPanel();
        debit.setLayout(new BorderLayout(0, 0));
        panel1.add(debit, BorderLayout.WEST);
        debitRekeningNrPanel = new JPanel();
        debitRekeningNrPanel.setLayout(new BorderLayout(0, 0));
        debit.add(debitRekeningNrPanel, BorderLayout.NORTH);
        debitNaamPanel = new JPanel();
        debitNaamPanel.setLayout(new BorderLayout(0, 0));
        debitRekeningNrPanel.add(debitNaamPanel, BorderLayout.SOUTH);
        debitSaldoPanel = new JPanel();
        debitSaldoPanel.setLayout(new BorderLayout(0, 0));
        debitNaamPanel.add(debitSaldoPanel, BorderLayout.SOUTH);
        debitBedragPanel = new JPanel();
        debitBedragPanel.setLayout(new BorderLayout(0, 0));
        debitSaldoPanel.add(debitBedragPanel, BorderLayout.SOUTH);
        debitBedragLabel = new JLabel();
        debitBedragLabel.setText("Bedrag");
        debitBedragPanel.add(debitBedragLabel, BorderLayout.WEST);
        debitBedragInput = new JTextField();
        debitBedragInput.setText("0.00");
        debitBedragPanel.add(debitBedragInput, BorderLayout.EAST);
        debitSaldoLabel = new JLabel();
        debitSaldoLabel.setText("Saldo");
        debitSaldoPanel.add(debitSaldoLabel, BorderLayout.WEST);
        debitSaldo = new JLabel();
        debitSaldo.setText("Geen");
        debitSaldoPanel.add(debitSaldo, BorderLayout.EAST);
        debitNaamLabel = new JLabel();
        debitNaamLabel.setText("Naam");
        debitNaamPanel.add(debitNaamLabel, BorderLayout.WEST);
        debitNaam = new JLabel();
        debitNaam.setText("Geen");
        debitNaamPanel.add(debitNaam, BorderLayout.EAST);
        debitRekeningNrLabel = new JLabel();
        debitRekeningNrLabel.setText("Rekening Nummer");
        debitRekeningNrPanel.add(debitRekeningNrLabel, BorderLayout.WEST);
        debitRekeningNrInput = new JTextField();
        debitRekeningNrInput.setText("enter rekening nr");
        debitRekeningNrPanel.add(debitRekeningNrInput, BorderLayout.EAST);
        knoppenbalk = new JPanel();
        knoppenbalk.setLayout(new BorderLayout(0, 0));
        panel1.add(knoppenbalk, BorderLayout.SOUTH);
        debitTransacties = new JPanel();
        debitTransacties.setLayout(new BorderLayout(0, 0));
        knoppenbalk.add(debitTransacties, BorderLayout.WEST);
        debitOpnemen = new JButton();
        debitOpnemen.setText("Opnemen");
        debitTransacties.add(debitOpnemen, BorderLayout.WEST);
        debitStorten = new JButton();
        debitStorten.setText("Storten");
        debitTransacties.add(debitStorten, BorderLayout.EAST);
        debitZoekenPanel = new JPanel();
        debitZoekenPanel.setLayout(new BorderLayout(0, 0));
        debitTransacties.add(debitZoekenPanel, BorderLayout.NORTH);
        debitZoeken = new JButton();
        debitZoeken.setText("Zoeken");
        debitZoekenPanel.add(debitZoeken, BorderLayout.CENTER);
        maakOver = new JPanel();
        maakOver.setLayout(new BorderLayout(0, 0));
        knoppenbalk.add(maakOver, BorderLayout.NORTH);
        overmaken = new JButton();
        overmaken.setText("Maak over >>");
        maakOver.add(overmaken, BorderLayout.CENTER);
        creditTransacties = new JPanel();
        creditTransacties.setLayout(new BorderLayout(0, 0));
        knoppenbalk.add(creditTransacties, BorderLayout.EAST);
        creditOpnemen = new JButton();
        creditOpnemen.setText("Opnemen");
        creditTransacties.add(creditOpnemen, BorderLayout.WEST);
        creditStorten = new JButton();
        creditStorten.setText("Storten");
        creditTransacties.add(creditStorten, BorderLayout.EAST);
        creditZoekenPanel = new JPanel();
        creditZoekenPanel.setLayout(new BorderLayout(0, 0));
        creditTransacties.add(creditZoekenPanel, BorderLayout.NORTH);
        creditZoeken = new JButton();
        creditZoeken.setText("Zoeken");
        creditZoekenPanel.add(creditZoeken, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return bankView;
    }

}
