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
        bindEvents();

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

    private void bindEvents() {

// Debit events
        debitZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int debitRekeningNr = Integer.parseInt(debitRekeningNummerInput.getText());
                bank.setDebitRekeningNr(debitRekeningNr);
                updateGui();
            }
        });

        debitStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int debitRekeningNr = bank.getDebitRekeningNr();
                double debitStortBedrag = Double.parseDouble(debitBedragInput.getText());
                bank.stortBedrag(debitRekeningNr, debitStortBedrag);
                updateGui();
            }
        });

        debitNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int debitRekeningNr = bank.getDebitRekeningNr();
                double debitOpneemBedrag = Double.parseDouble(debitBedragInput.getText());
                bank.neemBedragOp(debitRekeningNr, debitOpneemBedrag);
                updateGui();
            }
        });

// Credit events
        creditZoekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int creditRekeningNr = Integer.parseInt(creditRekeningNummerInput.getText());
                bank.setCreditRekeningNr(creditRekeningNr);
                updateGui();
            }
        });

        creditStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.stortBedrag(bank.getCreditRekeningNr(), Double.parseDouble(creditBedragInput.getText()));
                updateGui();
            }
        });

        creditNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.neemBedragOp(bank.getCreditRekeningNr(), Double.parseDouble(creditBedragInput.getText()));
                updateGui();
            }
        });

// Debit -> Credit events
        maakOver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.maakOver(bank.getDebitRekeningNr(),bank.getCreditRekeningNr(), Double.parseDouble(debitBedragInput.getText()));
                updateGui();
            }
        });
    }

}
