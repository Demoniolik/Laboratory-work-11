package com.lab11.constants;

public enum XML {
    GROUP("group"),
    STUDENT("student"),
    STUDENT_FIRST_NAME("firstname"),
    STUDENT_LAST_NAME("lastname"),
    GROUP_NUMBER("groupnumber"),
    SUBJECT("subject"),
    SUBJECT_TITLE("title"),
    SUBJECT_MARK("mark"),
    AVERAGE("average");

    private String value;

    XML(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
