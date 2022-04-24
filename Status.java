package exercicio_2.jogoDaVelha;

public enum Status {
	VAZIA(' '), JOGADOR_1('X'), JOGADOR_2('O');
	
	public char pos;
	Status(char posicao) {
		pos = posicao;
	}
}
