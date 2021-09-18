package carrinho;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

	private Carrinho car;
	private Produto livro2;
	public Produto livro3;
	private Produto livro4;
	
	@BeforeEach 
	public void inicializa() {
		car = new Carrinho();
		livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		livro3 = new Produto("Qualidade e Teste", 100.00);
		livro4 = new Produto("Programação  Orientada a Objetos", 150.00);
		car.addItem(livro2);
		car.addItem(livro3);
		car.addItem(livro4);
	} 
	
	
	@Test 
	public void VerificarItemInserido() {
		Produto livro5 = new Produto("IHM", 80.00);
		car.addItem(livro5);
		Assertions.assertAll(
				() -> assertThat(car.getValorTotal(), equalTo(420.00)),
				() -> assertThat(car.getQtdeItems(), equalTo(4))
				);
		
	}
	
	@Test 
	public void VerificarValor() {
		assertThat(car.getValorTotal(), equalTo(340.00));
	}
	
	
	@Test 
	public void VerficaQuantidadeDeItens() {
		assertThat(car.getQtdeItems(), equalTo(3));
	}
	
	//Verifica se o item que nao estava no carrinho realmente estava no carrinho e se foi removido
	@Test 
	public void VerificaItemRemovido() {
		Produto livro6 = new Produto ("Programação", 50.00);
		assertThrows(ProdutoNaoEncontradoException.class, () -> car.removeItem(livro6) );
		
	}
	
	@Test 
	public void VerificarCarrinhoVazio() {
		car.esvazia();
		assertTrue(car.getQtdeItems() == 0);
	}
}
