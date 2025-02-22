package org.neo4art.importer.wikipedia.parser;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;
import org.neo4art.domain.Country;

public class WikipediaCountryGermanTest {

	private static String INFOBOX ="{{Infobox former country\n"+
		"|native_name     = ''Deutsches Reich''\n"+
		"|conventional_long_name = German Empire\n"+
		"|common_name     = Germany\n"+
		"|latd=52 \n"+
		"|latm=31 \n"+
		"|latNS=N \n"+
		"|longd=13 \n"+
		"|longm=24 \n"+
		"|longEW=E\n"+
		"}}";
	
	
	@Test
	public void shoudParseArtwork() throws MalformedURLException{
		Country country = WikipediaCountryInfoboxParser.parse(INFOBOX);
		
		Assert.assertEquals("Deutsches Reich",country.getNativeName());
		Assert.assertEquals("German Empire",country.getConventionalLongName());
		Assert.assertEquals("52.0",""+country.getCoordinate().getLatD());
		Assert.assertEquals("31.0",""+country.getCoordinate().getLatM());
		Assert.assertEquals("N",country.getCoordinate().getLatNS());
		Assert.assertEquals("13.0",""+country.getCoordinate().getLongD());
		Assert.assertEquals("24.0",""+country.getCoordinate().getLongM());
		Assert.assertEquals("E",country.getCoordinate().getLongEW());	

	}
	
}
