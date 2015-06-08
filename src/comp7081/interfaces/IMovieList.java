/**
 * 
 */
package comp7081.interfaces;

/**
 * @author COMP7081 - Lab 8 - Group 2. kchan, msato, tlyngen
 *
 */
public interface IMovieList {
	public int size();
	public String add(IMovie movie);
	public String modifyName(int index, String newName);
	public String getMovieName(int index);
}
