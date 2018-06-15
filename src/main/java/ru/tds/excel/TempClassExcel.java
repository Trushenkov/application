package ru.tds.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import рф.пф.всво.роив.снз._2017_10_06.EDPFR;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TempClassExcel {

    private static final String FILE_PATH = "C:\\Users\\user\\Desktop\\014.xls";

    public static void main(String[] args) {

        File file = new File(FILE_PATH);
        System.out.println(file.getAbsolutePath());

        if (file.exists()) {
            try {
                readFromExcel(file.getAbsolutePath());
            } catch (IOException e) {
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
     * @return данные из excel-документа
     */
    private static void readFromExcel(String file) throws IOException {

        рф.пф.всво.роив.снз._2017_10_06.EDPFR edpfr = new EDPFR();


        try (HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file))) {

            HSSFSheet sheet = book.getSheetAt(0);

            ArrayList<EDPFR> list = new ArrayList<>();

            for (Row row : sheet) {

                EDPFR.SNZ.ПодтверждениеСтажа asdddd = new EDPFR.SNZ.ПодтверждениеСтажа();
                EDPFR.SNZ.ПодтверждениеСтажа.Запись letter = new EDPFR.SNZ.ПодтверждениеСтажа.Запись();
                EDPFR.SNZ.ПодтверждениеСтажа.Запись.Работодатель empoyment = new EDPFR.SNZ.ПодтверждениеСтажа.Запись.Работодатель();
                EDPFR.SNZ.ПодтверждениеСтажа.Запись.Работник worker = new EDPFR.SNZ.ПодтверждениеСтажа.Запись.Работник();
                EDPFR.SNZ.ПодтверждениеСтажа.Запись.ТрудовойДоговор workDocument = new EDPFR.SNZ.ПодтверждениеСтажа.Запись.ТрудовойДоговор();
                if (row.getRowNum() > 5 && row.getRowNum() < 33) {
                    EDPFR.SNZ snz = new EDPFR.SNZ();
                    for (Cell cell : row) {

                        switch (cell.getColumnIndex()) {
                            case 1:
                                snz.setМуниципальноеОбразование(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());
                                break;
                            case 2:
                                empoyment.setНаименование(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());

                                break;
                            case 3:
                                empoyment.setИНН(String.valueOf(cell.getNumericCellValue()));
                                System.out.println(String.valueOf(cell.getNumericCellValue()));
                                break;
                            case 4:
                                empoyment.setКПП(String.valueOf(cell.getNumericCellValue()));
                                System.out.println(String.valueOf(cell.getNumericCellValue()));

                                break;
                            case 5:
                                empoyment.setРегНомер(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());

                                break;
                            case 6:
                                worker.setФамилия(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());

                                break;
                            case 7:
                                worker.setИмя(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());

                                break;
                            case 8:
                                worker.setОтчество(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());

                                break;
                            case 9:
                                worker.setДатаРождения(cell.getDateCellValue());
                                System.out.println(cell.getDateCellValue());

                                break;
                            case 10:
                                worker.setСНИЛС(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());
                                break;
                            case 11:
                                workDocument.setДата(cell.getDateCellValue());
                                System.out.println(cell.getDateCellValue());
                                break;
                            case 12:
                                workDocument.setСрок(cell.getStringCellValue());
                                System.out.println(cell.getStringCellValue());
                                break;
                            case 13:
                                letter.setСтажПодтвержден(cell.getBooleanCellValue());
                                System.out.println(cell.getBooleanCellValue());
                                break;
                            case 14:
                                letter.setНачисленыСВ(cell.getBooleanCellValue());
                                System.out.println(cell.getBooleanCellValue());
                                break;
                        }

                        snz.setПодтверждениеСтажа(asdddd);
                    }
                    edpfr.setSNZ(snz);
                    list.add(edpfr);
                }


            }


            System.out.println(list.size());
        }


    }
}

