//package v2.model.response;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Comparator;
//
//public class LogsResponse {
//    private String status;
//    private String message;
//    private ArrayList<File> logfiles;
//
//    private File root;
//
//    public LogsResponse(String logPath) {
//        root = new File(logPath);
//        status = "alive";
//        try {
//            message = root.getCanonicalPath();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        logfiles = new ArrayList<>();
//    }
//
//    public void sort() {
//        this.logfiles.sort(Comparator.comparing(File::lastModified).reversed());
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public ArrayList<File> getLogfiles() {
//        return logfiles;
//    }
//
//    public void setLogfiles(ArrayList<File> logfiles) {
//        this.logfiles = logfiles;
//    }
//
//    public ArrayList<String> getLogFileNames() {
//        ArrayList<String> names = new ArrayList<>();
//        for (File f:this.logfiles) {
//            names.add(f.toPath().toString());
//        }
//        return names;
//    }
//}
//
