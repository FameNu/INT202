package int202.sit.simple2.repositories;

import int202.sit.simple2.entities.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    private static List<Subject> subjects;

    public List<Subject> findAll(){
        return subjects;
    }

    public SubjectRepository(){
        initialize();
    }

    private void initialize() {
        subjects = new ArrayList<>(20);
        subjects.add(new Subject("INT103", "Advanced Programming", 3.0));
        subjects.add(new Subject("INT104", "User Experience Design", 3.0));
        subjects.add(new Subject("INT105", "Basic SQL", 1.0));
        subjects.add(new Subject("INT107", "Computing Platform Technology", 3.0));
        subjects.add(new Subject("INT200", "Data Structure and Algorithms", 1.0));
        subjects.add(new Subject("INT100", "IT Fundamental", 3.0));
        subjects.add(new Subject("INT207", "Network I", 3.0));
        subjects.add(new Subject("GEN121", "Learning and Problem Solving Skills", 3.0));
    }
}
