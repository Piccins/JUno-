package Model.Mazzo;

import java.util.List;

/**
 * Quest'interfaccia definisce un produttore
 * di mazzi per i giochi di carte.
 * @param <T> Il tipo delle carte del mazzo.
 */
public interface MazzoFactory<T> {

    /**
     * Produce una lista contenente le carte.
     * @return Un oggetto di tipo List.
     */
    public List<T> produciMazzo();

}