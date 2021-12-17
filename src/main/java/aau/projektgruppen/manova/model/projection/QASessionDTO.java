package aau.projektgruppen.manova.model.projection;

/**
 * This class serves as a DTO (Data Transfer Object) between the database and the front-end, specifically transferring
 * data that a {@link aau.projektgruppen.manova.model.Session Recruiter} should have access to.
 * the data from {@link aau.projektgruppen.manova.model.projection.GenericDTO} (which this class extends) is all the
 * {@code Recruiter} needs access to which is why no extra fields are added to this class.
 *
 * <p>
 *     Once created, data is not mutable, hence no Setters are provided.
 * </p>
 *
 * @see GenericDTO
 */
public class QASessionDTO {
    private long sessionId;
    private long organisationId;
    private String timeOfCreation;

    public QASessionDTO(long sessionId, long organisationId, String timeOfCreation) {
        this.sessionId = sessionId;
        this.organisationId = organisationId;
        this.timeOfCreation = timeOfCreation;
    }

    public long getSessionId() {
        return sessionId;
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public String getTimeOfCreation() {
        return timeOfCreation;
    }
}
