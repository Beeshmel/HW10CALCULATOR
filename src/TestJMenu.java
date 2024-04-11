import TwoFrames.TemplateFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestJMenu extends TemplateFrame {
    TestJMenu(){
        var menuBar = new JMenuBar();
        JMenu mainMenu = new JMenu("Главное меню");
        var font = new Font("serif",Font.BOLD,15);
        mainMenu.setFont(font);

        var menuInner = new JMenu("О компании");
        mainMenu.add(menuInner);
        var item1 = new JMenuItem("Услуги");
        var item2 = new JMenuItem("История");
        var item3 = new JMenuItem("Контакты");
        item1.setFont(font);item2.setFont(font);item3.setFont(font);
        menuInner.add(item1);menuInner.add(item2);menuInner.add(item3);
        mainMenu.addSeparator();
        var item4 = new JMenuItem("Выход");
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainMenu.add(item4);
        menuBar.add(mainMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new TestJMenu().setVisible(true);
    }
}
