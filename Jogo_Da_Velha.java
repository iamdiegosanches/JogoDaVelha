package exercicio_2.jogoDaVelha;

import java.util.Scanner;

public class Jogo_Da_Velha {
	Scanner scanner = new Scanner(System.in);
	private char[][] tabuleiro = new char[3][3];
	
	Status jogador = Status.JOGADOR_1;
	
	boolean gameOver = true;
	
	public Jogo_Da_Velha() {
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = Status.VAZIA.pos;
			}
		}
	}
	
	private void printTabuleiro() {
		System.out.println("");
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print("|" + tabuleiro[i][j]);
			}
			System.out.println("|");
		}
	}
	
	private void jogada(Status jogador, int linha, int coluna) {
		if(linha > 2 || linha < 0 || coluna > 2 || coluna < 0) {
			System.out.println("\nJogada invalida!! Jogue novamente.");
		} else if (tabuleiro[linha][coluna] != Status.VAZIA.pos) {
			System.out.println("\nJogada invalida!! Jogue novamente.");
		} else {
			tabuleiro[linha][coluna] = jogador.pos;
			
			this.jogador = (jogador == Status.JOGADOR_1) ? Status.JOGADOR_2 : Status.JOGADOR_1;
		}
	}
	
	private char verificaVitoria() {
		String linha = null;
		String coluna = null;
		String diagonal_1 = null;
		String diagonal_2 = null;
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		
		for (int i = 0; i < tabuleiro.length; i++) {
			
			for (int j = 0; j < tabuleiro[i].length; j++) {
				linha = sb1.append(tabuleiro[i][j]).toString();
				coluna = sb2.append(tabuleiro[j][i]).toString();	
			}
			
			diagonal_1 = sb3.append(tabuleiro[i][i]).toString();	
			
			diagonal_2 = sb4.append(tabuleiro[i][tabuleiro.length-1-i]).toString();
			
			if(linha.equals("XXX") || linha.equals("OOO")) {
				return linha.charAt(0);
			}
			else if (coluna.equals("XXX") || coluna.equals("OOO")) {
				return coluna.charAt(0);
			}
			else if (diagonal_1.equals("XXX") || diagonal_1.equals("OOO")) {
				return diagonal_1.charAt(0);
			} 
			else if (diagonal_2.equals("XXX") || diagonal_2.equals("OOO")) {
				return diagonal_2.charAt(0);
			}
			
			linha = null;
			coluna = null;
			diagonal_1 = null;
			diagonal_2 = null;
		}
		return ' ';
	}
	
	private void verificaStatus(int contador) {
		char result = verificaVitoria();
		
		if(result == 'X' || result == 'O') {
			System.out.println("\nO vencedor é : " + result);
			gameOver = false;
		} else if (contador == 9) {
			System.out.println("\nDeu velha!");
			gameOver = false;
		}
		
	}
	
	public void iniciar() {
		printTabuleiro();
		
		int linha, coluna;
		int contador = 0;
		
		while(gameOver) {
			
			System.out.println("\nVez do jogador " + jogador.pos);
			
			System.out.print("Escolha uma posição de 1-3 para linha: ");
			linha = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Escolha uma posição de 1-3 para coluna: ");
			coluna = scanner.nextInt();
			scanner.nextLine();
			
			jogada(jogador, linha-1, coluna-1);
			
			contador++;
			printTabuleiro();
			
			verificaStatus(contador);
	
		}
	}
}
