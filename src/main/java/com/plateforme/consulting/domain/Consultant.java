package com.plateforme.consulting.domain;

public final class Consultant {
    private final ConsultantId consultantId;
    private final String name;
    private final String lastName;
    private String nickName;
    private int age;

    private String password;

    public Consultant(ConsultantId consultantId, String name,
                      String lastName, String nickName, int age, String password) {
        this.consultantId = consultantId;
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.password = password;
    }

    public ConsultantId getConsultantId() {
        return consultantId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}
