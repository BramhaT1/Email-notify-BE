//package com.example.Testing;
//import org.apache.poi.ss.usermodel.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.print.DocFlavor;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.time.LocalDateTime;
//import java.util.Map;
//
//import static java.util.Calendar.DATE;
//import static javax.xml.datatype.DatatypeConstants.DATETIME;
//
//@Service
//public class ExcelService {
//
//    public void readExcel(MultipartFile file) throws IOException {
//        InputStream inputStream = file.getInputStream();
//        Workbook workbook = WorkbookFactory.create(inputStream);
//        Sheet sheet = workbook.getSheetAt(0);
//
//
//        for (Row row : sheet) {
//            for (Cell cell : row) {
//
//                printCellValue(cell);
//            }
//            System.out.println(); // Move to the next row
//        }
//        workbook.close();
//        inputStream.close();
//    }
//    private void printCellValue(Cell cell) {
//        switch (cell.getCellType()) {
//            case STRING:
//                String cellValue = cell.getStringCellValue();
//                System.out.print(cellValue + "\t");
//                break;
//            case NUMERIC:
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    // Cell contains a date/time value
//                    LocalDateTime dateTimeValue = cell.getLocalDateTimeCellValue();
//                    System.out.print(dateTimeValue + "\t");
//                } else {
//                    // Cell contains a numeric value
//                    double numericValue = cell.getNumericCellValue();
//                    System.out.print(numericValue + "\t");
//                }
//                break;
//            // Handle other cell types as needed
//            default:
//                // Handle other cell types
//                break;
//        }
//    }
//
//
//
//}
//
