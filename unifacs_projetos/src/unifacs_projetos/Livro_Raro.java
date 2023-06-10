package unifacs_projetos;

public class Livro_Raro extends Livro {
	boolean raridade;
	double valor_mercado;
	
	
		public Livro_Raro(String titulo, String autor, String editora, String ano_Publi, int numero_paginas, boolean raridade, double valor_mercado) {
			super(titulo, autor, editora, ano_Publi, numero_paginas);
			this.raridade=raridade;
			this.valor_mercado=valor_mercado;
			
			
		}
			public boolean getRaridade() {
		        return raridade;
		    }

		    public void setRaridade(boolean raridade) {
		        this.raridade = raridade;
		    }

		    public double getValor_mercado() {
		        return valor_mercado;
		    }

		    public void setValor_mercado(double valor_mercado) {
		        this.valor_mercado = valor_mercado;
		    }
}