package testPack;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utility {

	public static void excelOutput(List<String>x,List<String>Appslist) throws IOException {
		String path=System.getProperty("user.dir")+"\\TestData\\ExcelOutput.xlsx";
		FileOutputStream file=new FileOutputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Titles");
		XSSFSheet sheet1=workbook.createSheet("Apps");
		for(int i=0;i<x.size();i++) {

		XSSFRow row=sheet.createRow(i);
			row.createCell(0).setCellValue(x.get(i));
			}
		
		
		
		//XSSFSheet sheet1=workbook.createSheet("Apps");
		for(int i=0;i<Appslist.size();i++) {
			XSSFRow row1=sheet1.createRow(i);


				row1.createCell(0).setCellValue(Appslist.get(i));	
		}
		workbook.write(file);
		workbook.close();
		file.close();
}
}
