/**
 * Created by har14 on 05/12/15.
 */
public class PrintingReporter implements Reporter {

    @Override
    public void report(String message) {
        System.out.println(message);
    }
}
