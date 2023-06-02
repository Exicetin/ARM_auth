//package v2.controllers;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import jakarta.servlet.http.HttpServletResponse;
//import v2.model.response.LogsResponse;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.ArrayList;
//
//@Controller
//@RequestMapping("/")
////@Hidden
//public class LogsController {
//
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(LogsController.class);
//
//    @Value("${pathToHomeLog}")
//    private String loggerRootPath;
//
//    @GetMapping("/logs")
//    public String logs(Model model) {
//        LOGGER.debug("getting api/logs");
//        LogsResponse logsResponse = new LogsResponse(loggerRootPath);
//        logsResponse.setLogfiles(this.getSubFiles(new File(loggerRootPath)));
//        logsResponse.sort();
//        model.addAttribute("logFiles", logsResponse.getLogFileNames());
//        return "loglist";
//    }
//
//    @GetMapping("/getLog")
//    public @ResponseBody byte[] getLog(@RequestParam("file") String file, HttpServletResponse response) throws IOException {
//        LOGGER.debug("getting api/getLog");
//        File f = new File(file);
//        response.setContentType("text/plain");
//        response.setHeader("Content-Disposition", "attachment;filename=" + f.getName());
//        return Files.readAllBytes(f.toPath());
//    }
//
//    private ArrayList<File> getSubFiles(File root) {
//        ArrayList<File> files = new ArrayList<>();
//        File[] subFiles = root.listFiles();
//        for (File f:subFiles) {
//            if (f.isDirectory()) {
//                files.addAll(this.getSubFiles(f));
//            }
//            if (f.isFile()) {
//                files.add(f);
//            }
//        }
//        return files;
//    }
//}
//
