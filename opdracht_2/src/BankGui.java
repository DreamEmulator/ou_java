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

    public BankGui() {
        this.bank = bank;
        System.out.println("Bank GUI Initiated!");

        JFrame frame = new JFrame("BankGui");
        frame.setContentPane(bankOverzicht);
        frame.setBounds(700, 200, 700, 200);
        frame.setVisible(true);
    }


    public void updateGui(int debitRekeningNr, String debitNaam, double debitSaldo, int creditRekeningNr, String creditNaam, double creditSaldo) {

        debitRekeningNummerInput.setText("" + debitRekeningNr);
        debitNaamOutput.setText(debitNaam);
        debitSaldoOutput.setText("" + debitSaldo);

        creditRekeningNummerInput.setText("" + creditRekeningNr);
        creditNaamOutput.setText(creditNaam);
        creditSaldoOutput.setText("" + creditSaldo);

        bindEvents(debitRekeningNr, creditRekeningNr);
    }

    private void bindEvents(int debitRekeningNr, int creditRekeningNr) {
        debitStortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(debitRekeningNr);
                Rekening debitRekening = bank.getRekening(debitRekeningNr);
                double debitStortBedrag = Double.parseDouble(debitBedragInput.getText());
                if (debitStortBedrag > 0) {
                    double huidigSaldo = debitRekening.getSaldo();
                    double nieuwSaldo = huidigSaldo += debitStortBedrag;
                    debitRekening.setSaldo(nieuwSaldo);
                    bank.updateGuiValues(debitRekeningNr,creditRekeningNr);
                }
            }
        });
    }

}
