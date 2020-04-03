package k8s.config.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.time.ZonedDateTime;

@RestController
public class ConfigController {

    @GetMapping
    public Response get() throws IOException {
        Response response = new Response();

        File file = new File("logs/log.log");
        file.getParentFile().mkdirs();
        file.createNewFile();
        try (BufferedWriter output = new BufferedWriter(new FileWriter(file, true))) {
            output.append("Request: ").append(response.getPodIp()).append("\n");
        } catch (Exception ignored) {
            System.out.println("");
        }

        return response;
    }

    public static class Response {
        private ZonedDateTime date = ZonedDateTime.now();
        private String dbHost = System.getenv("DB_HOST");
        private String dbPort = System.getenv("DB_PORT");
        private String dbUser = System.getenv("DB_USER");
        private String dbPassword = System.getenv("DB_PASSWORD");
        private String logLevel = System.getenv("LOG_LEVEL");
        private String podIp = System.getenv("POD_IP");

        public ZonedDateTime getDate() {
            return date;
        }

        public void setDate(ZonedDateTime date) {
            this.date = date;
        }

        public String getDbHost() {
            return dbHost;
        }

        public void setDbHost(String dbHost) {
            this.dbHost = dbHost;
        }

        public String getDbPort() {
            return dbPort;
        }

        public void setDbPort(String dbPort) {
            this.dbPort = dbPort;
        }

        public String getDbUser() {
            return dbUser;
        }

        public void setDbUser(String dbUser) {
            this.dbUser = dbUser;
        }

        public String getDbPassword() {
            return dbPassword;
        }

        public void setDbPassword(String dbPassword) {
            this.dbPassword = dbPassword;
        }

        public String getLogLevel() {
            return logLevel;
        }

        public void setLogLevel(String logLevel) {
            this.logLevel = logLevel;
        }

        public String getPodIp() {
            return podIp;
        }

        public void setPodIp(String podIp) {
            this.podIp = podIp;
        }
    }

}
