import java.util.Scanner;
import java.util.Random;
public class paper_and_scissor {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Random rand = new Random();
        String opt1, opt2;
        char start;
        int option;
        int min = 1;
        int max = 3;

        System.out.println("BEM VINDO AO PEDRA, PAPEL E TESOURA DO PAULOS!");
        System.out.println("Deseja iniciar seu jogo? (S/n)");
        start = read.next().charAt(0);
        boolean play_return = play(start);

        while (play_return) {
            System.out.println("Escolha entre pedra, papel e tesoura! (1, 2 ou 3).");
            option = read.nextInt();
            opt1 = verifyOption(option);

            int randomBotOption = rand.nextInt(max - min + 1) + min;
            opt2 = verifyOption(randomBotOption);
            

            System.out.println("Você escolheu a opção de: " + opt1 + "!");
            System.out.println("O bot escolheu a opção de: " + opt2 + "!");

            boolean winner = verifyWinner(option, randomBotOption);

            if (winner) {
                System.out.println("Você ganhou!");
            } else{
                System.out.println("Você perdeu :(");
            }

            System.out.println("Deseja continuar? (S/n)");
            start = read.next().charAt(0);
            play_return = play(start);
            
        }
    }

    public static boolean play(char start){
        if(start == 'S' || start == 's'){
            return(true);
        }
        return(false);
    }

    public static String verifyOption(int option){
        switch (option) {
            case 1: return("Pedra");
            case 2: return("Papel");
            case 3: return("Tesoura");
            default: return("Nada");
        }
    }

    public static boolean verifyWinner(int opt1, int opt2){
            if (opt1 == 1 && opt2 != 2) {
                return(true);
            } else if (opt1 == 2 && opt2 != 3) {
                return(true);
            } else if(opt1 == 3 && opt2 != 1){
                return(true);
            }
            else {
                return(false);
            }
    }
}