package com.finanzaspersonales.model.exporter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ExportExcelTest {

    @Test
    @DisplayName("Check - Creating file")
    void exportYearFilenameTest() {
        ExportExcel exportExcel = new ExportExcel();
        Assertions.assertDoesNotThrow(()-> {
            exportExcel.exportYear("testName.xls",2020);
        });
    }

    @Test
    @DisplayName("Check - Null or filename has no name")
    void exportYearNullNameTest() {
        ExportExcel exportExcel = new ExportExcel();
        Assertions.assertDoesNotThrow(()-> {
            String filename = LocalDate.now() + ".xls";
            exportExcel.exportYear(filename,2020);
        });
    }
}
