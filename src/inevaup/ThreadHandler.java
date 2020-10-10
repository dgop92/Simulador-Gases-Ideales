package inevaup;

public class ThreadHandler {

    private static ThreadHandler threadHandler = null;

    private ThreadHandler(){

    }

    public static ThreadHandler getInstance() {
        if (threadHandler == null) {
            threadHandler = new ThreadHandler();
        }
        return threadHandler;
    }
    
    public void doInBackground(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runnable.run();
            }
        });
        thread.start();
    }
}
