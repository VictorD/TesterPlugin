import java.util.logging.Logger;

public final class LogSender {
    private final static Logger log = Logger.getLogger("Minecraft");

    // i'm lazy, easier to call this than copy the above everywhere... :p
    public static void send(String s) {
        log.info(s);
    }
}
