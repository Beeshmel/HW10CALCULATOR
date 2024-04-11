import TwoFrames.TemplateFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestRadioButtons extends TemplateFrame {
    JRadioButton rb1,rb2,rb3;
    JCheckBox cb1,cb2,cb3;
    JLabel text;

    TestRadioButtons(){
        setTitle("Пример использования радио-кнопок");
        text = new JLabel("Тестовый текст");
        rb1 = new JRadioButton("20");
        rb2 = new JRadioButton("30");
        rb3 = new JRadioButton("40");

        cb1 = new JCheckBox("Курсив");
        cb2 = new JCheckBox("Жирный");
        cb3 = new JCheckBox("Обычный");

        List<JRadioButton> listRadio = new ArrayList<>();
        Collections.addAll(listRadio,rb1,rb2,rb3);

//        Если только одна радио-кнопка должна быть выбрана, то необходимо создать группу и в нее
//        добавить каждую радио-кнопку для этой группы

        ButtonGroup group = new ButtonGroup();
        group.add(rb1); group.add(rb2); group.add(rb3);
        var c = getContentPane();
        c.setLayout(new FlowLayout());
        var listener = new MyListener();

        for (JRadioButton button : listRadio) {
            button.addItemListener(listener);
            c.add(button);
        }
        c.add(cb1);c.add(cb2);c.add(cb3);
        cb1.addItemListener(listener);
        cb2.addItemListener(listener);
        cb3.addItemListener(listener);
        c.add(text);




    }

    class MyListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            var object = e.getSource();
            if(object instanceof JCheckBox){
                JOptionPane.showMessageDialog(null,"Событие с чекбоксом");
            }else if(object instanceof JRadioButton){
                JOptionPane.showMessageDialog(null,"Событие с радио");
            
                Font font = null;
                if ( ((JRadioButton) object).isSelected()){
                    font = new Font("verdana",Font.BOLD,Integer.parseInt(((JRadioButton) object).getText()));
                }
                text.setFont(font);
            }

        }
    }

    public static void main(String[] args) {
        new TestRadioButtons().setVisible(true);
    }
}
