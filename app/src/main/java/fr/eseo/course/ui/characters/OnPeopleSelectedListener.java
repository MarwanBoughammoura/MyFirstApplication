package fr.eseo.course.ui.characters;

import fr.eseo.course.model.People;

/**
 * Created by Marwan on 17/01/2018.
 */

public interface OnPeopleSelectedListener {
    /**
     * Declare an inner interface to listen click event on People items
     */
    void handle(final People people);
}
