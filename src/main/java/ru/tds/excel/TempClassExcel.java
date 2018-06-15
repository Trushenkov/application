package ru.tds.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.w3c.dom.Document;
import рф.пф.всво.роив.снз._2017_10_06.EDPFR;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class TempClassExcel {

    private static final String FILE_PATH = "C:\\Users\\user\\Desktop\\014.xls";

    public static void main(String[] args) throws Exception {
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
    private static void readFromExcel(String file) throws Exception {

        try (HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file))) {

            HSSFSheet sheet = book.getSheetAt(0);

            EDPFR edpfr = new EDPFR();


            for (Row row : sheet) {
                if (row.getRowNum() > 5 && row.getRowNum() < 33) {

                    EDPFR.SNZ snz = new EDPFR.SNZ();
                    EDPFR.SNZ.Работодатель employer = new EDPFR.SNZ.Работодатель();
                    EDPFR.SNZ.Работник worker = new EDPFR.SNZ.Работник();
                    EDPFR.SNZ.ТрудовойДоговор workDocument = new EDPFR.SNZ.ТрудовойДоговор();
                    for (Cell cell : row) {

                        switch (cell.getColumnIndex()) {
                            case 1:
                                snz.setМуниципальноеОбразование(cell.getStringCellValue());
                                break;
                            case 2:
                                employer.setНаименование(cell.getStringCellValue());
                                break;
                            case 3:
                                employer.setИНН(String.valueOf(cell.getNumericCellValue()));
                                break;
                            case 4:
                                employer.setКПП(String.valueOf(cell.getNumericCellValue()));
                                break;
                            case 5:
                                employer.setРегНомер(cell.getStringCellValue());
                                break;
                            case 6:
                                worker.setФамилия(cell.getStringCellValue());
                                break;
                            case 7:
                                worker.setИмя(cell.getStringCellValue());
                                break;
                            case 8:
                                worker.setОтчество(cell.getStringCellValue());
                                break;
                            case 9:
                                worker.setДатаРождения(cell.getDateCellValue());
                                break;
                            case 10:
                                worker.setСНИЛС(cell.getStringCellValue());
                                break;
                            case 11:
                                workDocument.setДата(cell.getDateCellValue());
                                break;
                            case 12:
                                workDocument.setСрок(cell.getStringCellValue());
                                break;
                            case 13:
                                snz.setСтажПодтвержден(cell.getBooleanCellValue());
                                break;
                            case 14:
                                snz.setНачисленыСВ(cell.getBooleanCellValue());
                                break;
                        }

                    }
                    snz.setРаботник(worker);
                    snz.setРаботодатель(employer);
                    snz.setТрудовойДоговор(workDocument);
                    edpfr.setSNZ(snz);
                    writeToXml(getXMLDocument(edpfr,EDPFR.class));
                }

            }
        }
    }

    private static void writeToXml(String string) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\application\\src\\main\\xsd\\014.xml", true))) {
            writer.write(string);
        }
    }

    private static <T> String getXMLDocument(T objectToParse, Class xmlDocumentClass) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        JAXBContext contextForRequest = JAXBContext.newInstance(xmlDocumentClass);
        Marshaller m = contextForRequest.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(objectToParse, document);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));

        return writer.toString();
    }
}

