import java.util.Scanner;

public class classe {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double resultado = 0;
        int numero = 0;
        int yn;
        int mesmoresult = 0;
        int outraop = 0;
        double num;
        double doubleresu;

        System.out.println("======== Calculadora: ==========");

        do{

            System.out.print("\n Digite qual operação deseja fazer:");
            String opcao = scan.nextLine();

            System.out.print("Operação selecionada: \n");


            switch (opcao) {
                case "+":
                    System.out.print("Soma: \n");

                    do {
                        System.out.print("digite o número: ");

                        numero = Integer.parseInt(scan.nextLine());
                        resultado += numero;

                        System.out.print("continuar? 1 = sim -- 0 = não \n");
                        yn = Integer.parseInt(scan.nextLine());

                    } while (yn != 0);
                    System.out.println("resultado das somas: " + resultado);
                    break;

                case "-":
                    System.out.print("Subtração: \n");

                    if (mesmoresult == 0) {
                        System.out.print("digite o valor inicial a subtrair: ");

                        resultado = Integer.parseInt(scan.nextLine());
                    }

                    do {
                        System.out.print("digite o número: ");

                        numero = Integer.parseInt(scan.nextLine());
                        resultado -= numero;

                        System.out.print("continuar? 1 = sim -- 0 = não \n");
                        yn = Integer.parseInt(scan.nextLine());


                    } while (yn != 0);
                    System.out.println("resultado das subtrações: " + resultado);
                    break;

                case "*":
                    System.out.print("multiplicação: \n");
                    if (resultado<=0){
                        resultado=1;
                    }

                    do {
                        System.out.print("digite o número: ");

                        numero = Integer.parseInt(scan.nextLine());
                        resultado *= numero;

                        System.out.print("continuar? 1 = sim -- 0 = não \n");
                        yn = Integer.parseInt(scan.nextLine());


                    } while (yn != 0);
                    System.out.println("resultado das multiplicações: " + resultado);
                    break;

                case "/":
                    System.out.print("divisão: \n");

                    if (mesmoresult == 0) {
                        System.out.print("digite o valor inicial a dividir: ");

                        doubleresu = Integer.parseInt(scan.nextLine());

                    } else {
                        doubleresu = resultado;
                    }

                    do {
                        System.out.print("digite o número: ");

                        num = Integer.parseInt(scan.nextLine());
                        doubleresu /= num;
                        resultado = doubleresu;

                        System.out.print("continuar? 1 = sim -- 0 = não \n");
                        yn = Integer.parseInt(scan.nextLine());


                    } while (yn != 0);
                    System.out.println("resultado das divisões: " + doubleresu);
                    break;

                default:
                    System.out.print("operador inválido.");
            }

            System.out.print("\n Deseja fazer outra operação? 1 = sim -- 0 = não");
            outraop = Integer.parseInt(scan.nextLine());

            if (outraop ==1) {
                System.out.print("manter o mesmo resultado? 1 = sim -- 0 = não");
                mesmoresult = Integer.parseInt(scan.nextLine());
                if (mesmoresult == 0) {
                    resultado = 0;
                }
            }

        } while (outraop == 1);
    }
}