package TwoFrames;

import javax.swing.*;

public class TemplateFrame extends JFrame {
    protected TemplateFrame(){
        setSize(280,500);
        setTitle("Работа с фреймами");
        setLocationRelativeTo(null);
        setResizable(false);//запрещаем менять размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие по крестику
    }


}
