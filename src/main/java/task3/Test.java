package task3;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


public class Test {
    int id;
    String title;
    String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Test> values;

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Test> getValues() {
        return values;
    }

    public void setValues(List<Test> values) {
        this.values = values;
    }
}
