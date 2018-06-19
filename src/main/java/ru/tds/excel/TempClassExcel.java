package ru.tds.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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
import java.util.Date;
import java.util.UUID;

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
     */
    private static void readFromExcel(String file) throws Exception {

        ЭДПФР edpfr;
        try (HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(file))) {
            StringBuilder builder = new StringBuilder();

            HSSFSheet sheet = book.getSheetAt(0);
            edpfr = new ЭДПФР();


            for (Row row : sheet) {

                if (row.getRowNum() > 5 && row.getRowNum() < 33) {
                    ЭДПФР.СНЗ snz = new ЭДПФР.СНЗ();
                    ТипСлужебнаяИнформация info = new ТипСлужебнаяИнформация();
                    ЭДПФР.СНЗ.ПодтверждениеСтажа stazh = new ЭДПФР.СНЗ.ПодтверждениеСтажа();
                    ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись letter = new ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись();
                    ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.Работник worker = new ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.Работник();
                    ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.Работодатель employer = new ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.Работодатель();
                    ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.ТрудовойДоговор workDocument = new ЭДПФР.СНЗ.ПодтверждениеСтажа.Запись.ТрудовойДоговор();
                    String LastName = "";
                    String MiddleName = "";
                    String Name = "";
                    System.out.println(builder.toString());
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
                                LastName = cell.getStringCellValue();
                                worker.setФИО(builder.append(LastName + " ").toString());
                                break;
                            case 7:
                                Name = cell.getStringCellValue();
                                worker.setФИО(builder.append(Name + " ").toString());
                                break;
                            case 8:
                                MiddleName = cell.getStringCellValue();
                                worker.setФИО(builder.append(MiddleName + " ").toString());
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
                                workDocument.setСрок(String.valueOf(cell.getStringCellValue()));
                                break;
                            case 13:
                                letter.setСтажПодтвержден(cell.getBooleanCellValue());
                                break;
                            case 14:
                                letter.setНачисленыСВ(cell.getBooleanCellValue());
                                break;
                            default:
                                builder.delete(0, 1000);



                    }

                    }

                    letter.setРаботодатель(employer);
                    letter.setРаботник(worker);
                    letter.setТрудовойДоговор(workDocument);

                    stazh.getЗапись().add(letter);
                    snz.setПодтверждениеСтажа(stazh);

                    info.setGUID(UUID.randomUUID());
                    Date date = new Date();
                    info.setДатаВремя(date);
                    edpfr.setСНЗ(snz);
                    edpfr.setСлужебнаяИнформация(info);
                    writeToXml(getXMLDocument(edpfr, ЭДПФР.class));

                }

            }
        }



    }

    /**
     * Метод для записи строки в xml файл.
     *
     * @param string строка
     * @throws IOException
     */
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

