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
        System.out.println("Bank GUI Initiated!");

        JFrame frame = new JFrame("Hols Bank");
        frame.setContentPane(bankOverzicht);
        frame.setBounds(700, 200, 700, 200);
        frame.setVisible(true);

        updateGui();
        bindEvents();
    }


    public void updateGui() {
        debitRekeningNummerInput.setText("" + bank.getDebitRekeningNr());
        debitNaamOutput.setText(bank.getRekening(bank.getDebitRekeningNr()).getNaam());
        debitSaldoOutput.setText("" + bank.getRekening(bank.getDebitRekeningNr()).getSaldo());

        creditRekeningNummerInput.setText("" + bank.getCreditRekeningNr());
        creditNaamOutput.setText(bank.getRekening(bank.getCreditRekeningNr()).getNaam());
        creditSaldoOutput.setText("" + bank.getRekening(bank.getCreditRekeningNr()).getSaldo());
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
                bank.getRekening(bank.getDebitRekeningNr()).stortBedrag(Double.parseDouble(debitBedragInput.getText()));
                updateGui();
            }
        });
        // Neem op
        debitNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.getRekening(bank.getDebitRekeningNr()).neemBedragOp(Double.parseDouble(creditBedragInput.getText()));
                updateGui();
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
                bank.getRekening(bank.getCreditRekeningNr()).stortBedrag(Double.parseDouble(creditBedragInput.getText()));
                updateGui();
            }
        });
        // Neem op
        creditNeemOpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.getRekening(bank.getCreditRekeningNr()).neemBedragOp(Double.parseDouble(creditBedragInput.getText()));
                updateGui();
            }
        });

// Debit -> Credit events
        //Maak over
        maakOver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.maakOver(bank.getDebitRekeningNr(),bank.getCreditRekeningNr(), Double.parseDouble(debitBedragInput.getText()));
                updateGui();
            }
        });
    }
}

//TODO: Vraag of je niet bete variabelen aan kan maken puur voor duidelijkheid?
