package calculadora;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois números")
	
	//Modificação Wagner verifica se o resultado obtido é igual ao esperado
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(0, 5);		
		assertTrue(soma == 5);	
	}
	
	//Modificação Wagner verifica se o resultado obtido é igual  a 16 
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(64, 4);
		Assertions.assertEquals(16, divisao);
	}
	
	//Teste modificado para verificar Nan
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(0, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@Test
	public void testehPositivo() {
		calc.ehPositivo(-2);
		assertFalse(calc.ehPositivo(-2) == true);
	}
	
	@Test
	public void testesomatoria() {
		int resultado = calc.somatoria(10);
		Assertions.assertEquals(55, resultado);
	}
	
	@Test
	public void testecompara() {
		int resultado = calc.compara(10,1);
		int resultado1 = calc.compara(1,1);
		int resultado2 = calc.compara(1,10);
		Assertions.assertAll(
				() -> assertThat(resultado ,equalTo(1)),
				() -> assertThat(resultado1 ,equalTo(0)),
				() -> assertThat(resultado2 ,equalTo(-1))
				);
	}

}