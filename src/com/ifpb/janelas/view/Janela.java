package com.ifpb.janelas.view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Janela extends JFrame {

    private JLabel label1, label2, label3, label4, label5, label6;
    private JTextField tfNome;
    private JPasswordField pfSenha;
    private JFormattedTextField tfCpf, tfNascimento;
    private JComboBox cbCargo;
    private JRadioButton btMasculino, btFeminino;
    private JButton btSalvar, btLimpar;

    public Janela(String titulo){
        super(titulo);
        setSize(350,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("google.png").getImage());

        Container container = getContentPane();
        container.setBackground(new Color(255,255,255));
        container.setLayout(null);

        adicionarLabels(container);
        addTextFields(container);
        addComboBox(container);
        addRadioButton(container);
        addButtons(container);

        //Ajustar layout para FlowLayout - antes de add componentes
//        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Ajustar layout para BorderLayout
//        container.setLayout(new BorderLayout());

        //Ajustar layout para GridLayout
//        container.setLayout(new GridLayout(2,3));

    }

    private void addButtons(Container container) {

        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");

        btSalvar.setBounds(60, 220, 100, 30);
        btLimpar.setBounds(190, 220,100, 30);

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("OK");
            }
        });

        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Limpar");
            }
        });

        container.add(btSalvar);
        container.add(btLimpar);

    }

    private void addRadioButton(Container container) {

        btMasculino = new JRadioButton("Masculino");
        btFeminino = new JRadioButton("Feminino");

        btFeminino.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(btMasculino);
        group.add(btFeminino);

        btMasculino.setBackground(Color.white);
        btFeminino.setBackground(Color.white);

        btMasculino.setBounds(120, 120, 100, 20);
        btFeminino.setBounds(230, 120, 100,20);

        container.add(btMasculino);
        container.add(btFeminino);
    }

    private void addComboBox(Container container) {

        String array[] = {"Atendimento", "Caixa", "Cozinha", "Gerência"};
        cbCargo = new JComboBox(array);
        cbCargo.setBounds(120, 180, 200, 20);
        container.add(cbCargo);

    }

    private void addTextFields(Container container){

        tfNome = new JTextField();
        tfNome.setBounds(120,60, 200,20);
        container.add(tfNome);
//        tfNome.setFont(new Font("Arial", Font.BOLD, 14));
//        tfNome.setForeground(Color.red);
//        String texto = "Digite seu nome";
//        tfNome.setText(texto);
//        tfNome.setSelectionStart(0);
//        tfNome.setSelectionEnd(texto.length());

        pfSenha = new JPasswordField();
        pfSenha.setBounds(120,150,200,20);
//        pfSenha.setEchoChar('*');
        container.add(pfSenha);

        MaskFormatter formatterCpf = null;
        MaskFormatter formatterNascimento = null;
        try{
            formatterCpf = new MaskFormatter("###.###.###-##");
            formatterNascimento = new MaskFormatter("##/##/####");
        }catch(ParseException ex){
            ex.printStackTrace();
        }

        tfCpf = new JFormattedTextField();
        if(formatterCpf != null){
            formatterCpf.install(tfCpf);
        }
        tfCpf.setBounds(120,30,200,20);
        container.add(tfCpf);

        tfNascimento = new JFormattedTextField();
        if(formatterNascimento != null){
            formatterNascimento.install(tfNascimento);
        }
        tfNascimento.setBounds(120,90,200,20);
        container.add(tfNascimento);

    }

    private void adicionarLabels(Container container) {
        label1 = new JLabel("CPF");
        label2 = new JLabel("Nome");
        label3 = new JLabel("Nascimento");
        label4 = new JLabel("Sexo");
        label5 = new JLabel("Senha");
        label6 = new JLabel("Cargo");

        label1.setBounds(10,30,100,15);
        label2.setBounds(10, 60, 100, 15);
        label3.setBounds(10, 90, 100, 15);
        label4.setBounds(10, 120, 100, 15);
        label5.setBounds(10, 150, 100, 15);
        label6.setBounds(10, 180, 100, 15);

        container.add(label1);
        container.add(label2);
        container.add(label3);
        container.add(label4);
        container.add(label5);
        container.add(label6);

    }


    private void adicionarComponentesGridLayout(Container container) {
        JButton botao1 = new JButton("Botão 1");
        JButton botao2 = new JButton("Botão 2");
        JButton botao3 = new JButton("Botão 3");
        JButton botao4 = new JButton("Botão 4");
        JButton botao5 = new JButton("Botão 5");
        JButton botao6 = new JButton("Botão 6");

        container.add(botao1);
        container.add(botao2);
        container.add(botao3);
        container.add(botao4);
        container.add(botao5);
        container.add(botao6);
    }

    private void adicionarComponentesBorderLayout(Container container) {

        JButton botao1 = new JButton("Norte");
        container.add(botao1, BorderLayout.NORTH);

        JButton botao2 = new JButton("Sul");
        container.add(botao2, BorderLayout.SOUTH);

        JButton botao3 = new JButton("Leste");
        container.add(botao3, BorderLayout.EAST);

        JButton botao4 = new JButton("Oeste");
        container.add(botao4, BorderLayout.WEST);

        JButton botao5 = new JButton("Centro");
        container.add(botao5, BorderLayout.CENTER);

    }

    public static void main(String[] args) {

        Janela janela = new Janela("Cadastro de Funcionário");
        janela.setVisible(true);

    }

    private class OuvinteBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getWhen());
        }

    }

}