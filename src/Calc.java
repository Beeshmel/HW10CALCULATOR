import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc extends JFrame {
    private JTextArea text;//поле для ввода цифр
    private double number1 = 0,number2 = 0;//переменные для хранения операндов
    private int oper;//номер операции

    Calc(){

        var c = getContentPane();
        var panel = new JPanel();
        panel.setLayout(null);//будем вручную настраивать местоположение элементов

        JButton buttons[] = new JButton[17];
        var font = new Font("serif",Font.ITALIC,15);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(font);//задаем шрифт текста в кнопке
            buttons[i].setLocation(100,50 + 30 * i);//задаем отступы у кнопок
            buttons[i].setSize(100,25);//размер кнопки
            buttons[i].setBackground(Color.BLUE);//цвет фона
            buttons[i].setForeground(Color.WHITE);//цвет текста
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();//получили кнопку, на которую был клик
                    String textButton = button.getText();
                    if(textButton.equalsIgnoreCase("Выход")){
                        System.exit(0);
                    } else if (textButton.equalsIgnoreCase("C")) {
                        text.setText("");//очищаем текстовое поле
                        number1 = 0;
                        number2 = 0;
                    } else if (textButton.equalsIgnoreCase("=")) {
                        number2 = Double.parseDouble(text.getText());
                        if(oper == 1){
                            text.setText("" + (number1 + number2));
                        }else if (oper == 2){
                            text.setText("" + (number1 - number2));
                        }else if (oper == 3){
                            text.setText("" + (number1 * number2));
                        }else if (oper == 4){
                            if(number2 == 0){
                                JOptionPane.showMessageDialog(null,"На 0 делить нельзя!");
                            }else {
                                text.setText("" + (number1 / number2));
                            }
                        }

                    } else if (textButton.equalsIgnoreCase("+")) {
                        oper = 1;//пусть сложение это первая операция
                        number1 = Double.parseDouble(text.getText());
                        text.setText("+");
                    }else if (textButton.equalsIgnoreCase("-")) {
                        oper = 2;//пусть сложение это первая операция
                        number1 = Double.parseDouble(text.getText());
                        text.setText("-");
                    }else if (textButton.equalsIgnoreCase("*")) {
                        oper = 3;//пусть сложение это первая операция
                        number1 = Double.parseDouble(text.getText());
                        text.setText("*");
                    }else if (textButton.equalsIgnoreCase("/")) {
                        oper = 4;//пусть сложение это первая операция
                        number1 = Double.parseDouble(text.getText());
                        text.setText("/");
                    }else{
                        text.setText(textButton);//клик на цифру
                    }

                }
            });
            panel.add(buttons[i]);//размещаем каждую кнопку в панельке
        }

        for (int i = 0; i < 10 ; i++) {
            buttons[i].setText(""+i);//
        }
        buttons[10].setText("+");
        buttons[11].setText("-");
        buttons[12].setText("*");
        buttons[13].setText("/");
        buttons[14].setText("=");
        buttons[15].setText("C");
        buttons[16].setText("Выход");

        var res = new JLabel("Результат");
        res.setFont(new Font("serif",Font.ITALIC|Font.BOLD,30));
        res.setBounds(130,0,300,50);
        panel.add(res);

        text = new JTextArea();
        text.setFont(new Font("serif",Font.BOLD,30));
        text.setBounds(300,10,300,35);
        panel.add(text);

        c.add(panel);

        setSize(800,600);
        setTitle("Калькулятор v1.0");
        setLocationRelativeTo(null);
        setResizable(false);//запрещаем менять размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие по крестику
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
