package streams.data;

public class CourseImpl implements Course {

    private final String name;

    public CourseImpl(String name) {
        this.name = name;
    }

    @Override
    public String getCourseName() {
        return name;
    }
}
