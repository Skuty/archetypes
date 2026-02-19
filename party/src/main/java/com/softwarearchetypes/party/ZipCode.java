package com.softwarearchetypes.party;

record ZipCode(String value) {

    public static ZipCode of(String value) {
        return new ZipCode(value);
    }

    public String asString() {
        return value;
    }
}
