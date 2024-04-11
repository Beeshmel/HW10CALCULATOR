package TwoFrames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends TemplateFrame{
    JTextField name,lastNameField,surnameField;
    JLabel textName,textLastName,textSurname;
    JButton button;

    FirstFrame(){
        this("","","");
    }

    public FirstFrame(String firstName, String lastName, String surname) {
        System.out.println(firstName + " " + lastName + " " + surname);
        name = new JTextField(firstName,20);
        lastNameField = new JTextField(lastName,20);
        surnameField = new JTextField(surname,20);
        textName = new JLabel("Введите имя");
        textLastName = new JLabel("Введите фамилию");
        textSurname = new JLabel("Введите отчество");

        button = new JButton("->");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);//скрыли окно
                String fio = name.getText()
                        .concat(" ")
                        .concat(surnameField.getText())
                        .concat(" ")
                        .concat(lastNameField.getText());
                var secondFrame = new SecondFrame(fio);
                secondFrame.setVisible(true);
            }
        });

        var c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,10,30));

        c.add(textName);
        c.add(this.name);

        c.add(textSurname);
        c.add(this.surnameField);

        c.add(textLastName);
        c.add(this.lastNameField);

        c.add(button);

        setVisible(true);
    }
}
