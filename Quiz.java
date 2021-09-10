package script;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
    
    public static void main(String args[]){
        
        Quiz quiz = new Quiz();
        
    }
    
    String[] Questoes = {
                         "Qual é a ordem de importância (do mais importante para o menos) dos 3 R’s?",
                         "De que cor é a lixeira correta para o descarte de papel?",
                         "Se a embalagem tiver este símbolo então é reciclável.",
                         "É preciso lavar as embalagens antes de as pôr no ecoponto?",
                         "Quantas vezes pode uma lata ser reciclada?",
                         "Quanto tempo o vidro leva para se decompor na natureza?",
                         "Qual é a porcentagem do lixo que é reciclado no Brasil?",
                         "Qual é o país número 1 em reciclagem de alumínio?",
                         "Qual é a cidade que mais produz lixo diariamente no Brasil?",
                         "De que cor é a lixeira correta para o descarte de metal?"
                         
                        };
    String[][] Opçoes = {
                            {"Reutilizar, reduzir, reciclar","Reciclar, reduzir, reutilizar","Reduzir, reutilizar, reciclar",
                             "Reciclar, reutilizar, reduzir"},//terceira
                            {"Azul","Verde","Vermelho","Marrom"},//primeira
                            {"Verdade","Mentira","Isso é relativo","Não Sei"},//segunda
                            {"Sim","Não","Isso é relativo","Não sei"},//primeira
                            {"Infinitamente","100000 vezes","10 vezes","Apenas uma vez"},//primeira
                            {"300 anos","1000 anos","100 anos","O vidro não é biodegradável"},//quarta
                            {"17%","40%","22%","3%"},//quarta
                            {"Alemanha","Estados Unidos da América","Itália","Brasil"},//quarta
                            {"Santos","São Paulo","Rio de Janeiro","Salvador"},//segunda
                            {"Azul","Verde","Vermelho","Marrom"}//terceira
                           
                            
                        };
    char[] Respostas = {
                        'C','A','B','A','A','D','D','D','B','C'
                       };
    char Escolha;
    char Resposta;
    int index;
    int chutesCorretos = 0;
    int questoesTotais = Questoes.length;
    int Resultado;
    
    JFrame frame = new JFrame();
    JTextField campoTexto = new JTextField();
    JTextArea areaTexto = new JTextArea();
    JButton botãoA = new JButton();
    JButton botãoB = new JButton();
    JButton botãoC = new JButton();
    JButton botãoD = new JButton();
    JLabel rótuloRespostaA = new JLabel();
    JLabel rótuloRespostaB = new JLabel();
    JLabel rótuloRespostaC = new JLabel();
    JLabel rótuloRespostaD = new JLabel();
    JTextField acertos = new JTextField();
    JTextField porcentagem = new JTextField();
    
    
    
    
    
    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1366,768);
        frame.getContentPane().setBackground(new Color(0,0,0));
        frame.setLayout(null);
        
        campoTexto.setBounds(0,0,1366,80);
        campoTexto.setBackground(new Color(255,255,255));
        campoTexto.setForeground(new Color (0,250,120));
        campoTexto.setFont(new Font("Ink Free",Font.BOLD,30));
        campoTexto.setBorder(BorderFactory.createBevelBorder(1));
        campoTexto.setHorizontalAlignment(JTextField.CENTER);
        campoTexto.setEditable(false);

  
        areaTexto.setBounds(0,160,1366,110);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setBackground(new Color(25,25,25));   
        areaTexto.setForeground(new Color(155,240,155));
        areaTexto.setFont(new Font("MV Boli",Font.BOLD,35));               
        areaTexto.setBorder(BorderFactory.createBevelBorder(1));
        areaTexto.setEditable(false);        
                
        
        botãoA.setBounds(20, 400, 65,65);     
        botãoA.setFont(new Font("MV Boli", Font.BOLD, 35));
        botãoA.setFocusable(false);
        botãoA.addActionListener(this);
        botãoA.setText("A");
        botãoA.setBackground(new Color(122,154,0));
        
        botãoB.setBounds(20, 500, 65,65);     
        botãoB.setFont(new Font("MV Boli", Font.BOLD, 35));
        botãoB.setFocusable(false);
        botãoB.addActionListener(this);
        botãoB.setText("B");
        botãoB.setBackground(new Color(122,154,0));
        
        botãoC.setBounds(600, 400, 65,65);     
        botãoC.setFont(new Font("MV Boli", Font.BOLD, 35));
        botãoC.setFocusable(false);
        botãoC.addActionListener(this);
        botãoC.setText("C");
        botãoC.setBackground(new Color(122,154,0));
        
        botãoD.setBounds(600, 500, 65,65);     
        botãoD.setFont(new Font("MV Boli", Font.BOLD, 35));
        botãoD.setFocusable(false);
        botãoD.addActionListener(this);
        botãoD.setText("D");
        botãoD.setBackground(new Color(122,154,0));
        
        rótuloRespostaA.setBounds(100,380,500,100);
        rótuloRespostaA.setBackground(new Color(3,10,9));
        rótuloRespostaA.setForeground(new Color(155,240,155));
        rótuloRespostaA.setFont(new Font("MV Boli", Font.PLAIN, 25));
        
        
        rótuloRespostaB.setBounds(100,480,500,100);
        rótuloRespostaB.setBackground(new Color(3,10,9));
        rótuloRespostaB.setForeground(new Color(155,240,155));
        rótuloRespostaB.setFont(new Font("MV Boli", Font.PLAIN, 25));
        
        
        rótuloRespostaC.setBounds(700,380,500,100);
        rótuloRespostaC.setBackground(new Color(3,10,9));
        rótuloRespostaC.setForeground(new Color(155,240,155));
        rótuloRespostaC.setFont(new Font("MV Boli", Font.PLAIN, 25));
        
        
        rótuloRespostaD.setBounds(700,480,500,100);
        rótuloRespostaD.setBackground(new Color(3,10,9));
        rótuloRespostaD.setForeground(new Color(155,240,155));
        rótuloRespostaD.setFont(new Font("MV Boli", Font.PLAIN, 25));
        
        
        acertos.setBounds(683,384,200,100);
        acertos.setBackground(new Color(25,25,25));
        acertos.setForeground(new Color(155,240,155));
        acertos.setFont(new Font("MV Boli", Font.BOLD, 50));
        acertos.setBorder(BorderFactory.createBevelBorder(1));
        acertos.setHorizontalAlignment(JTextField.CENTER);
        acertos.setEditable(false);
        
        porcentagem.setBounds(600,280,200,100);
        porcentagem.setBackground(new Color(25,25,25));
        porcentagem.setForeground(new Color(155,240,155));
        porcentagem.setFont(new Font("MV Boli", Font.BOLD, 50));
        porcentagem.setBorder(BorderFactory.createBevelBorder(1));
        porcentagem.setHorizontalAlignment(JTextField.CENTER);
        porcentagem.setEditable(false);
        
        
        frame.add(rótuloRespostaA);
        frame.add(rótuloRespostaB);
        frame.add(rótuloRespostaC);
        frame.add(rótuloRespostaD);
        frame.add(botãoA);
        frame.add(botãoB);
        frame.add(botãoC);
        frame.add(botãoD);
        frame.add(areaTexto);        
        frame.add(campoTexto);        
        frame.setVisible(true);
        
        proxQuestao();
        
        
    }
    public void proxQuestao(){
        if(index >= questoesTotais){
            resultados();
        }
        else{
            campoTexto.setText("Pergunta "+(index+1));
            areaTexto.setText(Questoes[index]);
            rótuloRespostaA.setText(Opçoes[index][0]);
            rótuloRespostaB.setText(Opçoes[index][1]);
            rótuloRespostaC.setText(Opçoes[index][2]);
            rótuloRespostaD.setText(Opçoes[index][3]);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        botãoA.setEnabled(false);
        botãoB.setEnabled(false);
        botãoC.setEnabled(false);
        botãoD.setEnabled(false);
        
        if(e.getSource()==botãoA){
            Resposta = 'A';
            if(Resposta == Respostas[index]){
                chutesCorretos++;
            }
        }
        if(e.getSource()==botãoB){
            Resposta = 'B';
            if(Resposta == Respostas[index]){
                chutesCorretos++;
            }
        }
        if(e.getSource()==botãoB){
            Resposta = 'B';
            if(Resposta == Respostas[index]){
                chutesCorretos++;
            }
        }
        if(e.getSource()==botãoC){
            Resposta = 'C';
            if(Resposta == Respostas[index]){
                chutesCorretos++;
            }
        }
        if(e.getSource()==botãoD){
            Resposta = 'D';
            if(Resposta == Respostas[index]){
                chutesCorretos++;
            }
        }
        Respostas();
    }
    public void Respostas(){
        botãoA.setEnabled(false);
        botãoB.setEnabled(false);
        botãoC.setEnabled(false);
        botãoD.setEnabled(false);
        
        if(Respostas[index] != 'A'){
            rótuloRespostaA.setForeground(new Color(255,0,0));
            botãoA.setBackground(new Color(255,0,0));
        }
        if(Respostas[index] != 'B'){
            rótuloRespostaB.setForeground(new Color(255,0,0));
            botãoB.setBackground(new Color(255,0,0));
        }
        if(Respostas[index] != 'C'){
            rótuloRespostaC.setForeground(new Color(255,0,0));
            botãoC.setBackground(new Color(255,0,0));
        }
        if(Respostas[index] != 'D'){
            rótuloRespostaD.setForeground(new Color(255,0,0));
            botãoD.setBackground(new Color(255,0,0));
        }
        
        Timer pause = new Timer(930, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){        
            
            rótuloRespostaA.setForeground(new Color(155,240,155));
            botãoA.setBackground(new Color(122,154,0));
            rótuloRespostaB.setForeground(new Color(155,240,155));
            botãoB.setBackground(new Color(122,154,0));
            rótuloRespostaC.setForeground(new Color(155,240,155));
            botãoC.setBackground(new Color(122,154,0)); 
            rótuloRespostaD.setForeground(new Color(155,240,155));
            botãoD.setBackground(new Color(122,154,0));   
            
            Resposta = ' ';
            botãoA.setEnabled(true);
            botãoB.setEnabled(true);
            botãoC.setEnabled(true);
            botãoD.setEnabled(true);
            index++;
            proxQuestao();
            }
           
        });
        pause.setRepeats(false);
        pause.start();
    }    
        
    
    public void resultados(){
        botãoA.setEnabled(false);
        botãoB.setEnabled(false);
        botãoC.setEnabled(false);
        botãoD.setEnabled(false);
        
        Resultado = (int)((chutesCorretos/(double)questoesTotais)*100);
        campoTexto.setText("RESULTADO!");
        areaTexto.setText("");
        rótuloRespostaA.setText("");
        rótuloRespostaB.setText("");
        rótuloRespostaC.setText("");
        rótuloRespostaD.setText("");
        
        acertos.setText("("+chutesCorretos+"/"+questoesTotais+")");
        porcentagem.setText(Resultado+"%");
        
        frame.add(porcentagem);
        frame.add(porcentagem);
        
        botãoA.setBounds(0, 0, 0,0);  
        botãoB.setBounds(0, 0, 0,0);
        botãoC.setBounds(0, 0, 0,0);  
        botãoD.setBounds(0, 0, 0,0);
        areaTexto.setBounds(0,0,0,0);
        
    }
   
    
    
    
    
}
