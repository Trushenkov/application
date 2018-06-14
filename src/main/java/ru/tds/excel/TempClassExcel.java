package ru.tds.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.Iterator;

public class TempClassExcel {

    private static final String FILE_PATH = "C:\\Users\\user\\Desktop\\014.xls";

    public static void main(String[] args) {

        File file = new File(FILE_PATH);

        if (file.exists()) {
            System.out.println(readFromExcel(file.getAbsolutePath()));
        } else {
            System.out.println("Файл не существует");
        }
    }

    /**
     * Метод для чтения данных из Excel-документа
     *
     * @param file excel-документ
     * @return данные из excel-документа
     */
    private static String readFromExcel(String file) {

        String result = "";

        try (HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file))) {

            HSSFSheet sheet = book.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (row.getRowNum() > 5 && row.getRowNum() < 33) {
                        result += cell + " | ";
                    }
                }
                result += ("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
