import java.util.Scanner;
public class jogodavelha {

    public static boolean vitoria(char[][] tabela) {
        int i;
    //linhas ---------------------------------------------
        for(i = 0; i < 3; i++) {
                if ((tabela[i][0] == tabela[i][1] && tabela[i][0] == tabela[i][2]) && (tabela[i][0] != ' ' && tabela[i][1] != ' ' && tabela[i][2] != ' ')) {
                    System.out.println(tabela[i][1] + " venceu!!!  :D"); // caso sejam iguais e diferentes de vazio
                    return true;
            }
        }

        i = 0;
    //colunas----------------------------------------------
        for(i = 0; i < 3; i++) {
                if ((tabela[0][i] == tabela[1][i] && tabela[0][i] == tabela[2][i]) && (tabela[0][i] != ' ' && tabela[1][i] != ' ' && tabela[2][i] != ' ')) {
                    System.out.println(tabela[1][i] + " venceu!!!  :D");
                    return true;
            }
        }

    //diagonais--------------------------------------------
        if (tabela[0][0] == tabela[1][1] && tabela[0][0] == tabela[2][2] && tabela[0][0] != ' ') {
            //não precisa ver se as outras estão vazias porque verificou antes que todas eram iguais
            System.out.println(tabela[1][1] + " venceu!!!  :D");
            return true;
        }
        else if(tabela[0][2] == tabela[1][1] && tabela[1][1] == tabela[2][0] && tabela[0][2] != ' ') {
            //igual anterior mas inverso
            System.out.println(tabela[1][1] + " venceu!!!  :D"); //como as diagonais são só duas, simplifiquei
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean velha(char[][] tabela) { // vê se é empate
        int i = 0;
        int j = 0;
        int teste = 0; //testa pra saber se todos os espaços foram preenchidos

        for(i = 0; i < 3; ++i) {
            for(j = 0; j < 3; ++j) {
                if (tabela[i][j] != ' ') {
                    ++teste;
                }
            }
        }

        if (!vitoria(tabela) && teste == 9) { //se ninguem ganhou e não tem mais espaço, resulta em empate/ velha
            System.out.println("empate ... :/");
            return true;
        } else {
            return false;
        }
    }

    public static void exibe(char[][] tela) { //exibição da tabela
        int i = 0;
        int j = 0;
        System.out.println("    0     1     2"); //indices de coluna

        for(i = 0; i < 3; ++i) { //imprime 3 linhas
            System.out.printf("" + i + "  "); //indice de linha

            for(j = 0; j < 3; ++j) {
                System.out.printf(" " + tela[i][j]); //imprime o valor da tabela
                System.out.printf("  | "); //divisória de coluna
            }

            System.out.println(" ");
            System.out.println("  -----|-----|-----|"); //divide as linhas
        }

    }

    public static void main(String[] args) {

        int resposta = 1;

        do {
            Scanner scan = new Scanner(System.in);
            char[][] tab = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}; //inicializa a matriz 3x3 com vazio
            int qualjog = 1; //quando == 1, jogador 1 e quando == 2, jogador 2
            int coordx = 0;
            int coordy = 0;
            boolean valid;

            while (!vitoria(tab) && !velha(tab)) { //enquanto não ganha nem empata

                System.out.println("jogador " + qualjog + " -> "); //titulo
                if (qualjog == 1) {  //caso seja jogador 1 ou 2
                    System.out.println("'O', digite a coordenada ([linha] [coluna]) da jogada:      ");

                } else {
                    System.out.println("'X', digite a coordenada ([linha] [coluna]) da jogada:      ");

                }

                do { //coleta um valor da coordenada x e valida, deve ser entre 0 e 2 e possibilita digitar denovo caso erre
                    System.out.println("x : ");
                    coordx = scan.nextInt();

                    if (coordx >= 0 && coordx <= 2) {
                        valid = true;
                    } else {
                        valid = false;
                        System.out.println("valor inválido, digite novamente.");
                    }
                } while (!valid);

                do {
                    System.out.println("y : ");
                    coordy = scan.nextInt();

                    if (coordy >= 0 && coordy <= 2) {
                        valid = true;
                    } else {
                        valid = false;
                        System.out.println("valor inválido, digite novamente.");
                    }
                } while (!valid);

                if (tab[coordx][coordy] == ' ') { //vê se a posição digitada não está ocupada

                    if (qualjog == 1) {
                        tab[coordx][coordy] = 'O';
                        qualjog = 2;
                    } else {
                        tab[coordx][coordy] = 'X';
                        qualjog=1;
                    }
                } else { //manda digitar denovo caso ja esteja cheia
                    System.out.println("a posição indicada já esta ocupada...");

                    if (qualjog == 1) { //inverte para a pessoa conseguir reescrever a posição
                        qualjog = 2;
                    } else {
                        qualjog = 1;
                    }
                }

                exibe(tab);
            }

                System.out.println("quer jogar de novo?    1 = sim / qualquer valor = não ");
                resposta = scan.nextInt();

        } while (resposta == 1);
    }
}
