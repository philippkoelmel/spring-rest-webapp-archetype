#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${packageInPathFormat}.xml;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${packageInPathFormat}.skull.Skull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class MarshallTest {
	
	@Autowired
	Marshaller marshaller;
	
	private static final String XML_SKULL_RESULT="<?xml version=${symbol_escape}"1.0${symbol_escape}" encoding=${symbol_escape}"UTF-8${symbol_escape}" standalone=${symbol_escape}"yes${symbol_escape}"?><skull><id>1</id></skull>";
	
	@Test
	public void marshallSkull() throws XmlMappingException, IOException {

		Skull skull = new Skull();
		skull.setId(1);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		
		marshaller.marshal(skull, result);
		
		assertEquals(
				XML_SKULL_RESULT,
				writer.toString());
	}
}
