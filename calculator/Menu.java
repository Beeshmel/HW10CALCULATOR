import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu extends JFrame {
    public Menu() {
        var font = new Font("Arial",Font.PLAIN,16);
        var fontP = new Font("Arial",Font.PLAIN,14);

        var menuBar = new JMenuBar();

        JMenu mainMenu = new JMenu("Меню");
        mainMenu.setFont(font);
        var menuInner = new JMenu("О программе");
        menuInner.setFont(fontP);
        mainMenu.add(menuInner);
        var item1 = new JMenuItem("Инструкция");
        var item2 = new JMenuItem("Контакты");
        var item4 = new JMenuItem("Выход");
        item1.setFont(fontP);item2.setFont(fontP);item4.setFont(fontP);
        mainMenu.addSeparator();
        menuInner.add(item1);
        menuInner.add(item2);
        mainMenu.add(item4);

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var c = getContentPane();
                var panel = new JPanel();
                c.add(panel);
                JTextArea text = new JTextArea();
                text.setFont(fontP);
                text.setText("Инструкция. 1. Сложение....");
                text.setBounds(5,5,290,390);
                panel.add(text);
                setSize(300,400);
                setTitle("Калькулятор v1.0_Инструкция");
                setLocationRelativeTo(null);
                setResizable(false);//запрещаем менять размер окна
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//закрытие по крестику
                setVisible(true);
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu secondMenu = new JMenu("Режим");
        secondMenu.setFont(font);
        var secondItem1 = new JMenuItem("Обычный");
        var secondItem2 = new JMenuItem("Математический");
        secondItem1.setFont(fontP); secondItem2.setFont(fontP);

        secondMenu.add(secondItem1);
        secondMenu.addSeparator();
        secondMenu.add(secondItem2);

        menuBar.add(mainMenu);
        menuBar.add(secondMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new Menu().setVisible(true);
    }
}
