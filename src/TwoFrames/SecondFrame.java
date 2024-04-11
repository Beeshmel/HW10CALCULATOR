package TwoFrames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrame extends TemplateFrame {
    JTextField fioField;
    JButton button;


    SecondFrame(String fio){
        fioField = new JTextField(fio);
        button = new JButton("<-");
        var c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,10,30));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                String masFio[] = fioField.getText().split(" ");
                new FirstFrame(masFio[0],masFio[2],masFio[1]).setVisible(true);
            }
        });

        c.add(fioField);
        c.add(button);
    }
}
