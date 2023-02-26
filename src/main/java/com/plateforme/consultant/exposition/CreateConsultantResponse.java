package com.plateforme.consultant.exposition;

public class CreateConsultantResponse {
    private final String consultantId;

    public CreateConsultantResponse(String consultantId) {
        this.consultantId = consultantId;
    }


    public String getConsultantId() {
        return consultantId;
    }
}
