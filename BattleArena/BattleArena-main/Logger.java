import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Logger {
    private static Logger Log = new Logger();

    private ArrayList <String> Playerdata = new ArrayList<String>();

    private Logger(){
    }

    public static Logger getLog(){

        if(Log == null){
            Log = new Logger();
        }
        return Log;
    }

    public void add(String info){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Playerdata.add(info+" "+timestamp);
    }

    public String get(int index){
        return Playerdata.get(index);
    }

    public void write(){
        BufferedWriter bw = null;
        for(int i = 0; i<Playerdata.size(); i++) {
            try {

                //Specify the file name and path here
                File file = new File("C:/myLogFile.txt");

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
                bw.write(Playerdata.get(i));

            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                try {
                    if (bw != null)
                        bw.close();
                } catch (Exception ex) {
                    System.out.println("Error in closing the BufferedWriter" + ex);
                }
            }
        }

    }
}
