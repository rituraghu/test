import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public class File {

	class main{
	 private File outputFile;
	 private String  destinationFolder;

	 public  main(){
	    this.destinationFolder="test";
	 }
	 public void fileIteration(){
	    try{
	        for(File fileEntry :  new File(this.destinationFolder).listFiles()){

	            if (fileEntry.isDirectory()){

	            }
	            else{
	                System.out.println(fileEntry.getName());
	                this.excelManipulate(fileEntry.getName());
	            }
	        }
	    }

	    catch(Exception e){
	        e.printStackTrace();
	    }
	 }


	 public void excelManipulate(String inputFile){
	 try{
	     System.out.println(inputFile);
	     Workbook workbook=Workbook.createWorkbook(new File("test/"+inputFile));
	     Sheet sheet=workbook.getSheetIndex(0);
	     Cell a5=((Object) sheet).getCell("a1");
	     System.out.println(((Object) a5).getContents());;
	 }
	 catch(Exception e){
	    System.out.println(e.getMessage());
	 }
	 }

	 public void  main(String[] args){
	    main ofh=new main();
	    ofh.fileIteration();
	    }
	 }
}
