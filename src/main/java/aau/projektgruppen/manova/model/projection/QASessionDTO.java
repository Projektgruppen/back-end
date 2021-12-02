package aau.projektgruppen.manova.model.projection;

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
