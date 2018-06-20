package ru.tds.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.w3c.dom.Document;
import рф.пф.аф._2017_08_21.ТипСлужебнаяИнформация;
import рф.пф.всво.роив.снз._2017_10_06.ЭДПФР;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
                startMethod(file.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Файл не существует");
        }


    }


    private static void startMethod(String file) throws Exception {

        try (HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file))) {

            HSSFSheet sheet = book.getSheetAt(0);

            XlsFile xlsFile = new XlsFile();

            ЭДПФР edpfr = new ЭДПФР();
            ЭДПФР.СНЗ snz = new ЭДПФР.СНЗ();
            ЭДПФР.СНЗ.ПодтверждениеСтажа stazh = new ЭДПФР.СНЗ.ПодтверждениеСтажа();
            List<XlsRow> rowList = new ArrayList<>();
            for (Row row : sheet) {
                if (row.getRowNum() > 5 && row.getRowNum() < 33) {
                    try {



                        ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись letter = new ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись();
                        ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.ТрудовойДоговор workDocument = new ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.ТрудовойДоговор();
                        ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.Работодатель employment = new ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.Работодатель();
                        ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.Работник worker = new ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.Работник();

                        //Заполнение строки из excel-документа
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

                        rowList.add(xlsRow);


                        employment.setНаименование(xlsRow.getNomination());
                        employment.setИНН(xlsRow.getInn());
                        employment.setКПП(xlsRow.getKpp());
                        employment.setРегНомер(xlsRow.getRegistrationNumber());

                        worker.setФИО(xlsRow.getLastName() + " " + xlsRow.getName() + " " + xlsRow.getMiddleName());
                        worker.setДатаРождения(xlsRow.getDateBirthday());
                        worker.setСНИЛС(xlsRow.getSnils());

                        workDocument.setДата(xlsRow.getDateOfContract());
                        workDocument.setСрок(xlsRow.getTermOfContract());

                        letter.setРаботник(worker);
                        letter.setРаботодатель(employment);
                        letter.setТрудовойДоговор(workDocument);
                        letter.setНачисленыСВ(xlsRow.getInsuranceСontributions());
                        letter.setСтажПодтвержден(xlsRow.getAgreeExperience());

                        stazh.getЗапись().add(letter);
                        snz.setПодтверждениеСтажа(stazh);
                        snz.setМуниципальноеОбразование(xlsRow.getMunicipalEducation());
                        edpfr.setСНЗ(snz);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

            Date date = new Date();

            //Формирование объекта XlsFile
            xlsFile.setDate(date);
            xlsFile.setGUID(UUID.randomUUID());
            xlsFile.setXlsRowList(rowList);


            ТипСлужебнаяИнформация info = new ТипСлужебнаяИнформация();
            info.setДатаВремя(xlsFile.getDate());
            info.setGUID(xlsFile.getGUID());

            edpfr.setСлужебнаяИнформация(info);

            writeToXml(getXMLDocument(edpfr, ЭДПФР.class));
        }
    }

    /**
     * Метод для записи строки в xml файл.
     *
     * @param string xml-строка
     * @throws IOException
     */
    private static void writeToXml(String string) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\application\\src\\main\\xsd\\014.xml"))) {
            writer.write(string);
        }
    }

    /**
     * Метод для получения xml-строки для объекта
     *
     * @param objectToParse объект
     * @param xmlDocumentClass класс объекта
     * @param <T>
     * @return сформированная для объекта xml-строка
     * @throws Exception
     */
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




