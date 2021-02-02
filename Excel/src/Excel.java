import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.WorkbookUtil;

import java.io.FileOutputStream;

public class Excel {

	public static void main(String[] args) {
		Workbook workbook = new HSSFWorkbook();
		
		Sheet sheet1 = workbook.createSheet();
		Sheet sheet2 = workbook.createSheet("Example");
		Sheet sheet3 = workbook.createSheet(WorkbookUtil.createSafeSheetName("?osjfkao[wfshahgowrhe"));
		
		try {
			FileOutputStream output = new FileOutputStream("Test1.xls");
			workbook.write(output);
			output.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
