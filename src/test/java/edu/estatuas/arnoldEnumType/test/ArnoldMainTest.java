package edu.estatuas.arnoldEnumType.test;



import static  org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.estatuas.arnoldEnumType.logica.Planeta;


public class ArnoldMainTest {

    public static String[] planetas;

	@BeforeEach
	public void CreacionArrayPlanetasSetup() {
		planetas = new String[8];
		int planetasIncluidos = 0;
		for (Planeta planeta : Planeta.values()) {
			planetas[planeta.ordinal()] = planeta.name();
			planetasIncluidos += 1;
		}
		assertThat(planetasIncluidos).isEqualTo(Planeta.values().length);
		assertThat(planetas).doesNotContainNull();
	}

    	@Test
	public void PlanetaConstructorTest() {
		// me aseguro de que los metodos de la api
		// de los Enum Types se comportan como espero
		Planeta planeta = Planeta.MERCURY;
		assertThat(planeta).isInstanceOf(Planeta.class);
		assertThat(planeta.ordinal()).isZero();
		assertThat(planeta.name()).isEqualToIgnoringCase("MERCURY");
		assertThat(Planeta.valueOf(planeta.name())).isEqualTo(Planeta.MERCURY);
		assertThat(planeta.compareTo(Planeta.MERCURY)).isZero();
		assertThat(planeta.toString()).isEqualToIgnoringCase("MERCURY");
		assertThat(planeta.equals(Planeta.MERCURY)).isTrue();
		assertThat(Planeta.values()[0]).isEqualTo(planeta);
	}

    @Test
	public void PlanetaGetMasaTest() {
		Planeta planeta = Planeta.MERCURY;
		assertThat(planeta.getMasa()).isEqualTo(3.303e+23);
	}

    @Test
	public void PlanetaGetRadioTest() {
		Planeta planeta = Planeta.MERCURY;
		assertThat(planeta.getRadio()).isEqualTo(2.4397e+6);
	}

	@Test
	public void PlanetaNamesIteratorTest() {
		for (Planeta planeta : Planeta.values()) {
			assertThat(planeta.name()).isIn(planetas);
		}
	}

		@Test
	public void PesoSuperficieMercurioTest() {
		Planeta planeta = Planeta.MERCURY;
		double pesoHumano = 175;
		assertEquals(66.107583, planeta.pesoSuperficie(pesoHumano), 0.001);
	}

	@Test
	public void ArrayPlanetasTerrestresTest() {

		String[] planetasTerrestres = new String[4];
		int planetasIncluidos = 0;

		for (int i = Planeta.MERCURY.ordinal(); i < Planeta.JUPITER.ordinal(); i++) {
			planetasTerrestres[i] = Planeta.values()[i].name();
			planetasIncluidos += 1;
		}
		assertThat(planetasIncluidos).isEqualTo(4);
		assertThat(planetas).doesNotContainNull();

		for (Planeta planeta : Planeta.getPlanetasTerrestres()) {
			assertThat(planeta.name()).isIn(planetasTerrestres);
		}
	}
	
	@Test
	public void ArrayGigantesGaseosos() {

		String[] gigantesGaseosos = new String[4];
		int planetasIncluidos = 0;

		byte index = 0;
		for (int i = Planeta.JUPITER.ordinal(); i <= Planeta.NEPTUNE.ordinal(); i++) {
			gigantesGaseosos[index] = Planeta.values()[i].name();
			planetasIncluidos += 1;
			index += 1;
		}
		assertThat(planetasIncluidos).isEqualTo(4);
		assertThat(planetas).doesNotContainNull();

		for (Planeta planeta : Planeta.getGigantesGaseosos()) {
			assertThat(planeta.name()).isIn(gigantesGaseosos);
		}
	}


}
