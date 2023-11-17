package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static Workbook workbook;
	
	public void excelConnect(String file) {
		try {
			FileInputStream inputFile=new FileInputStream(file);
			if(file.endsWith(".xlsx"))
				workbook =new XSSFWorkbook(inputFile);
			else if(file.endsWith(".xls"))
				workbook =new HSSFWorkbook(inputFile);
			else
				System.out.println("Wrong file extension");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public int lastRowNum(String sheet) {
		return workbook.getSheet(sheet).getLastRowNum();		
	}
	
	public String getCellData(String sheetname,int row,int cell) {
		return workbook.getSheet(sheetname).getRow(row).getCell(cell).toString();
		
	}
	
	public void setCellData(String sheetname,int row,int cell,String data) {
		workbook.getSheet(sheetname).getRow(row).createCell(cell).setCellValue(data);
		
	}
	
	public void writeExcel(String file) {
		try {
			FileOutputStream output=new FileOutputStream(file);
			workbook.write(output);
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
