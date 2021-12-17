package aau.projektgruppen.manova.model.user;

import javax.persistence.*;

/**
 * The {@code Recruiter} class represents a recruiter who answers questions asked by students in a specific session.
 * A {@code Recruiter} object contains an automatically generated id.
 * <P></P>
 * This is an example of the creation of an {@code Recruiter} object.
 *
 * <blockquote><pre>
 *     Recruiter recruiter = new Recruiter();
 * </pre></blockquote>
 *
 */
@Entity
@Table(name = "recruiters")
public class Recruiter {

    /**
     * Contains the id of the recruiter.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Creates an empty Recruiter object.
     */
    public Recruiter(){

    }

    /**
     * Getter for the moderator id.
     * @return A {@code long} specifying the id of a moderator.
     */
    public long getId() {
        return id;
    }

}
