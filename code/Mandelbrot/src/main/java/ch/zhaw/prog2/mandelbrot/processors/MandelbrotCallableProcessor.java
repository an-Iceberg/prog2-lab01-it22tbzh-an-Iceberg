package ch.zhaw.prog2.mandelbrot.processors;

import ch.zhaw.prog2.mandelbrot.ImageRow;
import ch.zhaw.prog2.mandelbrot.MandelbrotProcessorListener;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MandelbrotCallableProcessor extends MandelbrotProcessor {

    private AtomicBoolean terminate = new AtomicBoolean(false); // signal the threads to abort processing and terminate

    /**
     * Initialize the Mandelbrot processor.
     * This method also initializes the color palette, containing colors in spectral order.
     * @param processorListener class to notify about processing results
     * @param width with of the canvas in pixel
     * @param height height of the canvas in pixel
     */
    public MandelbrotCallableProcessor(MandelbrotProcessorListener processorListener, int width, int height) {
        super(processorListener, width, height);
    }

    /**
     * This method starts as many new threads as the user has specified,
     * and assigns a different part of the image to each thread.
     * The threads are run at lower priority than the event-handling thread,
     * in order to keep the GUI responsive.
     *
     * @param numThreads number of thread to start to run the tasks
     */
    @Override
    public void startProcessing(int numThreads) {
        terminate.set(false);  // Set the signal before starting the threads!
        super.tasksRemaining = height;  // Records how many of the threads are still running
        super.startTime = System.currentTimeMillis();

        // TODO: Start the the executor service with the given number of threads.

        // TODO: process all rows using the Callable MandelbrotTask and store returned Futures in a list





        long duration = System.currentTimeMillis()-startTime;
        System.out.println("Tasks submitted after " + duration + "ms");

        // TODO: get results from Future list and send them to the processListener (GUI)
        // make sure to handle all Exceptions
        try {





        } finally {
            // stop processing and shutdown executor
            stopProcessing();
        }
    }

    /**
     * Stopp processing tasks and terminate all threads.
     * Also notifies the GUI that the processing has been stopped.
     */
    @Override
    public void stopProcessing() {
        terminate.set(true);  // signal the threads to abort
        // TODO: shutdown executor service



        // calculate processing time
        long duration = System.currentTimeMillis() - startTime;
        // notify the listener that the processing is completed
        processorListener.processingStopped(duration);
    }


    /**
     * This class defines the thread that does the computation.
     * The run method computes the image one pixel at a time.
     * After computing the colors for each row of pixels, the colors are
     * copied into the image, and the part of the display that shows that
     * row is repainted.
     *
     * Extended to implement also Callable.
     * the call() method calculates and return only the result for the startRow.
     */
    private class MandelbrotTask implements Callable<ImageRow> {
        // TODO: Use Task implementation from MandelbrotExecutorProcessor change it to a Callable.


        public ImageRow call()  {
            return null; // Compute one row of pixels.
        }

    } // end MandelbrotTask
}
