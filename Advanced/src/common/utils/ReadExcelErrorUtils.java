//package common.utils;
//
//
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import org.junit.Test;
//
//import java.io.*;
//
///**
// * TODO
// *
// * @author yangshu
// * @version 5.0.0
// * @created at 2020/8/11-6:23 PM
// * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
// */
//public class ReadExcelErrorUtils {
//    @Test
//    public void read() {
//        ReadExcelErrorUtils obj = new ReadExcelErrorUtils();
//        File file = new File("inserttest.xls");
//        obj.readExcel(file);
//
//    }
//
//    public void readExcel(File file) {
//        try {
//            InputStream is = new FileInputStream(file.getAbsolutePath());
//            // jxl提供的Workbook类
//            Workbook wb = Workbook.getWorkbook(is);
//            // Excel的页签数量
//            int sheet_size = wb.getNumberOfSheets();
//            System.out.println("sheet_size:" + sheet_size);
//            for (int index = 0; index < sheet_size; index++) {
//                if(index!=2){
//                    continue;
//                }
//                //每个页签创建一个Sheet对象
//                Sheet sheet = wb.getSheet(index);
//                // sheet.getRows()返回该页的总行数
//                System.out.println("rows:" + sheet.getRows() + "columns:" + sheet.getColumns());
//                for (int i = 0; i < sheet.getRows(); i++) {
//                    if (i == 0) {
//                        continue;
//                    }
//                    // sheet.getColumns()返回该页的总列数
////                    System.out.println("columns in row--->:" + i );
//                    StringBuffer sb = new StringBuffer("(");
//                    for (int j = 0; j < sheet.getColumns(); j++) {
//                        String cellinfo = sheet.getCell(j, i).getContents();
//                        if(j==sheet.getColumns()-1){
//                            continue;
//                        }
//                        if (j == sheet.getColumns() - 3) {
//
//                            cellinfo = cellinfo.replace("'", "''");
//                        }
//
//                        sb.append("'" + cellinfo + "'" + ",");
//
//                    }
//                    sb.replace(sb.length() - 1, sb.length(), ")");
//                    System.out.println(sb);
//
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}