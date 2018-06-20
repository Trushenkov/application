package ru.tds.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.*;

public class TempClassExcel {

    private static final String FILE_PATH = "C:\\Users\\user\\Desktop\\014.xls";

//    private static List<XlsRow> rowList;

    public static void main(String[] args) {

        File file = new File(FILE_PATH);
        System.out.println(file.getAbsolutePath());

        if (file.exists()) {
            try {
                readFromExcel(file.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл не существует");
        }


    }

    /**
     * Метод для чтения данных из Excel-документа
     *
     * @param file excel-документ
     */
    private static void readFromExcel(String file) throws Exception {

        try (HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file))) {

            HSSFSheet sheet = book.getSheetAt(0);

            XlsFile xlsFile = new XlsFile();

            List<XlsRow> rowList = new ArrayList<>();
            for (Row row : sheet) {
                if (row.getRowNum() > 5 && row.getRowNum() < 33) {
                    try {

                        XlsRow xlsRow = new XlsRow();
                        xlsRow.setRowNumber((int) row.getCell(0).getNumericCellValue());
                        xlsRow.setMunicipalEducation(row.getCell(1).getStringCellValue());
                        xlsRow.setNomination(row.getCell(2).getStringCellValue());
                        xlsRow.setInn(String.valueOf(row.getCell(3).getNumericCellValue()));
                        xlsRow.setKpp(String.valueOf(row.getCell(4).getNumericCellValue()));
                        xlsRow.setRegistrationNumber(row.getCell(5).getStringCellValue());
                        xlsRow.setLastName(row.getCell(6).getStringCellValue());
                        xlsRow.setName(row.getCell(7).getStringCellValue());
                        xlsRow.setMiddleName(row.getCell(8).getStringCellValue());
                        xlsRow.setDateBirthday(row.getCell(9).getDateCellValue());
                        xlsRow.setSnils(row.getCell(10).getStringCellValue());
                        xlsRow.setDateOfContract(row.getCell(11).getDateCellValue());
                        xlsRow.setTermOfContract(row.getCell(12).getStringCellValue());
                        xlsRow.setAgreeExperience(row.getCell(13).getBooleanCellValue());
                        xlsRow.setInsuranceСontributions(row.getCell(14).getBooleanCellValue());

                        System.out.println(xlsRow);
                        rowList.add(xlsRow);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

            Date date = new Date();

            xlsFile.setDate(date);
            xlsFile.setGUID(UUID.randomUUID());
            xlsFile.setXlsRowList(rowList);

            System.out.println(xlsFile);
        }
    }
}




