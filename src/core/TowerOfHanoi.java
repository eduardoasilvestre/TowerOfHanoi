package core;


public class TowerOfHanoi {
	public static int numeroMovimentos = 0;

	public static void torreDeHanoi(int n, char origem, char meio, char destino) {
		if (n > 0) {
			torreDeHanoi(n - 1, origem, destino, meio);
			move(n, origem, destino);
			torreDeHanoi(n - 1, meio, origem, destino);
		}
	}
	public static void torreDeHanoi4Varetas(int n, char origem, char aux1, char aux2, char destino) {
		if (n == 1) {
			move(n, origem, destino);
		}
		else if (n == 2) {
			move(n, origem, aux1);
			move(n, origem, destino);
			move(n, aux1, aux2);
			
		} else {
			torreDeHanoi4Varetas(n - 2, origem, aux2, destino, aux1);
			move(n, origem, aux2);
			move(n, origem, destino);
			move(n, aux2, destino);
			torreDeHanoi4Varetas(n - 2, aux1, origem, aux2, destino);
		}
	}

	public static void main(String[] args) {
		
		int numeroDeDiscos = 20;
		Chronometer.start();
		torreDeHanoi(numeroDeDiscos, 'A', 'B', 'C');
		Chronometer.stop();
		System.out.println("\n\nO tempo de execução aproximado para " + numeroDeDiscos + " foi de " + Chronometer.elapsedTime() + " !!");
		System.out.println("O número de discos movidos foi " + numeroMovimentos + "!");
		

		
		/*int numeroDeDiscos = 20;
		Chronometer.start();
		//torreDeHanoi4Varetas(numeroDeDiscos, 'A', 'B', 'C', 'D');
		Chronometer.stop();
		System.out.println("\n\nO tempo de execução aproximado para " + numeroDeDiscos + " foi de " + Chronometer.elapsedTime() + " !!");
		System.out.println("O número de discos movidos foi " + numeroMovimentos + "!");
		*/
		
		
	}
	
	public static void move(int n, char origem, char destino) {
		System.out.println("Movendo o disco " + n + " da posição " + origem + " para posição " + destino + ".");
		numeroMovimentos++;
	}
}
