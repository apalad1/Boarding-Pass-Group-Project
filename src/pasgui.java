import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private JLabel error_label;


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
                System.out.println(print_to_console(name, age, gender, phone, email));

                //frame 2 displays pass
                frame2.setSize(500,400);
                frame2.setVisible(true);
            }
        });
        age_field.addKeyListener(new KeyAdapter() {                 //restrict them from putting in a letter as age
            @Override
            public void keyPressed(KeyEvent e) {

                String ageanswer = age_field.getText();
                int len = ageanswer.length();

                if(e.getKeyChar() >= '0' && e.getKeyChar() <= '3'){
                    if(len<3){                                          //if youre 1000 years old you cant get on this
                        age_field.setEditable(true);
                    } else{
                        age_field.setEditable(false);
                    }
                }else{
                    //for space and delete keys
                    if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE ||
                            e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                        age_field.setEditable(true);
                    } else{
                        age_field.setEditable(false);
                    }
                }
            }
        });
        phone_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                    String phoneanswer = phone_field.getText();
                    int len = phoneanswer.length();

                    if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
                        if(len<10){
                            phone_field.setEditable(true);
                        } else{
                            phone_field.setEditable(false);
                        }
                    }else{
                        //for space and delete keys
                        if(e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE ||
                                e.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                            phone_field.setEditable(true);
                        } else{
                            phone_field.setEditable(false);
                        }
                    }

            }
        });

    }

    static String print_to_console(String name, String age, String gender, String phone, String email){
        String reciept = "Name: " + name + "| Age: " + age + " | Gender: " + gender + "\r\n" + "Phone#: " + phone + "\r\n" + "Email: " + email;
        return reciept;
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
