public class Main {
    public static void main(String[] args) {
        LogService loggerA = LogService.getLogger();
        LogService loggerB = LogService.getLogger();

        loggerA.log("First message");
        loggerB.log("Second message");
    }
}

enum LogLevel {
    INFO, DEBUG, ERROR
}
class LogService {
    private LogService() {
        initialize();
    }

   
    private void initialize() {
        System.out.println("Logger Initialized.");
    }
    private static class SingletonHolder {
        private static final LogService INSTANCE = new LogService();
    }

      public static LogService getLogger() {
        return SingletonHolder.INSTANCE;
    }

       public void log(String message) {
        log(LogLevel.INFO, message);
    }

        public void log(LogLevel level, String message) {
        printFormatted(level, message);
    }

    
    private void printFormatted(LogLevel level, String message) {
        System.out.println("[LOG] " + message); 
    }
}
