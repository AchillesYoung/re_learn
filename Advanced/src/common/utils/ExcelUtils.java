package common.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.sun.xml.internal.bind.v2.model.core.ID;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.Test;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/8/11-6:23 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class ExcelUtils {
    @Test
    public void read() {
        ExcelUtils obj = new ExcelUtils();
        File file = new File("Murong' Scoring Data - Mshwari.xls");
        obj.readExcel(file);

    }

    public void readExcel(File file) {
        try {
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            System.out.println("sheet_size:" + sheet_size);
            for (int index = 0; index < sheet_size; index++) {

                System.out.println("go");
//                if (index == 0) {
//                    continue;
//                }
                //每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                System.out.println("rows:" + sheet.getRows() + "columns:" + sheet.getColumns());
                for (int i = 0; i < sheet.getRows(); i++) {
//                    if (i == 0) {
//                        continue;
//                    }

                    System.out.println( sheet.getColumns()+"columns in row--->:" + i );
                    StringBuffer sb = new StringBuffer("(");
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        sb.append("'" + cellinfo + "'" + ",");

                    }
                    sb.replace(sb.length() - 1, sb.length(), ")");
                    System.out.println(sb);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}