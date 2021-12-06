package aau.projektgruppen.manova.model.projection;

import java.util.Comparator;

public class QAStudentDTOComparator implements Comparator<QAStudentDTO> {

    @Override
    public int compare(QAStudentDTO o1, QAStudentDTO o2) {
        return o2.getTimeOfApprovalForQuestion().compareTo(o1.getTimeOfApprovalForQuestion());
    }
}

 