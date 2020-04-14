import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pasgui extends JFrame{


    private JPanel panelMain;
    private JButton submit_button;
    private JLabel name_label;
    private JTextField name_field;
    private JTextField phone_field;
    private JTextField email_field;
    private JTextField age_field;
    private JComboBox gender_combobox;
    private JLabel email_label;
    private JLabel age_label;
    private JLabel gender_label;


    static String name; static String email; static String phone; static String age; static String gender;
    JFrame frame2 = new JFrame("PassDisplay");

    public pasgui() {
        submit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Submitting your info");
                name = name_field.getText();
                age = age_field.getText();
                email = email_field.getText();
                phone = phone_field.getText();
                gender = (String)gender_combobox.getSelectedItem();

                //print on console
                System.out.println(gender);

                //frame 2 displays pass
                frame2.setSize(500,400);
                frame2.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        //create window
        JFrame frame = new JFrame("BoardingGUI");
        frame.setContentPane(new pasgui().panelMain);




        //display window
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
