import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextArea text;//поле для ввода цифр
    private double number1 = 0,number2 = 0;//переменные для хранения операндов
    private int oper;//номер операции

    Calculator(){
        var c = getContentPane();
        var panel = new JPanel();
        panel.setLayout(null);//будем вручную настраивать местоположение элементов

        JButton buttons[] = new JButton[20]; // количество кнопок
        var font = new Font("Arial",Font.ITALIC,17);
        int size = 60; // размер кнопок
        //Дизайн кнопок
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(font);//задаем шрифт текста в кнопке
            buttons[i].setSize(size,size);//размер кнопки
            buttons[i].setBackground(Color.WHITE);//цвет фона
            buttons[i].setForeground(Color.BLACK);//цвет текста
            panel.add(buttons[i]);//размещаем каждую кнопку в панельке
            // Действия при нажатии на кнопку
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();//получили кнопку, на которую был клик
                    String textButton = button.getText();

                    if (textButton.equalsIgnoreCase("=")) {
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

                    }else if (textButton.equalsIgnoreCase("\u221A")) {
                        number1 = Double.parseDouble(text.getText());
                        if (number1<0){
                            text.setText("Число отрицательное");
                        }else { text.setText("" + (Math.sqrt(number1)));}

                    }else if (textButton.equalsIgnoreCase("x^2")) {
                        number1 = Double.parseDouble(text.getText());
                        text.setText("" + (number1*number1));

                    }else if (textButton.equalsIgnoreCase("C")) {
                        text.setText("");//очищаем текстовое поле
                        number1 = 0;
                        number2 = 0;
                    }  else if (textButton.equalsIgnoreCase("+")) {
                        oper = 1;//пусть сложение это первая операция
                        number1 = Double.parseDouble(text.getText());
                        text.setText("");
                    }else if (textButton.equalsIgnoreCase("\u2212")) {
                        oper = 2;//пусть сложение это первая операция
                        number1 = Double.parseDouble(text.getText());
                        text.setText("");
                    }else if (textButton.equalsIgnoreCase("\u00D7")) {
                        oper = 3;//пусть сложение это первая операция
                        number1 = Double.parseDouble(text.getText());
                        text.setText("");
                    }else if (textButton.equalsIgnoreCase("\u00F7")) {
                        oper = 4;//пусть сложение это первая операция
                        number1 = Double.parseDouble(text.getText());
                        text.setText("");
                    }else if (textButton.equalsIgnoreCase("+/-")) {
                        number1 = Double.parseDouble(text.getText());
                        text.setText(""+(-1*number1));
                    }else if (textButton.equalsIgnoreCase(".")) {
                        int index = text.getText().indexOf(".");
                        if (index==-1&&text.getText().equalsIgnoreCase("")) {
                            text.setText("0.");
                        }else if (index==-1) {
                            text.append(textButton);
                        }
                    }else{
                        text.append(textButton);
                        //клик на цифру
                    }
                }
            });
        }

        //задаем отступы у кнопок
        int step = 10; // размер отступа между кнопками
        int wall = 10; // отступ от стенки окна
        //Область ввода/вывода текста
        text = new JTextArea();
        text.setFont(new Font("Arial",Font.PLAIN,20));
        text.setBounds(wall,wall,4*size+3*step,50);
        panel.add(text);
        //ЦИФРЫ _ КНОПКИ
        for (int i = 0; i < 10 ; i++) {
            buttons[i].setText(""+i);//
                   }
        //РАССТАНОВКА КНОПОК по сетке
        int x1 = wall;
        int x2 = x1+size+step;
        int x3 = x2+size+step;
        int x4= x3+size+step;
        int y1= wall+size+step;
        int y2 = y1 + size+step;
        int y3 = y2 + size+step;
        int y4 = y3 + size+ step;
        int y5 = y4 + size+ step;
        buttons[7].setLocation(x1,y2);
        buttons[8].setLocation(x2,y2);
        buttons[9].setLocation(x3,y2);
        buttons[4].setLocation(x1,y3);
        buttons[5].setLocation(x2,y3);
        buttons[6].setLocation(x3,y3);
        buttons[1].setLocation(x1,y4);
        buttons[2].setLocation(x2,y4);
        buttons[3].setLocation(x3,y4);
        buttons[0].setLocation(x2,y5);
        buttons[10].setText("\u00F7");
        buttons[10].setLocation(x4, y1);
        buttons[11].setText("\u00D7");
        buttons[11].setLocation(x4, y2);
        buttons[12].setText("\u2212");
        buttons[12].setLocation(x4, y3);
        buttons[13].setText("+");
        buttons[13].setLocation(x4, y4);
        buttons[14].setText("=");
        buttons[14].setLocation(x4, y5);
        buttons[15].setText("C");
        buttons[15].setLocation(x3,y1);
        buttons[16].setText("\u221A");
        buttons[16].setLocation(x1,y1);
        buttons[17].setText("x^2");
        buttons[17].setLocation(x2,y1);
        buttons[18].setText("+/-");
        buttons[18].setLocation(x1,y5);
        buttons[19].setText(".");
        buttons[19].setLocation(x3,y5);

        c.add(panel); //Добавим область панели
        int width = x4+size+25; // ширина окна
        int height = y5+size+70; // высота окна
        setSize(width,height);
        setTitle("Калькулятор v1.0");
        setLocationRelativeTo(null);

        setResizable(false);//запрещаем менять размер окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закрытие по крестику
        setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Menu menu =new Menu(); //создать меню
        calculator.setJMenuBar(menu.getJMenuBar());// добавить меню

    }

}
