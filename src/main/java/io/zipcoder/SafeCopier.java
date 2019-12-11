package io.zipcoder;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{
    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        try {
            while (this.stringIterator.hasNext()) {
                synchronized (stringIterator) {
                    if (stringIterator.hasNext()) {
                        String word = stringIterator.next();
                        sleep(new Random().nextInt(20));
                        copied += word + " ";

                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
