package aau.projektgruppen.manova.model.user;

import javax.persistence.*;

/**
 * The {@code Student} class represents a student attending a livestream session.
 * A {@code Student} object contains an automatically generated id.
 * <P></P>
 * This is an example of the creation of an {@code Student} object.
 *
 * <blockquote><pre>
 *     Student student = new Student();
 * </pre></blockquote>
 *
 */
@Entity
@Table(name = "students")
public class Student {

    /**
     * Contains the id of the student.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Creates an empty Student object.
     */
    public Student(){
    }

    /**
     * Getter for the student id
     * @return A {@code long} specifying the id of a student.
     */
    public long getId() {
        return id;
    }
}
