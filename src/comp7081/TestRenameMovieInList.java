/**
 * 
 */
package comp7081;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import comp7081.interfaces.IMovie;
import comp7081.interfaces.IMovieList;

/**
 * @author COMP7081 - Lab 8 - Group 2. kchan, msato, tlyngen
 *
 */

public class TestRenameMovieInList extends TestCase {
	 private IMovie movieMock;
	 private IMovieList movieListMock; 

	 @Before
	 public void setUp() {
		 movieMock = EasyMock.createMock(IMovie.class);
		 movieListMock = EasyMock.createMock(IMovieList.class);
	 }
	 
	 @Test
	 public void testName() {
		
		EasyMock.expect(movieMock.setName("StarWars")).andReturn("OK");
		EasyMock.expect(movieListMock.add(movieMock)).andReturn("OK");
		EasyMock.expect(movieListMock.getMovieName(0)).andReturn("StarWars");
		EasyMock.expect(movieListMock.modifyName(0, "Hobbit")).andReturn("OK");
		EasyMock.expect(movieListMock.getMovieName(0)).andReturn("Hobbit");

		
		EasyMock.replay(movieMock);
		EasyMock.replay(movieListMock);
		
		
		assertEquals("The movie name is set. Should be OK.","OK",movieMock.setName("StarWars"));
		assertEquals("The movie is added. Should be OK","OK",movieListMock.add(movieMock));
		assertEquals("The movie name on index 0 should be StarWars","StarWars", movieListMock.getMovieName(0));
		assertEquals("The movie name should be modified and the name should be Hobbit","OK", movieListMock.modifyName(0, "Hobbit"));
		assertEquals("The movie name on index 0 should be now Hobbit","Hobbit", movieListMock.getMovieName(0));
	 }
	 
		public static void main(String[] args) {
			junit.textui.TestRunner.run(TestEmptyName.class);
		}
}
