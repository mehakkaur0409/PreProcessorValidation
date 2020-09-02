import java.io.FileInputStream;

public class ExcelValidationParser {

    public static void main(String[] args) {
        FileInputStream excelInputStream = new FileInputStream(new File(fileName));
        Workbook workbook = new XSSFWorkbook(excelInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator < Row > rowItr = sheet.iterator();
        int rowNum = 0;
        while (rowItr.hasNext()) {
            Row row = rowItr.next();
            Iterator < Cell > cellItr = row.iterator();
            System.out.print(rowNum + ". ");
            while (cellItr.hasNext()) {
                Cell cell = cellItr.next();
                if (cell.getCellTypeEnum() == CellType.STRING) {
                    System.out.print(cell.getStringCellValue() + "\t");
                } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                    System.out.print(cell.getNumericCellValue() + "\t");
                }
            }
            System.out.println();
            rowNum++;
        }
        workbook.close();
        excelInputStream.close();
    }
}
