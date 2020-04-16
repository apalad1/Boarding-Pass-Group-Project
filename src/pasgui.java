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
    private JButton tosearch_button;
    private JTextField searchid_field;


    static String name; static String email; static String phone; static String age; static String gender;
    static String destination;

    static int searchid;

    JFrame frame2 = new JFrame("PassDisplay");

    JFrame searchframe = new JFrame("search bar");

    public void searchframepanel(){
        searchframe.setSize(700,400);
        searchframe.setLayout(new GridLayout(3,6));

        JLabel snamelabel = new JLabel("Name: ", JLabel.LEFT);
        snamelabel.setLayout(new GridLayout(1,1));
        searchframe.add(snamelabel);

        JLabel snameinput = new JLabel("send help DB!");                       //THIS NEEEDS THE DB INFO
        snameinput.setLayout(new GridLayout(1,2));                          //FOR NAME
        searchframe.add(snameinput);

        JLabel sagelabel = new JLabel("Age: ", JLabel.LEFT);
        sagelabel.setLayout(new GridLayout(1,3));
        searchframe.add(sagelabel);

        JLabel sageinput = new JLabel("send help DB!");                       //THIS NEEEDS THE DB INFO
        sageinput.setLayout(new GridLayout(1,4));                           //FOR AGE
        searchframe.add(sageinput);

        JLabel sgenderlabel = new JLabel("Gender: ", JLabel.LEFT);
        sgenderlabel.setLayout(new GridLayout(1,5));
        searchframe.add(sgenderlabel);

        JLabel sgenderinput = new JLabel("send help DB!");                       //THIS NEEEDS THE DB INFO
        sgenderinput.setLayout(new GridLayout(1,6));                        //FOR GENDER
        searchframe.add(sgenderinput);

        ////////////////2ND ROW /////////////////////////////////////////
        JLabel sphonelabel = new JLabel("Phone#: ", JLabel.LEFT);
        sphonelabel.setLayout(new GridLayout(2,1));
        searchframe.add(sphonelabel);

        JLabel sphoneinput = new JLabel("send help DB!");                       //THIS NEEEDS THE DB INFO
        sphoneinput.setLayout(new GridLayout(2,2));                        //FOR PHONE
        searchframe.add(sphoneinput);

        //email
        JLabel semaillabel = new JLabel("Email: ", JLabel.LEFT);
        semaillabel.setLayout(new GridLayout(2,3));
        searchframe.add(semaillabel);

        JLabel semailinput = new JLabel("send help DB!");                       //THIS NEEEDS THE DB INFO
        semailinput.setLayout(new GridLayout(2,4));                        //FOR   EMAIL
        searchframe.add(semailinput);

        //id , searchid is the variable for the userinput on the searchtextfield
        JLabel sidlabel = new JLabel("Id: ", JLabel.LEFT);
        sidlabel.setLayout(new GridLayout(2,5));
        searchframe.add(sidlabel);

        JLabel sidinput = new JLabel(Integer.toString(searchid));
        sidinput.setLayout(new GridLayout(2,6));
        searchframe.add(sidinput);

        ///////3RD ROW /////////////////////////////////////////////////////////
        //destination
        JLabel sdestinationlabel = new JLabel("Destination: ", JLabel.LEFT);
        sdestinationlabel.setLayout(new GridLayout(3,1));
        searchframe.add(sdestinationlabel);

        JLabel sdestinationinput = new JLabel("send help DB!");
        sdestinationinput.setLayout(new GridLayout(3,2));
        searchframe.add(sdestinationinput);

        //blanks to keep the structure intact for the grid
        JLabel sblank1 = new JLabel("");
        sblank1.setLayout(new GridLayout(3,3));
        searchframe.add(sblank1);

        JLabel sblank2 = new JLabel("");
        sblank2.setLayout(new GridLayout(3,4));
        searchframe.add(sblank2);

        JLabel sblank3 = new JLabel("");
        sblank3.setLayout(new GridLayout(3,5));
        searchframe.add(sblank3);

        JButton goback = new JButton("Go Back");                    //block for the goback button when youre on the searchframe
        goback.setLayout(new GridLayout(3,6));
        searchframe.add(goback);

        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit_button.setEnabled(true);

                searchframe.remove(goback);

                searchframe.remove(snamelabel); searchframe.remove(snameinput);
                searchframe.remove(sagelabel); searchframe.remove(sageinput);
                searchframe.remove(sgenderlabel); searchframe.remove(sgenderinput);

                searchframe.remove(sphonelabel); searchframe.remove(sphoneinput);
                searchframe.remove(semaillabel); searchframe.remove(semailinput);
                searchframe.remove(sidlabel); searchframe.remove(sidinput);

                searchframe.remove(sdestinationlabel); searchframe.remove(sdestinationinput);
                searchframe.remove(sblank1);
                searchframe.remove(sblank2);
                searchframe.remove(sblank3);


                searchframe.setVisible(false);
                searchid_field.setText("");
            }
        });


    }

    public void panels(){
        frame2.setSize(700,400);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(new GridLayout(3,6));

        String nametxtlabel = "Name: ";
        JLabel nametxt = new JLabel(nametxtlabel, JLabel.LEFT);               //block for the LABEL FOR NAME
        nametxt.setLayout(new GridLayout(1,1));
        nametxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(nametxt);

        JLabel nameinput = new JLabel(name, JLabel.CENTER);                     ///////////////BLOCK FOR THE USER INPUT FOR NAME
        nameinput.setLayout(new GridLayout(1,2));
        nameinput.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(nameinput);


        String agetxtlabel = "Age: ";
        JLabel agetxt = new JLabel(agetxtlabel, JLabel.LEFT);                 //block for LABEL FOR AGE
        agetxt.setLayout(new GridLayout(1,3));
        agetxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(agetxt);

         JLabel ageinput = new JLabel(age, JLabel.CENTER);                     ///////////////BLOCK FOR THE USER INPUT FOR AGE
        ageinput.setLayout(new GridLayout(1,4));
        ageinput.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(ageinput);


        String gendertxtlabel = "Gender: ";
        JLabel gendertxt = new JLabel(gendertxtlabel, JLabel.LEFT);                 //block for gender
        gendertxt.setLayout(new GridLayout(1,5));
        gendertxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(gendertxt);

        JLabel genderinput = new JLabel(gender, JLabel.CENTER);                     ///////////////BLOCK FOR THE USER INPUT FOR AGE
        genderinput.setLayout(new GridLayout(1,6));
        genderinput.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(genderinput);

        ///////////////////////2ND ROW//////////////////////////////////////////////////////////////////////////////

        String phonetxtlabel = "Phone#: ";
        JLabel phonetxt = new JLabel(phonetxtlabel, JLabel.LEFT);                 //block for phone
        phonetxt.setLayout(new GridLayout(2,1));
        phonetxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(phonetxt);

        JLabel phoneinput = new JLabel(phone, JLabel.CENTER);                     ///////////////BLOCK FOR THE USER INPUT FOR PHONE
        phoneinput.setLayout(new GridLayout(2,2));
        phoneinput.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(phoneinput);

        String emailtxtlabel = "Email: ";
        JLabel emailtxt = new JLabel(emailtxtlabel, JLabel.LEFT);                 //block for email
        emailtxt.setLayout(new GridLayout(2,3));
        emailtxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(emailtxt);

        JLabel emailinput = new JLabel(email, JLabel.CENTER);                     ///////////////BLOCK FOR THE USER INPUT FOR EMAIL
        emailinput.setLayout(new GridLayout(2,4));
        emailinput.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(emailinput);


        String idtxtlabel = "id: ";                                         //<-----------------BOARDING PASS ID IS NEEDED HERE!!!!!!!!!!!!!!!!!
        JLabel idtxt = new JLabel(idtxtlabel, JLabel.LEFT);
        emailtxt.setLayout(new GridLayout(2,5));
        emailtxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(idtxt);

        JLabel idinput = new JLabel("fill this in", JLabel.CENTER);                     ///////////////BLOCK FOR THE GENERATED ID
        idinput.setLayout(new GridLayout(2,6));
        idinput.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(idinput);

        //////////////////////3RD ROW //////////////////////////////////////////////////////////////////////////

        String destinationtxtlabel = "Destination: ";
        JLabel destinationtxt = new JLabel(destinationtxtlabel, JLabel.LEFT);                 //block for destination
        destinationtxt.setLayout(new GridLayout(3,1));
        destinationtxt.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(destinationtxt);

        JLabel destinationinput = new JLabel(destination, JLabel.CENTER);                 //block for destination input
        destinationinput.setLayout(new GridLayout(3,2));
        destinationinput.setFont(new Font("Serif",Font.PLAIN, 16));
        frame2.add(destinationinput);


        JLabel blank1 = new JLabel("", JLabel.LEFT);                            //need the blanks so the grid doesnt look like sht
        blank1.setLayout(new GridLayout(3,3));                              //for maintaining the 3row x 6 col structure of the grid
        frame2.add(blank1);

        JLabel blank2 = new JLabel("", JLabel.LEFT);
        blank2.setLayout(new GridLayout(3,4));
        frame2.add(blank2);

        JLabel blank3 = new JLabel("", JLabel.LEFT);
        blank3.setLayout(new GridLayout(3,5));
        frame2.add(blank3);

        //JLabel blank4 = new JLabel("", JLabel.LEFT);
        //blank4.setLayout(new GridLayout(3,6));
        //frame2.add(blank4);

        JButton gotoform = new JButton("Go Back to Form");
        gotoform.setLayout(new GridLayout(3,6));
        frame2.add(gotoform);

        /////////////////////FOR WHEN THE BUTTON TO GO FROM THE PASSDISPLAY TO THE MAIN FORM IS PRESSED
        gotoform.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);

                //REMOVE ALL THE PREVIOUS LABELS SO THAT WHEN THEY SUBMIT INFO AGAIN ITS FRESH
                frame2.remove(nametxt); frame2.remove(nameinput);
                frame2.remove(agetxt); frame2.remove(ageinput);
                frame2.remove(gendertxt); frame2.remove(genderinput);
                frame2.remove(phonetxt); frame2.remove(phoneinput);
                frame2.remove(emailtxt); frame2.remove(emailinput);
                frame2.remove(destinationtxt);frame2.remove(destinationinput);
                frame2.remove(idtxt); frame2.remove(idinput);
                frame2.remove(blank1);
                frame2.remove(blank2);
                frame2.remove(blank3);
                frame2.remove(gotoform);

                //MAKE THE FIELDS EDITABLE AND WIPE THE PREVIOUS TEXT
                name_field.setEditable(true); name_field.setText("");
                phone_field.setEditable(true); phone_field.setText("");
                age_field.setEditable(true); age_field.setText("");
                destination_field.setEditable(true); destination_field.setText("");
                email_field.setEditable(true); email_field.setText("");
                gender_combobox.setEditable(true); gender_combobox.setSelectedItem("");
                submit_button.setEnabled(true);
                tosearch_button.setEnabled(true);
                searchid_field.setEditable(true);
            }
        });

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
                System.out.println(print_to_console(name, age, gender, phone, email, destination));

                JOptionPane.showMessageDialog(null, "Submitting your info");
                //frame 2 displays pass

                panels();
                frame2.setVisible(true);

                if(frame2.isVisible() == true){
                    name_field.setEditable(false);
                    phone_field.setEditable(false);
                    age_field.setEditable(false);
                    destination_field.setEditable(false);
                    email_field.setEditable(false);
                    gender_combobox.setEditable(false);
                    submit_button.setEnabled(false);
                    tosearch_button.setEnabled(false);
                    searchid_field.setEditable(false);
                }

            }


        });



        //FOR WHEN THE SEARCH BUTTON IS PRESSED TO LOOK FOR THE ID
        tosearch_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    searchid = Integer.parseInt(searchid_field.getText());                        //assign the id that the user put in
                        searchframepanel();
                        searchframe.setVisible(true);
                        submit_button.setEnabled(false);

                }catch (Exception notanum){
                    JOptionPane.showMessageDialog(null, "Please Enter an ID number");
                    searchframe.setVisible(false);                                                      //dont show searchframe if they enter jank
                }




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

    static String print_to_console(String name, String age, String gender, String phone, String email, String destination){
        String reciept = "Name: " + name + "| Age: " + age + " | Gender: " + gender + "\r\n" + "Phone#: " + phone + "\r\n" + "Email: " + email + "\r\n"
                + "Destination: " + destination;
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
