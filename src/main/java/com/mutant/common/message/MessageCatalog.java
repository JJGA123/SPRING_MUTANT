package com.mutant.common.message;

import lombok.Getter;

@Getter
public enum MessageCatalog {

    NOTSQUARE("com.mutant.notSquare"),
    INVALIDCHARACTERS("com.mutant.invalidCharacters"),
    NOTVALIDMATRIX("com.mutant.notValidMatrix"),
    ISMUTANT("com.mutant.isMutant"),
    ISHUMAN("com.mutant.isHuman"),
    STATISTICS("com.mutant.statistics"),
    NOTERRORS("com.mutant.notErrors"),
    DNAEXIST("com.mutant.dnaExist");

    String details;

    MessageCatalog(String details) {
        this.details = details;
    }
}