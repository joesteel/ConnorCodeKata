package com.connor.leeteasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicenceKeyFormattingTest {

    @Test
    void shouldFormatLicence_happyPath() {
        assertEquals("AA-AA", LicenceKeyFormatting.licenseKeyFormatting("----aaaa", 2));
        assertEquals("AA-AA", LicenceKeyFormatting.licenseKeyFormatting("aaaa", 2));
        assertEquals("A-BC-DE", LicenceKeyFormatting.licenseKeyFormatting("ab-c-d-e", 2));
        assertEquals("A", LicenceKeyFormatting.licenseKeyFormatting("a-", 1));
        assertEquals("AB-CD", LicenceKeyFormatting.licenseKeyFormatting("a-b-c-d", 2));
    }
}