package Model.Mazzo;

import java.util.List;


public interface Mescolatore<T> {

	/**
	 * Mescola il lista passata in input.
	 * @param mazzo Il mazzo da mescolare.
	 */
	void mescola(List<T> mazzo);

}