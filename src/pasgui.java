import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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
    private JTextField destination_field;
    private JLabel destination_label;


    static String name; static String email; static String phone; static String age; static String gender;
    static String destination;
    JFrame frame2 = new JFrame("PassDisplay");

    //JLabel frame2namelabel = new JLabel("Name: ");
    JLabel frame2namefield = new JLabel(name);



    public void panels(){
        frame2.setSize(500,400);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(new GridLayout(3,3));

        JLabel nametxt = new JLabel(name, JLabel.CENTER);               //block for the users name that they put it showing back on the new frame/pass visual
        nametxt.setLayout(new GridLayout(1,1));
        nametxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(nametxt);

        JLabel agetxt = new JLabel(age, JLabel.CENTER);                 //block for age
        agetxt.setLayout(new GridLayout(1,2));
        agetxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(agetxt);

        JLabel gendertxt = new JLabel(gender, JLabel.CENTER);                 //block for gender
        gendertxt.setLayout(new GridLayout(1,3));
        gendertxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(gendertxt);

        JLabel phonetxt = new JLabel(phone, JLabel.CENTER);                 //block for phone
        phonetxt.setLayout(new GridLayout(2,1));
        phonetxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(phonetxt);

        JLabel emailtxt = new JLabel(email, JLabel.CENTER);                 //block for phone
        emailtxt.setLayout(new GridLayout(2,2));
        emailtxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(emailtxt);

        JLabel idtxt = new JLabel("id", JLabel.CENTER);                 //BOARDING PASS ID IS NEEDED HERE******************************
        emailtxt.setLayout(new GridLayout(2,3));
        emailtxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(idtxt);

        JLabel destinationtxt = new JLabel(destination, JLabel.CENTER);                 //BOARDING PASS ID IS NEEDED HERE******************************
        destinationtxt.setLayout(new GridLayout(3,1));
        destinationtxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(destinationtxt);


    }

    public pasgui() {
        submit_button.addActionListener(new ActionListener() {              //when the submit is pressed
            @Override
            public void actionPerformed(ActionEvent e) {

                name = name_field.getText();
                age = age_field.getText();
                email = email_field.getText();
                phone = phone_field.getText();
                gender = (String)gender_combobox.getSelectedItem();
                destination = destination_field.getText();

                //print on console
                System.out.println(print_to_console(name, age, gender, phone, email));

                JOptionPane.showMessageDialog(null, "Submitting your info");
                //frame 2 displays pass

                panels();
                frame2.setVisible(true);
            }
        });



        age_field.addKeyListener(new KeyAdapter() {                 //restrict them from putting in a letter as age
            @Override
            public void keyPressed(KeyEvent e) {

                String ageanswer = age_field.getText();
                int len = ageanswer.length();

                if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'){
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
