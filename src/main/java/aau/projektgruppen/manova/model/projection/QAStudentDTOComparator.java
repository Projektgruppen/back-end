package aau.projektgruppen.manova.model.projection;

import java.util.Comparator;

/**
 * Comparator class that implements {@code Comparator}.
 * Compares {@code QAStudentDTO} objects based on their {@code timeOfApprovalForQuestion} values such that newer approval times take priority.
 *
 * @see QAStudentDTO
 */
public class QAStudentDTOComparator implements Comparator<QAStudentDTO> {

    @Override
    public int compare(QAStudentDTO o1, QAStudentDTO o2) {
        return o2.getTimeOfApprovalForQuestion().compareTo(o1.getTimeOfApprovalForQuestion());
    }
}

 