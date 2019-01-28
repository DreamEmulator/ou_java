import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGui {
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

    public BankGui(Bank bank) {
        this.bank = bank;
        System.out.println("Bank GUI Initiated!");

        JFrame frame = new JFrame("Hols Bank");
        frame.setContentPane(bankOverzicht);
        frame.setBounds(700, 200, 700, 200);
        frame.setVisible(true);

        updateGui();
        bindEvents(bank.getDebitRekeningNr(), bank.getCreditRekeningNr());

    }


    public void updateGui() {

        String debitNaam = bank.getRekening(bank.getDebitRekeningNr()).getNaam();
        double debitSaldo = bank.getRekening(bank.getDebitRekeningNr()).getSaldo();

        String creditNaam = bank.getRekening(bank.getCreditRekeningNr()).getNaam();
        double creditSaldo = bank.getRekening(bank.getCreditRekeningNr()).getSaldo();


        debitRekeningNummerInput.setText("" + bank.getDebitRekeningNr());
        debitNaamOutput.setText(debitNaam);
        debitSaldoOutput.setText("" + debitSaldo);

        creditRekeningNummerInput.setText("" + bank.getCreditRekeningNr());
        creditNaamOutput.setText(creditNaam);
        creditSaldoOutput.setText("" + creditSaldo);
    }

    private void bindEvents(int debitRekeningNr, int creditRekeningNr) {

// Debit events
        debitStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Rekening debitRekening = bank.getRekening(debitRekeningNr);
                double debitStortBedrag = Double.parseDouble(debitBedragInput.getText());

                if (debitStortBedrag > 0) {
                    double huidigSaldo = debitRekening.getSaldo();
                    double nieuwSaldo = huidigSaldo + debitStortBedrag;

                    System.out.println("Huidig saldo " + huidigSaldo);
                    System.out.println("Debit stort bedrag " + debitStortBedrag);

                    debitRekening.setSaldo(nieuwSaldo);

                    System.out.println("Nieuw debit saldo " + nieuwSaldo);

                    updateGui();
                }
            }
        });

// Credit events
        creditStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rekening creditRekening = bank.getRekening(creditRekeningNr);
                double creditStortBedrag = Double.parseDouble(creditBedragInput.getText());

                if (creditStortBedrag > 0) {
                    double huidigSaldo = creditRekening.getSaldo();
                    double nieuwSaldo = huidigSaldo + creditStortBedrag;

                    System.out.println("Huidig saldo " + huidigSaldo);
                    System.out.println("Credit stort bedrag " + creditStortBedrag);

                    creditRekening.setSaldo(nieuwSaldo);

                    System.out.println("Nieuw credit saldo " + nieuwSaldo);

                    updateGui();
                }
            }
        });
    }

}
