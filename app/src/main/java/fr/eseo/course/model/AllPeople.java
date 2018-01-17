package fr.eseo.course.model;

import java.util.List;

/**
 * Created by Marwan on 17/01/2018.
 */

public class AllPeople {

    String next;

    String previous;

    String count;

    List<People> results;


    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public String getCount() {
        return count;
    }

    public List<People> getResults() {
        return results;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setResults(List<People> results) {
        this.results = results;
    }
}
