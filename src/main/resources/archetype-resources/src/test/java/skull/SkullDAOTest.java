#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.skull;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ${package}.SkullDBFixture;
import ${package}.exception.ResourceNotFound;
import ${package}.skull.Skull;
import ${package}.skull.SkullDAO;


/**
 * Tests the SkullDAO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class SkullDAOTest extends SkullDBFixture {

	/** The skull dao. */
	@Autowired
	SkullDAO skullDAO;

	/**
	 * Find first fixture.
	 * 
	 * @throws ResourceNotFound
	 *             resource not found
	 */
	@Test
	public void findFirstFixture() throws ResourceNotFound {
		Skull skull = skullDAO.findById(1);
		assertEquals(new Integer(1), skull.getId());
	}

	/**
	 * Persist a skull and find it again.
	 * 
	 * @throws ResourceNotFound
	 *             resource not found
	 */
	@Test
	public void persist() throws ResourceNotFound {
		Skull skull = new Skull();
		skullDAO.persist(skull);

		Skull otherSkull = skullDAO.findById(skull.getId());
		assertEquals(skull.getId(), otherSkull.getId());

		skullDAO.remove(otherSkull);
	}

	/**
	 * Don't find fixture and catch an exception intentionally
	 * 
	 * @throws ResourceNotFound
	 *             resource not found
	 */
	@Test(expected = ResourceNotFound.class)
	public void dontFindFixture() throws ResourceNotFound {
		skullDAO.findById(-1);
	}
}
