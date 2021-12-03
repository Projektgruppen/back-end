package aau.projektgruppen.manova.model.user;

import javax.persistence.*;

/**
 * The {@code Moderator} class represents a moderator moderating a livestream session.
 * A {@code Moderator} object contains an automatically generated id.
 * <P></P>
 * This is an example of the creation of an {@code Moderator} object.
 *
 * <blockquote><pre>
 *     Moderator moderator = new Moderator();
 * </pre></blockquote>
 *
 * @author Johan Nissen Riedel
 */
@Entity
@Table(name = "moderators")
public class Moderator {

    /**
     * Contains the id of the moderator.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Creates an empty Moderator object.
     */
    public Moderator() {

    }

    /**
     * Getter for the moderator id.
     * @return A {@code long} specifying the id of the moderator.
     */
    public long getId() {
        return id;
    }

}
