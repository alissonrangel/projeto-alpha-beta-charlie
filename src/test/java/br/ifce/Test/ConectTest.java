package br.ifce.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ifce.Utilitarios.Conect;

public class ConectTest {

	@Test
	public void test() {
		Conect conexao = new Conect();
		
		//Fatorial fatorial = new Fatorial();
		
		//double resultado = fatorial.calcula(0);
		String resultado = conexao.getContato();
		
		assertEquals("Alisson", resultado);
	}

}
